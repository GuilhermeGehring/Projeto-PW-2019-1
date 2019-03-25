/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author 20171pf.cc0178
 */
@Entity
@Table(name = "acessorios")
@NamedQuery(name = "todosAcessoriosOrdemNome", query = "from Acessorios where nome = :nome order by nome asc")
public class Acessorios {

    @Id
    @SequenceGenerator(name = "seq_acessorio", sequenceName = "seq_acessorio_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_acessorio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "grupo",
            joinColumns
            = @JoinColumn(name = "acessorio", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "grupo", referencedColumnName = "id", nullable = false)
    )
    private Set<Grupo> grupo; //associação bidirecional

    public Acessorios() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Acessorios other = (Acessorios) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Set<Grupo> getGrupo() {
        return grupo;
    }

    public void setGrupo(Set<Grupo> grupo) {
        this.grupo = grupo;
    }

}
