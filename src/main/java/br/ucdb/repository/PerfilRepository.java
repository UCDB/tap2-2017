package br.ucdb.repository;

import br.ucdb.model.Perfil;
import br.ucdb.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by Virmerson on 14/08/2017.
 */
public interface PerfilRepository extends JpaRepository<Perfil, Integer>  {

}
