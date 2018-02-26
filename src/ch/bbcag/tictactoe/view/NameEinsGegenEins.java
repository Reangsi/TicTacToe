package ch.bbcag.tictactoe.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.tictactoe.TicTacToeView;
import ch.bbcag.tictactoe.controller.GameController;
import ch.bbcag.tictactoe.helper.GameModus;

public class NameEinsGegenEins extends JPanel {

	private static final long serialVersionUID = -5232492020539837896L;
	private final GameController GAME_CONTROLLER = GameController.getGameController();
	
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
		
		okey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Schaut ob etwas im Eingabefeld eingegeben wurde und gibt Eingabe weiter
				if (!name.getText().trim().isEmpty() && !name1.getText().trim().isEmpty()) {
					setVisible(false);
					GAME_CONTROLLER.setPlayer(name.getText());
					GAME_CONTROLLER.setPlayer2(name1.getText());
					GAME_CONTROLLER.setGameModus(GameModus.PLAYER_VS_PLAYER);
					XorO xoro = new XorO(frame);
					frame.switchJPanel(xoro);
					System.out.println("Ok Button pressed");
				} else {
					nameErrorMessage(frame);
					//TODO: Diplay Warning!
				}
				
			}
		});
		
	}
	private void nameErrorMessage(TicTacToeView parentPanel) {
		JOptionPane.showMessageDialog(parentPanel, "Du musst etwas reinschreiben!", "Error",
				JOptionPane.WARNING_MESSAGE);
	}

}
