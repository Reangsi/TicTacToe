package ch.bbcag.tictactoe.database;

import java.util.List;

import ch.bbcag.tictactoe.model.Spiel;

public class SpielJdbcDao implements SpielDao {
	
	private SpielerDao spielerDao = new SpielerJdbcDao();

	@Override
	public void insertSpiel(Spiel spiel) {
		// insert spieler
		int spieler_1_id = spielerDao.insertSpieler(spiel.getSpieler_1());
		int spieler_2_id = spielerDao.insertSpieler(spiel.getSpieler_2());
		
		// insert ergebnis
		String sql = "insert into tictactoe.ergebnis (ergebnis) values(?)";
		
		
		
		
		// insert spiel
		

	}

	@Override
	public List<Spiel> findAllSpiele() {
		return null;
	}

}
