package ch.bbcag.tictactoe.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ch.bbcag.tictactoe.model.Spiel;

public class SpielJdbcDao implements SpielDao {

	private SpielerDao spielerDao = new SpielerJdbcDao();
	private ErgebnisDao ergebnisDao;
	private SpielDao spielDao = new SpielJdbcDao();

	@Override
	public void insertSpiel(Spiel spiel) {
		// insert spieler
		int spieler_1_id = spielerDao.insertSpieler(spiel.getSpieler_1());

		int spieler_2_id = -1;

		if (spiel.getSpieler_2() != null) {
			spieler_2_id = spielerDao.insertSpieler(spiel.getSpieler_2());
		}

		// insert ergebnis
		int ergebnis_id = ergebnisDao.insertErgebnis(spiel.getErgebnis());

		// insert spiel
		String sql = "insert into spiel (zeit, spieler_1_id, spieler_2_id, ergebnis_id) values (?, ?, ? , ?)";

		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, spiel.getZeit());
			ps.setInt(2, spieler_1_id);
			if (spieler_2_id != -1) {
				ps.setInt(3, spieler_2_id);
			} else {
				ps.setNull(3, java.sql.Types.INTEGER);
			}
			ps.setInt(4, ergebnis_id);
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("Spiel konnte nicht gespeichert werden.", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("Tut uns leid, wir haben ein technisches Problem.", e);
			}
		}
	}

	@Override
	public List<Spiel> findAllSpiele() {
		return null;
	}

	public SpielDao getSpielDao() {
		return spielDao;
	}

	public void setSpielDao(SpielDao spielDao) {
		this.spielDao = spielDao;
	}
}
