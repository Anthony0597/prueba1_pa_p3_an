package com.example.demo.correccion.service;

import java.math.BigDecimal;

public interface ITransferenciaCService {
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto);
}
