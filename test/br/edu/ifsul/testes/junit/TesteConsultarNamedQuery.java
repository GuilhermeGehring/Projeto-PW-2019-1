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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author guilherme
 */
public class TesteConsultarNamedQuery {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteConsultarNamedQuery() {
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
        List<Acessorios> a = em.createNamedQuery("todosAcessoriosOrdemNome")
                .setParameter("nome", "motor").getResultList();

        if (a != null) {
            System.out.println("Nome: " + a.get(0).getNome());
        } else {
            System.out.println("Não encontrou");
        }

    }
}
