package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import jdbc.ConnectionProvider;
import model.Atraccion;


public class AtraccionDAOImpl implements AtraccionDAO {
	
	public List<Atraccion> findAll() {
		try {
		String sql = "SELECT * FROM atracciones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		while(resultados.next()) {
			atracciones.add(toAtraccion(resultados));
		}
		return atracciones;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public int updateAtracciones(List<Atraccion> a1) {

		try {
			int rows = 0;
			String sql = "UPDATE atracciones SET cupo = ? WHERE id_atraccion = ?;";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			for (Atraccion atracciones : a1) {
				statement.setInt(1, atracciones.getCupo());
				statement.setInt(2, atracciones.getIdAtraccion());
				
				 rows = statement.executeUpdate();
			}
			
			return rows;

		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}
	
	public int update(Atraccion atraccion) {
		try {
		String sql = "UPDATE atracciones SET cupo = ? WHERE id_atraccion = ?";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, atraccion.getCupo());
		statement.setInt(2, atraccion.getIdAtraccion());
		int rows = statement.executeUpdate();
		return rows;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	private Atraccion toAtraccion(ResultSet resultados) {
		try {
		return new Atraccion(resultados.getInt(1), resultados.getString(2), resultados.getString(3), 
				resultados.getInt(4), resultados.getInt(5), resultados.getDouble(6));
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		return 0;
	}

	public int insert(Atraccion t){
		return 0;
	}

	public int delete(Atraccion t)  {
		return 0;
	}

	public Atraccion findByAtraccionId(int idAtraccion) {
		try {
			String sql = "SELECT * FROM atracciones WHERE id_atraccion = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, idAtraccion);
			ResultSet resultados = statement.executeQuery();
			Atraccion atraccion = null;
			if(resultados.next()) {
				atraccion = toAtraccion(resultados);
			}
			
			return atraccion;
			} catch(Exception e) {
				throw new MissingDataException(e);
			}
		}
	}
