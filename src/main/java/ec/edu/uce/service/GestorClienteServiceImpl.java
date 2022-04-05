package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Cobro;
import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.modelo.Vehiculo;

@Service
public class GestorClienteServiceImpl implements IGestorClienteService {

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IVehiculoService vehiculoService;
	@Autowired
	private IReservasService reservaService;
	@Autowired
	private ICobroService cobroService;
	
	private static Logger LOG = Logger.getLogger(GestorClienteServiceImpl.class);
	
	
	
	@Override
	public List<Vehiculo> buscarVehiculosDisponibles(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.vehiculoService.buscarVehiculoPorMarcaModelo(marca, modelo);
		
	}
	
	@Override
	public boolean buscarFechas(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		List<Reservas> reseFechSolap = this.reservaService.buscarReservasPorFechas(placa, fechaInicio, fechaFinal);
		if(reseFechSolap.isEmpty()|| reseFechSolap == null) {
			return false;
		}else {
			return true;
		}
	}
	
	@Override
	@Transactional
	public Cobro calcularCobro(Vehiculo vehiculo, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		Cobro cobro = new Cobro();
		Integer tiempoAlquiler = (int) ChronoUnit.DAYS.between(fechaInicio, fechaFinal);
		BigDecimal subTotal = vehiculo.getValorDia().multiply(new BigDecimal(tiempoAlquiler));
		BigDecimal valorICE = (subTotal.multiply(new BigDecimal(15.00))).divide(new BigDecimal(100));
		BigDecimal valorTotal = subTotal.add(valorICE);
		
		cobro.setValorSubTotal(subTotal);
		cobro.setValorICE(valorICE);
		cobro.setValorTotal(valorTotal);
		
		LOG.info(vehiculo.getPlaca()+vehiculo.getValorDia() + cobro.getValorTotal()+tiempoAlquiler );
		LOG.info("Tiempo Fechas: " +  fechaInicio + " - " + fechaFinal);
		
		return cobro;
	}
	
	@Override
	@Transactional
	public void reservarVehiculo(Cobro cobro, Cliente cliente, Vehiculo vehiculo, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		Reservas rese = new Reservas();
		
		rese.setClienteR(cliente);
		rese.setEstado("G");
		rese.setFechaInicio(fechaInicio);
		rese.setFechaFinal(fechaFinal);
		rese.setNumeroReserva(cliente.getCedula()+"-"+vehiculo.getPlaca()+"-" +rese.getFechaInicio());
		rese.setVehiculoR(vehiculo);
		cobro.setFechaCobro(LocalDateTime.now());
		
		List<Reservas>  listaReservas = cliente.getReservasC();
		listaReservas.add(rese);
		cliente.setReservasC(listaReservas);
		this.reservaService.insertar(rese);
		cobro.setReservas(rese);
//		rese.setCobro(cobro);
//		vehiculo.setReservasV(listaReservas);
		this.cobroService.insertar(cobro);
		this.clienteService.actualizar(cliente);
 	}

	@Override
	@Transactional
	public void registrarCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		cliente.setRegistro("C");
		this.clienteService.insertar(cliente);
		


	}





	


}
