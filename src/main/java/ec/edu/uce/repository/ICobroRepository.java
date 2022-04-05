package ec.edu.uce.repository;

import ec.edu.uce.modelo.Cobro;

public interface ICobroRepository {
	
	public Cobro buscar(Integer id);
	
	public void insertar(Cobro cobro);
	
	public void actualizar(Cobro cobro);
	
	public void eliminar(Integer id);

}
