package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Vehiculo;

public interface IVehiculoService {
	
	public Vehiculo buscar(Integer id);
	
	public void insertar(Vehiculo vehiculo);
	
	public void actualizar(Vehiculo vehiculo);
	
	public void eliminar(Integer id);
	
	public Vehiculo buscarVehiculoPorPlaca(String placa);
	
	public List<Vehiculo>  buscarVehiculoPorMarcaModelo(String marca, String modelo);
	
	public List<Vehiculo > buscarTodosVehiculos();


}
