package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import jdbc.ConnectionProvider;
import model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();
			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}
			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int updateUsuarios(List<Usuario> u1) {

		try {
			int rows = 0;
			String sql = "UPDATE usuarios SET presupuesto = ?, tiempo= ? WHERE id_usuario = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			for (Usuario usuarios : u1) {
				statement.setInt(1, usuarios.getPresupuesto());
				statement.setDouble(2, usuarios.getTiempoDisponible());
				statement.setInt(3, usuarios.getIdUsuario());
				 rows = statement.executeUpdate();
			}
			
			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public int update(Usuario usuario) {
		try {
			String sql = "UPDATE usuarios SET presupuesto = ?, tiempo= ? WHERE id = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, usuario.getPresupuesto());
			statement.setDouble(2, usuario.getTiempoDisponible());
			statement.setInt(3, usuario.getIdUsuario());
			int rows = statement.executeUpdate();
			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	private Usuario toUsuario(ResultSet resultados) {
		try {
			return new Usuario(resultados.getInt(1), resultados.getString(2), resultados.getString(3),
					resultados.getInt(4), resultados.getDouble(5));
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

	public int delete(Usuario t) {
		return 0;
	}

	public Usuario findByUsuarioName(String name) {
		return null;
	}
}
