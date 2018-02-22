package ch.bbcag.tictactoe.controller;

import ch.bbcag.tictactoe.database.SpielDao;
import ch.bbcag.tictactoe.database.SpielJdbcDao;
import ch.bbcag.tictactoe.helper.GameModus;
import ch.bbcag.tictactoe.model.Ergebnis;
import ch.bbcag.tictactoe.model.Spiel;
import ch.bbcag.tictactoe.model.Spieler;

public class GameController {

	private static final GameController GAME_CONTROLLER = new GameController();

	private GameModus gameModus;

	private SpielDao spielDao = new SpielJdbcDao();

	private ComputerGameLogicController computerObject;

	private GameController() {
		this.computerObject = new ComputerGameLogicController(this);
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
	
	public String getPlayer2() {
		return this.computerObject.getPlayer2();
	}

	public void setPlayer2(String player) {
		this.computerObject.setPlayer2(player);
	}
	
	public boolean isPlayerTurn() {
		return this.computerObject.isPlayerTurn();
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
		System.out.println("Aktueller Playerturn: " + computerObject.isPlayerTurn());
		// TODO: Fix sodass der Spieler nur klicken kann, wenn er auch wirklich dran
		// ist.
		if (computerObject.isPlayerTurn() && GameModus.PLAYER_VS_COMPUTER.equals(gameModus)) {
				// int[] posComputer = computerObject.computerPlayMove();
				// TODO zeichen sollte hier schon gewechselt sein!!! Auf Variable "view"
				// TODO informiere View, dass Computer die Position posComputer gesetzt hat
				computerObject.setPlayerMove(i, j);
				if (computerObject.checkForWin().equals("gewonnen")) {
					insertDataInDB("gewonnen", "computer", "");
				} else {
					Spiel spiel = new Spiel();
					Ergebnis ergebnis = new Ergebnis();
					ergebnis.setErgebnis("gewonnen");
					spiel.setErgebnis(ergebnis);
					Spieler spieler1 = new Spieler();
					spieler1.setName(getPlayer());
					Spieler spieler2 = new Spieler();
					spieler2.setName("Computer");
					spiel.setSpieler_1(spieler1);
					spiel.setSpieler_2(spieler2);
					spiel.setZeit("01:22");
					spielDao.insertSpiel(spiel);
				}
				return "spieler";
			// TODO: Fix sodass der Spieler nur klicken kann, wenn er auch wirklich dran
			// ist.
		} else if (GameModus.PLAYER_VS_PLAYER.equals(gameModus)){
			if (computerObject.isPlayerTurn()) {
			computerObject.setPlayerMove(i, j);
			// check for win			
			} else {
			computerObject.setPlayerMove2(i, j);
			// check for win
			}
		} else if (computerObject.isPlayerTurn() == false && GameModus.PLAYER_VS_COMPUTER.equals(gameModus)) {
			System.err.println("Du bist nicht am Zug!");
			return null;
		} else {
			
		}
		return "";
	}
	

	public int[] doComputerMove() {
		// TODO: Fix NullPointerEx.
		return computerObject.computerPlayMove();
	}
	
	private void insertDataInDB(String ergebnisEingabe, String computer, String zeit) {
		Spiel spiel = new Spiel();
		Ergebnis ergebnis = new Ergebnis();
		ergebnis.setErgebnis(ergebnisEingabe);
		spiel.setErgebnis(ergebnis);
		Spieler spieler1 = new Spieler();
		spieler1.setName(getPlayer());
		Spieler spieler2 = new Spieler();
		spieler2.setName(computer);
		spiel.setSpieler_1(spieler1);
		spiel.setSpieler_2(spieler2);
		spiel.setZeit(zeit);
		spielDao.insertSpiel(spiel);
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
