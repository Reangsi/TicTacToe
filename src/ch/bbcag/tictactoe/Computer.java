package ch.bbcag.tictactoe;

public class Computer {
	private String player;
	private String computer;
	private String[][] spielfeld = new String[3][3];
	private double playerTurn;

	public void computer() {

		findOutPlayerTurn();
		checkForTwoInARow();
		tryToWin();
		playerSetztEcke();
		playerSetztMitte();
		playerSetztNormal();
	}

	/**
	 * Bei der Methode findOutPlayerTurn wird herausgefunden, welcher Spieler an der
	 * Reihe ist und wie viele Felder dieser Spieler bzw Computer schon besetzt hat.
	 * 
	 * @return
	 */

	private double findOutPlayerTurn() {

		final int NUMBER_OF_FIELDS = 9;
		final int NUMBER_OF_PLAYERS = 2;
		int numberOfEmptyFields = 0;

		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j].equals("")) {
					numberOfEmptyFields++;
				}
			}
		}

		playerTurn = (NUMBER_OF_FIELDS - numberOfEmptyFields) / NUMBER_OF_PLAYERS + 0.5;
		return playerTurn;
	}

	private void checkForTwoInARow() {

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

	/**
	 * Die ganze Logik darin besteht daraus, dass wenn der Spieler zuerst in die
	 * mitte Setzt , dass der Computer dann in eine Ecke setzt, da er sonst
	 * verlieren könnte. Nach den ersten Schritten, die bestimmt sind, wird einfach
	 * die checkForTwoInRow Methode angewendet.
	 * 
	 * @return
	 */

	private void playerSetztMitte() {

		if (playerTurn == 1) {
			if (spielfeld[1][1] == player) {
				spielfeld[0][0] = computer;
			}
		}

		else if (playerTurn == 2) {
			spielfeld[2][0] = computer;
		}
	}

	private void playerSetztEcke() {

		if (spielfeld[0][0] == player || spielfeld[0][2] == player || spielfeld[2][0] == player
				|| spielfeld[2][2] == player) {
			if (playerTurn == 1) {
				spielfeld[1][1] = computer;
			} else if (playerTurn == 2) {
				if ((spielfeld[0][0] == player && spielfeld[2][1] == player)
						|| (spielfeld[2][1] == player && spielfeld[0][2] == player)
						|| (spielfeld[0][0] == player && spielfeld[1][2] == player)
						|| (spielfeld[1][0] == player && spielfeld[0][2] == player)
						|| (spielfeld[2][0] == player && spielfeld[0][1] == player)
						|| (spielfeld[0][1] == player && spielfeld[2][2] == player)
						|| (spielfeld[2][0] == player && spielfeld[1][2] == player)
						|| (spielfeld[1][0] == player && spielfeld[2][2] == player)) {

					if (spielfeld[2][0] == player) {
						spielfeld[2][2] = computer;
					}

					else {
						spielfeld[2][0] = computer;
					}
				}

				else {
					spielfeld[2][1] = computer;

				}
			}
		}
	}

	private void playerSetztNormal() {

		if (spielfeld[0][1] == player || spielfeld[1][2] == player || spielfeld[1][0] == player
				|| spielfeld[2][1] == player) {
			if (playerTurn == 1) {

				if (spielfeld[0][1] == player) {
					spielfeld[2][1] = computer;
				}

				if (spielfeld[1][0] == player) {
					spielfeld[1][2] = computer;
				}

				if (spielfeld[2][1] == player) {
					spielfeld[0][1] = computer;
				}

				if (spielfeld[1][2] == player) {
					spielfeld[1][0] = computer;
				}
			}
		}
	}

	private void tryToWin() {

		if ((spielfeld[0][1] == computer && spielfeld[0][2] == computer)
				|| (spielfeld[1][0] == computer && spielfeld[2][0] == computer)
				|| (spielfeld[1][1] == computer && spielfeld[2][2] == computer)) {

			spielfeld[0][0] = computer;
		}

		if ((spielfeld[0][0] == computer && spielfeld[0][1] == computer)
				|| (spielfeld[1][2] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[1][1] == computer)) {

			spielfeld[0][2] = computer;
		}

		if ((spielfeld[2][1] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[0][0] == computer && spielfeld[1][0] == computer)
				|| (spielfeld[1][1] == computer && spielfeld[0][2] == computer)) {

			spielfeld[2][0] = computer;
		}

		if ((spielfeld[0][0] == computer && spielfeld[1][1] == computer)
				|| (spielfeld[0][2] == computer && spielfeld[1][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[2][1] == computer)) {

			spielfeld[2][2] = computer;
		}

		if ((spielfeld[0][1] == computer && spielfeld[2][1] == computer)
				|| (spielfeld[1][0] == computer && spielfeld[1][2] == computer)
				|| (spielfeld[0][0] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[0][2] == computer)) {

			spielfeld[1][1] = computer;
		}

		if ((spielfeld[0][1] == computer && spielfeld[1][1] == computer)) {
			spielfeld[2][1] = computer;
		}

		if ((spielfeld[1][1] == computer && spielfeld[2][1] == computer)) {
			spielfeld[0][1] = computer;
		}

		if ((spielfeld[1][1] == computer && spielfeld[1][2] == computer)) {
			spielfeld[1][0] = computer;
		}

		if ((spielfeld[1][0] == computer && spielfeld[1][1] == computer)) {
			spielfeld[1][2] = computer;
		}
	}
}
