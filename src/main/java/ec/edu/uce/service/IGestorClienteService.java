package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Cobro;
import ec.edu.uce.modelo.Vehiculo;

public interface IGestorClienteService {
	
	List<Vehiculo> buscarVehiculosDisponibles(String marca, String modelo);
	boolean buscarFechas(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	Cobro calcularCobro(Vehiculo vehiculo, LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	void reservarVehiculo(Cobro cobro, Cliente cliente,Vehiculo vehiculo, LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	void registrarCliente(Cliente cliente);

}
