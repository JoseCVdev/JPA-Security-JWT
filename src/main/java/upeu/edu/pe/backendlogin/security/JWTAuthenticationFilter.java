package upeu.edu.pe.backendlogin.security;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, 
												HttpServletResponse response) throws AuthenticationException {
		
		AuthCredentials authCredentials = new AuthCredentials();
		
		try {
			authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
		} catch (IOException e) {
		}
		
		UsernamePasswordAuthenticationToken usernamePATH = new UsernamePasswordAuthenticationToken(
				authCredentials.getUsername(), authCredentials.getPassword(), Collections.emptyList());
		
		return getAuthenticationManager().authenticate(usernamePATH);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, 
											HttpServletResponse response, 
											FilterChain chain,
											Authentication authResult) throws IOException, ServletException {
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
		System.out.println("SUCCESS AUTHORITIES: " + userDetails.getAuthorities());
		String token = TokenSecurity.createToken(userDetails.getIdUsuario(), userDetails.getNombre(), userDetails.getUsername(), userDetails.getRol().getNombre_rol());
		
		response.addHeader("Authorization", "Bearer " + token);
	    response.getWriter().write(token);
		response.getWriter().flush();
		
		super.successfulAuthentication(request, response, chain, authResult);
	}
	
}
