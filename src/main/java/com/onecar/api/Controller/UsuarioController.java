package com.onecar.api.Controller;

import com.onecar.api.Entity.Usuario;
import com.onecar.api.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/avatar/{id}")
    public void upload(@RequestParam MultipartFile avatar,@PathVariable("id") Integer id){
        service.salvarAvatar(avatar,id);
    }
    @GetMapping("/{id}")
    public Usuario buscarUsuario(@PathVariable("id") Integer id){
        return service.buscarPorId(id);
    }


}
