package com.ceiba.consultanomina.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoConsultanomina {
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private Long analistaid;
    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
}
