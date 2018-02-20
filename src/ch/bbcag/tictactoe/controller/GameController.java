package ch.bbcag.tictactoe.controller;

import ch.bbcag.tictactoe.helper.GameModus;

public class GameController {

	private static final GameController GAME_CONTROLLER = new GameController();

	private GameModus gameModus;
	private String player = new String();
	private String currentPlayer = new String();
	private String[][] spielfeld = new String[3][3];
	private ComputerGameLogicController computerObject = new ComputerGameLogicController();

	private GameController() {
	}

	public static GameController getGameController() {
		return GameController.GAME_CONTROLLER;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
		this.currentPlayer = player;
	}

	public GameModus getGameModus() {
		return gameModus;
	}

	public void setGameModus(GameModus gameModus) {
		this.gameModus = gameModus;
	}

	public void clear() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				spielfeld[i][j] = "";
			}
		}
	}

	public String setField(int i, int j) {
		// int x;
		// int y;

		if (currentPlayer.equals(player)) {
			if (GameModus.PLAYER_VS_COMPUTER.equals(gameModus)) {
				spielfeld[i][j] = player;
				// int[] posComputer = computerObject.computerPlayMove();

				// TODO zeichen sollte hier schon gewechselt sein!!! Auf Variable "view"
				// aufrufen
				// x = posComputer[0];
				// y = posComputer[1];
				// getCordinatesForButton(x,y);
				// TODO informiere View, dass Computer die Position posComputer gesetzt hat
				checkForWin();
				currentPlayer = "computer";
				return "spieler";
			} else {
				// TODO Spieler vs Spieler soll startbereit sein(falls es noch nihct so ist)
				return null;
			}
		} else {
			System.err.println("Du bist nicht am Zug!");
			return null;
		}

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

	public int getCordinatesForButton(int i, int j) {
		String x = Integer.toString(i);
		String y = Integer.toString(i);
		String cords = x + y;
		int xy = Integer.valueOf(cords);
		switch (xy) {
		case 0:
			xy = 1;
			break;
		case 1:
			xy = 2;
			break;
		case 2:
			xy = 3;
			break;
		case 10:
			xy = 4;
			break;
		case 11:
			xy = 5;
			break;
		case 12:
			xy = 6;
			break;
		case 20:
			xy = 7;
			break;
		case 21:
			xy = 8;
			break;
		case 22:
			xy = 9;
			break;

		}
		return xy;
	}

	public void doComputerMove() {
		//TODO: Fix NullPointerEx.
		int[] posComputer = computerObject.computerPlayMove();
		System.out.println("Pos Values of Computer:");
		if (posComputer != null) {
			System.out.println("posComputer Length: " + posComputer.length);
			for (int i : posComputer) {
				System.out.println(i);
			}
			spielfeld[posComputer[0]][posComputer[1]] = "computer";
		}
		currentPlayer = player;
	}

	// public int getCordinatesForLogic(int i) {
	// int x = 0;
	// int y = 0;
	// int[] xyList = new int[2];
	// if (i > 9 || i < 1) {
	// throw new IllegalArgumentException("I muss zwischen 1 und 9 sein!");
	// }
	// switch (i) {
	// case 1:
	// x = 0;
	// y = 0;
	// break;
	// case 2:
	// x = 0;
	// y = 1;
	// break;
	// case 3:
	// x = 0;
	// y = 2;
	// break;
	// case 4:
	// x = 1;
	// y = 0;
	// break;
	// case 5:
	// x = 1;
	// y = 1;
	// break;
	// case 6:
	// x = 1;
	// y = 2;
	// break;
	// case 7:
	// x = 2;
	// y = 0;
	// break;
	// case 8:
	// x = 2;
	// y = 1;
	// break;
	// case 9:
	// x = 2;
	// y = 2;
	// break;
	//
	// }
	// xyList[0] = x;
	// xyList[1] = y;
	// for (int z = 0; z < 2; z++) {
	// return xyList[z];
	// }
	// }

}