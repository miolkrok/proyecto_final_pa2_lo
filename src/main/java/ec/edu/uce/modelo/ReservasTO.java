package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservasTO {
	
	private Vehiculo vehiculo;
	
	private Cliente cliente;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME )
	private LocalDateTime fechaInicio;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME )
	private LocalDateTime fechaFinal;
	
	private Cobro cobro;
	

	
	public ReservasTO() {
		
	}


	public ReservasTO(Vehiculo vehiculo, Cliente cliente, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
			Cobro cobro, String numerotarjeta) {

		this.vehiculo = vehiculo;
		this.cliente = cliente;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.cobro = cobro;
	}


	public Vehiculo getVehiculo() {
		return vehiculo;
	}


	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDateTime getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(LocalDateTime fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public Cobro getCobro() {
		return cobro;
	}


	public void setCobro(Cobro cobro) {
		this.cobro = cobro;
	}


	
	

}
