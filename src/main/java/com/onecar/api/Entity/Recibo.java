package com.onecar.api.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String entrada;
    private String saida;

    private Boolean status;

    @OneToOne
    private Vaga vaga;

    @OneToOne
    private Pagamento pagamento;

    @OneToOne
    private Veiculo veiculo;
}
