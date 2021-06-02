package com.ceiba.consultanomina.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Consultanomina {
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private Long analistaid;
    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
    private LocalDateTime fechaCreacion;

    public Consultanomina(
            String tipodocumento,
            String numerodocumento,
            String razonsocial,
            Long analistaid,
            Long id, String documentoempleado,
                          String periodo, Double valor,
                          Long companiaid,
                          LocalDateTime fechaCreacion) {
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.razonsocial = razonsocial;
        this.analistaid = analistaid;
        this.id = id;
        this.documentoempleado = documentoempleado;
        this.periodo = periodo;
        this.valor = valor;
        this.companiaid = companiaid;
        this.fechaCreacion = fechaCreacion;
    }
}
