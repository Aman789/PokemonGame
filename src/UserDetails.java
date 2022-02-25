import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserDetails {
	private static HttpURLConnection connection;

	public void userpokemonselection() {
		DataBaseController dbcontroller = new DataBaseController();
		System.out.println("Please enter three pokemon you desire:");
		HashMap<String, String[]> pokemonmoves = new HashMap<String, String[]>();
		Scanner trainerpokename = new Scanner(System.in);
		String[] pokemoves = new String[4];
		String[] party = new String[3];
		String pokename;
		//uncomment this
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
		
		//remove this after
		party[0] = "pikachu";
		party[1] = "bulbasaur";
		party[2] = "Blastoise";
		pokemoves[0] = "surf";
		pokemoves[1]="mega-punch";
		pokemoves[2]="thunder";
		pokemoves[3]="body-slam";
		pokemonmoves.put(party[0], pokemoves);
		pokemoves = new String[4];
		pokemoves[0] = "petal-dance";
		pokemoves[1]="cut";
		pokemoves[2]="giga-drain";
		pokemoves[3]="body-slam";
		pokemonmoves.put(party[1], pokemoves);
		pokemoves = new String[4];
		pokemoves[0] = "mega-punch";
		pokemoves[1]="earthquake";
		pokemoves[2]="surf";
		pokemoves[3]="ice-beam";
		pokemonmoves.put(party[2], pokemoves);
		
		System.out.println("You have selected: " + party[0] + ", " + party[1] + " and " + party[2]);

		//comment this later
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

}
