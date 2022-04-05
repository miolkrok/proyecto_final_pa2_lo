package ec.edu.uce.service;


import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.modelo.Vehiculo;

public interface IGestorEmpleadoService {
	
	void registrarEmpleado(Cliente cliente);
	Cliente buscarCliente(String cedula);
	void ingresarVehiculo(Vehiculo vehiculo);
	Vehiculo buscarVehiculo(String placa);
	void retirarVehiculo(String numeroReserva);
	void retirarVehiculoSinReserva(String numeroReserva);
	


}
