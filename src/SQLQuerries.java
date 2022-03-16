import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

public class SQLQuerries {
	private Connection connection;
	private HashMap<String, String> columndata;

	public HashMap<String, String> setup(String querry, ArrayList<String> column) {

		columndata = new HashMap<>();
		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemondb", "root",
					"Aman.deep123");

			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery(querry);
			if (resultset.next()) {
				for (String s : column) {
					columndata.put(s, resultset.getString(s));
				}
				statement.close();
				resultset.close();
				connection.close();
				return (columndata);
			}
			statement.close();
			resultset.close();
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return columndata;

	}

//	public void closeconn() {
//		connection = setup();
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public Boolean validatepokemon(String pokemon) throws SQLException {
//		connection = setup();
//		Statement statement = connection.createStatement();
//		ResultSet resultset = statement.executeQuery("select * from pokemon where pok_name =" + "'" + pokemon + "'");
//		if (resultset.next()) {
//			return true;
//		}
//		else {
//			return false;
//		}
//
//	}
}
