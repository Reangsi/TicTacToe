package ch.bbcag.tictactoe.model;

public class Spiel {
	private String zeit;
	private Spieler spieler_1;
	private Spieler spieler_2;
	private Ergebnis ergebnis;

	public String getZeit() {
		return zeit;
	}

	public void setZeit(String zeit) {
		this.zeit = zeit;
	}

	public Spieler getSpieler_1() {
		return spieler_1;
	}

	public void setSpieler_1(Spieler spieler_1) {
		this.spieler_1 = spieler_1;
	}

	public Spieler getSpieler_2() {
		return spieler_2;
	}

	public void setSpieler_2(Spieler spieler_2) {
		this.spieler_2 = spieler_2;
	}

	public Ergebnis getErgebnis() {
		return ergebnis;
	}

	public void setErgebnis(Ergebnis ergebnis) {
		this.ergebnis = ergebnis;
	}
}