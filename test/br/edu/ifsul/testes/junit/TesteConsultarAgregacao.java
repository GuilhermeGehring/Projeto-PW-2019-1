/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.modelo.Adicional;
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
public class TesteConsultarAgregacao {

    EntityManagerFactory emf;
    EntityManager em;

    public TesteConsultarAgregacao() {
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
        //consulta que retorna a quantidade de vendas por produto
        /*Query query = em.createNativeQuery("select p.nome, count(*) from produto p, item_produto ios "
            + "where p.id = ios.produto group by p.nome");
        for (Object linha : query.getResultList()) {
            Object[] obj = (Object[]) linha;
            System.out.println("Produto: " + obj[0] + " \nQuantidade de item produtos: " + obj[1]);
        }*/

        Query q2 = em.createQuery("select a.id, ta.nome from Adicional a, TipoAdicional ta "
                + "where a.tipo_adicional = ta.id");
        for (Object linha : q2.getResultList()) {
            Object[] obj = (Object[]) linha;
            System.out.println("\n\nAdicional: " + obj[0] + " \nTipoAdicional: " + obj[1]);
        }

        //qual é a diferença entre essas duas listagens ?
        Query q3 = em.createQuery("select a from Adicional a");
        List<Adicional> list = q3.getResultList();
        for (Adicional adicional : list) {
            System.out.println("\n\nAdicional: " + adicional.getId() + " \nTipoAdicional: " + adicional.getTipoAdicional().getNome());
        }
    }

}
