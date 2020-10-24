package com.onecar.api.Repository;


import com.onecar.api.Entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer > {



}
