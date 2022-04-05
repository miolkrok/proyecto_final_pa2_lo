package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.ReporteClientesVIPTO;
import ec.edu.uce.modelo.ReporteReservasTO;
import ec.edu.uce.modelo.ReporteVehiculosVIPTO;

public interface IGestorReportesService {
	
	public List<ReporteReservasTO> reporteReservasTo(LocalDateTime fechaInicio, LocalDateTime fechaFinal);
	
	public List<ReporteClientesVIPTO> reporteClientesVIPTO(String mes, String anio);
	
	public List<ReporteVehiculosVIPTO> reporteVehiculosVIPTO(String mes, String anio);

}
