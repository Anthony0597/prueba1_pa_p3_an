package com.example.demo.banco.repo;

import com.example.demo.banco.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {
	public void insertar(CuentaBancaria cuenta);
	public void actualizar(CuentaBancaria cuenta);
	public CuentaBancaria buscar(String numero);
	public void eliminar(String numero);
}
