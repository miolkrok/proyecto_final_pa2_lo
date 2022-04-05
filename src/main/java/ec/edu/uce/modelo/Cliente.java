package ec.edu.uce.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name= "cliente")
public class Cliente {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clie_id_seq")
	@SequenceGenerator(name = "clie_id_seq", sequenceName = "clie_id_seq", allocationSize = 1)
	@Id
	@Column(name="clie_id")
	private Integer id;
	@Column(name="clie_cedula")
	private String cedula;
	@Column(name="clie_nombre")
	private String nombre;
	@Column(name="clie_apellido")
	private String apellido;
	@Column(name="clie_fechaNacimiento", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaNacimiento;
	@Column(name="clie_genero")
	private String genero;
	@Column(name="clie_registro")
	private String registro;
	@OneToMany(mappedBy = "clienteR",cascade=CascadeType.ALL)
	private List<Reservas> reservasC;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public LocalDateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public List<Reservas> getReservasC() {
		return reservasC;
	}
	public void setReservasC(List<Reservas> reservasC) {
		this.reservasC = reservasC;
	}



	
}
