package GestionePlayer;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PlayerData {
	private String Database = "PlayerData.txt";
	private static ArrayList<Player> listaPlayerTris = new ArrayList<>();
	private static ArrayList<Player> listaPlayerImpiccato = new ArrayList<>();
	private File dataFile = new File(Database);
	private Scanner inputStream = null;
	private PrintWriter outputStream = null;
	
	public void controlloFile() {
		if (dataFile.exists()) {
			if (dataFile.canRead()) {
				try {
					inputStream = new Scanner(dataFile);
				}catch(FileNotFoundException e) {
					System.out.println("File non trovato fine del programma");
					System.exit(0);
				}
				while (inputStream.hasNextLine()) {
					String buffer = inputStream.nextLine();
					String[] a = buffer.split(" ");
					presente(new Player(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3])));
				}
				inputStream.close();
			}
		}
	}
	
	public void aggiorna() {
		try {
			outputStream = new PrintWriter(dataFile);
		}catch(FileNotFoundException e) {
			System.out.println("File non trovato fine del programma");
			System.exit(0);
		}
		listaPlayerTris.trimToSize();
		for (int i=0; i<listaPlayerTris.size(); i++) {
			outputStream.print(listaPlayerTris.get(i).getUsername()+" ");
			outputStream.print(listaPlayerTris.get(i).getWin()+" ");
			outputStream.print(listaPlayerTris.get(i).getLose()+" ");
			outputStream.print(listaPlayerTris.get(i).getDraw()+" ");
			outputStream.println();
		}
		outputStream.close();
	}

	public void classifica() {
		listaPlayerTris.sort(null);
	}
	
	private Player aggiungiPlayer(Player p) {
		listaPlayerTris.add(p);
		return p;
	}
	
	public void presente(Player player) {
		for(Player p : listaPlayerTris) {
			if (player.equals(p)) {
				return;
			}
		}
		aggiungiPlayer(player);
		
	}
	
	public Player presente(String playerUsername) {
		for(int i=0; i < listaPlayerTris.size(); i++) {
			if (playerUsername.equals(listaPlayerTris.get(i).getUsername())) 
				return listaPlayerTris.get(i);
		}
		return aggiungiPlayer(new Player(playerUsername));
		
	}
	
	public int numPlayerData() {
		return listaPlayerTris.size();
	}
	
	@Override
	public String toString() {
		return "Database=\n" + listaPlayerTris ;
	}
	
	
}
