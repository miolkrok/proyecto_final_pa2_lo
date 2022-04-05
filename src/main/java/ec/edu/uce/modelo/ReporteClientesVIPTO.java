package ec.edu.uce.modelo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ReporteClientesVIPTO {
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaInicio;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaFinal;
	
	private String valorICE;
	
	private String valorTotal;

	public ReporteClientesVIPTO() {
		
	}
	
	public ReporteClientesVIPTO(LocalDateTime fechaInicio, LocalDateTime fechaFinal, String valorICE,
			String valorTotal) {
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

	public String getValorICE() {
		return valorICE;
	}

	public void setValorICE(String valorICE) {
		this.valorICE = valorICE;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	

}
