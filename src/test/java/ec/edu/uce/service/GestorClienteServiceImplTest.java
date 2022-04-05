package ec.edu.uce.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import ec.edu.uce.modelo.Cliente;

@Transactional
@Rollback(true)
@SpringBootTest
class GestorClienteServiceImplTest {
	
	@Autowired
	private IClienteService clientServ;
	@Autowired
	private IGestorClienteService gestClientServ;
	@Autowired
	private IGestorEmpleadoService gestEmpServ;
	@Autowired
	private IVehiculoService vehiServ;
	

	@Test
	void testBuscarVehiculosDisponibles() {
		assertThat(this.gestClientServ.buscarVehiculosDisponibles("chevrolet", "camaro")).isNotNull();
		
	}
	
	@Test
	void testBuscarVehiculosDisponibles1() {
		assertThat(this.gestClientServ.buscarVehiculosDisponibles("hyundai", "crossover")).isNotNull();
		
	}

	@Test
	void testRegistrarCliente() {
		Cliente clie = new Cliente();
		clie.setCedula("1885145514");
		clie.setNombre("ariel");
		this.gestClientServ.registrarCliente(clie);
		assertEquals("ariel", this.clientServ.buscarClientePorCedula("1885145514").getNombre());
	}
	
	@Test
	void testRegistrarCliente1() {
		Cliente clie = new Cliente();
		clie.setCedula("1885145514");
		clie.setGenero("masculino");
		this.gestClientServ.registrarCliente(clie);
		assertEquals("masculino", this.clientServ.buscarClientePorCedula("1885145514").getGenero());
	}

}
