package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.TicTacToeView;

public class WINorLOSE extends JPanel {

	private static final long serialVersionUID = 6118968701538046010L;
	private JPanel headPanel;
	private JPanel history;
	private JPanel southPanel;	
	private JButton restart;
	private JLabel winLabel;


	public WINorLOSE (TicTacToeView frame, String resultat, String player) {
		
		setLayout(new BorderLayout());
		setSize(500, 500);
		setVisible(true);
		setBackground(Color.BLACK);
		
		headPanel = new JPanel();
		history = new JPanel();
		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));
		restart = new JButton("Restart");
		
		if (resultat.equals("gewonnen")) {
			winLabel = new JLabel(player + "hat GEWONNEN");
		} else if (resultat.equals("verloren")) {
			winLabel = new JLabel(player + "hat VERLOREN");
		} else if (resultat.equals("gleichstand")) {
			winLabel = new JLabel("GLEICHSTAND");
		} else if (resultat.equals("gewonnen2")) {
			winLabel = new JLabel(player + "hat GEWONNEN");
		} else if (resultat.equals("verloren2")) {
			winLabel = new JLabel(player + "hat VERLOREN");
		}
		headPanel.add(winLabel);
		southPanel.add(restart);
		
		add(headPanel, BorderLayout.NORTH);
		add(history, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				StartScreen start = new StartScreen(frame);
				frame.switchJPanel(start);
				System.out.println("Ok Button pressed");
				
			}
		});
	}

	private void setWinPanel(JPanel jPanel) {
		// TODO Auto-generated method stub
		
	}


}


