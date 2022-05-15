package com.algaworks.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.erp.model.Empresa;

public class SchemaGeneration {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
		
		EntityManager em = factory.createEntityManager();
		
		List<Empresa> empresas = em.createQuery("from Empresa", Empresa.class)
				.getResultList();
		
		System.out.println(empresas);
		
		em.close();
		factory.close();
	}
}
