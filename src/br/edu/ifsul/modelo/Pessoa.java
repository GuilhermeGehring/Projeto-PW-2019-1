/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author guilherme
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@Table(name = "pessoa")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING,
        length = 2)
@DiscriminatorValue(value = "PE")
public class Pessoa implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_id_pessoa",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF não pode ser nulo")
    @Length(max = 14, message = "O CPF deve ter {max} caracteres")
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;

    @NotBlank(message = "O RG não pode ser nulo")
    @Length(max = 10, message = "O RG deve ter no máximo {max} caracteres")
    @Column(name = "rg", length = 10, nullable = false)
    private String rg;

    public Pessoa() {
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
