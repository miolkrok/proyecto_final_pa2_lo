package ec.edu.uce.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class RetirarVehiculoTO {

	private Vehiculo vehiculo;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaInicio;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaFinal;
	
	private Cliente cliente;
	
	private String numeroReserva;
	
	public RetirarVehiculoTO() {
		
	}

	public RetirarVehiculoTO(Vehiculo vehiculo, Cliente cliente, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
			String numeroReserva) {
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.numeroReserva = numeroReserva;
		this.cliente = cliente;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
	

}
