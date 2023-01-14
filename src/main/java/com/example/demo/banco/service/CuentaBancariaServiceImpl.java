package com.example.demo.banco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.repo.ICuentaBancariaRepo;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	private ICuentaBancariaRepo bancariaRepo;
	
	@Override
	public void crear(CuentaBancaria cuenta) {
		// TODO Auto-generated method stub
		this.bancariaRepo.insertar(cuenta);
	}

	@Override
	public void actualizar(CuentaBancaria cuenta) {
		// TODO Auto-generated method stub
		this.bancariaRepo.actualizar(cuenta);
	}

	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepo.buscar(numero);
	}

	@Override
	public void borrar(String numero) {
		// TODO Auto-generated method stub
		this.bancariaRepo.eliminar(numero);
	}

}
