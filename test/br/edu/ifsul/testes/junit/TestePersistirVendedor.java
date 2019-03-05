/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Vendedor;
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
public class TestePersistirVendedor {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirVendedor() {
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
        Vendedor obj = new Vendedor();
        obj.setNome("Joel Santana");
        obj.setCpf("398.785.810-98");
        obj.setRg("424640776");
        obj.setNomeUsuario("JoelS");
        obj.setSenha("admin");
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}
