package GestioneTris;

public class Tris {
	private static final int RIGHE = 3;
	private static final int COLONNE = 3;

	private char tabella[][] = new char[RIGHE][COLONNE];
	
	public void stampaGioco() {
		System.out.println("["+ stampaCasella(PosizioniTabella.q) +"|"+stampaCasella(PosizioniTabella.w)+"|"+stampaCasella(PosizioniTabella.e)+"]");
		System.out.println("["+ stampaCasella(PosizioniTabella.a) +"|"+stampaCasella(PosizioniTabella.s)+"|"+stampaCasella(PosizioniTabella.d)+"]");
		System.out.println("["+ stampaCasella(PosizioniTabella.z) +"|"+stampaCasella(PosizioniTabella.x)+"|"+stampaCasella(PosizioniTabella.c)+"]");
	}
	
	public void stampaSituazione() {
		System.out.println("["+ (PosizioniTabella.q) +"|"+(PosizioniTabella.w)+"|"+(PosizioniTabella.e)+"]");
		System.out.println("["+ (PosizioniTabella.a) +"|"+(PosizioniTabella.s)+"|"+(PosizioniTabella.d)+"]");
		System.out.println("["+ (PosizioniTabella.z) +"|"+(PosizioniTabella.x)+"|"+(PosizioniTabella.c)+"]");
	}
	
	public void inserisci(PosizioniTabella posizione, char carattere) {
		/*if (!isUsed(posizione))
			throw new CasellaOccupataException("Casella inserita già occupata");*/
		tabella[posizione.getRiga()][posizione.getColonna()] = carattere;
	}
	
	private char stampaCasella(PosizioniTabella posizione) {
		return tabella[posizione.getRiga()][posizione.getColonna()];
	}
	
	public void pulisciTabella() {
		for (int i = 0; i< RIGHE ; i++)
			for (int j=0; j<COLONNE ; j++)
				tabella[i][j] = '\0';
	}
	
	private void isUsed(PosizioniTabella posizione) {
		//TODO implementare un metodo per comprendere quando una casella è usata + volte
	}
	
	public char controlloVittoria() {
		int sommaO = 0;
		int sommaX = 0;

		for (int i=0; i<RIGHE; i++) 
		{
			for (int j=0; j<COLONNE; j++) 
			{
				if (tabella[i][j] == 'O')
					sommaO += 1;
				if (tabella[i][j] == 'X')
					sommaX += 2;
			}
			
			if (sommaO == 3)
				return 'O';
			if (sommaX == 6)
				return 'X';
			sommaO = 0;
			sommaX = 0;
		}
		

		for (int i=0; i<RIGHE; i++) 
		{
			for (int j=0; j<COLONNE; j++) 
			{
				if (tabella[j][i] == 'O')
					sommaO += 1;
				if (tabella[j][i] == 'X')
					sommaX += 2;
			}
			
			if (sommaO == 3)
				return 'O';
			if (sommaX == 6)
				return 'X';
			sommaO = 0;
			sommaX = 0;
		}

		for (int i=0, j=2; i<RIGHE; j--, i++) 
		{
			
			if (tabella[i][j] == 'O')
				sommaO += 1;
			if (tabella[i][j] == 'X')
				sommaX += 2;
		}
		if (sommaO == 3)
			return 'O';
		if (sommaX == 6)
			return 'X';
		
		sommaO = 0;
		sommaX = 0;

		for (int i=0; i<RIGHE; i++) 
		{
			
			if (tabella[i][i] == 'O')
				sommaO += 1;
			if (tabella[i][i] == 'X')
				sommaX += 2;
		}
		if (sommaO == 3)
			return 'O';
		if (sommaX == 6)
			return 'X';
		else 
			return 'P';
	}
}
