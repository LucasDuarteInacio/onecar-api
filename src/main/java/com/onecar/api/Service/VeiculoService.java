package com.onecar.api.Service;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Veiculo;
import com.onecar.api.Repository.ClienteRepository;
import com.onecar.api.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {


    @Autowired
    private VeiculoRepository repository;

    @Autowired
    private ClienteService clienteService;

    public Veiculo buscarPorId(Integer idVeiculo){
        return repository.findById(idVeiculo).get();
    }

    public List<Veiculo> buscarTodos(){
        return repository.findAll();
    }

   public Veiculo cadastrarVeiculo(Veiculo veiculo){
        Cliente cliente = clienteService.buscarPorId(veiculo.getCliente().getId());
        veiculo.setCliente(cliente);
        return repository.save(veiculo);
   }

   public List<Veiculo> buscarPorCliente(Integer idCliente){
       Cliente cliente = clienteService.buscarPorId(idCliente);
      return  repository.findAllByCliente(cliente);

   }


}
