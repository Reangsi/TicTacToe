package ch.bbcag.tictactoe;

public class GameController {

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
	
	public void checkForWin() {
		
	}
}

//	{
//		int gamemode = 2;
//		String board = "";
//		int player = -1;
//
//		if (gamemode == 0) {
//			// Gui anzeigen
//			// Computer-Logik s
//		} else {
//			// Gui anzeigen
//			if (board == "[20][21][22]" || board == "[10][11][12]" || board == "[00][01][02]" || board == "[00][11][22]" // Schaut
//																															// wer
//																															// gewonnen
//																															// hat
//					|| board == "[20][11][02]" || board == "[00][10][20]" || board == "[01][11][21]"
//					|| board == "[02][12][22]") {
//				// gameover
//				if (player == 1) {
//					System.out.println("Player 1 hat gewonnen!");
//				} else {
//					System.out.println("Player 2 hat gewonnen!");
//				}
//
//			} else if (board == "[00][01][02][10][11][12][20][21][22]") {
//				System.out.println("Unentschieden");
//				// gameover ()
//			}
//
//		}
//	}
//
//	boolean checkForWinningRow() {
//
//		if (checkIfEqual(0, 1) && checkIfEqual(1, 2))
//
//			return true;
//		else if (checkIfEqual(3, 4) && checkIfEqual(4, 5))
//			return true;
//		else if (checkIfEqual(6, 7) && checkIfEqual(7, 8))
//			return true;
//
//		// vertical win check
//		else if (checkIfEqual(0, 3) && checkIfEqual(3, 6))
//			return true;
//		else if (checkIfEqual(1, 4) && checkIfEqual(4, 7))
//			return true;
//		else if (checkIfEqual(2, 5) && checkIfEqual(5, 8))
//			return true;
//
//		// diagonal win check
//		else if (checkIfEqual(0, 4) && checkIfEqual(4, 8))
//			return true;
//		else if (checkIfEqual(2, 4) && checkIfEqual(4, 6))
//			return true;
//		else
//			return false;
//
//	}
//
//	public boolean checkIfEqual(int a, int b) {
//		if (buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals(""))
//			return true;
//		else
//			return false;
//	}
//}