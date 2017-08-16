package br.ucdb.service;

import br.ucdb.model.Perfil;
import br.ucdb.model.Usuario;
import br.ucdb.repository.PerfilRepository;
import br.ucdb.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Virmerson on 07/08/2017.
 */
@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    public Usuario salvar(Usuario usuario) throws ServiceException {


        String nomeRegistrado="";
        String nomeNovo =  usuario.getNome();

        if (usuario.getId()!=null) {
            Usuario usuRegistrado = usuarioRepository.findOne(usuario.getId());
             nomeRegistrado = usuRegistrado.getNome();

        }

        if (!nomeRegistrado.equals(nomeNovo)){

            List<Usuario> usuarioList = usuarioRepository.findByNome(usuario.getNome());
            if (usuarioList != null && usuarioList.size() > 0) {
                throw new ServiceException("Usuario Já Existente");
            }

        }


        Perfil perfil = perfilRepository.findOne(usuario.getPerfil().getId());
        usuario.setPerfil(perfil);

        return usuarioRepository.save(usuario);
    }


    public List<Usuario> buscarPorNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }

    public List<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> buscarPorNomeOuEmail(String nome, String email) {
        return usuarioRepository.findByNomeAndEmailAllIgnoreCase(nome,email);
    }

    public void excluir(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> buscarTodosPorPerfilId(Integer perfilId) {
       return  usuarioRepository.findByPerfilId(perfilId);
    }
}
