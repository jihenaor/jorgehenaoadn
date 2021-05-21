package com.ceiba.compania.servicio.testdatabuilder;

import com.ceiba.compania.comando.ComandoCompania;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoCompaniaTestDataBuilder {

    private Long id;
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private Long analistaid;
    private LocalDateTime fecha;

    public ComandoCompaniaTestDataBuilder() {
        tipodocumento = "NI";
        numerodocumento = "816609801";
//        razonsocial = UUID.randomUUID().toString();
        analistaid = null;
        razonsocial = "SERVICIUDAD";
        fecha = LocalDateTime.now();
    }

    public ComandoCompaniaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoCompaniaTestDataBuilder conNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
        return this;
    }

    public ComandoCompaniaTestDataBuilder conAnalistaid(Long analistaid) {
        this.analistaid = analistaid;
        return this;
    }

    public ComandoCompania build() {
        return new ComandoCompania(id, tipodocumento, numerodocumento, razonsocial, analistaid, fecha);
    }
}
