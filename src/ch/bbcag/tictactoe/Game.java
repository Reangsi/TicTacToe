package ch.bbcag.tictactoe;

public class Game {
	{
		int gamemode = 2;
		String board = "";
		int player = -1;

		if (gamemode == 0) {
			// Gui anzeigen
			// Computer-Logik s
		} else {
			// Gui anzeigen
			if (board == "[20][21][22]" || board == "[10][11][12]" || board == "[00][01][02]" || board == "[00][11][22]"			// Schaut wer gewonnen hat
					|| board == "[20][11][02]" || board == "[00][10][20]" || board == "[01][11][21]"
					|| board == "[02][12][22]") {
				// gameover
				if (player == 1) {
					System.out.println("Player 1 hat gewonnen!");
				} else {
					System.out.println("Player 2 hat gewonnen!");
				}

			}
			else if (board == "[00][01][02][10][11][12][20][21][22]") {
				System.out.println("Unentschieden");
				//gameover ()
			}

		}
	}
}

/** boolean checkForWinningRow() {
    /**
    * Reference: the button array is arranged like this as the board 0 | 1 | 2 3 |
    * 4 | 5 6 | 7 | 8
    *
    // horizontal win check
    if (checkAdjacent(0, 1) && checkAdjacent(1, 2)) // no need to put " == true" because the default check is
                                                                                     // for true
           return true;
    else if (checkAdjacent(3, 4) && checkAdjacent(4, 5))
           return true;
    else if (checkAdjacent(6, 7) && checkAdjacent(7, 8))
           return true;

    // vertical win check
    else if (checkAdjacent(0, 3) && checkAdjacent(3, 6))
           return true;
    else if (checkAdjacent(1, 4) && checkAdjacent(4, 7))
           return true;
    else if (checkAdjacent(2, 5) && checkAdjacent(5, 8))
           return true;

    // diagonal win check
    else if (checkAdjacent(0, 4) && checkAdjacent(4, 8))
           return true;
    else if (checkAdjacent(2, 4) && checkAdjacent(4, 6))
           return true;
    else
           return false;

}

public boolean checkAdjacent(int a, int b) {
    if (buttons[a].getText().equals(buttons[b].getText()) && !buttons[a].getText().equals(""))
           return true;
    else
           return false; */
