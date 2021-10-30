package dao;

import java.util.List;
import model.Atraccion;

public interface AtraccionDAO extends GenericDAO<Atraccion> {
	
	public abstract Atraccion findByAtraccionId(int idAtraccion);
	public abstract int updateAtracciones(List<Atraccion> a1);
}
