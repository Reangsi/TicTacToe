package ch.bbcag.tictactoe;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class View extends JFrame {

	private static final long serialVersionUID = -5596068842899943296L;
	private static JLabel timerLabel = new JLabel("Duration: 00:00");

	public static void main(String[] args) {
		View v = new View();
		v.setTitle("Timer");
		v.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		v.add(timerLabel, BorderLayout.CENTER);
		v.pack();

		Timer timer = new Timer(v);
		timer.setDaemon(true);
		timer.start();
		v.setVisible(true);
		
	}

	public void updateTime(String[] time) {
		timerLabel.setText("Duration: " + time[0] + ":" + time[1]);
	}
}
