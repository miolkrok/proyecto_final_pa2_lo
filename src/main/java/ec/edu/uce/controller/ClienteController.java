package ec.edu.uce.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.Cliente;
import ec.edu.uce.modelo.Cobro;
import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.modelo.ReservasTO;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.service.GestorClienteServiceImpl;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IGestorClienteService;
import ec.edu.uce.service.IGestorEmpleadoService;
import ec.edu.uce.service.IVehiculoService;

@Controller
@RequestMapping("/clientes/")
public class ClienteController {
	
	@Autowired
	private IVehiculoService vehiServ;
	@Autowired
	private IGestorEmpleadoService gestEmpServ;
	@Autowired
	private IGestorClienteService gestClienServ;
	@Autowired
	private IClienteService clienteService;
	
	private static Logger LOG = Logger.getLogger(ClienteController.class);
	
//	@GetMapping("buscar/{idVehiculo}")
//	public String obtenerVehiculoId(@PathVariable("idVehiculo")Integer idVehiculo, Model modeloC) {
//		Vehiculo vehi = this.vehiServ.buscar(idVehiculo);
//		modeloC.addAttribute("vehi", vehi);
//		
//		return "vehiculoDisponibles";
//	}
//	@GetMapping("todos")
//	public String buscarTodosClie(Model modelo) {
//		
//		List<Cliente> listaClientes = this.clienteService.buscarClienteTodos();
//		modelo.addAttribute("clientes", listaClientes);
//		return "clientes/listaClientes";
//	}
	/************************* 1a*******************************************/
	//metodo  obtener pagina
	@GetMapping("buscar/Disponibles")
	public String paginaVehiculoDisponible(Model modeloC) {
		
		return"vehiculo/todosVehiculosDisponibles";
	}
	//metodo get para buscar vehiculo disponibles
	@PostMapping("vehiculosDisponibles")
	public String obtenerVehiculo(@RequestParam("marca")String marca,@RequestParam("modelo")String modelo, Model modeloC) {
		List<Vehiculo> listaVehi =  this.gestClienServ.buscarVehiculosDisponibles(marca, modelo);
		
		modeloC.addAttribute("vehiculo", listaVehi);
		
		
		return "vehiculo/todosVehiculosDisponibles";
	}
	/***************************1B***********************************************/
	@GetMapping("comprobarReserva")
	public String obtenerPaginaIngresoDatosReserva(ReservasTO reservasTO) {
		
		return "clientes/comprobarReserva";
	}
	
	@PostMapping("fechasDisponibles")
	public String obtenerFechasDisponibles(ReservasTO reservasTO, Model modelo, RedirectAttributes redirectAttrs) {
//		LOG.info(reservas.getClienteR().getCedula());
		Cliente cliente = this.clienteService.buscarClientePorCedula(reservasTO.getCliente().getCedula());
		LOG.info(cliente.getCedula());
		Vehiculo vehiculo = this.vehiServ.buscarVehiculoPorPlaca(reservasTO.getVehiculo().getPlaca());
		if(this.gestClienServ.buscarFechas(vehiculo.getPlaca(), reservasTO.getFechaInicio(), reservasTO.getFechaFinal())) {
			redirectAttrs.addFlashAttribute("mensaje", "FECHAS INDISPONIBLES");
			return "redirect:comprobarReserva";
		}else {
			Cobro cobro = this.gestClienServ.calcularCobro(vehiculo, reservasTO.getFechaInicio(), reservasTO.getFechaFinal());
			reservasTO.setCobro(cobro);
//			LOG.info(reservas.getClienteR().getCedula());
			redirectAttrs.addFlashAttribute("mensaje", "FECHAS DISPONIBLES");
			modelo.addAttribute("cobro", cobro);
			modelo.addAttribute("vehiculo", vehiculo);
			modelo.addAttribute("cliente", cliente);
			modelo.addAttribute("reservasTO", reservasTO);
			return "clientes/cobrarReserva";
		}

	}
	/***************************1C***********************************************/
	@PostMapping("reservar")
	public String reservar(ReservasTO reservasTO, Model modelo) {
//		LOG.info(reservasTO.getFechaInicio().toString());
//		LOG.info(reservasTO.getCobro().getNumeroTarjeta());
		Cobro cobro = reservasTO.getCobro();
//		LOG.info(cobro.getValorSubTotal().toString());
		
		Cliente cliente = this.clienteService.buscarClientePorCedula(reservasTO.getCliente().getCedula());
		Vehiculo vehiculo = this.vehiServ.buscarVehiculoPorPlaca(reservasTO.getVehiculo().getPlaca());
		
		this.gestClienServ.reservarVehiculo(cobro, cliente, vehiculo, reservasTO.getFechaInicio(), reservasTO.getFechaFinal());
		
		return "clientes/reservaRealizada";
	}
	
	
	//metodos para registrar cliente
	@GetMapping("registrarCliente")
	public String obtenerPaginaIngresoDatosCliente(Cliente cliente,Model modelo) {
		modelo.addAttribute("buscarClie",false);
		return "clientes/registrarClientes";
	}
	@PostMapping("insertar")
	public String insertarCliente(Cliente cliente, BindingResult result, Model modelo, RedirectAttributes redirectAttrs) {
		this.gestClienServ.registrarCliente(cliente);
		modelo.addAttribute("buscarClie",true);
		redirectAttrs.addFlashAttribute("mensaje", "Cliente Registrado");
		return "clientes/registrarClientes";
		
	}
	
	
	

}
