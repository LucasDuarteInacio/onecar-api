package com.onecar.api.Service;

import com.onecar.api.Entity.Usuario;
import com.onecar.api.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;

    public Usuario buscarPorId(Integer idUsuario){
        return repository.findById(idUsuario).get();
    }

    public List<Usuario> buscarTodos(){
        return repository.findAll();
    }


    public Usuario buscarLogin(Usuario usuario){
        Optional<Usuario> user = repository.findLoginAndSenha(usuario.getLogin(),usuario.getSenha());
        if(!user.isPresent()){
            throw new RuntimeException("Credenciais nao encontradas");
        }
        return user.get();
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        Optional<Usuario> cpf = repository.findByCpf(usuario.getCpf());
        if(cpf.isPresent()){
            throw new RuntimeException("Ja existe Usuario com esse cpf");
        }
        return repository.save(usuario);
    }


}
