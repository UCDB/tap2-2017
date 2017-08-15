package br.ucdb.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by Virmerson Bento dos Santos on 7/24/17.
 */

@Entity
@Data
public class Usuario {
    @Id
    @SequenceGenerator(name ="seq_usu" , sequenceName = "seq_usu")
    @GeneratedValue(generator = "seq_usu")

    private Integer id;

    private String nome;

    private String email;

    private String senha;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn
    private Perfil perfil;

}
