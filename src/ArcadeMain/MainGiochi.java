package ArcadeMain;

import java.util.InputMismatchException;
import java.util.Scanner;
import GestioneImpiccato.ComandiImpiccato;
import GestioneImpiccato.FineGiocoException;
import GestionePlayer.PlayerData;
import GestioneTris.*;

public class MainGiochi {

	public static void main(String[] args) {
		ComandiTris t = new ComandiTris();
		ComandiImpiccato i = new ComandiImpiccato();
		Scanner in = new Scanner(System.in);
		Byte scelta = 0;
		PlayerData db = new PlayerData();
		
		db.controlloFile();
		do {
			System.out.println("MENU");
			System.out.println("1) Tris");
			System.out.println("2) Impiccato");
			System.out.println("0) Uscire");
			try {
				scelta = in.nextByte();
				if (scelta <0 || scelta >2)
					throw new IndiceNonValidoException("Puoi inserire solamente caratteri fra 0 e 2");
			}catch(IndiceNonValidoException i1) {
				System.out.println(i1.getMessage());
				in.nextLine();
				System.out.println("MENU");
				System.out.println("1) Tris");
				System.out.println("2) Impiccato");
				System.out.println("0) Uscire");
				try {
					scelta = in.nextByte();
					if (scelta <0 || scelta >2)
						throw new IndiceNonValidoException("Puoi inserire solamente caratteri fra 0 e 2");
				}catch(InputMismatchException e1) {
					System.out.println("Error 404");
					System.exit(0);
				}catch(IndiceNonValidoException i2) {
					System.out.println("Errore fatale. Arresto delprogramma");
					System.exit(0);
				}
			}catch(InputMismatchException e) {
				System.out.println("Carattere non consentito riprova");
				in.nextLine();
				System.out.println("MENU");
				System.out.println("1) Tris");
				System.out.println("2) Impiccato");
				System.out.println("0) Uscire");
				try {
					scelta = in.nextByte();
				}catch(InputMismatchException e1) {
					System.out.println("Error 404");
					System.exit(0);
				}
				in.nextLine();
			}
			switch (scelta) {
			case 1:
				try {
					t.menu();
				}catch(FineGiocoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					i.menu();
				}catch(FineGiocoException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 0:
				System.out.println("Arrivederci");
				System.exit(0); 
			}
		}while(scelta != 0);
	}

}
