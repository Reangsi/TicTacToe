package ch.bbcag.tictactoe.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.helper.ImageLoader;

public class XorO extends JPanel {

	private static final long serialVersionUID = 1949775359019597146L;
	private JPanel xPanel;
	private JPanel oPanel;
	private JPanel xCenterPanel;
	private JPanel oCenterPanel;
	private JPanel controllPanel;
	private JLabel xLabel;
	private JLabel oLabel;
	private JButton x1;
	private JButton x2;
	private JButton x3;
	private JButton o1;
	private JButton o2;
	private JButton o3;
	private JButton startGame;
	
	private JButton chosenX;
	private JButton chosenO;

	public XorO(TicTacToeView frame) {

		setLayout(new GridLayout(5, 1));
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);

		xPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		oPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		xCenterPanel = new JPanel(new GridLayout(1, 3, 10, 10));
		oCenterPanel = new JPanel(new GridLayout(1, 3, 10, 10));
		controllPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

		x1 = new JButton(ImageLoader.loadIcon("Unbenannt.PNG"));
		x2 = new JButton(ImageLoader.loadIcon("Unbenannt.PNG"));
		x3 = new JButton(ImageLoader.loadIcon("Unbenannt.PNG"));
		o1 = new JButton(ImageLoader.loadIcon("Unbenannt.PNG"));
		o2 = new JButton(ImageLoader.loadIcon("Unbenannt.PNG"));
		o3 = new JButton(ImageLoader.loadIcon("Unbenannt.PNG"));

		startGame = new JButton("Start Game");

		xLabel = new JLabel("X");
		oLabel = new JLabel("O");

		xPanel.setBackground(Color.RED);
		oPanel.setBackground(Color.BLACK);
		xCenterPanel.setBackground(Color.GREEN);
		oCenterPanel.setBackground(Color.LIGHT_GRAY);

		xPanel.add(xLabel);
		oPanel.add(oLabel);

		controllPanel.add(startGame);

		xCenterPanel.add(x1);
		xCenterPanel.add(x2);
		xCenterPanel.add(x3);
		oCenterPanel.add(o1);
		oCenterPanel.add(o2);
		oCenterPanel.add(o3);

		add(xPanel);
		add(xCenterPanel);
		add(oPanel);
		add(oCenterPanel);
		add(controllPanel);
		
		x1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenX = x1;
				System.out.println("X gewählt");
			}
		});
		
		x2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenX = x2;
				System.out.println("X gewählt");
			}
		});
		
		x3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenX = x3;
				System.out.println("X gewählt");
			}
		});
		
		o1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenO = o1;
				System.out.println("O gewählt");
			}
		});
		
		o2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenO = o2;
				System.out.println("O gewählt");
			}
		});
		
		o3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				chosenO = o3;
				System.out.println("O gewählt");
			}
		});

		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenX != null && chosenO != null) {
					setVisible(false);
					GridButtons grid = new GridButtons(frame, chosenX.getIcon(), chosenO.getIcon());
					frame.switchJPanel(grid);
					System.out.println("Game started");
				} else {
					System.err.println("Beide Spielerbilder müssen gewählt werden!");
				}
			}
		});

	}

}
