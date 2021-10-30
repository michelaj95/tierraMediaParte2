package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;

import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Itinerario;
import model.Promocion;
import model.Usuario;

public class ItinerarioDAOImpl implements ItinerarioDAO {

	public List<Itinerario> findAll() {
		try {
			String sql = "SELECT * FROM itinerario";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			List<Itinerario> itinerarios = new LinkedList<Itinerario>();
			while (resultados.next()) {
				itinerarios.add(toItinerario(resultados));
			}
			return itinerarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Itinerario toItinerario(ResultSet resultados) {
		try {
			return new Itinerario(resultados.getInt(1), resultados.getInt(2), resultados.getInt(3));
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int updateItinerario(List<Usuario> u1) {
		try {
			int rows = 0;
			String sql = "INSERT INTO itinerario (id_usuario, id_atraccion, id_promocion)" + "VALUES (?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			for (Usuario usuario : u1) {
					if (!usuario.getItinerarioAtracciones().isEmpty()) {
						for (Atraccion atracc : usuario.getItinerarioAtracciones()) {
							statement.setInt(1, usuario.getIdUsuario());
							statement.setInt(2, atracc.getIdAtraccion());
							statement.setNull(3, Types.INTEGER);
							rows = statement.executeUpdate();
						}
					}
					if (!usuario.getItinerarioPromociones().isEmpty()) {
						for (Promocion promo : usuario.getItinerarioPromociones()) {
							statement.setInt(1, usuario.getIdUsuario());
							statement.setNull(2, Types.INTEGER);
							statement.setInt(3, promo.getPromocionId());
							rows = statement.executeUpdate();
						}
				}
			}
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		return 0;
	}

	public int insert(Usuario t) {
		return 0;
	}

	public int update(Usuario t) {

		return 0;
	}

	public int delete(Usuario t) {
		return 0;
	}

	public int insert(Itinerario t) {
		return 0;
	}

	public int update(Itinerario t) {
		return 0;
	}

	public int delete(Itinerario t) {
		return 0;
	}

}
