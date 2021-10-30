package dao;

import java.util.List;
import model.Itinerario;
import model.Usuario;


public interface ItinerarioDAO extends GenericDAO<Itinerario>{

	public abstract int updateItinerario(List<Usuario> u1);
}
