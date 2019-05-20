/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_carro", sequenceName = "seq_id_carro",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_carro", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "A placa não pode ser nula")
    @NotBlank(message = "A placa não pode ser em branco")
    @Length(max = 8, message = "A placa não pode ter mais que {max} caracteres")
    @Column(name = "placa", nullable = false, length = 8)
    private String placa;
    
    @Min(message = "O ano de fabricação não pode ser negativo", value = 0)
    @NotNull(message = "O ano de fabricação não pode ser nulo")
    @Column(name = "anoFabricacao", nullable = false, columnDefinition = "integer")
    private Integer anoFabricacao;
    
    @Min(message = "O ano do modelo não pode ser negativo", value = 0)
    @NotNull(message = "O ano do modelo não pode ser nulo")
    @Column(name = "anoModelo", nullable = false, columnDefinition = "integer")
    private Integer anoModelo;
    
    @NotNull(message = "A versão não pode ser nula")
    @NotBlank(message = "A versão não pode ser em branco")
    @Length(max = 50, message = "A versão não pode ter mais que {max} caracteres")
    @Column(name = "versao", nullable = false, length = 8)
    private String versao;
    
    @NotNull(message = "O modelo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "modelo", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_carro_modelo"))
    private Modelo modelo;

    public Carro() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
