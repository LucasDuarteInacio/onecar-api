package com.onecar.api.Service;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repository;

    public Cliente buscarPorId(Integer idCliente){
        return repository.findById(idCliente).get();
    }

    public List<Cliente> buscarTodos(){
        return repository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return repository.save(cliente);
    }


}
