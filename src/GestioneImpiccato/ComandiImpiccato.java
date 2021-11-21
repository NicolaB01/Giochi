package GestioneImpiccato;

import java.util.InputMismatchException;
import java.util.Scanner;
import GestioneTris.IndiceNonValidoException;

public class ComandiImpiccato {
	Impiccato impiccato;
	private Byte scelta;
	private char prova;
	private int errori = 1;
	private Scanner in = new Scanner(System.in);

	public ComandiImpiccato() {

	}

	public void menu() throws FineGiocoException{
		System.out.println("MENU");
		System.out.println("0) Exit");
		System.out.println("1) Play");
		System.out.println("2) Rules");
		try {
			scelta = in.nextByte();
			if (scelta <0 || scelta >2)
				throw new IndiceNonValidoException("Puoi inserire solamente caratteri fra 0 e 2");
		}catch(IndiceNonValidoException i) {
			System.out.println(i.getMessage());
			in.nextLine();
			System.out.println("MENU");
			System.out.println("0) Exit");
			System.out.println("1) Play");
			System.out.println("2) Rules");
			try {
				scelta = in.nextByte();
				if (scelta <0 || scelta >3)
					throw new IndiceNonValidoException("Puoi inserire solamente caratteri fra 0 e 2");
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
			try {
				scelta = in.nextByte();
			}catch(InputMismatchException e1) {
				System.out.println("Error 404");
				System.exit(0);
			}
			in.nextLine();
		}
		this.menuScelta();
		this.menu();
	}

	public void menuScelta() throws FineGiocoException{
		switch(scelta) {
		case 0:
			throw new FineGiocoException("Alla prossima");
		case 1:
			impiccato = new Impiccato();
			impiccato.stampaUnderscore();
			while(errori<7 && !impiccato.controlloVittoria()) {
				impiccato.impiccatoScelte(errori);
				System.out.println("Inserisci il carattere da provare ");
				try {
					prova = in.next().charAt(0);
				}catch(InputMismatchException e) {
					System.out.println("Programma interrotto");
					System.exit(0);
				}
				if (impiccato.indovina(prova) != 0) {
					if (impiccato.indovina(prova) == 1)
						System.out.println("Hai indovinato "+ impiccato.indovina(prova) +" carattere");
					else 
						System.out.println("Hai indovinato "+ impiccato.indovina(prova) +" caratteri");
				}	
				else {
					errori++;
					System.out.println("Il carattere non è presente nella parola sei ha "+ (errori-1) +" errori!"); 
				}
				impiccato.stampaParolaIndovinata();
			}
			if (errori >= 7) {
				impiccato.impiccatoScelte(errori);
				System.out.println();
				System.out.println();
				System.out.println("Hai perso!!");
			}
			else {
				System.out.println();
				System.out.println();
				System.out.print("Bravo! Hai indovinato la parola era ");
				impiccato.stampaParolaIndovinata();
				System.out.println();
			}

			break;
		case 2:
			System.out.println("Hai 7 possibilità per indovinare la parola "
					+ "\npuoi inserire un carattere ala volta oppure "
					+ "\nprovare ad indovinare ma questa decisione comporterà "
					+ "\nla fine della partita con un esito o positivo o negativo\n");
		}
	}
}
