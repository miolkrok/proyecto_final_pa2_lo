package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Cobro;
@Repository
@Transactional
public class CobroRepositoryImpl implements ICobroRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cobro buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cobro.class, id);
	}

	@Override
	public void insertar(Cobro cobro) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cobro);
	}

	@Override
	public void actualizar(Cobro cobro) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cobro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Cobro cob = this.buscar(id);
		this.entityManager.remove(cob);
	}

}
