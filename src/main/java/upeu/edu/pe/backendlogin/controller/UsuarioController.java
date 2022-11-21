package upeu.edu.pe.backendlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import upeu.edu.pe.backendlogin.entity.Usuario;
import upeu.edu.pe.backendlogin.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin({"*"})
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@PostMapping("/create-usuario")
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario postProducto(@RequestBody Usuario usuario){
		return usuarioService.createUsuario(usuario);
	}
	
}
