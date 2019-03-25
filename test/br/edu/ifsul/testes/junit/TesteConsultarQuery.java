/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Acessorios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author guilherme
 */
public class TesteConsultarQuery {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteConsultarQuery() {
    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("Locadora-Veiculos-ModelPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void teste() {

        //mostrar a consulta sem o parametro
        //instrução HQL (referencia as classes e os seus respectivos atributos)
        Query consulta = em.createQuery("from Acessorios where nome like 'm%'");
        List<Acessorios> lista = consulta.getResultList();
        for (Acessorios a : lista) {
            System.out.println("ID: " + a.getId() + " Nome: " + a.getNome());
        }
    }

}
