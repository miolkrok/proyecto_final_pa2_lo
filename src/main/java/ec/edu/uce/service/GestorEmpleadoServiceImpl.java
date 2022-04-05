package ec.edu.uce.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.modelo.Vehiculo;

@Service
public class GestorEmpleadoServiceImpl implements IGestorEmpleadoService {

	@Autowired
	private IClienteService clienteServ;
	@Autowired
	private IVehiculoService vehiculoServ;
	@Autowired
	private IReservasService reservasServ;
	
	//funcionalidad 2.a de empleados
	@Override
	public void registrarEmpleado(Cliente cliente) {
		// TODO Auto-generated method stub
		cliente.setRegistro("E");
		this.clienteServ.insertar(cliente);
		
	}

	//funcionalidad 2.b empleados
	@Override
	public  Cliente buscarCliente(String cedula) {
		// TODO Auto-generated method stub
		
		return this.clienteServ.buscarClientePorCedula(cedula);
	}
	//funcionalidad 2.c empleados
	@Override
	@Transactional
	public void ingresarVehiculo(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoServ.insertar(vehiculo);
	}
	//funcionalidad 2.d empleados
	@Override
	public Vehiculo buscarVehiculo(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoServ.buscarVehiculoPorPlaca(placa);
	}
	//funcionalidad 2.e empleados
	@Override
	@Transactional
	public void retirarVehiculo(String numeroReserva) {
		
		
		Reservas rese = this.reservasServ.buscarReservasPorNumeroReservas(numeroReserva);
		Vehiculo vehi = this.vehiculoServ.buscar(rese.getId());
		rese.setEstado("E");
		vehi.setEstado("I");
		this.vehiculoServ.actualizar(vehi);
		this.reservasServ.actualizar(rese);
		
	}
	//funcionalidad 2.f empleados
	@Override
	@Transactional
	public void retirarVehiculoSinReserva(String numeroReserva) {
		// TODO Auto-generated method stub
		this.reservasServ.buscarReservasPorNumeroReservas(numeroReserva);
		Reservas rese = new Reservas();
		rese.setEstado("E");
		rese.getVehiculoR().setEstado("I");
		this.reservasServ.insertar(rese);
	}

}
