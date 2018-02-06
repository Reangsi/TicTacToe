package ch.bbcag.tictactoe.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.helpers.ImageLoader;

public class StartScreen extends JPanel {

	private static final long serialVersionUID = 1949775359019597146L;

	private JPanel headerPanel;
	private JPanel vsPanel;
	private JPanel namePanel;
	private JLabel logoLabel;
	private JLabel nameLabel;
	private JTextField name;
	private JButton einsGegenEinBtn;
	private JButton einsGegenPc;

	public StartScreen(TicTacToeView frame) {

		setLayout(new BorderLayout());
		setSize(400, 400);
		setVisible(true);
		setBackground(Color.BLACK);

		headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));
		vsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));
		namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 30));

		logoLabel = new JLabel(ImageLoader.loadIcon("Unbenannt.PNG"));

		nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 24));

		name = new JTextField();
		name.setPreferredSize(new Dimension(200, 30));

		einsGegenEinBtn = new JButton("1 vs 1");
		einsGegenPc = new JButton("1 vs PC");

		einsGegenEinBtn.setPreferredSize(new Dimension(150, 150));
		einsGegenPc.setPreferredSize(new Dimension(150, 150));

		headerPanel.add(logoLabel);
		vsPanel.add(einsGegenEinBtn);
		vsPanel.add(einsGegenPc);
		namePanel.add(nameLabel);
		namePanel.add(name);

		einsGegenEinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EinsGegenEinPanel einGegenEinsPanel = new EinsGegenEinPanel(frame);
				frame.switchJPanel(einGegenEinsPanel);
				System.out.println("1 gegen 1 Button pressed");
				
			}
		});

		headerPanel.setBackground(Color.BLUE);
		vsPanel.setBackground(Color.BLACK);
		namePanel.setBackground(Color.RED);

		add(headerPanel, BorderLayout.NORTH);
		add(vsPanel, BorderLayout.CENTER);
		add(namePanel, BorderLayout.SOUTH);

	}

}
