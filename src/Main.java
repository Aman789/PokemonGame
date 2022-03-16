import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		UserDetails userdetails = new UserDetails();
//		Battle battle = new Battle();
//		userdetails.userpokemonselection();
//		
//		userdetails.enemyteamtest();
//		Trainer trainer = new Trainer();
//		Pokemon poke1 = new Pokemon("pikachu");
//		Moves move1 = new Moves("water-gun");
//		poke1.sethp(100);
//		System.out.println(poke1.getPokemonHp());
//		System.out.println(trainer.getParty());
//		trainer.addPokemon(poke1);
//		poke1.addMoveToList(move1);
//		for (Pokemon pok : trainer.getParty()) {
//			System.out.println(pok.getPokemonName());
//			for (Moves move : pok.getmoveList()) {
//				System.out.println("following moves " + move.getname());
//			}
//		}
		Trainer user = new Trainer();
		Trainer enemy = new Trainer();
		user = userdetails.userPartySelection();
		enemy = userdetails.enemyteamtest();
		
		Battle battle = new Battle(user, enemy);
		
		
	}

}
