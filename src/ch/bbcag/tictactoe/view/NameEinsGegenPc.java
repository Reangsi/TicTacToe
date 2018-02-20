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

import ch.bbcag.tictactoe.GameController;
import ch.bbcag.tictactoe.TicTacToeView;

public class NameEinsGegenPc extends JPanel {

	private static final long serialVersionUID = 3333784181523217083L;
	private final GameController GAME_CONTROLLER = new GameController();
	
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
		
		okey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!name.getText().equals(null)) {
					setVisible(false);
					GAME_CONTROLLER.setPlayer(name.getText());
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
