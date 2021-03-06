package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.erp.model.Empresa;

public class Empresas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
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
		return em.createQuery("from Empresa where razaoSocial like :razaoSocial", Empresa.class)
				.setParameter("razaoSocial", nome  + "%")
				.getResultList();
	}
	
	public List<Empresa> todas(){
		return em.createQuery("from Empresa", Empresa.class).getResultList();
	}
	
	public Empresa guardar(Empresa empresa) {
		return em.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		em.remove(empresa);
	}
	
}
