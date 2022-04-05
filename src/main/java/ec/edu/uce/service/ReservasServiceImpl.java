package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.ReporteClientesVIPTO;
import ec.edu.uce.modelo.ReporteReservasTO;
import ec.edu.uce.modelo.ReporteVehiculosVIPTO;
import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.repository.IReservasRepository;

@Service
public class ReservasServiceImpl implements IReservasService{
	
	@Autowired
	private IReservasRepository reservasRepo;

	@Override
	public Reservas buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.reservasRepo.buscar(id);
	}

	@Override
	public void insertar(Reservas reservas) {
		// TODO Auto-generated method stub
		this.reservasRepo.insertar(reservas);
	}

	@Override
	public void actualizar(Reservas reservas) {
		// TODO Auto-generated method stub
		this.reservasRepo.actualizar(reservas);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.reservasRepo.eliminar(id);
	}

	@Override
	public List<Reservas> buscarReservasPorFechas(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		return this.reservasRepo.buscarReservasPorFechas(placa, fechaInicio, fechaFinal);
	}

	@Override
	public Reservas buscarReservasPorNumeroReservas(String numeroReserva) {
		// TODO Auto-generated method stub
		return this.reservasRepo.buscarReservasPorNumeroReservas(numeroReserva);
	}

	@Override
	public List<ReporteReservasTO> reporteReservasTo(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		return this.reservasRepo.reporteReservasTo(fechaInicio, fechaFinal);
		
	}

	@Override
	public List<ReporteClientesVIPTO> reporteClientesVIPTO(String mes, String anio) {
		// TODO Auto-generated method stub
		return this.reservasRepo.reporteClientesVIPTO(mes, anio);
	}
	@Override
	public List<ReporteVehiculosVIPTO> reporteVehiculosVIPTO(String mes, String anio) {
		// TODO Auto-generated method stub
		return this.reservasRepo.reporteVehiculosVIPTO(mes, anio);
	}



}
