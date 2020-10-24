package com.onecar.api.Repository;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Vaga;
import com.onecar.api.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Integer > {


}
