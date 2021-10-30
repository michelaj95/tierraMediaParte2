package dao;

import java.util.List;

import model.Usuario;


public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public abstract Usuario findByUsuarioName(String name);
	public abstract int updateUsuarios(List<Usuario> u1);
}
