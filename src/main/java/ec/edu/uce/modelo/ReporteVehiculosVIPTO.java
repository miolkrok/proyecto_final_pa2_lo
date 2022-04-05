package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;

public class ReporteVehiculosVIPTO {
	
	private Vehiculo vehiculo;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaInicio;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaFinal;
	
	private BigDecimal valorICE;
	
	private BigDecimal valorTotal;

	public ReporteVehiculosVIPTO() {
		
	}
	


	public ReporteVehiculosVIPTO(Vehiculo vehiculo, LocalDateTime fechaInicio, LocalDateTime fechaFinal,
			BigDecimal valorICE, BigDecimal valorTotal) {
		this.vehiculo = vehiculo;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.valorICE = valorICE;
		this.valorTotal = valorTotal;
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

	public BigDecimal getValorICE() {
		return valorICE;
	}

	public void setValorICE(BigDecimal valorICE) {
		this.valorICE = valorICE;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}



	public Vehiculo getVehiculo() {
		return vehiculo;
	}



	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	


	

}
