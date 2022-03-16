import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pokemon {
	private String name;
	private String[] pokemonMoves = new String[4];
	private DataBaseController dbcontroller = new DataBaseController();
	private HashMap<String, String> pokemonStats;
	private double hp;
	private double pattk;
	private double pdef;
	private double sattk;
	private double sdef;
	private double speed;
	private String status = "normal";
	private double level = 50;
	public List<Moves> moveList = new ArrayList<Moves>();

	public Pokemon(String name) {
		this.name = name;
		setStats();
	}

	private void setStats() {
		pokemonStats = dbcontroller.getPokemonStats(this.name);
		this.hp = calculateHP(Double.valueOf(pokemonStats.get("b_hp")));
		this.pattk = calculateotherstats(Double.valueOf(pokemonStats.get("b_atk")));
		this.pdef = calculateotherstats(Double.valueOf(pokemonStats.get("b_def")));
		this.sattk = calculateotherstats(Double.valueOf(pokemonStats.get("b_sp_atk")));
		this.sdef = calculateotherstats(Double.valueOf(pokemonStats.get("b_sp_def")));
		this.speed = calculateotherstats(Double.valueOf(pokemonStats.get("b_speed")));

	}

	public double calculateHP(Double php) {
		int iv = 31;
		int ev = 0;

		return Math.floor(0.01 * ((2 * (php + iv) + Math.floor(0.25 * Math.sqrt(ev))) * level)) + level + 10;
	}

	public double calculateotherstats(Double stat) {
		int iv = 31;
		int ev = 0;
		// Math.floor(0.01 * (2 * Base + IV + Math.floor(0.25 * EV)) * Level) + 5) *
		// Nature;
		return Math.floor(0.01 * (2 * stat + iv + Math.floor(0.25 * Math.sqrt(ev))) * level) + 5;
	}

	public String getPokemonName() {
		return name;
	}

	public Double getPokemonHp() {
		return hp;
	}

	public Double getPhysAttk() {
		return pattk;
	}

	public Double getPhsDef() {
		return pdef;
	}

	public Double getSpecAttk() {
		return sattk;
	}

	public Double getsdef() {
		return sdef;
	}

	public Double getspeed() {
		return speed;

	}

	public String getstatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public void sethp(double d) {
		this.hp = d;
		if (this.hp == 0) {
			this.status ="desc";
		}
	}

	public List<Moves> getmoveList() {
		return moveList;
	}

	public void addMoveToList(Moves move) {

		moveList.add(move);
	}

}
