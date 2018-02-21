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

	private static final long serialVersionUID = 1L;
	private static JPanel headPanel;
	private static JPanel history;
	private static JButton restart = new JButton("Restart");
	private JLabel winLabel;
	private JPanel winPanel;
	private JPanel southPanel;

	public WINorLOSE (TicTacToeView frame) {
		
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);
		
		//Panels
		headPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));
		history = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));
		southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
		setWinPanel(new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30)));


		// Gewonnen
		winLabel = new JLabel("Gewonnen!");
		winLabel.setFont(new Font("Arial", Font.BOLD, 24));
		winLabel.setForeground(Color.white);
		
		//Verloren
		/*winLabel = new JLabel("Verloren");
		winLabel.setFont(new Font("Arial", Font.BOLD, 24));
		winLabel.setForeground(Color.white);*/
		
		//Unentschieden
		/*winLabel = new JLabel("Unentschieden");
		winLabel.setFont(new Font("Arial", Font.BOLD, 24));
		winLabel.setForeground(Color.white);*/
		

		// Backgrounds
		winPanel.setBackground(Color.BLUE);
		history.setBackground(Color.BLACK);
		southPanel.setBackground(Color.RED);
		history.setBackground(Color.BLACK);

		add(history, BorderLayout.CENTER);
		add(restart, BorderLayout.SOUTH);
		add(southPanel, BorderLayout.SOUTH);
		add(winPanel, BorderLayout.NORTH);

		winPanel.add(winLabel);
		southPanel.add(restart);
		restart = new JButton("Restart");
		
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


