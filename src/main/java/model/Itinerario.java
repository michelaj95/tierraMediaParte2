package model;

public class Itinerario {
	
	private int id_usuario, id_atraccion, id_promocion;
	
	public Itinerario(int id_usuario, int id_atraccion, int id_promocion) {
		
		this.id_usuario = id_usuario;
		this.id_atraccion = id_atraccion;
		this.id_promocion = id_promocion;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public int getId_atraccion() {
		return id_atraccion;
	}

	public int getId_promocion() {
		return id_promocion;
	}

}
