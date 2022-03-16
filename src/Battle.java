import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Battle {

	private DataBaseController dbcontroller = new DataBaseController();
	private Trainer userParty;
	private Trainer enemyParty;
	private boolean battlestatus;
	private Pokemon userPokemon;
	private Pokemon enemyPokemon;
	private Moves userMove;
	private Moves enemyMove;

	public Battle() {

	}

	public Battle(Trainer userTeam, Trainer enemyTrainer) {
		this.userParty = userTeam;
		this.enemyParty = enemyTrainer;
		this.battlestatus = true;

		teamstatuscheck();

	}

	public void teamstatuscheck() {
		Pokemon plPoke = null;
		Pokemon enPoke = null;
		System.out.println("pokmeon status is: " + userParty.getParty().get(1).getstatus());
		userParty.getParty().get(1).setStatus("desc");
		userParty.getParty().get(2).setStatus("desc");
		for (int i = 0; i < userParty.getParty().size(); i++) {
			if (userParty.getParty().get(i).getstatus() != "desc") {
				plPoke = userParty.getParty().get(i);
				this.userPokemon = userParty.getParty().get(i);
				for (int j = 0; j < enemyParty.getParty().size(); j++) {
					if (enemyParty.getParty().get(j).getstatus() != "desc") {
						enPoke = enemyParty.getParty().get(j);
						this.enemyPokemon = enemyParty.getParty().get(j);
						break;
					}
				}
			}
		}
		pokemonselect(plPoke, enPoke);
	}

	public void pokemonselect(Pokemon userpoke, Pokemon enpoke) {
		System.out.println("Starting Pokemon------------------------------");
		System.out.println("user: " + userpoke.getPokemonName());
		System.out.println("enemy: " + enpoke.getPokemonName());
		System.out.println("Starting Pokemon------------------------------");
		initiateBattle(userpoke, enpoke);
	}

	public void initiateBattle(Pokemon userpoke, Pokemon enpoke) {
		Boolean userTurn = true;
		Boolean enemyTeamstatus = true;
		Boolean userTeamstatus = true;
		Scanner selectedmove = new Scanner(System.in);
		String selmove;
		Moves moveselected;
		Moves enemMove;
		Moves useMove;
		Pokemon currturn;
		Pokemon secturn;
		double speed = userpoke.getspeed() - enpoke.getspeed();
		// select move
		this.userMove = selectMove(userpoke);
		this.enemyMove = selectMove(enpoke);
		// check speed

		// check damage
		// check hp
		// check pokemon

		while (userpoke.getstatus() != "desc" || enpoke.getstatus() != "desc") {
			if (userpoke.getspeed() > enpoke.getspeed()) {
				System.out.println("user's " + userpoke.getPokemonName() + " decide your first move: ");
				System.out.print("Select move:");
				for (int i = 0; i < userpoke.getmoveList().size(); i++) {
					System.out.println((i + 1) + ": " + userpoke.getmoveList().get(i).getname());
				}
				selmove = selectedmove.nextLine();
				moveselected = userpoke.getmoveList().get(Integer.valueOf(selmove) - 1);
				System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				if (enpoke.getPokemonHp() - moveselected.getpower() > 0) {
					enpoke.sethp(enpoke.getPokemonHp() - moveselected.getpower());
					System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				} else {
					System.out.println("pokemon defeated");
					enpoke.sethp(0);
					enpoke.setStatus("desc");
				}
				System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				System.out.println(userpoke.getPokemonHp() + " " + enpoke.getPokemonHp());
				System.out.println();

			} else {
				System.out.println(enpoke.getPokemonName() + " decide your first move: ");
				System.out.print("Select move:");
				for (int i = 0; i < enpoke.getmoveList().size(); i++) {
					System.out.println((i + 1) + ": " + enpoke.getmoveList().get(i).getname());
				}
				selmove = selectedmove.nextLine();
				moveselected = enpoke.getmoveList().get(Integer.valueOf(selmove) - 1);
				System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				if (userpoke.getPokemonHp() - moveselected.getpower() > 0) {
					userpoke.sethp(userpoke.getPokemonHp() - moveselected.getpower());
					System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				} else {
					System.out.println("pokemon defeated");
					userpoke.sethp(0);
					userpoke.setStatus("desc");
				}
				System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				System.out.println(userpoke.getPokemonHp() + " " + enpoke.getPokemonHp());
				System.out.println(userpoke.getstatus() + "||" + enpoke.getstatus());
				System.out.println(userpoke.getstatus() != "desc" || enpoke.getstatus() != "desc");
				System.out.println();
			}
		}

	}

	public Moves selectMove(Pokemon poke) {
		String selmove;
		Moves moveselected;
		Scanner selectedmove = new Scanner(System.in);
		for (int i = 0; i < poke.getmoveList().size(); i++) {
			System.out.println((i + 1) + ": " + poke.getmoveList().get(i).getname());
		}
		selmove = selectedmove.nextLine();
		moveselected = poke.getmoveList().get(Integer.valueOf(selmove) - 1);
		return moveselected;

	}

	public void damageStep() {

		if (userPokemon.getspeed() > enemyPokemon.getspeed()) {
			healthcheck(userPokemon);
			dmgcalc(userMove, enemyPokemon);
		} else {
			healthcheck(enemyPokemon);
			dmgcalc(enemyMove, userPokemon);
		}
	}

	public boolean healthcheck(Pokemon pokemon) {
		return pokemon.getstatus() == "desc";
	}

	public void dmgcalc(Moves move, Pokemon secpoke) {
		if (secpoke.getPokemonHp() - move.getpower() > 0) {
			secpoke.sethp(secpoke.getPokemonHp() - move.getpower());

		} else {
			secpoke.sethp(0);
			System.out.println(secpoke.getPokemonName() + " is deafeated!");
		}
	}

}
