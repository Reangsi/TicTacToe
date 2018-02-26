package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.controller.GameController;
import ch.bbcag.tictactoe.helper.GameModus;
import ch.bbcag.tictactoe.helper.ImageLoader;

public class StartScreen extends JPanel {

	private static final long serialVersionUID = 1949775359019597146L;
	
	private final GameController GAME_CONTROLLER = GameController.getGameController();

	private JPanel headerPanel;
	private JPanel vsPanel;
	private JLabel logoLabel;
	private JButton einsGegenEinBtn;
	private JButton einsGegenPc;

	public StartScreen(TicTacToeView frame) {

		setLayout(new BorderLayout());
		setSize(500, 500);
		setVisible(true);
		setBackground(Color.BLACK);

		headerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));
		vsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 50));

		logoLabel = new JLabel(ImageLoader.loadIcon("TicTacToe.png"));

		einsGegenEinBtn = new JButton("1 vs 1");
		einsGegenPc = new JButton("1 vs PC");

		einsGegenEinBtn.setPreferredSize(new Dimension(150, 150));
		einsGegenPc.setPreferredSize(new Dimension(150, 150));

		headerPanel.add(logoLabel);
		vsPanel.add(einsGegenEinBtn);
		vsPanel.add(einsGegenPc);


		einsGegenEinBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Setzt Gamemodus und öffnet nächstes Frame
				setVisible(false);
				NameEinsGegenEins eins = new NameEinsGegenEins(frame);
				frame.switchJPanel(eins);
				GAME_CONTROLLER.setGameModus(GameModus.PLAYER_VS_PLAYER);
				System.out.println("1 gegen 1 Button pressed");
			}
		});
		
		einsGegenPc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Setzt Gamemodus und öffnet nächstes Frame
				setVisible(false);
				NameEinsGegenPc pc = new NameEinsGegenPc(frame);
				frame.switchJPanel(pc);
				GAME_CONTROLLER.setGameModus(GameModus.PLAYER_VS_COMPUTER);
				System.out.println("1 gegen PC Button pressed");
			}
		});
		

		headerPanel.setBackground(Color.white);
		vsPanel.setBackground(Color.BLACK);

		add(headerPanel, BorderLayout.NORTH);
		add(vsPanel, BorderLayout.CENTER);

	}

}
