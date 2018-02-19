package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.Computer;
import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.Timer;

public class GridButtons extends JPanel implements TimedLabels {

	private static final long serialVersionUID = 1L;

	private List<JButton> buttonList = new ArrayList<JButton>(9);
	
	private Icon iconX;
	private Icon iconO;

	private JPanel northPanel;
	private JPanel gamePanel;
	private JLabel timerLabel;

	public GridButtons(TicTacToeView frame, Icon iconX, Icon iconO) {
		setLayout(new GridLayout(2, 1));
		frame.setSize(500,500);
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
		
		
		
		
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j <3; j++) {
				JButton b = new JButton();
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if (findOutPlayerTurn() == 2) {
							//x bild this.button hinzufügen
							//this.button enabled
							getCordinatesForButton(i, j);
							
						}
						else if (findOutPlayerTurn() == 1) {
							//x bild this.button hinzufügen
							//this.button enabled
							getCordinatesForLogic(i);
						}
						
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

	public void updateTime(String[] time) {

		timerLabel.setText("Duration: " + time[0] + ":" + time[1]);
	}
	
	public int getCordinatesForButton(int i, int j) {
		String x = Integer.toString(i);
		String y = Integer.toString(i);
		String cords = x + y;
        int xy = Integer.valueOf(cords);
        switch (xy) {
            case 0:  xy = 1;
                     break;
            case 1:  xy = 2;
                     break;
            case 2:  xy = 3;
                     break;
            case 10:  xy = 4;
                     break;
            case 11:  xy = 5;
                     break;
            case 12:  xy = 6;
                     break;
            case 20:  xy = 7;
                     break;
            case 21:  xy = 8;
                     break;
            case 22:  xy = 9;
                     break;

        }
        return xy;
	}
	
	public int getCordinatesForLogic(int i) {
		switch (i) {
        case 1:  i = 0;
                 break;
        case 2:  i = 1;
                 break;
        case 3:  i = 2;
                 break;
        case 4:  i = 10;
                 break;
        case 5:  i = 11;
                 break;
        case 6:  i = 12;
                 break;
        case 7:  i = 20;
                 break;
        case 8:  i = 21;
                 break;
        case 9:  i = 22;
                 break;

    }
    return i;
	}
}