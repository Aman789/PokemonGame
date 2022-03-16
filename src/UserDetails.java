import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDetails {
	private static HttpURLConnection connection;
	DataBaseController dbcontroller = new DataBaseController();

	public void userpokemonselection() {

		System.out.println("Please enter three pokemon you desire:");
		HashMap<String, String[]> pokemonmoves = new HashMap<String, String[]>();
		Scanner trainerpokename = new Scanner(System.in);
		String[] pokemoves = new String[4];
		String[] party = new String[3];
		String pokename;
		// uncomment this
//		for (int i = 0; i < 3; i++) {
//			System.out.println("Please enter a pokemon name:");
//			pokename = trainerpokename.nextLine();
//			if (!dbcontroller.validatepokemonbyName(pokename)) {
//				party[i] = pokename;
//
//			} else {
//				System.out.println("invalid pokemon, please try again");
//				i--;
//			}
//
//		}

		// remove this after
		party[0] = "pikachu";
		party[1] = "bulbasaur";
		party[2] = "Blastoise";
		pokemoves[0] = "surf";
		pokemoves[1] = "mega-punch";
		pokemoves[2] = "thunder";
		pokemoves[3] = "body-slam";
		pokemonmoves.put(party[0], pokemoves);
		pokemoves = new String[4];
		pokemoves[0] = "petal-dance";
		pokemoves[1] = "cut";
		pokemoves[2] = "giga-drain";
		pokemoves[3] = "body-slam";
		pokemonmoves.put(party[1], pokemoves);
		pokemoves = new String[4];
		pokemoves[0] = "mega-punch";
		pokemoves[1] = "earthquake";
		pokemoves[2] = "surf";
		pokemoves[3] = "ice-beam";
		pokemonmoves.put(party[2], pokemoves);

		System.out.println("You have selected: " + party[0] + ", " + party[1] + " and " + party[2]);

		// comment this later
//		System.out.println("Select moves for your pokemon:");
//		for (String s : party) {
//			System.out.println("Select moves for your pokemon: " + s);
//			for (int j = 0; j < 4; j++) {
//				pokemoves[j] = trainerpokename.nextLine();
//				if(dbcontroller.validatepokemonmovebyname(s, pokemoves[j])) {
//					System.out.println("invald move for "+s+", please try again");
//					j--;
//				}
//			}
//			pokemonmoves.put(s, pokemoves);
//			pokemoves = new String[4];
//		}
		System.out.println("Player Team------------------------------------");
		String[] rando = new String[4];
		for (Map.Entry mapElement : pokemonmoves.entrySet()) {
			String key = (String) mapElement.getKey();
			System.out.println(key);
			rando = (String[]) mapElement.getValue();
			for (String s : rando) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	public void moveselection() {

	}

	public Trainer enemyteamtest() {
		HashMap<String, String[]> enemyteam = new HashMap<String, String[]>();
		String pokename;
		Trainer enemyTrainer = new Trainer();
		ArrayList<String> pokemonlist = new ArrayList<>();
		String pokemonmove;
		int m = 0;
		String[] pokemoves = new String[4];
		// ArrayList<String> pokemoves = new ArrayList<>();

		// pokemon
		for (int i = 0; i < 3; i++) {
			pokename = dbcontroller.getpokemonname();
			if (pokemonlist.contains(pokename)) {
				i--;
			} else {
				pokemonlist.add(pokename);
				pokemoves = new String[4];
				for (m = 0; m < 4; m++) {
					pokemonmove = dbcontroller.getpokemonmove(pokename);
					if (pokemonmove != null) {
						pokemoves[m] = pokemonmove;
					} else {
						pokemonlist.remove(pokename);
						i--;
						break;
					}
				}
				if (m == 4) {
					enemyteam.put(pokename, pokemoves);
				}
			}
		}
		Pokemon enepoke1 = new Pokemon(pokemonlist.get(0));
		Pokemon enepoke2 = new Pokemon(pokemonlist.get(1));
		Pokemon enepoke3 = new Pokemon(pokemonlist.get(2));

		String[] rando1 = enemyteam.get(pokemonlist.get(0));
		Moves move1e1 = new Moves(rando1[0]);
		Moves move2e1 = new Moves(rando1[1]);
		Moves move3e1 = new Moves(rando1[2]);
		Moves move4e1 = new Moves(rando1[3]);

		String[] rando2 = enemyteam.get(pokemonlist.get(1));
		Moves move1e2 = new Moves(rando2[0]);
		Moves move2e2 = new Moves(rando2[1]);
		Moves move3e2 = new Moves(rando2[2]);
		Moves move4e2 = new Moves(rando2[3]);

		String[] rando3 = enemyteam.get(pokemonlist.get(2));
		Moves move1e3 = new Moves(rando3[0]);
		Moves move2e3 = new Moves(rando3[1]);
		Moves move3e3 = new Moves(rando3[2]);
		Moves move4e3 = new Moves(rando3[3]);

		enepoke1.addMoveToList(move1e1);
		enepoke1.addMoveToList(move2e1);
		enepoke1.addMoveToList(move3e1);
		enepoke1.addMoveToList(move4e1);

		enepoke2.addMoveToList(move1e2);
		enepoke2.addMoveToList(move2e2);
		enepoke2.addMoveToList(move3e2);
		enepoke2.addMoveToList(move4e2);

		enepoke3.addMoveToList(move1e3);
		enepoke3.addMoveToList(move2e3);
		enepoke3.addMoveToList(move3e3);
		enepoke3.addMoveToList(move4e3);

		enemyTrainer.addPokemon(enepoke1);
		enemyTrainer.addPokemon(enepoke2);
		enemyTrainer.addPokemon(enepoke3);
		System.out.println("Enemy team--------------------------------");
		for (Pokemon pokemon : enemyTrainer.getParty()) {
			System.out.println(pokemon.getPokemonName() + " has the following moves:");
			for (Moves move : pokemon.getmoveList()) {
				System.out.println(move.getname());
			}
		}

		return enemyTrainer;

	}

	public Trainer userPartySelection() {

		Trainer trainer = new Trainer();
		Pokemon poke1 = new Pokemon("Pikachu");
		Pokemon poke2 = new Pokemon("Bulbasaur");
		Pokemon poke3 = new Pokemon("Blastoise");
		Moves move1p1 = new Moves("surf");
		Moves move2p1 = new Moves("mega-punch");
		Moves move3p1 = new Moves("thunder");
		Moves move4p1 = new Moves("body-slam");

		poke1.addMoveToList(move4p1);
		poke1.addMoveToList(move3p1);
		poke1.addMoveToList(move2p1);
		poke1.addMoveToList(move1p1);

		// for 2nd
		Moves move1p2 = new Moves("petal-dance");
		Moves move2p2 = new Moves("cut");
		Moves move3p2 = new Moves("giga-drain");
		Moves move4p2 = new Moves("body-slam");
		poke2.addMoveToList(move4p2);
		poke2.addMoveToList(move3p2);
		poke2.addMoveToList(move2p2);
		poke2.addMoveToList(move1p2);
		// for 3rd
		Moves move1p3 = new Moves("mega-punch");
		Moves move2p3 = new Moves("earthquake");
		Moves move3p3 = new Moves("surf");
		Moves move4p3 = new Moves("ice-beam");
		poke3.addMoveToList(move4p3);
		poke3.addMoveToList(move3p3);
		poke3.addMoveToList(move2p3);
		poke3.addMoveToList(move1p3);

		trainer.addPokemon(poke3);
		trainer.addPokemon(poke2);
		trainer.addPokemon(poke1);

		for (Pokemon pokemon : trainer.getParty()) {
			System.out.println(pokemon.getPokemonName() + " has the following moves:");
			for (Moves move : pokemon.getmoveList()) {
				System.out.println(move.getname());

			}
		}
		System.out.println("---------------------------------------------");
		return trainer;
	}

}
