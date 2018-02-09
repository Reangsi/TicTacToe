package ch.bbcag.tictactoe.database;

import java.util.List;

import ch.bbcag.tictactoe.model.Ergebnis;
import ch.bbcag.tictactoe.model.Spiel;

public class SpielJdbcDao implements SpielDao {

	private SpielerDao spielerDao = new SpielerJdbcDao();
	private ErgebnisDao ergebnisDao;
	private SpielDao spielDao = new SpielJdbcDao();

	@Override
	public void insertSpiel(Spiel spiel) {
		// insert spieler
		int spieler_1_id = spielerDao.insertSpieler(spiel.getSpieler_1());
		int spieler_2_id = spielerDao.insertSpieler(spiel.getSpieler_2());

		// insert ergebnis
		String sql = "insert into tictactoe.ergebnis (ergebnis) values(?)";
		int ergebnis_id = ergebnisDao.insertErgebnis(spiel.getErgebnis());

		// insert spiel
		String sql1 = "insert into tictactoe.spiel (spiel) values (?)";
		// TODO: Fix me
		//int spiel_id = spielDao.insertSpiel(spiel.getSpiel());

		
		
	}

	@Override
	public List<Spiel> findAllSpiele() {
		return null;
	}
}
