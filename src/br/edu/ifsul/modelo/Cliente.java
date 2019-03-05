/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilherme
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@Table(name = "cliente")
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING,
        length = 2)
@DiscriminatorValue(value = "CL")
public class Cliente extends Pessoa implements Serializable {

    @NotBlank(message = "O telefone deve ser informado")
    @Length(max = 14, message = "O telefone não pode ter mais que {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;

    @NotBlank(message = "O endereço não pode ser nulo")
    @Length(max = 50, message = "O endereço deve ter no máximo {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;

    @NotBlank(message = "O CEP não pode ser nulo")
    @Length(max = 9, message = "O CEP deve ter no máximo {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;

    @NotBlank(message = "O bairro não pode ser nulo")
    @Length(max = 50, message = "O bairro deve ter no máximo {max} caracteres")
    @Column(name = "bairro", length = 50, nullable = false)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_pf_cidade"))
    private Cidade cidade;

    public Cliente() {
        super();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
