package ch.bbcag.tictactoe.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch.bbcag.tictactoe.model.Ergebnis;

public class ErgebnisJdbcDao implements ErgebnisDao {

	@Override
	public int insertErgebnis(Ergebnis ergebnis) {
		String sql = "insert into tictactoe.ergebnis (ergebnis) values(?)";
		Connection con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		int newPK = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ergebnis.getErgebnis());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();

			if (rs.next()) {
				newPK = rs.getInt(1);
			}
		} catch (SQLException e) {
			throw new RuntimeException("Ergebnis konnte nicht gespeichert werden.", e);
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
	public Ergebnis findErgebnisById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
