package com.onecar.api.Controller;

import com.onecar.api.Entity.Usuario;
import com.onecar.api.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/login")
    public Usuario logarSistema(@RequestBody  Usuario usuario){
       return  service.buscarLogin(usuario);
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody  Usuario usuario){
        return  service.cadastrarUsuario(usuario);
    }

    @GetMapping
    public List<Usuario> listarTodos(){
        return service.buscarTodos();
    }

}
