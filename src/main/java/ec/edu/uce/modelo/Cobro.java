package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "cobro")
public class Cobro {
	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cobr_id_seq")
	@SequenceGenerator(name = "cobr_id_seq", sequenceName = "cobr_id_seq", allocationSize = 1)
	@Id
	@Column(name="cobr_id")
	private Integer id;
	@Column(name="cobr_valor_subtotal")
	private BigDecimal valorSubTotal;
	@Column(name="cobr_valor_ice")
	private BigDecimal valorICE;
	@Column(name="cobr_valor_Total")
	private BigDecimal valorTotal;
	@Column(name="cobr_fecha_cobro", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaCobro;
	@Column(name="cobr_numero_tarjeta")
	private String numeroTarjeta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cobr_id_rese")
	private Reservas reservas;
	
	public Reservas getReservas() {
		return reservas;
	}
	public void setReservas(Reservas reservas) {
		this.reservas = reservas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValorSubTotal() {
		return valorSubTotal;
	}
	public void setValorSubTotal(BigDecimal valorSubTotal) {
		this.valorSubTotal = valorSubTotal;
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
	public LocalDateTime getFechaCobro() {
		return fechaCobro;
	}
	public void setFechaCobro(LocalDateTime fechaCobro) {
		this.fechaCobro = fechaCobro;
	}
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	
	

}
