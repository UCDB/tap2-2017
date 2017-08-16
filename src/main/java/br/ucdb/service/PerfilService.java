package br.ucdb.service;

import br.ucdb.model.Perfil;
import br.ucdb.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rf3020 on 15/08/2017.
 */
@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public List<Perfil> buscarTodos() {
        return perfilRepository.findAll();
    }


}
