package ch.bbcag.tictactoe.database;

import ch.bbcag.tictactoe.model.Ergebnis;

public interface ErgebnisDao {

	public abstract int insertErgebnis(Ergebnis ergebnis);

	public abstract Ergebnis findErgebnisById(int id);
}
