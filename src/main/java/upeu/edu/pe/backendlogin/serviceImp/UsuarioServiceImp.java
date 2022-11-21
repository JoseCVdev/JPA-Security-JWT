package upeu.edu.pe.backendlogin.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import upeu.edu.pe.backendlogin.entity.Usuario;
import upeu.edu.pe.backendlogin.repository.UsuarioRepository;
import upeu.edu.pe.backendlogin.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService{

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario createUsuario(Usuario usuario) {
		usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}

}
