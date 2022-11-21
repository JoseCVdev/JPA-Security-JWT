package upeu.edu.pe.backendlogin.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import upeu.edu.pe.backendlogin.entity.Usuario;
import upeu.edu.pe.backendlogin.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = usuarioRepository.findOneByUsername(username)
		.orElseThrow( () -> new UsernameNotFoundException("El usuario con username "+" no existe"));
		
		return new UserDetailsImpl(usuario);
		
	}
	
}
