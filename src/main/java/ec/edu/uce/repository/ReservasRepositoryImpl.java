package ec.edu.uce.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.ReporteClientesVIPTO;
import ec.edu.uce.modelo.ReporteReservasTO;
import ec.edu.uce.modelo.ReporteVehiculosVIPTO;
import ec.edu.uce.modelo.Reservas;
import ec.edu.uce.modelo.Vehiculo;

@Repository
@Transactional
public class ReservasRepositoryImpl implements IReservasRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Reservas buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Reservas.class, id);
	}

	@Override
	public void insertar(Reservas reservas) {
		// TODO Auto-generated method stub
		this.entityManager.persist(reservas);
	}

	@Override
	public void actualizar(Reservas reservas) {
		// TODO Auto-generated method stub
		this.entityManager.merge(reservas);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Reservas rese = this.buscar(id);
		this.entityManager.remove(rese);
	}

	@Override
	public List<Reservas> buscarReservasPorFechas(String placa, LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		TypedQuery<Reservas> myQuery = this.entityManager.createQuery(
				"SELECT r FROM Reservas r JOIN FETCH r.vehiculoR v WHERE v.placa=:placa AND ((r.fechaInicio <:fechaInicio AND r.fechaFinal>:fechaInicio) "
						+ "OR (r.fechaInicio <: fechaFinal AND r.fechaFinal >=:fechaFinal) OR (r.fechaInicio >:fechaInicio AND r.fechaFinal <:fechaFinal))",
				Reservas.class);

		myQuery.setParameter("placa", placa);
		myQuery.setParameter("fechaInicio", fechaInicio);
		myQuery.setParameter("fechaFinal", fechaFinal);

		return myQuery.getResultList();
	}

	@Override
	public Reservas buscarReservasPorNumeroReservas(String numeroReserva) {
		// TODO Auto-generated method stub
		TypedQuery<Reservas> myQuery = this.entityManager
				.createQuery("SELECT r FROM Reservas r WHERE r.numeroReserva=:numeroReserva", Reservas.class);
		myQuery.setParameter("numeroReserva", numeroReserva);
		return myQuery.getSingleResult();
	}

	@Override
	public List<ReporteReservasTO> reporteReservasTo(LocalDateTime fechaInicio, LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		TypedQuery<ReporteReservasTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW ec.edu.uce.modelo.ReporteReservasTO(r.id,r.fechaInicio, r.fechaFinal, r.estado,r.numeroReserva,c.cedula,c.nombre,c.apellido,v.placa,v.valorDia) FROM Reservas r JOIN r.clienteR c JOIN r.vehiculoR v WHERE r.fechaInicio>:fechaInicio AND r.fechaFinal <=:fechaFinal",
				ReporteReservasTO.class);
		myQuery.setParameter("fechaInicio", fechaInicio);
		myQuery.setParameter("fechaFinal", fechaFinal);
		return myQuery.getResultList();
	}
	
	@Override
	public List<ReporteClientesVIPTO> reporteClientesVIPTO(String mes, String anio) {
		// TODO Auto-generated method stub
		String fech = "01/" + mes + "/" + anio;
		LocalDate loda = LocalDate.parse(fech, DateTimeFormatter.ofPattern("d/MM/yyyy"));
		LocalDateTime fecha = loda.atStartOfDay();
		TypedQuery<ReporteClientesVIPTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW ec.edu.uce.modelo.ReporteClientesVIPTO(v, sum(c.valorICE),sum(p.valorTotal)AS total) FROM Reservas r JOIN r.clienteR v JOIN r.cobro c WHERE r.fechaInicio>:fecha GROUP BY v ORDER BY total DESC",
				ReporteClientesVIPTO.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	}

	@Override
	public List<ReporteVehiculosVIPTO> reporteVehiculosVIPTO(String mes, String anio) {
		// TODO Auto-generated method stub
		String fech = "01/" + mes + "/" + anio;
		LocalDate loda = LocalDate.parse(fech, DateTimeFormatter.ofPattern("d/MM/yyyy"));
		LocalDateTime fecha = loda.atStartOfDay();
		TypedQuery<ReporteVehiculosVIPTO> myQuery = this.entityManager.createQuery(
				"SELECT NEW ec.edu.uce.modelo.ReporteVehiculosVIPTO(v, sum(c.valorICE),sum(c.valorTotal)AS total) FROM Reservas r JOIN r.vehiculoR v JOIN r.cobro c WHERE r.fechaInicio>:fecha GROUP BY v ORDER BY total DESC",
				ReporteVehiculosVIPTO.class);
		myQuery.setParameter("fecha", fecha);
		return myQuery.getResultList();
	}



}
