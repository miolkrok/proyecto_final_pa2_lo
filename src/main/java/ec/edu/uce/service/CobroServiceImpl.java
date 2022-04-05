package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Cobro;
import ec.edu.uce.repository.ICobroRepository;
@Service
public class CobroServiceImpl implements ICobroService {

	@Autowired
	private ICobroRepository cobroRepo;
	
	@Override
	public Cobro buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.cobroRepo.buscar(id);
	}

	@Override
	public void insertar(Cobro cobro) {
		// TODO Auto-generated method stub
		this.cobroRepo.insertar(cobro);
	}

	@Override
	public void actualizar(Cobro cobro) {
		// TODO Auto-generated method stub
		this.cobroRepo.actualizar(cobro);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.cobroRepo.eliminar(id);
	}

}
