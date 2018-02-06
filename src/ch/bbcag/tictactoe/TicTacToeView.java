package ch.bbcag.tictactoe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		JPanel vs = new JPanel(new GridLayout(1,2));
		JPanel nameEingabe = new JPanel(new BorderLayout());
		
		JButton eins = new JButton("1 vs 1");
		JButton pc = new JButton("1 vs PC");
		
		int size = 50;
		
		eins.setSize(size,size);
		pc.setSize(size,size);
		
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
		
		JButton x1 = new JButton();
		JButton x2 = new JButton();
		JButton x3 = new JButton();
		
		JButton o1 = new JButton();
		JButton o2 = new JButton();
		JButton o3 = new JButton();
		
		x.add("North", new JButton("x"));
		x.add("East", x1);
		x.add("West", x2);
		x.add("Center", x3);
		
		o.add("North", new JButton("o"));
		o.add("East", o1);
		o.add("West", o2);
		o.add("Center", o3);
		
		xo.add("North", x);
		xo.add("South", o);
		
		xo.setSize(400, 400);
		xo.setVisible(true);
	}

	public TicTacToeView() {

	  }


}

