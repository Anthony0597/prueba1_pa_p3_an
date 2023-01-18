package com.example.demo.correccion.repo;

import org.springframework.stereotype.Repository;

import com.example.demo.correcion.modelo.TransferenciaC;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class TransferenciaCRepoImpl implements ITransferenciaCRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(TransferenciaC transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}

}
