package ch.bbcag.tictactoe.controller;

public class ComputerGameLogicController {
	private String player;
	private String player2;
	private String computer = "computer";
	private transient String[][] spielfeld = new String[3][3];
	private double playerTurn;

	private boolean isPlayerTurn = true;
	private int[] posComputer = null;

	public ComputerGameLogicController(GameController gameControllerObjekt) {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				spielfeld[x][y] = new String();
			}
		}
	}

	public int[] computerPlayMove() {
		findOutPlayerTurn();
		posComputer = null;

		posComputer = checkForTwoInARow();

		if (posComputer == null) {

			posComputer = playerSetztNormal();
		}
		if (posComputer == null) {

			posComputer = playerSetztEcke();
		}
		if (posComputer == null) {
			posComputer = playerSetztMitte();
		}
		if (posComputer == null) {
			posComputer = tryToWin();
		}
		if (posComputer == null) {
			posComputer = setRandom();
		}

		switchPlayerTurn();
		return posComputer;
	}

	/**
	 * Bei der Methode findOutPlayerTurn wird herausgefunden, welcher Spieler an der
	 * Reihe ist und wie viele Felder dieser Spieler bzw Computer schon besetzt hat.
	 * 
	 * @return
	 */

	private void findOutPlayerTurn() {
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
	}

	public void switchPlayerTurn() {
		isPlayerTurn = !isPlayerTurn;

	}

	private int[] checkForTwoInARow() {

		if ((spielfeld[0][1] == player && spielfeld[0][2] == player)
				|| (spielfeld[1][0] == player && spielfeld[2][0] == player)
				|| (spielfeld[1][1] == player && spielfeld[2][2] == player)) {

			if (spielfeld[0][0] != computer) {
				spielfeld[0][0] = computer;
				posComputer = new int[] { 0, 0 };
			} else {

			}
		}

		if ((spielfeld[0][0] == player && spielfeld[0][1] == player)
				|| (spielfeld[1][2] == player && spielfeld[2][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[1][1] == player)) {

			if (spielfeld[0][2] != computer) {
				spielfeld[0][2] = computer;
				posComputer = new int[] { 0, 2 };
			}
		}

		if ((spielfeld[2][1] == player && spielfeld[2][2] == player)
				|| (spielfeld[0][0] == player && spielfeld[1][0] == player)
				|| (spielfeld[1][1] == player && spielfeld[0][2] == player)) {

			if (spielfeld[2][0] != computer) {
				spielfeld[2][0] = computer;
				posComputer = new int[] { 2, 0 };
			}
		}

		if ((spielfeld[0][0] == player && spielfeld[1][1] == player)
				|| (spielfeld[0][2] == player && spielfeld[1][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[2][1] == player)) {

			if (spielfeld[2][2] != computer) {
				spielfeld[2][2] = computer;
				posComputer = new int[] { 2, 2 };
			}
		}

		if ((spielfeld[0][1] == player && spielfeld[2][1] == player)
				|| (spielfeld[1][0] == player && spielfeld[1][2] == player)
				|| (spielfeld[0][0] == player && spielfeld[2][2] == player)
				|| (spielfeld[2][0] == player && spielfeld[0][2] == player)) {

			if (spielfeld[1][1] != computer) {
				spielfeld[1][1] = computer;
				posComputer = new int[] { 1, 1 };
			}
		}

		if ((spielfeld[0][1] == player && spielfeld[1][1] == player)) {
			if (spielfeld[2][1] != computer) {
				spielfeld[2][1] = computer;
				posComputer = new int[] { 2, 1 };
			}
		}

		if ((spielfeld[1][1] == player && spielfeld[2][1] == player)) {
			if (spielfeld[0][1] != computer) {
				spielfeld[0][1] = computer;
				posComputer = new int[] { 0, 1 };
			}
		}

		if ((spielfeld[1][1] == player && spielfeld[1][2] == player)) {
			if (spielfeld[1][0] != computer) {
				spielfeld[1][0] = computer;
				posComputer = new int[] { 1, 0 };
			}
		}

		if ((spielfeld[1][0] == player && spielfeld[1][1] == player)) {
			if (spielfeld[1][2] != computer) {
				spielfeld[1][2] = computer;
				posComputer = new int[] { 1, 2 };
			}
		}

		if ((spielfeld[0][0] == player && spielfeld[0][2] == player)) {
			if (spielfeld[0][1] != computer) {
				spielfeld[0][1] = computer;
				posComputer = new int[] { 0, 1 };
			}
		}

		if ((spielfeld[0][0] == player && spielfeld[1][1] == player)) {
			if (spielfeld[2][2] != computer) {
				spielfeld[2][2] = computer;
				posComputer = new int[] { 2, 2 };
			}
		}

		if ((spielfeld[0][0] == player && spielfeld[2][0] == player)) {
			if (spielfeld[1][0] != computer) {
				spielfeld[1][0] = computer;
				posComputer = new int[] { 1, 0 };
			}
		}

		if ((spielfeld[0][2] == player && spielfeld[2][2] == player)) {
			if (spielfeld[1][2] != computer) {
				spielfeld[1][2] = computer;
				posComputer = new int[] { 1, 2 };
			}
		}

		if ((spielfeld[2][0] == player && spielfeld[2][2] == player)) {
			if (spielfeld[2][1] != computer) {
				spielfeld[2][1] = computer;
				posComputer = new int[] { 2, 1 };
			}
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

		if (playerTurn == 0.5) {
			if (spielfeld[1][1] == player) {
				if (spielfeld[0][0] != computer) {
					spielfeld[0][0] = computer;
					posComputer = new int[] { 0, 0 };
				}
			}
		}

		else if (playerTurn == 1.5) {
			if (spielfeld[2][0] != computer) {
				spielfeld[2][0] = computer;
				posComputer = new int[] { 2, 0 };
			}
		}
		return posComputer;
	}

	private int[] playerSetztEcke() {

		if (spielfeld[0][0] == player || spielfeld[0][2] == player || spielfeld[2][0] == player
				|| spielfeld[2][2] == player) {
			if (playerTurn == 0.5) {
				spielfeld[1][1] = computer;
				posComputer = new int[] { 1, 1 };
			}
		} else if (playerTurn == 1.5) {
			if ((spielfeld[0][0] == player && spielfeld[2][1] == player)
					|| (spielfeld[2][1] == player && spielfeld[0][2] == player)
					|| (spielfeld[0][0] == player && spielfeld[1][2] == player)
					|| (spielfeld[1][0] == player && spielfeld[0][2] == player)
					|| (spielfeld[2][0] == player && spielfeld[0][1] == player)
					|| (spielfeld[0][1] == player && spielfeld[2][2] == player)
					|| (spielfeld[2][0] == player && spielfeld[1][2] == player)
					|| (spielfeld[1][0] == player && spielfeld[2][2] == player)) {

				if (spielfeld[2][0] == player) {
					if (spielfeld[2][2] != computer) {
						spielfeld[2][2] = computer;
						posComputer = new int[] { 2, 2 };
					}
				}

				else {
					if (spielfeld[2][0] != computer) {
						spielfeld[2][0] = computer;
						posComputer = new int[] { 2, 0 };
					}
				}
			}

			else {
				if (spielfeld[2][1] != computer) {
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
			if (playerTurn == 0.5) {

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

			if (spielfeld[0][0] != player) {
				spielfeld[0][0] = computer;
				posComputer = new int[] { 0, 0 };
			}
		}

		if ((spielfeld[0][0] == computer && spielfeld[0][1] == computer)
				|| (spielfeld[1][2] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[1][1] == computer)) {

			if (spielfeld[0][2] != player) {
				spielfeld[0][2] = computer;
				posComputer = new int[] { 0, 2 };
			}
		}

		if ((spielfeld[2][1] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[0][0] == computer && spielfeld[1][0] == computer)
				|| (spielfeld[1][1] == computer && spielfeld[0][2] == computer)) {

			if (spielfeld[2][0] != player) {
				spielfeld[2][0] = computer;
				posComputer = new int[] { 2, 0 };
			}
		}

		if ((spielfeld[0][0] == computer && spielfeld[1][1] == computer)
				|| (spielfeld[0][2] == computer && spielfeld[1][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[2][1] == computer)) {

			if (spielfeld[2][2] != player) {
				spielfeld[2][2] = computer;
				posComputer = new int[] { 2, 2 };
			}
		}

		if ((spielfeld[0][1] == computer && spielfeld[2][1] == computer)
				|| (spielfeld[1][0] == computer && spielfeld[1][2] == computer)
				|| (spielfeld[0][0] == computer && spielfeld[2][2] == computer)
				|| (spielfeld[2][0] == computer && spielfeld[0][2] == computer)) {

			if (spielfeld[1][1] != player) {
				spielfeld[1][1] = computer;
				posComputer = new int[] { 1, 1 };
			}
		}

		if ((spielfeld[0][1] == computer && spielfeld[1][1] == computer)) {
			if (spielfeld[2][1] != player) {
				spielfeld[2][1] = computer;
				posComputer = new int[] { 2, 1 };
			}
		}

		if ((spielfeld[1][1] == computer && spielfeld[2][1] == computer)) {
			if (spielfeld[0][1] != player) {
				spielfeld[0][1] = computer;
				posComputer = new int[] { 0, 1 };
			}
		}

		if ((spielfeld[1][1] == computer && spielfeld[1][2] == computer)) {
			if (spielfeld[1][0] != player) {
				spielfeld[1][0] = computer;
				posComputer = new int[] { 1, 0 };
			}
		}

		if ((spielfeld[1][0] == computer && spielfeld[1][1] == computer)) {
			if (spielfeld[1][2] != player) {
				spielfeld[1][2] = computer;
				posComputer = new int[] { 1, 2 };
			}
		}

		if ((spielfeld[0][0] == computer && spielfeld[0][2] == computer)) {
			if (spielfeld[0][1] != player) {
				spielfeld[0][1] = computer;
				posComputer = new int[] { 0, 1 };
			}
		}

		if ((spielfeld[0][2] == computer && spielfeld[2][2] == computer)) {
			if (spielfeld[1][2] != player) {
				spielfeld[1][2] = computer;
				posComputer = new int[] { 1, 2 };
			}
		}

		if ((spielfeld[2][2] == computer && spielfeld[2][0] == computer)) {
			if (spielfeld[2][1] != player) {
				spielfeld[2][1] = computer;
				posComputer = new int[] { 2, 1 };
			}
		}

		if ((spielfeld[0][0] == computer && spielfeld[2][0] == computer)) {
			if (spielfeld[1][0] != player) {
				spielfeld[1][0] = computer;
				posComputer = new int[] { 1, 0 };
			}
		}
		return posComputer;
	}

	private int[] setRandom() {

		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j].equals("")) {
					spielfeld[i][j] = computer;
					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getPlayer() {
		return this.player;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.player2 = player2;
	}

	public boolean checkHorizontalRow(int i, String playerName) {

		if (spielfeld[i][0] == playerName && spielfeld[i][1] == playerName && spielfeld[i][2] == playerName) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkVertikalRow(int j, String playerName) {
		if (spielfeld[0][j] == playerName && spielfeld[1][j] == playerName && spielfeld[2][j] == playerName) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDiagonalFromLeftToRightRow(String playerName) {
		if (spielfeld[0][0] == playerName && spielfeld[1][1] == playerName && spielfeld[2][2] == playerName) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkDiagonalFromRightToLeftRow(String playerName) {
		if (spielfeld[2][0] == playerName && spielfeld[1][1] == playerName && spielfeld[0][2] == playerName) {
			return true;
		} else {
			return false;
		}
	}

	public String checkForWin(String playerName) {
		if (checkHorizontalRow(0, playerName) == true || checkHorizontalRow(1, playerName) == true
				|| checkHorizontalRow(2, playerName) == true ||

				checkVertikalRow(0, playerName) == true || checkVertikalRow(1, playerName) == true
				|| checkVertikalRow(2, playerName) == true ||

				checkDiagonalFromRightToLeftRow(playerName) == true
				|| checkDiagonalFromLeftToRightRow(playerName) == true) {
			clear();
			return "gewonnen";
		} else if (checkEmptyFilds() == true) {
			clear();
			return "gleichstandOderVerloren";
		}
		return "";
	}

	private boolean checkEmptyFilds() {
		int numberOfEmptyFields = 0;

		for (int i = 0; i < spielfeld.length; i++) {
			for (int j = 0; j < spielfeld.length; j++) {
				if (spielfeld[i][j].equals("")) {
					numberOfEmptyFields++;
				}
			}
		}

		if (numberOfEmptyFields == 0) {
			return true;
		} else {
			return false;
		}

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
		// System.out.println("Spieler im Feld spielfeld[" + i + "][" + j + "] VORHER: "
		// + spielfeld[i][j]);
		if (spielfeld[i][j].isEmpty()) {
			spielfeld[i][j] = this.getPlayer();
			switchPlayerTurn();
			// System.out.println("Spieler im Feld spielfeld[" + i + "][" + j + "] NACHHER:
			// " + spielfeld[i][j]);
		}
	}

	public void setPlayerMove2(int i, int j) {
		// System.out.println("Spieler im Feld spielfeld[" + i + "][" + j + "] VORHER: "
		// + spielfeld[i][j]);
		if (spielfeld[i][j].isEmpty()) {
			spielfeld[i][j] = this.getPlayer2();
			switchPlayerTurn();
			// System.out.println("Spieler im Feld spielfeld[" + i + "][" + j + "] NACHHER:
			// " + spielfeld[i][j]);
		}
	}

	public String[][] getSpielfeld() {
		return spielfeld;
	}

}
