package com.example.demo.correcion.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "transferencia")
public class TransferenciaC {
	
	@Id
	@SequenceGenerator(name = "tran_seq", sequenceName = "tran_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "tran_seq")
	@Column(name = "tran_id")
	private Integer id;
	@Column(name = "tran_fecha_transferencia")
	private LocalDateTime fechaTransferencia;
	@Column(name = "tran_cuenta_origen")
	private String numeroOrigen;
	@Column(name = "tran_cuenta_destino")
	private String numeroDestino;
	@Column(name = "tran_monto")
	private BigDecimal monto;
	@Column(name = "tran_comision")
	private BigDecimal comision;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getFechaTransferencia() {
		return fechaTransferencia;
	}
	public void setFechaTransferencia(LocalDateTime fechaTransferencia) {
		this.fechaTransferencia = fechaTransferencia;
	}
	public String getCuentaOrigen() {
		return numeroOrigen;
	}
	public void setCuentaOrigen(String cuentaOrigen) {
		this.numeroOrigen = cuentaOrigen;
	}
	public String getCuentaDestino() {
		return numeroDestino;
	}
	public void setCuentaDestino(String cuentaDestino) {
		this.numeroDestino = cuentaDestino;
	}
	public BigDecimal getMonto() {
		return monto;
	}
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	public BigDecimal getComision() {
		return comision;
	}
	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}
	@Override
	public String toString() {
		return "Transferencia [id=" + id + ", fechaTransferencia=" + fechaTransferencia + ", cuentaOrigen="
				+ numeroOrigen + ", cuentaDestino=" + numeroDestino + ", monto=" + monto + ", comision=" + comision
				+ "]";
	}
	
	
}
