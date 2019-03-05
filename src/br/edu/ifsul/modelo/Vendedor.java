/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "vendedor")
@DiscriminatorValue(value = "VE")
public class Vendedor extends Pessoa implements Serializable {

    @NotBlank(message = "O nome de usuário deve ser informado")
    @Length(max = 20, message = "O usuário não pode ter mais que {max} caracteres")
    @Column(name = "nome_usuario", length = 20, nullable = false)
    private String nomeUsuario;

    @NotBlank(message = "A senha deve ser informada")
    @Length(max = 20, message = "A senha não pode ter mais que {max} caracteres")
    @Column(name = "senha", length = 20, nullable = false)
    private String senha;

    private boolean ativo;

    public Vendedor() {
        super();
        this.ativo = true;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
