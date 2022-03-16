import java.util.ArrayList;
import java.util.List;

public class Trainer {

	private List<Pokemon> pokemonList = new ArrayList<>();;

	public List<Pokemon> getParty() {
		return pokemonList;
	}

	public String addPokemon(Pokemon pokemonName) {
		pokemonList.add(pokemonName);
		return null;
	}
}
