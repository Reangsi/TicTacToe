package ch.bbcag.tictactoe.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JLabel errorLabel;
	// private JLabel anleitung;
	private JButton x1;
	private JButton x2;
	private JButton x3;
	private JButton o1;
	private JButton o2;
	private JButton o3;
	private JButton[] xButton = { x1, x2, x3 };
	private JButton[] oButton = { o1, o2, o3 };
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

		// TODO: Add Buttons to ArrayLists & Designs
		x1 = new JButton(ImageLoader.loadIcon("adidas.PNG"));
		x2 = new JButton(ImageLoader.loadIcon("cingcang.PNG"));
		x3 = new JButton(ImageLoader.loadIcon("x.PNG"));
		o1 = new JButton(ImageLoader.loadIcon("nike.PNG"));
		o2 = new JButton(ImageLoader.loadIcon("yingyang.PNG"));
		o3 = new JButton(ImageLoader.loadIcon("o.PNG"));

		startGame = new JButton("Start Game");

		xLabel = new JLabel("X (Spieler)");
		oLabel = new JLabel("O (Computer)");
		// anleitung = new JLabel("Wähle ein Design für das X und 0");

		xPanel.setBackground(Color.LIGHT_GRAY);
		oPanel.setBackground(Color.LIGHT_GRAY);
		xCenterPanel.setBackground(Color.LIGHT_GRAY);
		oCenterPanel.setBackground(Color.LIGHT_GRAY);

		
		
		xPanel.add(xLabel);
		oPanel.add(oLabel);
		// xPanel.add(anleitung);
		errorLabel = new JLabel("Bitte ein Design wählen");

		controllPanel.add(errorLabel);
		controllPanel.add(startGame);
		controllPanel.setBackground(Color.LIGHT_GRAY);

		xCenterPanel.add(x1);
		xCenterPanel.add(x2);
		xCenterPanel.add(x3);
		oCenterPanel.add(o1);
		oCenterPanel.add(o2);
		oCenterPanel.add(o3);

		add(controllPanel);
		add(xPanel);
		add(xCenterPanel);
		add(oPanel);
		add(oCenterPanel);

		// TODO: Add ActionListener to Buttons in ArrayLists using a for each loop.
		x1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenX == null) {
					x1.setBackground(Color.BLUE);
					chosenX = x1;
					System.out.println("X gewählt");
				} else {
					System.out.println("Du hast schon gewählt");
					displayIconErrorMessage(frame);
				}
			}
		});

		x2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenX == null) {
					x2.setBackground(Color.BLUE);
					chosenX = x2;
					System.out.println("X gewählt");
				} else {
					System.out.println("Du hast schon gewählt");
					displayIconErrorMessage(frame);
				}
			}
		});

		x3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenX == null) {
					x3.setBackground(Color.BLUE);
					chosenX = x3;
					System.out.println("X gewählt");
				} else {
					System.out.println("Du hast schon gewählt");
					displayIconErrorMessage(frame);
				}
			}
		});

		o1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenO == null) {
					o1.setBackground(Color.BLUE);
					chosenO = o1;
					System.out.println("O gewählt");
				} else {
					System.out.println("Du hast schon gewählt");
					displayIconErrorMessage(frame);
				}
			}
		});

		o2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenO == null) {
					o2.setBackground(Color.BLUE);
					chosenO = o2;
					System.out.println("O gewählt");
				} else {
					System.out.println("Du hast schon gewählt");
					displayIconErrorMessage(frame);
				}
			}
		});

		o3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenO == null) {
					o3.setBackground(Color.BLUE);
					chosenO = o3;
					System.out.println("O gewählt");
				} else {
					System.out.println("Du hast schon gewählt");
					displayIconErrorMessage(frame);
				}
			}
		});

		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chosenO != null && chosenO != null) {
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

	private void displayIconErrorMessage(TicTacToeView parentPanel) {
		JOptionPane.showMessageDialog(parentPanel, "Es kann nur 1 Bild pro Spieler gewählt werden!", "Error",
				JOptionPane.WARNING_MESSAGE);
	}

	public JButton[] getoButton() {
		return oButton;
	}

	public void setoButton(JButton[] oButton) {
		this.oButton = oButton;
	}

	public JButton[] getxButton() {
		return xButton;
	}

	public void setxButton(JButton[] xButton) {
		this.xButton = xButton;
	}

}
