/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "grupo")
public class Grupo implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_grupo", sequenceName = "seq_id_grupo",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_grupo", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Min(message = "O valor da diária não pode ser negativo", value = 0)
    @NotNull(message = "O valor da diária não pode ser nulo")
    @Column(name = "valor_diaria", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorDiaria;

}
