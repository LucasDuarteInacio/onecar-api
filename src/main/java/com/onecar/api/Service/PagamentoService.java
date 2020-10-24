package com.onecar.api.Service;

import com.onecar.api.Entity.Pagamento;
import com.onecar.api.Entity.Vaga;
import com.onecar.api.Repository.PagamentoRepository;
import com.onecar.api.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {


    @Autowired
    private PagamentoRepository repository;


    public Pagamento buscarPorId(Integer idPagamento) {
        return repository.findById(idPagamento).get();
    }

    public List<Pagamento> buscarTodos() {
        return repository.findAll();
    }

    public Pagamento cadastrarPagamento(Pagamento pagamento) {
        return repository.save(pagamento);
    }


}
