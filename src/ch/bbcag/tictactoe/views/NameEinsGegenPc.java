package ch.bbcag.tictactoe.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.tictactoe.TicTacToeView;

public class NameEinsGegenPc extends JPanel {

	private static final long serialVersionUID = 3333784181523217083L;
	
	private JLabel nameLabel;
	private JTextField name;
	private JButton okey;
	
	
	public NameEinsGegenPc (TicTacToeView frame) {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 40, 50));
		setSize(400, 400);
		setVisible(true);
		setBackground(Color.WHITE);
		
		
		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 24));

		name = new JTextField();
		name.setPreferredSize(new Dimension(200, 30));
		
		okey = new JButton("OK");
		okey.setPreferredSize(new Dimension(70, 30));
		 
		add(nameLabel);
		add(name);
		add(okey);
		
	}


}
