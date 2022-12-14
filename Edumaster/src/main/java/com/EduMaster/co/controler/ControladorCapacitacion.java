package com.edumaster.co.controler;

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

import com.edumaster.co.interfaceService.ICapacitacionService;
import com.edumaster.co.modelo.Capacitacion;

@Controller
@RequestMapping
public class ControladorCapacitacion {
	
	@Autowired
	private ICapacitacionService service;
	
	@GetMapping("/")
	public String index() {
		return "login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/ConsultaEmpleado")
	public String ConsultaEmpleado() {
		return "ConsultaEmpleado";
	}
	
	@GetMapping("/CertificadoEmpleado")
	public String CertificadoEmpleado() {
		return "CertificadoEmpleado";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Capacitacion> Capacitacion = service.listar();
		model.addAttribute("Capacitacion", Capacitacion);
		return "Index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("Capacitacion", new Capacitacion());
		return "CapacitacionSave";
	}
	
	@PostMapping("/save")
	public String save(@Validated Capacitacion p, Model model) {
		service.save(p);
		return "redirect:/listar";		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Capacitacion>Capacitacion = service.listarId(id);
		model.addAttribute("Capacitacion", Capacitacion);
		return "CapacitacionSave";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
	}
}
