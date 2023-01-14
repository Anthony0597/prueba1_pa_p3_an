package com.example.demo.banco.service;

import java.math.BigDecimal;

public interface ITransferenciaService {
	public void generar(String cuentaOrigen, String cuentaDestino, BigDecimal monto);
}
