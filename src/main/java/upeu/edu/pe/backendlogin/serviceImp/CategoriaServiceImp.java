package upeu.edu.pe.backendlogin.serviceImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import upeu.edu.pe.backendlogin.entity.Categoria;
import upeu.edu.pe.backendlogin.repository.CategoriaRepository;
import upeu.edu.pe.backendlogin.service.CategoriaService;

@Service
public class CategoriaServiceImp implements CategoriaService{
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> readAllCategories() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<Categoria> readOneCategoria(int id_categoria) {
		return categoriaRepository.findById(id_categoria);
	}
	
}
