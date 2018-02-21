package ch.bbcag.tictactoe.controller;

public class ComputerGameLogicController {
	private String player;
	private String computer = "computer";
	private String[][] spielfeld = new String[3][3];
	private boolean isPlayerTurn = true;
	int[] posComputer = null;

	public ComputerGameLogicController() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				spielfeld[x][y] = new String();
			}
		}
	}

	public int[] computerPlayMove() {
		int[] posComputer = null;

		switchPlayerTurn();

		posComputer = checkForTwoInARow();

		if (posComputer == null) {

			posComputer = tryToWin();

			if (posComputer == null) {

				posComputer = playerSetztEcke();
				//System.out.println(posComputer);
				if (posComputer == null) {

					posComputer = playerSetztMitte();

					if (posComputer == null) {

						posComputer = playerSetztNormal();
						if (posComputer == null) {
							System.err.println("Gibt nichts zurück!");
						}
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

	private void switchPlayerTurn() {
//		//TODO: Fix Bug: Output muss für Spieler und Computer je gleich sein!
//		final int NUMBER_OF_FIELDS = 9;
//		final int NUMBER_OF_PLAYERS = 2;
//		int numberOfEmptyFields = 0;
//
//		for (int i = 0; i < spielfeld.length; i++) {
//			for (int j = 0; j < spielfeld.length; j++) {
//				if (spielfeld[i][j].equals("")) {
//					numberOfEmptyFields++;
//				}
//			}
//		}
//
//		playerTurn = (NUMBER_OF_FIELDS - numberOfEmptyFields) % NUMBER_OF_PLAYERS;
		isPlayerTurn = !isPlayerTurn;
		
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
		
		if ((spielfeld[0][0] == player && spielfeld[0][2] == player)) {
			spielfeld[0][1] = computer;
			posComputer = new int[] { 0, 1 };
		}
		
		return posComputer;
	}

	/**
	 * Die ganze Logik darin besteht daraus, dass wenn der Spieler zuerst in die
	 * Mitte Setzt , dass der Computer dann in eine Ecke setzt, da er sonst
	 * verlieren könnte. Nach den ersten Schritten, die bestimmt sind, sollte
	 * einfach die checkForTwoInRow Methode angewendet werden.
	 * 
	 * @return
	 */

	private int[] playerSetztMitte() {

		if (!isPlayerTurn) {
			if (spielfeld[1][1] == player) {
				spielfeld[0][0] = computer;
				posComputer = new int[] { 0, 0 };
			}
		}

		else if (isPlayerTurn) {
			spielfeld[2][0] = computer;
			posComputer = new int[] { 2, 0 };
		}
		return posComputer;
	}

	private int[] playerSetztEcke() {

		if (spielfeld[0][0] == player || spielfeld[0][2] == player || spielfeld[2][0] == player
				|| spielfeld[2][2] == player) {
			if (!isPlayerTurn) {
				spielfeld[1][1] = computer;
				posComputer = new int[] { 1, 1 };
			} else if (isPlayerTurn) {
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
			if (!isPlayerTurn) {

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

	public void setPlayer(String player) {
		this.player = player;
	}
	
	public String getPlayer() {
		return this.player;
	}
	
	public boolean checkHorizontalRow(int i) {
		for (int j = 0; j < 2; j++) {
			if (spielfeld[i][j] == player) {
				return true;
			}
		}
		return false;
	}

	public boolean checkVertikalRow(int j) {
		for (int i = 0; i < 2; i++) {
			if (spielfeld[i][j] == player) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonalFromLeftToRightRow() {
		for (int i = 0; i < 2; i++) {
			if (spielfeld[i][i] == player) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonalFromRightToLeftRow() {
		if (spielfeld[2][0] == player && spielfeld[1][1] == player && spielfeld[0][2] == player) {
			return true;
		}
		return false;
	}

	public void checkForWin() {

		checkHorizontalRow(0);
		checkHorizontalRow(1);
		checkHorizontalRow(2);

		checkVertikalRow(0);
		checkVertikalRow(1);
		checkVertikalRow(2);

		checkDiagonalFromRightToLeftRow();
		checkDiagonalFromLeftToRightRow();
	}
	public void clear() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				spielfeld[i][j] = "";
			}
		}
	}

	public boolean isPlayerTurn() {
		return isPlayerTurn;
	}

	public void setPlayerMove(int i, int j) {
		System.out.println("Spieler im Feld spielfeld[" + i + "][" + j + "] VORHER: " + spielfeld[i][j]);
		if (spielfeld[i][j].isEmpty()) {
			spielfeld[i][j] = this.getPlayer();
			switchPlayerTurn();
			System.out.println("Spieler im Feld spielfeld[" + i + "][" + j + "] NACHHER: " + spielfeld[i][j]);
		}
	}
	
	
}


