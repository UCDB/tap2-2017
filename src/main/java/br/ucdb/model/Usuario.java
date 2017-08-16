package br.ucdb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Virmerson Bento dos Santos on 7/24/17.
 */

@Entity
@Data
//@NamedQuery(name = "Usuario.findByPerfilId",query="select new Usuario(u.id,u.nome, u.email) from Usuario u where u.perfil.id=?1")
public class Usuario {
    @Id
    @SequenceGenerator(name ="seq_usu" , sequenceName = "seq_usu")
    @GeneratedValue(generator = "seq_usu")

    private Integer id;

    private String nome;

    private String email;
    @JsonIgnore
    private String senha;

   // @JsonIgnore
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn
    private Perfil perfil;

    public Usuario(){

    }
    public Usuario(Integer id, String nome, String email){
        this.id= id;
        this.nome= nome;
        this.email= email;
    }

}
