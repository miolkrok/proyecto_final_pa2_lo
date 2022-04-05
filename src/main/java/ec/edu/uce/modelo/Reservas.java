package ec.edu.uce.modelo;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name= "reservas")
public class Reservas {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rese_id_seq")
	@SequenceGenerator(name = "rese_id_seq", sequenceName = "rese_id_seq", allocationSize = 1)
	@Id
	@Column(name="rese_id")
	private Integer id;
	@Column(name="rese_fecha_Inicio", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaInicio;
	@Column(name="rese_fecha_Final", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaFinal;
	@Column(name="rese_estado")
	private String estado;
	@Column(name="rese_numero_reserva")
	private String numeroReserva;
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente clienteR;
	@ManyToOne
	@JoinColumn(name="vehi_id")
	private Vehiculo vehiculoR;
	@OneToOne(mappedBy = "reservas",cascade = CascadeType.ALL)
	private Cobro cobro;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Cliente getClienteR() {
		return clienteR;
	}
	public void setClienteR(Cliente clienteR) {
		this.clienteR = clienteR;
	}
	public Vehiculo getVehiculoR() {
		return vehiculoR;
	}
	public void setVehiculoR(Vehiculo vehiculoR) {
		this.vehiculoR = vehiculoR;
	}
	public Cobro getCobro() {
		return cobro;
	}
	public void setCobro(Cobro cobro) {
		this.cobro = cobro;
	}
	public String getNumeroReserva() {
		return numeroReserva;
	}
	public void setNumeroReserva(String numeroReserva) {
		this.numeroReserva = numeroReserva;
	}
	
	

}
