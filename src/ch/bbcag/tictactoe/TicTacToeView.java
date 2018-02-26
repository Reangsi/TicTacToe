package ch.bbcag.tictactoe;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.view.StartScreen;

public class TicTacToeView extends JFrame {

	private static final long serialVersionUID = 7784372619859095392L;

	public TicTacToeView(String titel) {
		setTitle(titel);
	}
	
	public void switchJPanel(JPanel panel) {
		add(panel);
		pack();
        panel.setVisible(true);
        panel.setSize(500,500);
	}
	
	public static void main(String[] args) {

		// Spielfeld
		TicTacToeView frame = new TicTacToeView("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Start
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		
		StartScreen start = new StartScreen(frame);
		frame.add(start);
		frame.pack();
		frame.setVisible(true);

	}

}
