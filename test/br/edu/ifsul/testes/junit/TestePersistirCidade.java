/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author guilherme
 */
public class TestePersistirCidade {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCidade() {
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
        Cidade c = new Cidade();
        c.setNome("Ibirapuitã");
        c.setEstado("Rio Grande do Sul");
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
