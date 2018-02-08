package ch.bbcag.tictactoe.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.helpers.ImageLoader;

public class XorO extends JPanel {

	private static final long serialVersionUID = 1949775359019597146L;
		private JPanel xPanel;
		private JPanel oPanel;
		private JPanel xocenterPanel;
		private JLabel xLabel;
		private JLabel oLabel;
		private JButton x1;
		private JButton x2;
		private JButton x3;
		private JButton o1;
		private JButton o2;
		private JButton o3;
	

	public XorO(TicTacToeView frame) {
		
		setLayout(new BorderLayout());
		setSize(500, 500);
		setVisible(true);

		xPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		oPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		xocenterPanel = new JPanel(new GridLayout(2, 3, 10, 10));

		x1 = new JButton("x");
		x2 = new JButton("x");
		x3 = new JButton("x");

		o1 = new JButton();
		o2 = new JButton();
		o3 = new JButton();
		
		xLabel = new JLabel("X");
		oLabel = new JLabel("O");
		
		xPanel.add(xLabel);
		oPanel.add(oLabel);
		
		xocenterPanel.add(x1);
		xocenterPanel.add(x2);
		xocenterPanel.add(x3);
		xocenterPanel.add(o1);
		xocenterPanel.add(o2);
		xocenterPanel.add(o3);
		
		add(xPanel, BorderLayout.NORTH);
		add(oPanel, BorderLayout.SOUTH);
		add(xocenterPanel, BorderLayout.CENTER);
		


	}

}
