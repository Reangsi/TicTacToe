package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WINorLOSE extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel headPanel;
	private static JPanel history;
	private static JButton restart = new JButton("Restart");
	private JLabel winLabel;
	private JPanel winPanel;
	private JPanel southPanel;

	public static void main(String[] args) {
		WINorLOSE frame = new WINorLOSE();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);

	}

	public WINorLOSE() {
		
		setTitle("TicTacToe");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
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

	}

	public JPanel getHeadPanel() {
		return headPanel;
	}

	public void setHeadPanel(JPanel headPanel) {
		WINorLOSE.headPanel = headPanel;
	}

	public JPanel getHistory() {
		return history;
	}

	public void setHistory(JPanel history) {
		WINorLOSE.history = history;
	}

	public JButton getRestart() {
		return restart;
	}

	public void setRestart(JButton restart) {
		WINorLOSE.restart = restart;
	}

	public JPanel getWinPanel() {
		return winPanel;
	}

	public void setWinPanel(JPanel winPanel) {
		this.winPanel = winPanel;
	}

	public JPanel getSouthPanel() {
		return southPanel;
	}

	public void setSouthPanel(JPanel southPanel) {
		this.southPanel = southPanel;
	}

}
