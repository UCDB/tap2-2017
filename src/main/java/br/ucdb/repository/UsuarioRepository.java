package br.ucdb.repository;

import br.ucdb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

    @Query("select new Usuario(u.id,u.nome, u.email) from Usuario u where u.perfil.id=?1")
    List<Usuario> findByPerfilId(Integer id);


}
