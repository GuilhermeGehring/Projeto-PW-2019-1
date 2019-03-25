/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilherme
 */
@Entity
@Table(name = "locacao")
public class Locacao implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_locacao", sequenceName = "seq_id_locacao",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_locacao", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de locação não pode ser nula")
    @Column(name = "data_locacao", nullable = true)
    private Calendar dataLocacao;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data de devolução não pode ser nula")
    @Column(name = "data_devolucao", nullable = true)
    private Calendar dataDevolucao;

    @Min(message = "O valor da diária não pode ser negativo", value = 0)
    @NotNull(message = "O valor da diário não pode ser nulo")
    @Column(name = "valor_diaria", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorDiaria;

    @Min(message = "A quilometragem inicial não pode ser negativa", value = 0)
    @NotNull(message = "A quilometragem inicial não pode ser nula")
    @Column(name = "km_inicial", nullable = false)
    private Integer kmInicial;

    @Min(message = "A quilometragem final não pode ser negativa", value = 0)
    @NotNull(message = "A quilometragem final não pode ser nula")
    @Column(name = "km_inicial", nullable = false)
    private Integer kmFinal;

    @Min(message = "O valor total não pode ser negativo", value = 0)
    @NotNull(message = "O valor total não pode ser nulo")
    @Column(name = "valor_total", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorTotal;

    @OneToMany(mappedBy = "locacao", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Adicional> adicional; //composição, ou seja, adicional não vive sem a locação. Adicional por sua vez, referencia Locação. É bidirecional

    public Locacao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(Calendar dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Integer getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(Integer kmInicial) {
        this.kmInicial = kmInicial;
    }

    public Integer getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Integer kmFinal) {
        this.kmFinal = kmFinal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Locacao other = (Locacao) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
