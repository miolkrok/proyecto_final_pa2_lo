package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Vehiculo;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Vehiculo buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vehiculo.class, id);
	}

	@Override
	public void insertar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vehiculo);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Vehiculo vehi = this.buscar(id);
		this.entityManager.remove(vehi);
	}

	@Override
	public Vehiculo buscarVehiculoPorPlaca(String placa) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = 
				this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.placa=:valor",Vehiculo.class);
		myQuery.setParameter("valor", placa);
		
		return myQuery.getSingleResult();
	}

	@Override
	public List<Vehiculo> buscarVehiculoPorMarcaModelo(String marca, String modelo) {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = 
				this.entityManager
				.createQuery("SELECT v FROM Vehiculo v WHERE v.marca=:valor AND v.modelo=:valor1",Vehiculo.class);
		myQuery.setParameter("valor", marca);
		myQuery.setParameter("valor1", modelo);
		
		return myQuery.getResultList();
	}

	@Override
	public List<Vehiculo> buscarTodosVehiculos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery = 
				this.entityManager
				.createQuery("SELECT v FROM Vehiculo v",Vehiculo.class);
		
		return myQuery.getResultList();
	}

}
