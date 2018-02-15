package ch.bbcag.tictactoe;

public class Computer {
	private String player;
	private String computer;
	private String[][] spielfeld = new String[3][3];
	private double playerTurn;
	int[] posComputer = null;

	public int[] computer() {
		int[] posComputer = null;

		findOutPlayerTurn();

		posComputer = checkForTwoInARow();

		if (posComputer == null) {

			posComputer = tryToWin();

			if (posComputer == null) {

				posComputer = playerSetztEcke();

				if (posComputer == null) {

					posComputer = playerSetztMitte();

					if (posComputer == null) {

						posComputer = playerSetztNormal();
					}
				}
			}
		}
		return posComputer;
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

	private int[] checkForTwoInARow() {

		if ((spielfeld[0][1] == player && spielfeld[0][2] == player)
				|| (spielfeld[1][0] == player && spielfeld[2][0] == player)
				|| (spielfeld[1][1] == player && spielfeld[2][2] == player)) {

			spielfeld[0][0] = computer;
			posComputer = new int[] { 0, 0 };
		}

		if ((spielfeld[0][0] == player && spielfeld[0][1] == player)
				|| (spielfeld[1][2] == player && spielfeld[2][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[1][1] == player)) {

			spielfeld[0][2] = computer;
			posComputer = new int[] { 0, 2 };
		}

		if ((spielfeld[2][1] == player && spielfeld[2][2] == player)
				|| (spielfeld[0][0] == player && spielfeld[1][0] == player)
				|| (spielfeld[1][1] == player && spielfeld[0][2] == player)) {

			spielfeld[2][0] = computer;
			posComputer = new int[] { 2, 0 };
		}

		if ((spielfeld[0][0] == player && spielfeld[1][1] == player)
				|| (spielfeld[0][2] == player && spielfeld[1][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[2][1] == player)) {

			spielfeld[2][2] = computer;
			posComputer = new int[] { 2, 2 };
		}

		if ((spielfeld[0][1] == player && spielfeld[2][1] == player)
				|| (spielfeld[1][0] == player && spielfeld[1][2] == player)
				|| (spielfeld[0][0] == player && spielfeld[2][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[0][2] == player)) {

			spielfeld[1][1] = computer;
			posComputer = new int[] { 1, 1 };
		}

		if ((spielfeld[0][1] == player && spielfeld[1][1] == player)) {
			spielfeld[2][1] = computer;
			posComputer = new int[] { 2, 1 };
		}

		if ((spielfeld[1][1] == player && spielfeld[2][1] == player)) {
			spielfeld[0][1] = computer;
			posComputer = new int[] { 0, 1 };
		}

		if ((spielfeld[1][1] == player && spielfeld[1][2] == player)) {
			spielfeld[1][0] = computer;
			posComputer = new int[] { 1, 0 };
		}

		if ((spielfeld[1][0] == player && spielfeld[1][1] == player)) {
			spielfeld[1][2] = computer;
			posComputer = new int[] { 1, 2 };
		}
		return posComputer;
	}

	/**
	 * Die ganze Logik darin besteht daraus, dass wenn der Spieler zuerst in die
	 * mitte Setzt , dass der Computer dann in eine Ecke setzt, da er sonst
	 * verlieren könnte. Nach den ersten Schritten, die bestimmt sind, wird einfach
	 * die checkForTwoInRow Methode angewendet.
	 * 
	 * @return
	 */

	private int[] playerSetztMitte() {

		if (playerTurn == 1) {
			if (spielfeld[1][1] == player) {
				spielfeld[0][0] = computer;
				posComputer = new int[] { 0, 0 };
			}
		}

		else if (playerTurn == 2) {
			spielfeld[2][0] = computer;
			posComputer = new int[] { 2, 0 };
		}
		return posComputer;
	}

	private int[] playerSetztEcke() {

		if (spielfeld[0][0] == player || spielfeld[0][2] == player || spielfeld[2][0] == player
				|| spielfeld[2][2] == player) {
			if (playerTurn == 1) {
				spielfeld[1][1] = computer;
				posComputer = new int[] { 1, 1 };
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
						posComputer = new int[] { 2, 2 };
					}

					else {
						spielfeld[2][0] = computer;
						posComputer = new int[] { 2, 0 };
					}
				}

				else {
					spielfeld[2][1] = computer;
					posComputer = new int[] { 2, 1 };
				}
			}
		}
		return posComputer;
	}

	private int[] playerSetztNormal() {
		if (spielfeld[0][1] == player || spielfeld[1][2] == player || spielfeld[1][0] == player
				|| spielfeld[2][1] == player) {
			if (playerTurn == 1) {

				if (spielfeld[0][1] == player) {
					spielfeld[2][1] = computer;
					posComputer = new int[] { 2, 1 };
				}

				if (spielfeld[1][0] == player) {
					spielfeld[1][2] = computer;
					posComputer = new int[] { 1, 2 };
				}

				if (spielfeld[2][1] == player) {
					spielfeld[0][1] = computer;
					posComputer = new int[] { 0, 1 };
				}

				if (spielfeld[1][2] == player) {
					spielfeld[1][0] = computer;
					posComputer = new int[] { 1, 0 };
				}
			}
		}
		return posComputer;
	}

	private int[] tryToWin() {

		if ((spielfeld[0][1] == computer && spielfeld[0][2] == computer)
				|| (spielfeld[1][0] == computer && spielfeld[2][0] == computer)
				|| (spielfeld[1][1] == computer && spielfeld[2][2] == computer)) {

			spielfeld[0][0] = computer;
			posComputer = new int[] { 0, 0 };
		}

		if ((spielfeld[0][0] == computer && spielfeld[0][1] == computer)
				|| (spielfeld[1][2] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[1][1] == computer)) {

			spielfeld[0][2] = computer;
			posComputer = new int[] { 0, 2 };
		}

		if ((spielfeld[2][1] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[0][0] == computer && spielfeld[1][0] == computer)
				|| (spielfeld[1][1] == computer && spielfeld[0][2] == computer)) {

			spielfeld[2][0] = computer;
			posComputer = new int[] { 2, 0 };
		}

		if ((spielfeld[0][0] == computer && spielfeld[1][1] == computer)
				|| (spielfeld[0][2] == computer && spielfeld[1][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[2][1] == computer)) {

			spielfeld[2][2] = computer;
			posComputer = new int[] { 2, 2 };
		}

		if ((spielfeld[0][1] == computer && spielfeld[2][1] == computer)
				|| (spielfeld[1][0] == computer && spielfeld[1][2] == computer)
				|| (spielfeld[0][0] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[0][2] == computer)) {

			spielfeld[1][1] = computer;
			posComputer = new int[] { 1, 1 };
		}

		if ((spielfeld[0][1] == computer && spielfeld[1][1] == computer)) {
			spielfeld[2][1] = computer;
			posComputer = new int[] { 2, 1 };
		}

		if ((spielfeld[1][1] == computer && spielfeld[2][1] == computer)) {
			spielfeld[0][1] = computer;
			posComputer = new int[] { 0, 1 };
		}

		if ((spielfeld[1][1] == computer && spielfeld[1][2] == computer)) {
			spielfeld[1][0] = computer;
			posComputer = new int[] { 1, 0 };
		}

		if ((spielfeld[1][0] == computer && spielfeld[1][1] == computer)) {
			spielfeld[1][2] = computer;
			posComputer = new int[] { 1, 2 };
		}
		return posComputer;
	}
}
