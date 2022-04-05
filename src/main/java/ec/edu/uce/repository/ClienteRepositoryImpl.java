package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Cliente;


@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		Cliente clie = this.buscar(id);
		this.entityManager.remove(clie);
	}

	@Override
	public Cliente buscarClientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myQuery = 
				this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula=:valor",Cliente.class);
		myQuery.setParameter("valor", cedula);
		
		return myQuery.getSingleResult();
	}

	@Override
	public List<Cliente> buscarClienteTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myQuery = 
				this.entityManager
				.createQuery("SELECT c FROM Cliente c",Cliente.class);
		
		return myQuery.getResultList();
	}

}
