package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;
import ch.bbcag.tictactoe.helper.ImageLoader;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.Computer;
import ch.bbcag.tictactoe.GameController;
import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.Timer;
import ch.bbcag.tictactoe.helper.ImageLoader;

public class GridButtons extends JPanel implements TimedLabels {

	private static final long serialVersionUID = 1L;

	private final GameController GAME_CONTROLLER = new GameController(this);

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
					GAME_CONTROLLER.setField(GAME_CONTROLLER.getPlayer(), new Integer(buttonCoordinates[0]) , new Integer(buttonCoordinates[1]));
					b.setIcon(new ImageIcon(""+iconX));
					
				}
				});
				gamePanel.add(b);
				buttonList.add(b);

				b.doClick();
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
	
	public void setButtonIcon(int posX, int posY) {
		//TODO: Set Icon of button to player OR computer.
	}

	public void updateTime(String[] time) {

		timerLabel.setText("Duration: " + time[0] + ":" + time[1]);
	}

}