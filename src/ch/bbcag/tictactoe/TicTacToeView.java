package ch.bbcag.tictactoe;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.TextField;

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
		JPanel logo = new JPanel();
		JPanel einsVSeins = new JPanel();
		JPanel einsVSpc = new JPanel();
		JPanel nameEingabe = new JPanel();
		
		logo.add(new JButton(""));
		einsVSeins.add(new JButton("1 vs 1"));
		einsVSpc.add(new JButton("1 vs PC"));
		nameEingabe.add(new TextField("Name"));
		
		startFrame.add("North",logo);
		startFrame.add("Center",logo);
		startFrame.add("West",logo);
		startFrame.add("East",logo);
		
		
		
	}

	public TicTacToeView() {

	  }


}

