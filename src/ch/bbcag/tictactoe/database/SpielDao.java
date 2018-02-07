package ch.bbcag.tictactoe.database;

import java.util.List;

import ch.bbcag.tictactoe.model.Spiel;

public interface SpielDao {
	public abstract void insertSpiel(Spiel spiel);

	public abstract List<Spiel> findAllSpiele();
}
