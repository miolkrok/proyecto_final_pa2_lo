package ec.edu.uce.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ec.edu.uce.modelo.ReporteReservasTO;
import ec.edu.uce.modelo.ReporteVehiculosVIPTO;
import ec.edu.uce.service.IGestorReportesService;

@Controller
@RequestMapping("/reportes/")
public class ReportesController {

	@Autowired
	private IGestorReportesService gestRepoServ;

	/******************3a*****************************/
	@GetMapping("reservas")
	private String paginaReporteReservas(ReporteReservasTO reporteReservasTO) {
		
		return "reportesReserva";
		
	}
	
	
	@GetMapping("reservaEncontrada")
	public String reporteReservas(@RequestParam(value = "fechaInicio") String fechaInicio,
			@RequestParam(value = "fechaFinal") String fechaFinal, Model model) {
		model.addAttribute("repo", this.gestRepoServ.reporteReservasTo(LocalDateTime.parse(fechaInicio), LocalDateTime.parse(fechaFinal)));
		
		return "";

	}
	/******************3a*****************************/
	/******************3c*****************************/
	@GetMapping("reporteReservas/{mes}/{anio}")
	public String reporteVehiculoVIPTO(@PathVariable("mes")String mes, @PathVariable("anio")String anio,Model modelo) {
		
		List<ReporteVehiculosVIPTO> listVehiculo = this.gestRepoServ.reporteVehiculosVIPTO(mes, anio);
		modelo.addAttribute("report", listVehiculo);
		return "listaVehiculoVIP";
		
	}
	

}
