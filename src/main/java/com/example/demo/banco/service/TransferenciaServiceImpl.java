package com.example.demo.banco.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.modelo.Transferencia;
import com.example.demo.banco.repo.ITransferenciaRepo;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{
	@Autowired
	private ICuentaBancariaService bancariaService;
	@Autowired
	private ITransferenciaRepo transferenciaRepo;
	
	@Override
	public void generar(String cuentaOrigen, String cuentaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		Transferencia transferencia = new Transferencia();		
		
		BigDecimal montoTotal;
		
		CuentaBancaria cuentaO = new CuentaBancaria();
		cuentaO = this.bancariaService.buscar(cuentaOrigen);
		
		CuentaBancaria cuentaD = new CuentaBancaria();
		cuentaD = this.bancariaService.buscar(cuentaDestino);
		
		montoTotal=monto.add(calcularComision(monto));
		
		
		if(validarMonto(cuentaO.getSaldo(), montoTotal)) {
			cuentaO.setSaldo(cuentaO.getSaldo().subtract(montoTotal));
			cuentaD.setSaldo(cuentaD.getSaldo().add(monto));
			
			transferencia.setComision(calcularComision(monto));
			transferencia.setCuentaOrigen(cuentaOrigen);
			transferencia.setCuentaDestino(cuentaDestino);
			transferencia.setFechaTransferencia(LocalDateTime.now());
			transferencia.setMonto(monto);
			
			this.bancariaService.actualizar(cuentaO);
			this.bancariaService.actualizar(cuentaD);
			this.transferenciaRepo.insertar(transferencia);
			System.out.println("La transferencia se ha realizado con éxito");
			System.out.println(transferencia);
		}else {
			System.out.println("No se puedo realizar la transferencia por falta de fondos en la cuenta de origen");
		}
	}
	
	private boolean validarMonto(BigDecimal saldo, BigDecimal monto) {
		boolean res=true;
		if(saldo.subtract(monto).compareTo(new BigDecimal(0)) == -1) {
			res=false;
		}		
		return res;
	}
	
	private BigDecimal calcularComision(BigDecimal monto) {
		return monto.multiply(new BigDecimal(0.05));
	}
}
