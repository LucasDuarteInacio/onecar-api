package com.onecar.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String placa;
    private String modelo;
    private String cor;
    private String tipo;


    @OneToOne
    private Cliente cliente;

    @JsonIgnore
    @OneToOne
    private Recibo recibo;

}
