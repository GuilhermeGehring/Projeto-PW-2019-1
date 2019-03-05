/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Cliente;
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
public class TestePersistirCliente {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirCliente() {
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
        Cliente obj = new Cliente();
        obj.setNome("Joe Montana");
        obj.setCpf("351.034.660-23");
        obj.setRg("468676764");
        obj.setTelefone("(54)99233-4587");
        obj.setEndereco("Av.Brasil");
        obj.setCep("99150-000");
        obj.setBairro("Centro");
        obj.setCidade(em.find(Cidade.class, 1));
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
    }
}
