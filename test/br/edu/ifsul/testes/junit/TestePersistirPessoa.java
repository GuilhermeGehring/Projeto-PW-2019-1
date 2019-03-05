/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author guilherme
 */
public class TestePersistirPessoa {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirPessoa() {
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
        Pessoa obj = new Pessoa();
        obj.setNome("Guilherme Gehring");
        obj.setCpf("890.003.830-30");
        obj.setRg("482171017");

        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }

}
