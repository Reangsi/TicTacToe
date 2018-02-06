package ch.bbcag.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {{
	int gamemode = 2;
	boolean checkForWinningRow;
	List<String> board = new ArrayList<>();
	
	if(gamemode==0)
	{
		//Gui anzeigen
		// Computer-Logik  s
	}else
	{	
		//Gui anzeigen
		if (board == [20][21][22] or board == [10][11][12] or board == [00][01][02] or board == [00][11][22] or board == [20][11][02] or board == [00][10][20] or board == [01][11][21] or board == [02][12][22]) {
			//gameover
			if (player == "1") {
				System.out.println("Player 1 hat gewonnen!");
			}
			else {
				System.out.println("Player 2 hat gewonnen!");
			}
			
		}
		
	}
}
}
