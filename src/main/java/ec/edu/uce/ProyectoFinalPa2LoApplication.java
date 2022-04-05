package ec.edu.uce;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.ReporteReservasTO;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.service.IGestorClienteService;
import ec.edu.uce.service.IGestorEmpleadoService;
import ec.edu.uce.service.IGestorReportesService;
import ec.edu.uce.service.IReservasService;
import ec.edu.uce.service.IVehiculoService;

@SpringBootApplication
public class ProyectoFinalPa2LoApplication implements CommandLineRunner {

	@Autowired
	private IVehiculoService vehiculoServ;
	@Autowired
	private IGestorClienteService gestClieServ;
	@Autowired
	private IGestorEmpleadoService gestEmplServ;
	@Autowired
	private IGestorReportesService gestRepServ;
	private static final Logger LOG = LoggerFactory.getLogger(ProyectoFinalPa2LoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPa2LoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		List<FacturaSencilla> lista = this.facturaService.buscarPorFechaSencilla(LocalDateTime.now());
//		for(FacturaSencilla f : lista) {
//			LOG.info(f.toString());
//		}
//		List<Vehiculo> listVehi =  this.vehiculoServ.buscarVehiculoPorMarcaModelo("chevrolet", "camaro");
//		for(Vehiculo f : listVehi) {
//			LOG.info(f.toString());
//		}
//		this.gestClieServ.reservarVehiculo("pdo-3562", "1718496944", LocalDateTime.of(2022, Month.APRIL, 10, 12, 30), LocalDateTime.of(2022, Month.APRIL, 11, 12, 30), "9874-2145-4654-4546");
//		this.gestClieServ.reservarVehiculo(null, null, null, null, null);
//		this.gestEmplServ.retirarVehiculo("1718496944-pdb-3548-2022-04-30T02:30");
//		List<ReporteReservasTO> listRe = this.gestRepServ.reporteReservasTo(LocalDateTime.of(1999, Month.MAY, 8, 0, 0),
//				LocalDateTime.of(2023, Month.MAY, 8, 0, 0));
//		for (ReporteReservasTO r : listRe) {
//			LOG.info(r.toString());
//
//		}
//		this.gestRepServ.reporteVehiculosVIPTO("05", "2022");
	}

}
