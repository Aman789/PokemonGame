import java.util.ArrayList;
import java.util.HashMap;

public class DataBaseController extends SQLQuerries {
	private ArrayList<String> columns;

	public Boolean validatepokemonbyName(String name) {
		columns = new ArrayList<>();
		columns.clear();
		columns.add("pok_name");
		return setup("Select * from pokemon where pok_name= '" + name + "';", columns) == null;

	}

	public Boolean validatepokemonmovebyname(String pokename, String movename) {

		columns = new ArrayList<>();
		columns.clear();
		columns.add("move_name");

		return setup("call validate_pokemon_moves('" + pokename + "', '" + movename + "');", columns) == null;
	}

	public String getpokemonname() {
		columns = new ArrayList<>();
		columns.clear();
		columns.add("pok_name");
		return setup("SELECT * FROM pokemon ORDER BY RAND() LIMIT 1;", columns).get("pok_name");
	}

	public String getpokemonmove(String pokename) {
		columns.clear();
		columns.add("move_name");
		String move = setup("call output_one_pokemon_move('" + pokename + "');", columns).get("move_name");
		
		if (move != null) {
			return move;

		}
		return null;
	}

}
