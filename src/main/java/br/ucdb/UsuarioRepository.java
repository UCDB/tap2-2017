package br.ucdb;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Virmerson Bento dos Santos on 7/24/17.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findByNome(String nome);

    //Select * From usuarios where upper(nome) = upper(?)
    List<Usuario> findByNomeIgnoreCase(String nome);

    List<Usuario> findByEmail(String email);

    List<Usuario> findByNomeAndEmail(String nome, String email);

    List<Usuario> findByNomeIgnoreCaseAndEmailIgnoreCase(String nome, String email);

    List<Usuario> findByNomeAndEmailAllIgnoreCase(String nome, String email);

    List<Usuario> findByNomeOrEmailAllIgnoreCase(String nome, String email);

}
