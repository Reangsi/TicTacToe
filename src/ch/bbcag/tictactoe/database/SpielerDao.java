package ch.bbcag.tictactoe.database;

import ch.bbcag.tictactoe.model.Spieler;

public interface SpielerDao {
	public abstract int insertSpieler(Spieler spieler);

	public abstract Spieler findSpielerById(int id);
}