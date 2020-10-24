package com.onecar.api.Controller;

import com.onecar.api.Entity.Recibo;
import com.onecar.api.Entity.Vaga;
import com.onecar.api.Service.ReciboService;
import com.onecar.api.Service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/recibo")
public class ReciboController {

    @Autowired
    private ReciboService service;

    @GetMapping
    public List<Recibo> listarTodos() {
        return service.buscarTodos();
    }

    @PostMapping
    public Recibo novoRecibo(@RequestBody Recibo recibo) {
        return service.cadastrarRecibo(recibo);
    }

    @GetMapping("/ativo")
    public List<Recibo> buscarAtivos(){
        return service.BuscarAtivos();
    }

    @PostMapping("/pagamento")
    public Recibo pagamentoRecibo(@RequestBody Recibo recibo) {
        return service.realizarPagamento(recibo);
    }

}
