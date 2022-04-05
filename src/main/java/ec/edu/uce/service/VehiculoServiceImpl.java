package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService{
	
	@Autowired
	private IVehiculoRepository vehiculoRepo;

	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscar(id);
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.insertar(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.actualizar(vehiculo);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.eliminar(id);
	}

	@Override
	public Vehiculo buscarVehiculoPorPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscarVehiculoPorPlaca(placa);
	}

	@Override
	public List<Vehiculo> buscarVehiculoPorMarcaModelo(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscarVehiculoPorMarcaModelo(marca, modelo);
	}

	@Override
	public List<Vehiculo> buscarTodosVehiculos() {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.buscarTodosVehiculos();
	}



}
