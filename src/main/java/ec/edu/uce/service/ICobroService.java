package ec.edu.uce.service;

import ec.edu.uce.modelo.Cobro;

public interface ICobroService {
	
	public Cobro buscar(Integer id);
	
	public void insertar(Cobro cobro);
	
	public void actualizar(Cobro cobro);
	
	public void eliminar(Integer id);

}
