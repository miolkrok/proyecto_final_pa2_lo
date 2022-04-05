package ec.edu.uce.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.ReporteClientesVIPTO;
import ec.edu.uce.modelo.ReporteReservasTO;
import ec.edu.uce.modelo.ReporteVehiculosVIPTO;

@Service
public class GestorReportesServiceImpl implements IGestorReportesService{

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IReservasService reservaService;
	@Autowired
	private ICobroService cobroService;
	
	private static Logger LOG = Logger.getLogger(GestorReportesServiceImpl.class);

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<ReporteReservasTO> reporteReservasTo(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		return this.reservaService.reporteReservasTo(fechaInicio, fechaFinal);
		
	}
	
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<ReporteClientesVIPTO> reporteClientesVIPTO(String mes, String anio) {
		// TODO Auto-generated method stub
		return this.reservaService.reporteClientesVIPTO(mes, anio);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<ReporteVehiculosVIPTO> reporteVehiculosVIPTO(String mes, String anio) {
		// TODO Auto-generated method stub
		return this.reservaService.reporteVehiculosVIPTO(mes, anio);
	}


}
