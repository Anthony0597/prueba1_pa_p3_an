package com.example.demo.correccion.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.correccion.repo.ICuentaRepo;
import com.example.demo.correccion.repo.ITransferenciaCRepo;
import com.example.demo.correcion.modelo.Cuenta;
import com.example.demo.correcion.modelo.TransferenciaC;

@Service
public class TransferenciaCServiceImpl implements ITransferenciaCService {

	@Autowired
	private ICuentaRepo cuentaRepo;
	@Autowired
	private ITransferenciaCRepo transferenciaCRepo;
	@Override
	public void realizar(String numeroOrigen, String numeroDestino, BigDecimal monto) {
		// ORIGEN
		Cuenta origen = this.cuentaRepo.buscar(numeroOrigen);
		BigDecimal comision = monto.multiply(new BigDecimal(0.05));
		BigDecimal montoDebitar = monto.add(comision);
				
		BigDecimal saldoActual = origen.getSaldo();		
		
		
		if(saldoActual.compareTo(montoDebitar) >= 0) {
			System.out.println("Monto no permitido");
		}else {
			origen.setSaldo(saldoActual.subtract(montoDebitar));
			this.cuentaRepo.actualizar(origen);
			//DESTINO
			Cuenta destino = this.cuentaRepo.buscar(numeroDestino);
			BigDecimal saldoActualD = destino.getSaldo();
			origen.setSaldo(saldoActualD.add(monto));
			this.cuentaRepo.actualizar(destino);
			
			//TRANSFERENCIA
			
			TransferenciaC transfer = new TransferenciaC();
			transfer.setFechaTransferencia(LocalDateTime.now());
			transfer.setCuentaDestino(numeroDestino);
			transfer.setCuentaOrigen(numeroOrigen);
			transfer.setMonto(monto);
			transfer.setComision(comision);
			
			this.transferenciaCRepo.insertar(transfer);
			
		}
		
	}

}
