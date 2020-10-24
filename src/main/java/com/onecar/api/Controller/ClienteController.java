package com.onecar.api.Controller;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Usuario;
import com.onecar.api.Entity.Veiculo;
import com.onecar.api.Service.ClienteService;
import com.onecar.api.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<Cliente> listarTodos(){
        return service.buscarTodos();
    }

    @PostMapping
    public Cliente novoCliente(@RequestBody Cliente cliente){
        return service.cadastrarCliente(cliente);
    }

}
