package com.ceiba.consultanomina.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoConsultanomina {
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private Long analistaid;
    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
    private LocalDateTime fecha;
}
