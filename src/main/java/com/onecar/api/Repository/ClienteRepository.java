package com.onecar.api.Repository;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer > {



}
