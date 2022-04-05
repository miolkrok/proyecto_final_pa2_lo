package ec.edu.uce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.modelo.Vehiculo;
@Transactional
@Rollback(true)
@SpringBootTest
class GestorEmpleadoServiceImplTest {
	
	@Autowired
	private IClienteService clientServ;
	@Autowired
	private IGestorClienteService gestClientServ;
	@Autowired
	private IGestorEmpleadoService gestEmpServ;
	@Autowired
	private IVehiculoService vehiServ;
	
	

	@Test
	void testRegistrarEmpleado() {
		
		Cliente clie = new Cliente();
		clie.setCedula("1711585185");
		clie.setApellido("castro");
		this.gestEmpServ.registrarEmpleado(clie);
		assertEquals("castro", this.clientServ.buscarClientePorCedula("1711585185").getApellido());
	}

	@Test
	void testBuscarCliente() {
		assertThat(this.clientServ.buscar(1).getId()).isNotNull();
	}

	@Test
	void testIngresarVehiculo() {
		Vehiculo vehi = new Vehiculo();
		vehi.setPlaca("ptt-9455");
		vehi.setModelo("camaro");
		this.vehiServ.insertar(vehi);
		assertEquals("ptt-9455", this.vehiServ.buscarVehiculoPorPlaca("ptt-9455").getPlaca());
	}

	@Test
	void testBuscarVehiculo() {
		assertEquals("hyundai", this.vehiServ.buscarVehiculoPorPlaca("pdo-3562").getMarca());
	}

	@Test
	void testRetirarVehiculo() {
		assertThat(this.vehiServ.buscarVehiculoPorPlaca("pdo-3562").getAvaluo()).isNotNull();
	}
	@Test
	void testRegistrarEmpleado1() {
		
		Cliente clie = new Cliente();
		clie.setCedula("1762941569");
		clie.setNombre("cristian");;
		this.gestEmpServ.registrarEmpleado(clie);
		assertEquals("cristian", this.clientServ.buscarClientePorCedula("1762941569").getNombre());
	}

	@Test
	void testBuscarCliente1() {
		assertThat(this.clientServ.buscarClientePorCedula("1718496944").getApellido()).isNotNull();
	}

	@Test
	void testIngresarVehiculo1() {
		Vehiculo vehi = new Vehiculo();
		vehi.setPlaca("ptt-9455");
		vehi.setModelo("f-150");
		this.vehiServ.insertar(vehi);
		assertEquals("f-150", this.vehiServ.buscarVehiculoPorPlaca("ptt-9455").getModelo());
	}

	@Test
	void testBuscarVehiculo1() {
		assertEquals("booggie", this.vehiServ.buscarVehiculoPorPlaca("pdc-5847").getModelo());
	}

	@Test
	void testRetirarVehiculo1() {
		assertThat(this.vehiServ.buscarVehiculoPorMarcaModelo("chevrolet", "camaro")).isNotNull();
	}


}
