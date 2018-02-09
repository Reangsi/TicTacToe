package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.Timer;

public class GridButtons extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton[] jButton = new JButton[9];
	private JPanel northPanel;
	private JPanel gamePanel;
	private JLabel timerLabel;

	public GridButtons(TicTacToeView frame, Icon iconX, Icon iconO) {
		setLayout(new GridLayout(2, 1));
		
		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
		gamePanel = new JPanel(new GridLayout(3, 3));
		
		timerLabel = new JLabel("Duration: 00:00");
		Timer timer = new Timer(this);
		timer.setDaemon(true);
		timer.start();
		
		for (int i = 0; i < 9; i++) {
			jButton[i] = new JButton();
			gamePanel.add(jButton[i]);

			/*
			 * einsGegenEinBtn.addActionListener(new ActionListener() {
			 * 
			 * @Override public void actionPerformed(ActionEvent e) { setVisible(false);
			 * XorO xoro = new XorO(frame); frame.switchJPanel(xoro);
			 * System.out.println("1 gegen 1 Button pressed");
			 */

		}
		
		northPanel.setBackground(Color.LIGHT_GRAY);
		gamePanel.setBackground(Color.GRAY);
		
		northPanel.add(timerLabel);
		
		add(northPanel, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);
		
		/*
		 * private JButton x1; private JButton x2; private JButton x3; private JButton
		 * o1; private JButton o2; private JButton o3;
		 */
	
	}
	
	public void updateTime(String[] time) {
		timerLabel.setText("Duration: " + time[0] + ":" + time[1]);
	}
}