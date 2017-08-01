package br.ucdb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Virmerson Bento dos Santos on 7/24/17.
 */

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios")
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return salvar(usuario);
    }

    @PutMapping("/usuarios")
    public Usuario alterar(@RequestBody Usuario usuario) {
        return salvar(usuario);
    }


    private Usuario salvar(Usuario usuario) {
       return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios/todos")
    public List<Usuario> buscarTodos(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuarios/nome")
    public List<Usuario> buscarPorNome(@RequestParam("nome") String nome){
        return usuarioRepository.findByNomeIgnoreCase(nome);
    }

    @GetMapping("/usuarios/email")
    public List<Usuario> buscarPorEmail(@RequestParam("email") String email){
        return usuarioRepository.findByEmail(email);
    }

    @GetMapping("/usuarios/nomeemail")
    public List<Usuario> buscarPorEmail(@RequestParam("nome") String nome, @RequestParam("email") String email){
        return usuarioRepository.findByNomeOrEmailAllIgnoreCase(nome, email);
    }

    @DeleteMapping("/usuarios")
    public void excluir (@RequestBody Usuario usuario){
         usuarioRepository.delete(usuario);
    }



}
