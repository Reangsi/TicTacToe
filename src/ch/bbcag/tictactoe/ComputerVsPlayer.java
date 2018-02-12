package ch.bbcag.tictactoe;

public class ComputerVsPlayer {
	private String player;
	private String computer;
	private String[][] spielfeld = new String[3][3];

	public void checkForTwoInARow() {
		if ((spielfeld[0][1] == player && spielfeld[0][2] == player)
				|| (spielfeld[1][0] == player && spielfeld[2][0] == player)
				|| (spielfeld[1][1] == player && spielfeld[2][2] == player)) {

			spielfeld[0][0] = computer;
		}

		if ((spielfeld[0][0] == player && spielfeld[0][1] == player)
				|| (spielfeld[1][2] == player && spielfeld[2][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[1][1] == player)) {

			spielfeld[0][2] = computer;
		}

		if ((spielfeld[2][1] == player && spielfeld[2][2] == player)
				|| (spielfeld[0][0] == player && spielfeld[1][0] == player)
				|| (spielfeld[1][1] == player && spielfeld[0][2] == player)) {

			spielfeld[2][0] = computer;
		}

		if ((spielfeld[0][0] == player && spielfeld[1][1] == player)
				|| (spielfeld[0][2] == player && spielfeld[1][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[2][1] == player)) {

			spielfeld[2][2] = computer;
		}

		if ((spielfeld[0][1] == player && spielfeld[2][1] == player)
				|| (spielfeld[1][0] == player && spielfeld[1][2] == player)
				|| (spielfeld[0][0] == player && spielfeld[2][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[0][2] == player)) {

			spielfeld[1][1] = computer;
		}

		if ((spielfeld[0][1] == player && spielfeld[1][1] == player)) {
			spielfeld[2][1] = computer;
		}

		if ((spielfeld[1][1] == player && spielfeld[2][1] == player)) {
			spielfeld[0][1] = computer;
		}

		if ((spielfeld[1][1] == player && spielfeld[1][2] == player)) {
			spielfeld[1][0] = computer;
		}

		if ((spielfeld[1][0] == player && spielfeld[1][1] == player)) {
			spielfeld[1][2] = computer;
		}
	}

	// Die ganze Logik darin besteht daraus, dass wenn der Spieler zuerst in die
	// mitte Setzt
	// , dass der Computer dann in eine Ecke setzt, da er sonst verlieren könnte.
	// Nach den ersten
	// Schritten, die bestimmt sind, wird einfach die checkForTwoInRow Methode
	// angewendet.
	// public void playerSetztMitte() {
	// if (PlayerTurn == 1) {
	// if (spielfeld[1][1] == player) {
	// spielfeld[0][0] = computer;
	// }
	// }
	//
	// else if (PlayerTurn == bf2) { // Diese Funktion wird noch gemacht
	// spielfeld[2][0] = computer;
	// }
	// }
}
