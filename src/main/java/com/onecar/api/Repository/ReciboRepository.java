package com.onecar.api.Repository;

import com.onecar.api.Entity.Cliente;
import com.onecar.api.Entity.Recibo;
import com.onecar.api.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Integer> {


    List<Recibo> findByStatus(Boolean status);
}
