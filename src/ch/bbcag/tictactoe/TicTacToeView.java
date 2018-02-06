package ch.bbcag.tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.TextField;
import java.net.URL;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TicTacToeView extends JFrame {
	
	
	
	public static void main(String[] args) {
		
		//Spielfeld
		JFrame frame = new JFrame("TicTacToe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel northPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel centerPanel = new JPanel(new GridLayout(3,3));
		
		northPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		centerPanel.add(new JButton(""));
		
		frame.add("North",northPanel);
		frame.add("Center",centerPanel);
		
		frame.setSize(400, 400);
		frame.setVisible(true);
		
		//Start
		JFrame startFrame = new JFrame("TicTacToe");
		startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel logo = new JPanel(new BorderLayout());
		JPanel vs = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));
		JPanel nameEingabe = new JPanel(new BorderLayout());
		//logo.setPreferredSize(new Dimension(5,10));
		
		JButton eins = new JButton("1 vs 1");
		JButton pc = new JButton("1 vs PC");
		
		eins.setPreferredSize(new Dimension(150,150));
		pc.setPreferredSize(new Dimension(150,150));
		
		logo.add(new JButton(""));
		vs.add(eins);
		vs.add(pc);
		nameEingabe.add(new TextField("Name"));
		
		startFrame.add("North",logo);
		startFrame.add("South",nameEingabe);
		startFrame.add("Center",vs);
		
		startFrame.setSize(400, 400);
		startFrame.setVisible(true);
		
		//X und O
		JFrame xo = new JFrame("TicTacToe");
		xo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel x = new JPanel(new BorderLayout());
		JPanel o = new JPanel(new BorderLayout());
		JPanel xocenter = new JPanel(new GridLayout(2,3));
		
		JButton x1 = new JButton("x");
		JButton x2 = new JButton("x");
		JButton x3 = new JButton("x");
		
		JButton o1 = new JButton();
		JButton o2 = new JButton();
		JButton o3 = new JButton();
		
		x.add("North", new JButton("x"));
		xocenter.add(x1);
		xocenter.add(x2);
		xocenter.add(x3);
		
		o.add("North", new JButton("o"));
		xocenter.add(o1);
		xocenter.add(o2);
		xocenter.add(o3);
		
		xo.add("North", x);
		xo.add("South", o);
		xo.add("Center", xocenter);
		
		xo.setSize(400, 400);
		xo.setVisible(true);
		
		//Highscore
		JFrame hScore = new JFrame("TicTacToe");
		hScore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel hSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JPanel hNorth = new JPanel(new BorderLayout());
		JPanel hCenter = new JPanel(new BorderLayout());
		
		JButton restart = new JButton("Restart");
		JTextField hhCenter = new JTextField();
		
		JLabel winLose = new JLabel(loadIcon("images.jpg"));
		
		hSouth.add(restart);
		hCenter.add("Center",hhCenter);
		hNorth.add("Center",winLose);
		
		hScore.add("South",hSouth);
		hScore.add("Center",hCenter);
		hScore.add("North",hNorth);
		
		hScore.setSize(400, 400);
		hScore.setVisible(true);
	}

	
	private static Icon loadIcon(String iconName) {
		final URL resource = TicTacToeView.class.getResource("/images/" + iconName);

		if (resource == null) {
			// TODO Replace by logger
			System.err.println(
					"Error in " + TicTacToeView.class.getName() + ": Icon /images/" + iconName + " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

	
}

