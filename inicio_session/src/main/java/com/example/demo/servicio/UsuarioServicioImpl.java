package com.example.demo.servicio;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UsuarioRegistroDTO;
import com.example.demo.modelo.Rol;
import com.example.demo.modelo.Usuarios;
import com.example.demo.repositorio.UsuarioRepositorio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
	
	private UsuarioRepositorio usuarioRepositorio;
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	@Override
	public Usuarios guardar(UsuarioRegistroDTO registroDTO) {
		Usuarios usuario =new Usuarios(registroDTO.getNombre(),
				registroDTO.getApellido(),
				registroDTO.getEmail(),
				passwordEncoder.encode(registroDTO.getPassword()),
				Arrays.asList(new Rol("ROLE_USER")));
		
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuarios usuario = usuarioRepositorio.findByEmail(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario o password invalido");
		}
		return new UserDetails(usuario.getEmail(),
				usuario.getPassword(),
				mapearAutoridadesRoles(usuario.getRoles())
		);
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles) {
		
		return roles.stream().map(role-> new(SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList()));
	}

	@Override
	public List<Usuarios> listarUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}