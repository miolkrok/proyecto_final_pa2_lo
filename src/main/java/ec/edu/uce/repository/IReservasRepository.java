package ec.edu.uce.repository;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.ReporteClientesVIPTO;
import ec.edu.uce.modelo.ReporteReservasTO;
import ec.edu.uce.modelo.ReporteVehiculosVIPTO;
import ec.edu.uce.modelo.Reservas;

public interface IReservasRepository {
	
	public Reservas buscar(Integer id);
	
	public void insertar(Reservas reservas);
	
	public void actualizar(Reservas reservas);
	
	public void eliminar(Integer id);
	
	public List<Reservas>  buscarReservasPorFechas(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	
	public Reservas buscarReservasPorNumeroReservas(String numeroReserva);
	
	public List<ReporteReservasTO> reporteReservasTo(LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	
	public List<ReporteClientesVIPTO> reporteClientesVIPTO(String mes, String anio);
	
	public List<ReporteVehiculosVIPTO> reporteVehiculosVIPTO(String mes, String anio);

}
