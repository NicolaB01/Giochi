package GestionePlayer;
import java.lang.Comparable;

public class Player implements Comparable {
	private String username;
	//private String pwd; da mettere in seguito
	private int win;
	private int lose;
	private int draw;
	
	public Player() {
		this("", 0, 0, 0);
	}
	
	public Player(String username) {
		this(username, 0, 0, 0);
	}
	
	public Player(String username, int win, int lose, int draw) {
		this.username = username;
		this.win = win;
		this.lose = lose;
		this.draw = draw;
	}
	
	public boolean equals(Object o) {
		if (o != null && (o instanceof Player)) {
			Player altroPlayer = ((Player)o);
			return this.getUsername().equals(altroPlayer.getUsername()) && this.getLose() == altroPlayer.getLose() &&
					this.getWin() == altroPlayer.getWin() && this.getDraw() == altroPlayer.getDraw();
		}
		return false;
	}
	
	public int compareTo(Object o) {
		if (o!= null && o.getClass() == this.getClass()) {
			Player altroPlayer = ((Player)o);
			return (this.getWin()-altroPlayer.getWin()) - (this.getLose() - altroPlayer.getLose()) - (this.getDraw() - altroPlayer.getDraw());
		}
		return -1;
	}
	
	public void incrementaWin() {
		this.win++;
	}
	
	public void incrementaLose() {
		this.lose++;
	}
	
	public void incrementaDraw() {
		this.draw++;
	}

	@Override
	public String toString() {
		return "\nusername=" + username + ", win=" + win + ", lose=" + lose + ", draw=" + draw ;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getWin() {
		return win;
	}

	public int getLose() {
		return lose;
	}

	public int getDraw() {
		return draw;
	}
	
}
