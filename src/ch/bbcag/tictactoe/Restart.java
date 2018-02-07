package ch.bbcag.tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Restart implements ActionListener {
	
	private JButton restart;
	
	public Restart(JButton tmpRestart) {
		this.restart = tmpRestart;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("restart")) {
			//this.dispose();
			//new TicTacToeView();
			
		}
		
	}


}
