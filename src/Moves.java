import java.util.HashMap;

public class Moves extends DataBaseController {
	private String type;
	private double power;
	private double accuracy;
	private String moveName;
	private double pp;
	private HashMap<String, String> moveStats;

	public Moves(String name) {
		moveName = name;
		movestats();
	}

	public Moves(String name, String moveType, int movePower, double d) {
		moveName = name;
		type = moveType;
		power = movePower;
		accuracy = d;
	}

	public String getname() {
		return moveName;
	}

	public void movestats() {
		moveStats = getMoveStats(this.moveName);
		if (moveStats.get("move_power") != null) {
			this.power = Double.valueOf(moveStats.get("move_power"));
		} else {
			this.power = 0;
		}
		if (moveStats.get("move_accuracy") != null) {
			this.accuracy = Double.valueOf(moveStats.get("move_accuracy"));
		} else {
			this.accuracy = 0;
		}
		this.pp = Double.valueOf(moveStats.get("move_pp"));
		this.type = moveStats.get("type_name");

	}

	public String getType() {
		return this.type;
	}

	public double getAccuracy() {
		return this.accuracy;
	}

	public double getpp() {
		return this.pp;
	}

	public double getpower() {
		return this.power;
	}

}
