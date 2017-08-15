package br.ucdb.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Created by Virmerson on 14/08/2017.
 */
@Entity
@Data
public class Perfil {

    @Id
    @SequenceGenerator(name ="seq_perfil" , sequenceName = "seq_perfil")
    @GeneratedValue(generator = "seq_perfil")

    private Integer id;

    private String descricao;

}
