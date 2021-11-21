package GestioneTris;

enum PosizioniTabella {
	
	q(0,0), w(0,1), e(0,2), a(1,0), s(1,1), d(1,2), z(2,0), x(2,1), c(2,2);
	
	private final int colonna;
	private final int riga;
	
	private PosizioniTabella(int riga, int colonna) {
		this.riga = riga;
		this.colonna = colonna;
	}

	public int getColonna() {
		return colonna;
	}

	public int getRiga() {
		return riga;
	}
}
