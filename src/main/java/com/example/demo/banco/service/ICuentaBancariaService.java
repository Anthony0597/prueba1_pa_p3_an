package com.example.demo.banco.service;

import com.example.demo.banco.modelo.CuentaBancaria;

public interface ICuentaBancariaService {
	public void crear(CuentaBancaria cuenta);
	public void actualizar(CuentaBancaria cuenta);
	public CuentaBancaria buscar(String numero);
	public void borrar(String numero);
}
