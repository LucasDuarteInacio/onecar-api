package com.onecar.api.Controller;

import com.onecar.api.Entity.Pagamento;
import com.onecar.api.Entity.Vaga;
import com.onecar.api.Service.PagamentoService;
import com.onecar.api.Service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @GetMapping
    public List<Pagamento> listarTodos(){
        return service.buscarTodos();
    }

    @PostMapping
    public Pagamento novoPagamento(@RequestBody Pagamento pagamento){
        return service.cadastrarPagamento(pagamento);
    }

}
