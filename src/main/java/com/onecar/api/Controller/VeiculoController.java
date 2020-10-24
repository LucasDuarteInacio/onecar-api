package com.onecar.api.Controller;

import com.onecar.api.Entity.Usuario;
import com.onecar.api.Entity.Veiculo;
import com.onecar.api.Service.UsuarioService;
import com.onecar.api.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping
    public List<Veiculo> listarTodos() {
        return service.buscarTodos();
    }

    @GetMapping(value = "cliente/{idCliente}")
    public List<Veiculo> listarporCliente(@PathVariable("idCliente") Integer idCliente) {
        return service.buscarPorCliente(idCliente);
    }

    @PostMapping
    public Veiculo addVeiculo(@RequestBody Veiculo veiculo) {
        return service.cadastrarVeiculo(veiculo);
    }


}
