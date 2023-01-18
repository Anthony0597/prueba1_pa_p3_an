package com.example.demo.correcion.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuenta_bancaria")
public class Cuenta {
	
	@Id
	@Column(name = "cuen_numero")
	private String numero;
	@Column(name = "cuen_tipo")
	private String tipo;
	@Column(name = "cuen_saldo")
	private BigDecimal saldo;
	@Column(name = "cuen_cedula_propietario")
	private String cedulaPropietario;
	
	//GET Y SET
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public String getCedulaPropietario() {
		return cedulaPropietario;
	}
	public void setCedulaPropietario(String cedulaPropietario) {
		this.cedulaPropietario = cedulaPropietario;
	}
	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", tipo=" + tipo + ", saldo=" + saldo + ", cedulaPropietario="
				+ cedulaPropietario + "]";
	}
	
	
}
