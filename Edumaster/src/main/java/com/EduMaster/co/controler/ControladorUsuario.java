package com.edumaster.co.controler;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edumaster.co.interfaceService.IUsuarioService;
import com.edumaster.co.modelo.Usuario;


@Controller
@RequestMapping
public class ControladorUsuario {
	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/listarUsuario")
	public String listar(Model model) {
		List<Usuario> Usuario = service.listarUsuario();
		model.addAttribute("Usuario", Usuario);
		return "ListarUsuarios";
	}
	
	@GetMapping("/newUsuario")
	public String agregar(Model model) {
		model.addAttribute("Usuario", new Usuario());
		return "UsuarioSave";
	}
	
	@PostMapping("/saveUsuario")
	public String save(@Validated Usuario p, Model model) {
		service.saveUsuario(p);
		return "redirect:/listarUsuario";		
	}
	
	@GetMapping("/editarUsuario/{Cedula}")
	public String editar(@PathVariable BigInteger Cedula, Model model) {
		Optional<Usuario>Usuario = service.listarCedulaUsuario(Cedula);
		model.addAttribute("Usuario", Usuario);
		return "UsuarioSave";
	}
	
	@GetMapping("/eliminarUsuario/{Cedula}")
	public String eliminar(@PathVariable BigInteger Cedula, Model model) {
		service.deleteUsuario(Cedula);
		return "redirect:/listar";
	}

}
