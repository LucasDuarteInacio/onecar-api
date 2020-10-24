package com.onecar.api.Service;

import com.onecar.api.Entity.Pagamento;
import com.onecar.api.Entity.Recibo;
import com.onecar.api.Entity.Vaga;
import com.onecar.api.Entity.Veiculo;
import com.onecar.api.Repository.ReciboRepository;
import com.onecar.api.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReciboService {


    @Autowired
    private ReciboRepository repository;
    @Autowired
    private VagaService vagaService;
    @Autowired
    private PagamentoService pagamentoService;
    @Autowired
    private VeiculoService veiculoService;

    public List<Recibo> BuscarAtivos() {
        return repository.findByStatus(true);
    }

    public Recibo buscarPorId(Integer idRecibo) {
        return repository.findById(idRecibo).get();
    }

    public List<Recibo> buscarTodos() {
        return repository.findAll();
    }

    public Recibo cadastrarRecibo(Recibo recibo) {
        Vaga vaga = vagaService.buscarPorId(recibo.getVaga().getId());
        //Pagamento pagamento = pagamentoService.buscarPorId(recibo.getPagamento().getId());
        Veiculo veiculo = veiculoService.buscarPorId(recibo.getVeiculo().getId());

        vaga.setStatusOcupacao(true);
        vagaService.cadastrarVaga(vaga);

        recibo.setVaga(vaga);
        recibo.setStatus(true);
        //recibo.setPagamento(pagamento);
        recibo.setVeiculo(veiculo);

        return repository.save(recibo);
    }

    public Recibo realizarPagamento(Recibo recibo) {
        Vaga vaga = vagaService.buscarPorId(recibo.getVaga().getId());
        Veiculo veiculo = veiculoService.buscarPorId(recibo.getVeiculo().getId());


        vaga.setStatusOcupacao(false);
        vagaService.cadastrarVaga(vaga);

        recibo.setVaga(vaga);
        recibo.setStatus(false);
        recibo.setVeiculo(veiculo);

        Pagamento pagamento = recibo.getPagamento();
        pagamentoService.cadastrarPagamento(pagamento);

        return repository.save(recibo);

    }


}
