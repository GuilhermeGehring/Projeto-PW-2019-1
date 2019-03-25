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

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "adicional")
public class Adicional implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_adicional", sequenceName = "seq_id_adicional",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_adicional", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Min(message = "O valor não pode ser negativo", value = 0)
    @NotNull(message = "O valor não pode ser nulo")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valor;

    @NotNull(message = "O tipo de adicional deve ser informado")
    @ManyToOne
    @JoinColumn(name = "tipo_adicional", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_adicional_tipo_adicional"))
    private TipoAdicional tipoAdicional;

    public Adicional() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public TipoAdicional getTipoAdicional() {
        return tipoAdicional;
    }

    public void setTipoAdicional(TipoAdicional tipoAdicional) {
        this.tipoAdicional = tipoAdicional;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Adicional other = (Adicional) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
