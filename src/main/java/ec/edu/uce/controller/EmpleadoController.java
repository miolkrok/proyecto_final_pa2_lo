package ec.edu.uce.controller;

import java.util.List;

import javax.persistence.NoResultException;

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
import ec.edu.uce.modelo.ReservasTO;
import ec.edu.uce.modelo.RetirarVehiculoTO;
import ec.edu.uce.modelo.Vehiculo;
import ec.edu.uce.service.IClienteService;
import ec.edu.uce.service.IGestorEmpleadoService;
import ec.edu.uce.service.IReservasService;
import ec.edu.uce.service.IVehiculoService;

@Controller
@RequestMapping("/empleados/")
public class EmpleadoController {
	
	@Autowired
	private IGestorEmpleadoService gestEmpleadoServ;
	@Autowired
	private IClienteService clientServ;
	@Autowired
	private IVehiculoService vehiServ;
	@Autowired
	private IReservasService reseServ;
	
	private static Logger LOG = Logger.getLogger(EmpleadoController.class);
	//metodo para verificar todos
//	@GetMapping("todos")
//	public String buscarTodos(Model modelo) {
//		List<Cliente> listaClientes = this.clientServ.buscarClienteTodos();
//		modelo.addAttribute("clientes", listaClientes);
//		return "clientes/listaClientes";
//	}
	/***************************2A***********************************************/
	//2.a
	
	//metodo getmapping para que el empleado registre al cliente
	@GetMapping("registrarClienteEmp")
	public String obtenerPaginaIngresoDatosEmp(Cliente cliente,Model modelo) {
		modelo.addAttribute("buscarClie",false);
		return "registrarClienteEmp";
	}
	//metodo getmapping para que el empleado registre al cliente
	@PostMapping("insertarEmp")
	public String insertarClienteEmp(Cliente cliente, BindingResult result, Model modelo, RedirectAttributes redirectAttrs) {
		this.gestEmpleadoServ.registrarEmpleado(cliente);
		redirectAttrs.addFlashAttribute("mensaje", "Cliente Registrado");
		modelo.addAttribute("buscarClie",true);
		return "registrarClienteEmp";
		
	}
	/***************************2B***********************************************/
	//2b
	@GetMapping("clientes/buscar/registrados")
	public String paginaClienteRegistrado(Model modelo) {
		modelo.addAttribute("buscar", false);
		return"clientes/listaClientes";
	}
	//metodo para buscar cliente por cedula
	@PostMapping("clientes/encontrar/registrados")
	public String obtenerCliente(@RequestParam("cedula")String cedula, Model modelo) {
		Cliente clientes = this.gestEmpleadoServ.buscarCliente(cedula);
		
		modelo.addAttribute("clientes", clientes);
		modelo.addAttribute("buscar", true);
		return "clientes/listaClientes";
	}
	/***************************2C***********************************************/
	//2.c
	//metodo para obtener pagina de ingreso de datos del vehiculo
	@GetMapping("ingresarVehiculo")
	public String obtenerPaginaIngresoDatosVehiculo(Vehiculo vehiculo) {
		
		return "vehiculo/ingresarVehiculo";
	}
	//metodo para insertar el vehiculo
	@PostMapping("insertarVehiculo")
	public String insertarVehiculo(Vehiculo vehiculo, BindingResult result, Model modelo, RedirectAttributes redirectAttrs) {
		this.gestEmpleadoServ.ingresarVehiculo(vehiculo);
		
		redirectAttrs.addFlashAttribute("mensaje", "Vehiculo Registrado");
		
		return "redirect:todosVehiculos";
	}
	//para probar todos
	@GetMapping("todosVehiculos")
	public String buscarTodosVehi(Model modelo) {
		
		List<Vehiculo> listaVehi = this.vehiServ.buscarTodosVehiculos();
		modelo.addAttribute("vehiculo", listaVehi);
		return "vehiculo/todosVehiculosDisponibles";
	}
	/**************************2D***********************************************/
	//2d
	@GetMapping("vehiculo/buscar/placa")
	public String paginaVehiculoRegistrados(Model modelo) {
		modelo.addAttribute("buscarPlaca", false);
		return"vehiculo/vehiculosPlaca";
	}
	
	@PostMapping("buscar/porPlaca")
	public String obtenerVehiculoPorPlaca(@RequestParam("placa")String placa,Model modelo,RedirectAttributes redirectAttrs) {

			Vehiculo vehiculo = this.gestEmpleadoServ.buscarVehiculo(placa);
			modelo.addAttribute("vehiculo", vehiculo);
			modelo.addAttribute("buscarPlaca", true);
			return"vehiculo/vehiculosPlaca";

	}
	/***************************2E***********************************************/
	//2.e
	//metodo para retirar vehiculo reservado
//	@GetMapping("obtenerPaginaNumeroReserva")
//	private String obtenerPaginaNumeroReserva(@RequestParam(name="numeroReserva")String numeroReserva,RetirarVehiculoTO retirarVehiculoTO , Model modelo ) {
//		modelo.addAttribute("buscarRetiro", false);
//		return "obtenerNumeroReserva";
//	}
	@GetMapping("obtenerNumeroReserva")
	private String obtenerNumeroReserva(@RequestParam(required=false,name="numeroReserva")String numeroReserva,RetirarVehiculoTO retirarVehiculoTO , Model modelo ) {
		
		modelo.addAttribute("textoReserva",this.reseServ.buscarReservasPorNumeroReservas(retirarVehiculoTO.getNumeroReserva()));
		modelo.addAttribute("buscarRetiro", false);
		return "obtenerNumeroReserva";
	}
	@PostMapping("retirarReserva")
	public String retirarReserva(@RequestParam(required=false,name="numeroReserva")String numeroReserva, Model modelo,RedirectAttributes redirectAttrs) {
			
		this.gestEmpleadoServ.retirarVehiculo(numeroReserva);
		modelo.addAttribute("buscarRetiro", true);
		return "obtenerNumeroReserva";
	}
	

}
