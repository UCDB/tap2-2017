package br.ucdb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Virmerson Bento dos Santos on 7/24/17.
 */

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String email;
}
