package ch.bbcag.tictactoe; 

public class Game {{
	int gamemode = 2;
	String board = "";
	int player = -1;
	
	if(gamemode==0)
	{
		//Gui anzeigen
		// Computer-Logik  s
	}else
	{	
		//Gui anzeigen
		if (board == "[20][21][22]" || board == "[10][11][12]" || board == "[00][01][02]" || board == "[00][11][22]" || board == "[20][11][02]" || board == "[00][10][20]" || board == "[01][11][21]" || board == "[02][12][22]") {
			//gameover
			if (player == 1) {
				System.out.println("Player 1 hat gewonnen!");
			}
			else {
				System.out.println("Player 2 hat gewonnen!");
			}
			
		}
		
	}
}
}
