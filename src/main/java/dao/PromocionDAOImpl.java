package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import jdbc.ConnectionProvider;
import model.Atraccion;
import model.Promocion;
import model.Promocion3x2;
import model.PromocionFinal;
import model.PromocionPorcentual;

public class PromocionDAOImpl implements PromocionDAO {

	public List<Promocion> findAll() {
		try {
		String sql = "SELECT * FROM promociones";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		List<Promocion> promociones = new LinkedList<Promocion>();
		while(resultados.next()) {
			promociones.add(toPromocion(resultados));
		}
		return promociones;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
/*	
	public int update(Promocion promocion) {
		try {
		String sql = "UPDATE promociones SET presupuesto = ?, tiempo= ? WHERE id = ?;";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, usuario.getPresupuesto());
		statement.setDouble(2, usuario.getTiempoDisponible());
		statement.setInt(3, usuario.getIdUsuario());
		int rows = statement.executeUpdate();
		return rows;
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}
	*/
	private Promocion toPromocion(ResultSet resultados) {
		try {
		AtraccionDAO atraccDAO = DAOFactory.getAtraccionDAO();
		List <Atraccion> atracciones; 
		Promocion promo = null;
		if(resultados.getString(6) != null){
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccDAO.findByAtraccionId(resultados.getInt(4)));
		atracciones.add(atraccDAO.findByAtraccionId(resultados.getInt(5)));
		atracciones.add(atraccDAO.findByAtraccionId(resultados.getInt(6)));
		return new Promocion3x2(resultados.getInt(1), resultados.getString(2), atracciones);
		}else if(resultados.getString(9) != null) {
		atracciones = new ArrayList<Atraccion>();
		atracciones.add(atraccDAO.findByAtraccionId(resultados.getInt(4)));
		atracciones.add(atraccDAO.findByAtraccionId(resultados.getInt(5)));
		return new PromocionPorcentual(resultados.getInt(1), resultados.getString(2), atracciones, resultados.getInt(9));
		} else {
			atracciones = new ArrayList<Atraccion>();
			atracciones.add(atraccDAO.findByAtraccionId(resultados.getInt(4)));
			atracciones.add(atraccDAO.findByAtraccionId(resultados.getInt(5)));
		return new PromocionFinal(resultados.getInt(1), resultados.getString(2), atracciones, resultados.getInt(8));
		}
		} catch(Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		return 0;
	}

	public int insert(Promocion t){
		return 0;
	}

	public int delete(Promocion t)  {
		return 0;
	}

	public Promocion findByPromocionName(String name) {
		return null;
	}
	public int update(Promocion t) {
		return 0;
	}
}
