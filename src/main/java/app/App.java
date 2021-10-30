package app;

import dao.AtraccionDAO;
import dao.DAOFactory;
import dao.ItinerarioDAO;
import dao.PromocionDAO;
import dao.UsuarioDAO;
import model.Administrador;

public class App {
	public static void main(String[] args) {
		Administrador adm = new Administrador();
		AtraccionDAO atraccDAO = DAOFactory.getAtraccionDAO();
		adm.agregarTodasAtracciones(atraccDAO.findAll());
		
		UsuarioDAO usuDAO = DAOFactory.getUsuarioDAO();
		adm.agregarTodosUsuarios(usuDAO.findAll());
		
		PromocionDAO promoDAO = DAOFactory.getPromocionDAO();
		adm.agregarTodasPromociones(promoDAO.findAll());
		
		ItinerarioDAO itiDAO = DAOFactory.getItinerarioDAO();
		
		System.out.println(adm);
		
		adm.ordenarAtracciones();
		adm.ordenarPromociones();
		
		adm.recomendarAUsuarios();
		usuDAO.updateUsuarios(adm.getUsuarios()); 
		atraccDAO.updateAtracciones(adm.getAtracciones()); 
		itiDAO.updateItinerario(adm.getUsuarios());
	
		
	}
}
