/*package com.edumaster.co.controler;

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

import com.edumaster.co.modelo.Registro;


@Controller
@RequestMapping
public class ControladorRegistro {
	@Autowired
	private IRegistroService service;
	
	@GetMapping("/listarRegistro")
	public String listar(Model model) {
		List<Registro> Registro = service.listarRegistro();
		model.addAttribute("Registro", Registro);
		return "ListarRegistros";
	}
	
	@GetMapping("/newRegistro")
	public String agregar(Model model) {
		model.addAttribute("Registro", new Registro());
		return "RegistroSave";
	}
	
	@PostMapping("/saveRegistro")
	public String save(@Validated Registro p, Model model) {
		service.saveRegistro(p);
		return "redirect:/listarRegistro";		
	}
	
	@GetMapping("/editarRegistro/{Id_usuario}{Id_capacitacion}")
	public String editar(@PathVariable BigInteger Id_usuario, Integer Id_capacitacion, Model model) {
		Optional<Registro>Registro = service.listarIdRegistro(Id_usuario,Id_capacitacion);
		model.addAttribute("Registro", Registro);
		return "RegistroSave";
	}
	
	@GetMapping("/eliminarRegistro/{Id_usuario}{Id_capacitacion}")
	public String eliminar(@PathVariable BigInteger Id_usuario, Integer Id_capacitacion, Model model) {
		service.deleteRegistro(Id_usuario,Id_capacitacion);
		return "redirect:/listar";
	}

}*/
