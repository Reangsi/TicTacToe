package ch.bbcag.tictactoe.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import ch.bbcag.tictactoe.TicTacToeView;

public class HistoryView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameTextField = new JTextField("Name: ");
	private JTextField name2TextField = new JTextField("Name: ");

	public HistoryView(TicTacToeView frame) {
		add(nameTextField, BorderLayout.NORTH);
		add(name2TextField, BorderLayout.CENTER);
	}

}
