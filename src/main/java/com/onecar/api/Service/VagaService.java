package com.onecar.api.Service;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Vaga;
import com.onecar.api.Entity.Veiculo;
import com.onecar.api.Repository.VagaRepository;
import com.onecar.api.Repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {


    @Autowired
    private VagaRepository repository;



    public Vaga buscarPorId(Integer idVaga){
        return repository.findById(idVaga).get();
    }

    public List<Vaga> buscarTodos(){
        return repository.findAll();
    }

   public Vaga cadastrarVaga(Vaga vaga){
        return repository.save(vaga);
   }


}
