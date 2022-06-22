import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Battle {

	private DataBaseController dbcontroller = new DataBaseController();
	private Trainer userParty;
	private Trainer enemyParty;
	private boolean enemyteamstatus;
	private boolean userteamstatus;
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
		this.enemyteamstatus = true;
		this.userteamstatus = true;
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

	public void pokeselectionuser() {
		Pokemon plPoke = null;
		Pokemon enPoke = null;
		System.out.println(enemyPokemon.getPokemonName());
		if (enemyPokemon.getstatus().contains("desc")) {
			for (int j = 0; j < enemyParty.getParty().size(); j++) {
				if (enemyParty.getParty().get(j).getstatus() != "desc") {
					enPoke = enemyParty.getParty().get(j);
					this.enemyPokemon = enemyParty.getParty().get(j);
					break;
				}
			}
		}

		if (userPokemon.getstatus().contains("desc")) {
			for (int i = 0; i < userParty.getParty().size(); i++) {
				if (userParty.getParty().get(i).getstatus() != "desc") {
					plPoke = userParty.getParty().get(i);
					this.userPokemon = userParty.getParty().get(i);
					break;
				}
			}
		}
	}

	public boolean enemypartystatuscheck() {
		Pokemon enPoke = null;
		for (int j = 0; j < enemyParty.getParty().size(); j++) {
			if (enemyParty.getParty().get(j).getstatus() != "desc") {
				return this.battlestatus;
			}

		}
		this.enemyteamstatus = false;
		this.battlestatus = false;
		return this.battlestatus;
	}

	public boolean userpartystatuscheck() {
		Pokemon plPoke = null;
		for (int i = 0; i < userParty.getParty().size(); i++) {
			if (userParty.getParty().get(i).getstatus() != "desc") {
				return this.battlestatus;
			}
		}

		this.userteamstatus = false;
		this.battlestatus = false;
		return this.battlestatus;
	}

	public void pokemonselect(Pokemon userpoke, Pokemon enpoke) {
		System.out.println("Starting Pokemon------------------------------");
		System.out.println("user: " + userpoke.getPokemonName());
		System.out.println("enemy: " + enpoke.getPokemonName());
		System.out.println("----------------------------------------------");
		initiateBattle(userpoke, enpoke);
	}

	public void initiateBattle(Pokemon userpoke, Pokemon enpoke) {
		Boolean userTurn = true;
		Boolean enemyTeamstatus = true;
		Boolean userTeamstatus = true;
		Scanner selectedmove = new Scanner(System.in);
		String selmove;
		Moves moveselected;
		Moves enemMove = null;
		Moves useMove;
		Pokemon currturn;
		Pokemon secturn;
		double speed = userpoke.getspeed() - enpoke.getspeed();
		// select move
//		this.userMove = selectMove(userpoke);
//		this.enemyMove = selectMove(enpoke);
		// check speed

		// check damage
		// check hpD
		// check pokemon

		displayhp(userpoke, enpoke);

//		while (userpoke.getstatus() != "desc" & enpoke.getstatus() != "desc") {
		while (this.battlestatus) {
			System.out.println("user's " + userpoke.getPokemonName() + " decide your first move: ");
			System.out.println("Select move:");
			for (int i = 0; i < userpoke.getmoveList().size(); i++) {
				System.out.println((i + 1) + ": " + userpoke.getmoveList().get(i).getname());
			}
			selmove = selectedmove.nextLine();
			useMove = userpoke.getmoveList().get(Integer.valueOf(selmove) - 1);

			for (int i = 0; i < enpoke.getmoveList().size(); i++) {
				if (enpoke.getmoveList().get(i).getpower() > 0) {
					enemMove = enpoke.getmoveList().get(i);
				}
			}

			if (userpoke.getspeed() > enpoke.getspeed()) {

//				for (int i = 0; i < userpoke.getmoveList().size(); i++) {
//					System.out.println((i + 1) + ": " + userpoke.getmoveList().get(i).getname());
//				}
//				selmove = selectedmove.nextLine();
//				moveselected = userpoke.getmoveList().get(Integer.valueOf(selmove) - 1);
//				System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				if (enpoke.getPokemonHp() - useMove.getpower() > 0) {
					enpoke.sethp(enpoke.getPokemonHp() - useMove.getpower());
					//System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				} else {
					System.out.println(enpoke.getPokemonName() + " was defeated");
					enpoke.sethp(0);
					enpoke.setStatus("desc");
				}
				if (!enpoke.getstatus().contains("desc")) {
					if (userpoke.getPokemonHp() - enemMove.getpower() > 0) {
						userpoke.sethp(userpoke.getPokemonHp() - enemMove.getpower());
						//System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
					} else {
						System.out.println(userpoke.getPokemonName() + " was defeated");
						userpoke.sethp(0);
						userpoke.setStatus("desc");
					}
				}

				

			} else {
//				System.out.println(enpoke.getPokemonName() + " decide your first move: ");
//				System.out.print("Select move:");
//				for (int i = 0; i < enpoke.getmoveList().size(); i++) {
//					System.out.println((i + 1) + ": " + enpoke.getmoveList().get(i).getname());
//				}
//				selmove = selectedmove.nextLine();
//				moveselected = enpoke.getmoveList().get(Integer.valueOf(selmove) - 1);
				System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				if (userpoke.getPokemonHp() - enemMove.getpower() > 0) {
					userpoke.sethp(userpoke.getPokemonHp() - enemMove.getpower());
					//System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
				} else {
					userpoke.sethp(0);
					userpoke.setStatus("desc");
				}
				if (!userpoke.getstatus().contains("desc")) {
					if (enpoke.getPokemonHp() - useMove.getpower() > 0) {
						enpoke.sethp(enpoke.getPokemonHp() - useMove.getpower());
						//System.out.println(userpoke.getPokemonHp() + "||" + enpoke.getPokemonHp());
					} else {
						System.out.println("was defeated");
						enpoke.sethp(0);
						enpoke.setStatus("desc");
					}
					
				}
			}

			pokeselectionuser();
			enemypartystatuscheck();
			userpartystatuscheck();
			enpoke = this.enemyPokemon;
			userpoke = this.userPokemon;
			displayhp(userpoke, enpoke);
			System.out.println(userpoke.getstatus() + "   " + enpoke.getstatus());

		}

		if (!this.userteamstatus) {
			System.out.println("user has lost");
		} else {
			System.out.println("Enemy defeated");
		}
		

	}

	public void battleCheck() {
		Pokemon plPoke = null;
		Pokemon enPoke = null;
		System.out.println(enemyPokemon.getPokemonName());
		if (enemyPokemon.getstatus().contains("desc")) {
			for (int j = 0; j < enemyParty.getParty().size(); j++) {
				if (enemyParty.getParty().get(j).getstatus() != "desc") {
					enPoke = enemyParty.getParty().get(j);
					this.enemyPokemon = enemyParty.getParty().get(j);
					System.out.println(enemyPokemon.getPokemonName());
					break;
				}
			}
		}

		if (userPokemon.getstatus().contains("desc")) {
			for (int i = 0; i < userParty.getParty().size(); i++) {
				if (userParty.getParty().get(i).getstatus() != "desc") {
					plPoke = userParty.getParty().get(i);
					this.userPokemon = userParty.getParty().get(i);
				}
			}
		}
	}

	public void displayhp(Pokemon userpoke, Pokemon enpoke) {
		System.out.format("%20s %3s %20s", userpoke.getPokemonName(), "||", enpoke.getPokemonName());
		System.out.println();
		System.out.format("%20s %3s %20s", userpoke.getPokemonHp(), "||", enpoke.getPokemonHp());
		// System.out.println(userpoke.getPokemonHp() + " " + enpoke.getPokemonHp());
		System.out.println();
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
