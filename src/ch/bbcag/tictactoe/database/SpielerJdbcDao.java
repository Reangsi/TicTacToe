package ch.bbcag.tictactoe.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ch.bbcag.tictactoe.model.Spieler;

public class SpielerJdbcDao implements SpielerDao {

	@Override
	public int insertSpieler(Spieler spieler) {
		String sql = "insert into tictactoe.spieler (name) values(?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int newPK = 0;

		try {
			ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, spieler.getName());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				newPK = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Spieler " + spieler.getName() + " konnte nicht gespeichert werden.", e);
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}

				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException("Tut uns leid, wir haben ein technisches Problem.", e);
			}
		}
		return newPK;
	}

	@Override
	public Spieler findSpielerById(int id) {
		return null;
	}

}
