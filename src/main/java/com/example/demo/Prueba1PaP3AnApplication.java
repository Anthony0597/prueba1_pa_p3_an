package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.banco.modelo.CuentaBancaria;
import com.example.demo.banco.service.ICuentaBancariaService;
import com.example.demo.banco.service.ITransferenciaService;

@SpringBootApplication
public class Prueba1PaP3AnApplication implements CommandLineRunner{
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private ITransferenciaService transferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(Prueba1PaP3AnApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		CuentaBancaria cuenta1 = new  CuentaBancaria();
		cuenta1.setCedulaPropietario("1685521645");
		cuenta1.setNumero("000001");
		cuenta1.setTipo("ahorros");
		cuenta1.setSaldo(new BigDecimal(200));		
		this.bancariaService.crear(cuenta1);
		
		CuentaBancaria cuenta2 = new  CuentaBancaria();
		cuenta2.setCedulaPropietario("1347985268");
		cuenta2.setNumero("000002");
		cuenta2.setTipo("ahorros");
		cuenta2.setSaldo(new BigDecimal(150));
		this.bancariaService.crear(cuenta2);
		
		System.out.println("Saldo de la cuenta de origen antes de la transferencia:");
		System.out.println(this.bancariaService.buscar(cuenta1.getNumero()).getSaldo());
		
		this.transferenciaService.generar(cuenta1.getNumero(), cuenta2.getNumero(), new BigDecimal(10));
		
		System.out.println("Saldo de la cuenta de origen luego de la transferencia:");
		System.out.println(this.bancariaService.buscar(cuenta1.getNumero()).getSaldo());
	}

}
