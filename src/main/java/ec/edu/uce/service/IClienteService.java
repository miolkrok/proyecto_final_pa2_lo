package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Cliente;

public interface IClienteService {
	
	public Cliente buscar(Integer id);
	
	public void insertar(Cliente cliente);
	
	public void actualizar(Cliente cliente);
	
	public void eliminar(Integer id);
	
	public Cliente buscarClientePorCedula(String cedula);
	
	public List<Cliente> buscarClienteTodos();

}
