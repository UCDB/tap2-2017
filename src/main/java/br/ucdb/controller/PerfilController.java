package br.ucdb.controller;

import br.ucdb.model.Perfil;

import br.ucdb.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rf3020 on 15/08/2017.
 */
@CrossOrigin(origins = "*")
@RestController
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/usuarios/perfil")
    public List<Perfil> buscarTodos(){
        return perfilService.buscarTodos();
    }
}
