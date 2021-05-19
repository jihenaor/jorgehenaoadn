package com.ceiba.compania.servicio.testdatabuilder;

import com.ceiba.compania.comando.ComandoCompania;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoCompaniaTestDataBuilder {

    private Long id;
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private LocalDateTime fecha;

    public ComandoCompaniaTestDataBuilder() {
        tipodocumento = "NI";
        numerodocumento = "816609801";
//        razonsocial = UUID.randomUUID().toString();
        razonsocial = "SERVICIUDAD";
        fecha = LocalDateTime.now();
    }

    public ComandoCompaniaTestDataBuilder conRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
        return this;
    }

    public ComandoCompania build() {
        return new ComandoCompania(id, tipodocumento, numerodocumento, razonsocial, fecha);
    }
}
