package com.example.demo.banco.repo;

import com.example.demo.banco.modelo.Transferencia;

public interface ITransferenciaRepo {
	public void insertar(Transferencia transferencia);
	public Transferencia buscar(Integer id);
}
