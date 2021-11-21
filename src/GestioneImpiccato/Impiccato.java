package GestioneImpiccato;

import java.util.Random;

public class Impiccato {
	private String parolaSegreta;
	private char[] parolaIndovinata;
	private int numCaratteri;
	private String[] parole = {"luisaviaroma", "supreme", "virtuosamente", "bomba", "simone", "olive", "frantoio", "tastiera"};

	public Impiccato() {
		Random gen = new Random();
		parolaSegreta = parole[gen.nextInt(parole.length)];
		parolaIndovinata = new char[parolaSegreta.length()];
	}

	public void stampaParolaIndovinata() {
		for (char c: parolaIndovinata) 
			System.out.print(c);
		System.out.println();
	}

	public void stampaUnderscore( ) {
		for (int i=0; i<parolaSegreta.length(); i++)
			System.out.print("-");
		System.out.println("\nLa parola da indovinare è lunga: "+parolaSegreta.length()+" caratteri");
	}

	public int indovina(char tentativo) {
		numCaratteri = 0;
		for (int i=0; i<parolaSegreta.length(); i++) {
			if (parolaSegreta.charAt(i) == tentativo) {
				parolaIndovinata[i] = tentativo;
				numCaratteri++;
			}
			else
				if (!Character.isLetter(parolaIndovinata[i])) 
					parolaIndovinata[i] = '-';	
		}
		return numCaratteri;
	}

	public boolean controlloVittoria() {
		if (parolaSegreta.equals(String.valueOf(parolaIndovinata)))
			return true;
		return false;
	}

	public void impiccatoScelte(int errori) {
		switch(errori) {
		case 1:
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println("|      ");
			System.out.println("|      ");
			System.out.println("|      ");
			System.out.println("|      ");
			System.out.println("|      ");
			System.out.println("-      ");
			break;
		case 2:
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println("|      /\\");
			System.out.println("|      \\/");
			System.out.println("|      ");
			System.out.println("|      ");
			System.out.println("|      ");
			System.out.println("-       ");
			break;
		case 3:
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println("|      /\\");
			System.out.println("|      \\/");
			System.out.println("|       |");
			System.out.println("|       |");
			System.out.println("|       ");
			System.out.println("-       ");
			break;
		case 4:
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println("|      /\\");
			System.out.println("|      \\/");
			System.out.println("|      /|");
			System.out.println("|       |");
			System.out.println("|       ");
			System.out.println("-       ");
			break;
		case 5:
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println("|      /\\");
			System.out.println("|      \\/");
			System.out.println("|      /|\\");
			System.out.println("|       |");
			System.out.println("|       ");
			System.out.println("-       ");
			break;
		case 6:
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println("|      /\\");
			System.out.println("|      \\/");
			System.out.println("|      /|\\");
			System.out.println("|       |");
			System.out.println("|      / ");
			System.out.println("-        ");
			break;
		case 7:
			System.out.println("--------");
			System.out.println("|      |");
			System.out.println("|      /\\");
			System.out.println("|      \\/");
			System.out.println("|      /|\\");
			System.out.println("|       |");
			System.out.println("|      / \\");
			System.out.println("-       ");
		}
	}
}
