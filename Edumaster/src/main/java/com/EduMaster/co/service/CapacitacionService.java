package com.edumaster.co.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumaster.co.interfaceService.ICapacitacionService;
import com.edumaster.co.interfaces.ICapacitacion;
import com.edumaster.co.modelo.Capacitacion;

@Service
public class CapacitacionService implements ICapacitacionService{
	@Autowired
	private ICapacitacion data;
	
	@Override
	public List<Capacitacion> listar() {
		return (List<Capacitacion>) data.findAll();
	}

	@Override
	public Optional<Capacitacion> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Capacitacion p) {
		int res=0;
		Capacitacion Capacitacion = data.save(p);
		if(!Capacitacion.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}
}
