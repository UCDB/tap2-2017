package br.ucdb.controller;


import br.ucdb.service.ServiceException;
import br.ucdb.model.Usuario;
import br.ucdb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Virmerson Bento dos Santos on 7/24/17.
 */

@CrossOrigin(origins = "*")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    @PostMapping("/usuarios")
    public Usuario cadastrar(@RequestBody Usuario usuario) throws ServiceException {
        try {
            return usuarioService.salvar(usuario);
        }catch (ServiceException e){
            throw  e;
        }
    }

    @PutMapping("/usuarios")
    public Usuario alterar(@RequestBody Usuario usuario) throws ServiceException {
        return usuarioService.salvar(usuario);
    }



    @GetMapping("/usuarios/todos")
    public List<Usuario> buscarTodos(){
        return usuarioService.buscarTodos();
    }

    @GetMapping("/usuarios/nome")
    public List<Usuario> buscarPorNome(@RequestParam("nome") String nome){
        return usuarioService.buscarPorNome(nome);
    }

    @GetMapping("/usuarios/email")
    public List<Usuario> buscarPorEmail(@RequestParam("email") String email){
        return usuarioService.buscarPorEmail(email);
    }

    @GetMapping("/usuarios/nomeemail")
    public List<Usuario> buscarPorEmail(@RequestParam("nome") String nome, @RequestParam("email") String email){
        return usuarioService.buscarPorNomeOuEmail(nome, email);
    }

    @DeleteMapping("/usuarios")
    public void excluir (@RequestBody Usuario usuario){
        usuarioService.excluir(usuario);
    }



}
