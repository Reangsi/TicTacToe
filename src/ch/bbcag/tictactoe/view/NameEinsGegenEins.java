package ch.bbcag.tictactoe.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.tictactoe.TicTacToeView;

public class NameEinsGegenEins extends JPanel {

	private static final long serialVersionUID = -5232492020539837896L;
	
	private JLabel nameLabel;
	private JLabel name1Label;
	private JTextField name1;
	private JTextField name;
	private JButton okey;
	
	public NameEinsGegenEins (TicTacToeView frame) {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 40, 50));
		setSize(400, 400);
		setVisible(true);
		setBackground(Color.WHITE);
		
		
		nameLabel = new JLabel("Name Spieler 1:");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 24));
		
		name = new JTextField();
		name.setPreferredSize(new Dimension(200, 30));
		
		name1Label = new JLabel("Name Spieler 2:");
		name1Label.setFont(new Font("Arial", Font.BOLD, 24));
		
		name1 = new JTextField();
		name1.setPreferredSize(new Dimension(200, 30));
		
		okey = new JButton("OK");
		okey.setPreferredSize(new Dimension(70, 30));
		 
		add(nameLabel);
		add(name);
		add(name1Label);
		add(name1);
		add(okey);
		
	}

}
