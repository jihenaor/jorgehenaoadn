package com.ceiba.nomina.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoNomina {
    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
    private LocalDateTime fechaCreacion;

}
