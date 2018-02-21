package ch.bbcag.tictactoe.controller;

import ch.bbcag.tictactoe.helper.GameModus;

public class GameController {

	private static final GameController GAME_CONTROLLER = new GameController();

	private GameModus gameModus;

	private ComputerGameLogicController computerObject = new ComputerGameLogicController();

	private GameController() {
	}

	public static GameController getGameController() {
		return GameController.GAME_CONTROLLER;
	}

	public String getPlayer() {
		return this.computerObject.getPlayer();
	}

	public void setPlayer(String player) {
		this.computerObject.setPlayer(player);
	}

	public GameModus getGameModus() {
		return gameModus;
	}

	public void setGameModus(GameModus gameModus) {
		this.gameModus = gameModus;
	}



	public String setField(int i, int j) {
		// int x;
		// int y;
		System.out.println(computerObject.getPlayerTurn());
		if (computerObject.getPlayerTurn() == 1 || computerObject.getPlayerTurn() == 0) {
			if (GameModus.PLAYER_VS_COMPUTER.equals(gameModus)) {

				// int[] posComputer = computerObject.computerPlayMove();

				// TODO zeichen sollte hier schon gewechselt sein!!! Auf Variable "view"
				// aufrufen
				// x = posComputer[0];
				// y = posComputer[1];
				// getCordinatesForButton(x,y);
				// TODO informiere View, dass Computer die Position posComputer gesetzt hat
				computerObject.setPlayerMove(i, j);
				computerObject.checkForWin();
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



	public void doComputerMove() {
		//TODO: Fix NullPointerEx.
		int[] posComputer = computerObject.computerPlayMove();
		
		System.out.println("Pos Values of Computer:");
		if (posComputer != null) {
			System.out.println("posComputer Length: " + posComputer.length);
			for (int i : posComputer) {
				System.out.println(i);
			}
		}
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