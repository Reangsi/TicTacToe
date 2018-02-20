package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.controller.GameController;
import ch.bbcag.tictactoe.helper.Timer;

public class GridButtons extends JPanel implements TimedLabels {

	private static final long serialVersionUID = 1L;

	private final GameController GAME_CONTROLLER = GameController.getGameController();

	private List<JButton> buttonList = new ArrayList<JButton>(9);

	private Icon iconX;
	private Icon iconO;

	private JPanel northPanel;
	private JPanel gamePanel;
	private JLabel timerLabel;

	public GridButtons(TicTacToeView frame, Icon iconX, Icon iconO) {
		setLayout(new GridLayout(2, 1));
		frame.setSize(500, 500);
		frame.setVisible(true);

		this.iconX = iconX;
		this.iconO = iconO;

		northPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 110, 110));
		gamePanel = new JPanel(new GridLayout(3, 3));

		timerLabel = new JLabel("Duration: 00:00");
		timerLabel.setFont(new Font("Arial", Font.BOLD, 24));
		Timer timer = new Timer(this);
		timer.setDaemon(true);
		timer.start();

		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				JButton b = new JButton();
				b.setName("" + x + ";" + y);
				b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String[] buttonCoordinates = b.getName().split(";");
					String currentMove = GAME_CONTROLLER.setField(new Integer(buttonCoordinates[0]) , new Integer(buttonCoordinates[1]));
					if(currentMove == null) {
						nameErrorMessage(frame);
					} else if (currentMove.equals("spieler")) {
						b.setIcon(iconX);
						GAME_CONTROLLER.doComputerMove();
					} else if(currentMove.equals("computer")) {
						b.setIcon(iconO);
					}
					
				}
				});
				gamePanel.add(b);
				buttonList.add(b);

				//b.doClick();
			}

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
	
	private void nameErrorMessage(TicTacToeView parentPanel) {
		JOptionPane.showMessageDialog(parentPanel, "Du bist nicht am Zug!", "Error",
				JOptionPane.WARNING_MESSAGE);
	}

	public void setButtonIcon(int posX, int posY) {
		// TODO: Set Icon of button to player OR computer.
	}

	public void updateTime(String[] time) {

		timerLabel.setText("Duration: " + time[0] + ":" + time[1]);
	}

}
