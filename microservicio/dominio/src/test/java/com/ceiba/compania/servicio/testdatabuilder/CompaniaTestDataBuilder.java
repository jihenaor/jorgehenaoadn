package com.ceiba.compania.servicio.testdatabuilder;

import com.ceiba.compania.modelo.entidad.Compania;

import java.time.LocalDateTime;

public class CompaniaTestDataBuilder {

    private Long id;
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private Long analistaid;
    private LocalDateTime fecha;

    public CompaniaTestDataBuilder() {
        tipodocumento = "NI";
        numerodocumento = "800001001";
        razonsocial = "COMPAÑIA 1";
        fecha = LocalDateTime.now();
    }

    public CompaniaTestDataBuilder conTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
        return this;
    }

    public CompaniaTestDataBuilder conNumerodocumento(String numerodocumento) {
        this.numerodocumento = numerodocumento;
        return this;
    }

    public CompaniaTestDataBuilder conRazonSocial(String razonsocial) {
        this.razonsocial = razonsocial;
        return this;
    }

    public CompaniaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CompaniaTestDataBuilder conAnalistaid(Long analistaid) {
        this.analistaid = analistaid;
        return this;
    }

    public Compania build() {
        return new Compania(id,tipodocumento, numerodocumento, razonsocial, analistaid, fecha);
    }
}
