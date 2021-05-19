package com.ceiba.compania.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCompania {
    private Long id;
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private LocalDateTime fechaCreacion;
}
