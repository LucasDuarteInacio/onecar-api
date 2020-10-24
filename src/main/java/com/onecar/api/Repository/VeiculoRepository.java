package com.onecar.api.Repository;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Usuario;
import com.onecar.api.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Integer > {


    List<Veiculo> findAllByCliente(Cliente cliente);
}
