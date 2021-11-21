package GestioneTris;
import java.util.InputMismatchException;
import GestioneImpiccato.FineGiocoException;
import java.util.Scanner;
import GestionePlayer.Player;
import GestionePlayer.PlayerData;

public class ComandiTris {
	private Byte scelta;
	private int mossa = 0;
	private char giocatore1;
	private char giocatore2;
	private PlayerData dataBase = new PlayerData();
	private Tris t = new Tris();
	private Scanner in = new Scanner(System.in);

	public ComandiTris() {

	}

	public void menu() throws FineGiocoException {
		System.out.println("MENU");
		System.out.println("0) Exit");
		System.out.println("1) Play");
		System.out.println("2) Rules");
		System.out.println("3) Stats");
		try {
			scelta = in.nextByte();
			if (scelta <0 || scelta >3)
				throw new IndiceNonValidoException("Puoi inserire solamente caratteri fra 0 e 3");
		}catch(IndiceNonValidoException i) {
			System.out.println(i.getMessage());
			in.nextLine();
			System.out.println("MENU");
			System.out.println("0) Exit");
			System.out.println("1) Play");
			System.out.println("2) Rules");
			System.out.println("3) Stats");
			try {
				scelta = in.nextByte();
				if (scelta <0 || scelta >3)
					throw new IndiceNonValidoException("Puoi inserire solamente caratteri fra 0 e 3");
			}catch(InputMismatchException e1) {
				System.out.println("Error 404");
				System.exit(0);
			}catch(IndiceNonValidoException i1) {
				System.out.println("Errore fatale. Arresto delprogramma");
				System.exit(0);
			}
		}catch(InputMismatchException e) {
			System.out.println("Carattere non consentito riprova");
			in.nextLine();
			System.out.println("MENU");
			System.out.println("0) Exit");
			System.out.println("1) Play");
			System.out.println("2) Rules");
			System.out.println("3) Stats");
			try {
				scelta = in.nextByte();
			}catch(InputMismatchException e1) {
				System.out.println("Error 404");
				System.exit(0);
			}
			in.nextLine();
		}
		menuScelta();
		menu();
	}

	private void menuScelta() throws FineGiocoException{
		switch (this.scelta) {
		case 0:
			System.out.println("Aggiornamento del database");
			dataBase.aggiorna();
			throw new FineGiocoException("Arrivederci");
			
		case 1:
			System.out.println("Immetti il nome del primo giocatore");
		
			Player p1 = dataBase.presente(in.next());
			
			System.out.println("Immetti il nome del secondo giocatore");
			Player p2 = dataBase.presente(in.next());
			
			System.out.println(p1.getUsername()+ " vuoi giocare con O o X");
			giocatore1 = in.next().charAt(0);
			giocatore2 = (giocatore1 == 'O') ? 'X' : 'O';

			System.out.println("Questo è il menu delle scelte");
			t.stampaSituazione();
			mossa = 0;

			do {
				System.out.println(p1.getUsername()+" seleziona la casella");
				t.inserisci(posizione(in.next().charAt(0)), giocatore1);
				mossa++;
				t.stampaGioco();

				if (t.controlloVittoria() == 'P' && mossa < 8) {
					System.out.println(p2.getUsername()+" seleziona la casella");
					t.inserisci(posizione(in.next().charAt(0)), giocatore2);
					mossa++;
					t.stampaGioco();
				}
			}while(t.controlloVittoria() == 'P' && mossa < 9);
			
			if (giocatore1 == t.controlloVittoria()) {
				p1.incrementaWin();
				p2.incrementaLose();
			}
			if (giocatore2 == t.controlloVittoria()) {
				p2.incrementaWin();
				p1.incrementaLose();
			}if (t.controlloVittoria() == 'P') {
				p1.incrementaDraw();
				p2.incrementaDraw();
			}
			
			t.pulisciTabella();
			break;
		case 2:
			System.out.println();
			System.out.println("Dopo aver scelto la X o la O a turno bisogna selezionare una casella inserendo il carattere scritto nella tabella di prova:");
			t.stampaSituazione();
			System.out.println("Non inserire una casella già occupata!!");
			System.out.println();
			break;
		case 3:
			//dataBase.classifica();
			if (dataBase.numPlayerData() == 0)
				System.out.println("La lista è vuota");
			else 
				System.out.println(dataBase);
		}
	}

	private  PosizioniTabella posizione(char posizioneChar) {
		if(posizioneChar == 'q')
			return PosizioniTabella.q;
		if(posizioneChar == 'w')
			return PosizioniTabella.w;
		if(posizioneChar == 'e')
			return PosizioniTabella.e;
		if(posizioneChar == 'a')
			return PosizioniTabella.a;
		if(posizioneChar == 's')
			return PosizioniTabella.s;
		if(posizioneChar == 'd')
			return PosizioniTabella.d;
		if(posizioneChar == 'z')
			return PosizioniTabella.z;
		if(posizioneChar == 'x')
			return PosizioniTabella.x;
		else 
			return PosizioniTabella.c;
	}
}
