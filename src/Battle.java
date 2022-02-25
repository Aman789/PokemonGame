import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Battle {

	private DataBaseController dbcontroller = new DataBaseController();

	// create enemy team
	public void enemyteam() {
		HashMap<String, ArrayList<String>> enemyteam = new HashMap<String, ArrayList<String>>();
		String pokename;
		ArrayList<String> pokemonlist = new ArrayList<>();
		String pokemonmove;
		int j = 0;
		// String[] pokemoves = new String[4];
		ArrayList<String> pokemoves = new ArrayList<>();
		for (int i = 0; i < 3; i++) {

			// store pokemon name
			pokename = dbcontroller.getpokemonname();
			System.out.println(i + " poke is : " + pokename);
			// check if pokemon exits in list
			if (!pokemonlist.contains(pokename)) {
				// new string
				pokemonlist.add(pokename);
				System.out.println(pokename);
				// pokemoves = new String[4];

				for (j = 0; j < 4; j++) {
					pokemonmove = dbcontroller.getpokemonmove(pokename);
					System.out.println(j + " pokemon move: " + pokemonmove);
					if (pokemonmove != null) {
						System.out.println("---" + pokemoves.contains(pokemonmove));
						// if (!Arrays.stream(pokemoves).anyMatch(pokemonmove::equals)) {
						if (!pokemoves.contains(pokemonmove)) {
							// pokemoves[j] = pokemonmove;
							pokemoves.add(pokemonmove);
						} else {
							j--;
						}
					} else {
						System.out.println("reset-----------------");
						pokemonlist.remove(pokename);
						i--;
						break;
					}

				}
				// pokemonlist.add(pokename);
				if (j == 4) {
					enemyteam.put(pokename, pokemoves);

				}
			} else {
				i--;

			}
		}

		ArrayList<String> rando = new ArrayList<>();
		for (Map.Entry mapElement : enemyteam.entrySet()) {
			String key = (String) mapElement.getKey();
			System.out.println("pokemon: " + key);
			rando = (ArrayList<String>) mapElement.getValue();
			for (String s : rando) {
				System.out.print(s + " ");
			}
			System.out.println();
		}

	}

	// create enemy team
	public void enemyteamtest() {
		HashMap<String, String[]> enemyteam = new HashMap<String, String[]>();
		String pokename;
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

		System.out.println("Enemy Team--------------------------------------");
		String[] rando = new String[4];
		for (Map.Entry mapElement : enemyteam.entrySet()) {
			String key = (String) mapElement.getKey();
			System.out.println(key);
			rando = (String[]) mapElement.getValue();
			for (String ss : rando) {
				System.out.print(ss + " ");
			}
			System.out.println();
		}

	}

}
