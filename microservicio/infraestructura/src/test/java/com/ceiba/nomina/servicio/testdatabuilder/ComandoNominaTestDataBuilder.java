package com.ceiba.nomina.servicio.testdatabuilder;

import com.ceiba.nomina.comando.ComandoNomina;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoNominaTestDataBuilder {

    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
    private LocalDateTime fecha;

    public ComandoNominaTestDataBuilder() {
        documentoempleado = "25246871";
        periodo = "202001";
        valor = 1000000D;
        companiaid = 1L;
        fecha = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), 1, 0, 0, 0, 0);
    }

    public ComandoNominaTestDataBuilder conValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ComandoNomina build() {
        return new ComandoNomina(id, documentoempleado, periodo, valor, companiaid, fecha);
    }
}
