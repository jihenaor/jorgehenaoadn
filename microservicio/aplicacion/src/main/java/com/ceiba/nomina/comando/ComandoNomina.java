package com.ceiba.nomina.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoNomina {

    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
    private LocalDateTime fecha;
}
