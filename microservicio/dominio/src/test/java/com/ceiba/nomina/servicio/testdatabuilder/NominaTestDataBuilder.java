package com.ceiba.nomina.servicio.testdatabuilder;

import com.ceiba.nomina.modelo.entidad.Nomina;

import java.time.LocalDateTime;

public class NominaTestDataBuilder {

    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
    private LocalDateTime fecha;

    public NominaTestDataBuilder() {
        documentoempleado = "25246871";
        periodo = "202001";
        valor = 1000000D;
        companiaid = 1L;
        fecha = LocalDateTime.now();
    }

    public NominaTestDataBuilder conDocumentoempleado(String documentoempleado) {
        this.documentoempleado = documentoempleado;
        return this;
    }

    public NominaTestDataBuilder conPeriodo(String documentoempleado) {
        this.periodo = documentoempleado;
        return this;
    }

    public NominaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public NominaTestDataBuilder conCompaniaid(Long companiaid) {
        this.companiaid = companiaid;
        return this;
    }

    public NominaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Nomina build() {
        return new Nomina(id, documentoempleado, periodo, valor, companiaid, fecha);
    }
}
