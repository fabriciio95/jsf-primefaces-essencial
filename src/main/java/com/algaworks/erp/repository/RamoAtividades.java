package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.algaworks.erp.model.RamoAtividade;

public class RamoAtividades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	public RamoAtividades() {}
	
	public RamoAtividades(EntityManager em) {
		this.em = em;
	}
	
	public List<RamoAtividade> pesquisar(String descricao) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		
		CriteriaQuery<RamoAtividade> query = builder.createQuery(RamoAtividade.class);
		
		Root<RamoAtividade> root = query.from(RamoAtividade.class);
		
		query.select(root);
		
		query.where(builder.like(root.get("descricao"), descricao + "%"));
		
		return em.createQuery(query).getResultList();
	}
}
