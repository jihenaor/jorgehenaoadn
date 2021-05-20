package com.ceiba.nomina.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Nomina {
    private static final String SE_DEBE_INGRESAR_EL_DOCUMENTO_DEL_EMPLEADO = "Se debe ingresar el documento del empleado";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_LA_NOMINA = "Se debe ingresar el valor de la nomina";
    private static final String EL_VALOR_DE_LA_NOMINA_DEBE_SER_MAYOR_IGUAL_CERO = "El valor de la nomina debe ser mayor igual a cero";
    private static final String SE_DEBE_INGRESAR_UN_PERIODO = "Se debe ingresar un periodo";
    private static final String EL_PERIODO_DEBE_TERNER_UNA_LONGITUD_6 = "El periodo debe tener una longitud de 6 digitos";
    private static final String EL_IDCOMPANIA_ES_REQUERIDO = "Se debe ingresar el identificador de la compañia";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";

    private static final int LONGITUD_PERIODO = 6;

    private Long id;
    private String documentoempleado;
    private String periodo;
    private Double valor;
    private Long companiaid;
    private LocalDateTime fechaCreacion;

    public Nomina(Long id, String documentoempleado,
                  String periodo, Double valor,
                  Long companiaid,
                  LocalDateTime fechaCreacion) {
        validarObligatorio(documentoempleado, SE_DEBE_INGRESAR_EL_DOCUMENTO_DEL_EMPLEADO);
        validarObligatorio(periodo, SE_DEBE_INGRESAR_UN_PERIODO);
        validarLongitudIgual(periodo, LONGITUD_PERIODO, String.format(EL_PERIODO_DEBE_TERNER_UNA_LONGITUD_6, LONGITUD_PERIODO));
        validarObligatorio(valor, SE_DEBE_INGRESAR_EL_VALOR_DE_LA_NOMINA);
        validarPositivo(valor, EL_VALOR_DE_LA_NOMINA_DEBE_SER_MAYOR_IGUAL_CERO);
        validarObligatorio(companiaid, EL_IDCOMPANIA_ES_REQUERIDO);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        this.id = id;
        this.documentoempleado = documentoempleado;
        this.periodo = periodo;
        this.valor = valor;
        this.companiaid = companiaid;
        this.fechaCreacion = fechaCreacion;

//        validarFechaCreacion();
    }
/*
    private void validarFechaCreacion() {
        if (id == null) {
            if (fechaCreacion.getDayOfMonth() > 14) {
                throw new RuntimeException("La fecha de registro no puede ser superior al dia 14");
            }
        }
    }
*/
}
