package ch.bbcag.tictactoe.helper;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import ch.bbcag.tictactoe.TicTacToeView;

public class ImageLoader {

	public static Icon loadIcon(String iconName) {
		final URL resource = TicTacToeView.class.getResource("/images/" + iconName);

		if (resource == null) {
			System.err.println("Error in " + TicTacToeView.class.getName() + ": Icon /images/" + iconName
					+ " could not be loaded.");
			return new ImageIcon();
		}
		return new ImageIcon(resource);
	}

}
