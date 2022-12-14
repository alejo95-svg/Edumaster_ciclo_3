/*package com.edumaster.co.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edumaster.co.interfaceService.IRegistroService;
import com.edumaster.co.interfaces.IRegistro;
import com.edumaster.co.modelo.Registro;

@Service
public class RegistroService implements IRegistroService{
	@Autowired
	private IRegistro data;
	
	@Override
	public List<Registro> listarRegistro() {
		return (List<Registro>) data.findAll();
	}

	@Override
	public Optional<Registro> listarIdRegistro(BigInteger Id_usuario, Integer Id_capacitacion) {
		return data.findById(Id_usuario,Id_capacitacion);
	}

	@Override
	public int saveRegistro(Registro p) {
		int res=0;
		Registro Registro = data.save(p);
		if(!Registro.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deleteRegistro(BigInteger Id_usuario, Integer Id_capacitacion) {
		data.deleteById(Id_usuario,Id_capacitacion);
	}
}*/
