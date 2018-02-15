package ch.bbcag.tictactoe;

public class GameController {

	private TicTacToeView view;
	private GameModus gameModus;
	private String player;
	private String[][] spielfeld = new String[3][3];
	private Computer computer;

	public GameController(TicTacToeView view) {
		setView(view);
		clear();
	}

	private TicTacToeView getView() {
		return view;
	}

	private void setView(TicTacToeView view) {
		this.view = view;
	}

	public void clear() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				spielfeld[i][j] = "";
			}
		}
	}

	public void setField(String player, int i, int j) {
		spielfeld[i][j] = player;
		checkForWin();

		if (GameModus.PLAYER_VS_COMPUTER.equals(gameModus)) {
			Computer computerObject = new Computer();
			int[] posComputer = computerObject.computer();
			// TODO zeichen sollte hier schon gewechselt sein!!!
			// TODO informiere View, dass Computer die Position posComputer gesetzt hat
			checkForWin();
		} else {
			// TODO Spieler vs Spieler soll startbereit sein(falls es noch nihct so ist)
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
}