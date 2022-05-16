package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.algaworks.erp.model.Empresa;

public class Empresas implements Serializable {
	private static final long serialVersionUID = 1L;

	private EntityManager em;
	
	public Empresas() {
	}
	
	public Empresas(EntityManager em) {
		this.em = em;
	}
	
	public Empresa porId(Long id) {
		return em.find(Empresa.class, id);
	}
	
	public List<Empresa> pesquisar(String nome){
		return em.createQuery("from Empresa where nomeFantasia like :nome", Empresa.class)
				.setParameter("nome", nome  + "%")
				.getResultList();
	}
	
	public Empresa guardar(Empresa empresa) {
		return em.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		em.remove(empresa);
	}
	
}
