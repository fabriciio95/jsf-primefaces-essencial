package com.algaworks.erp.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
//@RequestScoped//Ciclo de vida: Instancia criada quando requisição é criada e encerrada quando requisição é encerrada
//@ViewScoped//Ciclo de vida: Instancia criada quando é carregada a página (View) e termina quando a sessão termina ou alguma outra navegação dentro de um componente
//@SessionScoped//Ciclo de vida: Instancia criada quando a sessão é criada, e é encerrada quando a sessão é encerrada
@ApplicationScoped//Ciclo de vida: Instancia é criada quando a aplicação sobe, e permanece por toda a aplicação
public class GestaoEmpresasBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private static Integer NUMERO = 0;
    
    public GestaoEmpresasBean() {
        NUMERO++;
    }
    
    public Integer getNumero() {
        return NUMERO;
    }
}
