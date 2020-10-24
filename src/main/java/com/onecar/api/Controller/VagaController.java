package com.onecar.api.Controller;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Vaga;
import com.onecar.api.Service.ClienteService;
import com.onecar.api.Service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/vaga")
public class VagaController {

    @Autowired
    private VagaService service;

    @GetMapping
    public List<Vaga> listarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public Vaga novaVaga(@RequestBody Vaga vaga) {
        return service.cadastrarVaga(vaga);
    }

    @GetMapping("/id")
    public Vaga BuscarVagaId(@PathVariable("id") Integer idVaga) {
        return service.buscarPorId(idVaga);
    }

}
