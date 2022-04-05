package ec.edu.uce.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name= "vehiculo")
public class Vehiculo {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehi_id_seq")
	@SequenceGenerator(name = "vehi_id_seq", sequenceName = "vehi_id_seq", allocationSize = 1)
	@Id
	@Column(name="vehi_id")
	private Integer id;
	@Column(name="vehi_placa")
	private String placa;
	@Column(name="vehi_modelo")
	private String modelo;
	@Column(name="vehi_marca")
	private String marca;
	@Column(name="vehi_anio_fabricacion")
	private String anioFabricacion;
	@Column(name="vehi_cilindraje")
	private String cilindraje;
	@Column(name="vehi_avaluo")
	private BigDecimal avaluo;
	@Column(name="vehi_estado")
	private String estado;
	@Column(name="vehi_valor_dia")
	private BigDecimal valorDia;
	
	@OneToMany(mappedBy = "vehiculoR",cascade=CascadeType.ALL)
	private List<Reservas> reservasV;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(String anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	public String getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}
	public BigDecimal getAvaluo() {
		return avaluo;
	}
	public void setAvaluo(BigDecimal avaluo) {
		this.avaluo = avaluo;
	}
	public BigDecimal getValorDia() {
		return valorDia;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}
	public List<Reservas> getReservasV() {
		return reservasV;
	}
	public void setReservasV(List<Reservas> reservasV) {
		this.reservasV = reservasV;
	}
	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", marca=" + marca
				+ ", anioFabricacion=" + anioFabricacion + ", cilindraje=" + cilindraje + ", avaluo=" + avaluo
				+ ", estado=" + estado + ", valorDia=" + valorDia + "]";
	}



}
