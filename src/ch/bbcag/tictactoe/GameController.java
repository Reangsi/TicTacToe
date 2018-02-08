package ch.bbcag.tictactoe;

public class GameController {
	
	private String player;
	
	private String[][] spielfeld = new String[3][3];

	public GameController() {
		clear();
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

