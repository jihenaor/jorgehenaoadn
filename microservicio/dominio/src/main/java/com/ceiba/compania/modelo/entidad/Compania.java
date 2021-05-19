package com.ceiba.compania.modelo.entidad;


import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;

@Getter
public class Compania {
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO = "Se debe ingresar el tipo de documento";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO = "Se debe ingresar el número de documento";
    private static final String SE_DEBE_INGRESAR_LA_RAZON_SOCIAL = "Se debe ingresar la razón social";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";

    private static final String EL_TIPO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "El tipo de documento debe tener una longitud igual a %s";

    private static final String EL_NUMERO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "El numero de documento debe tener una longitud mayor o igual a %s";
    private static final String EL_NUMERO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "El numero de documento debe tener una longitud menor o igual a %s";

    private static final String LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "La razon social debe tener una longitud mayor o igual a %s";
    private static final String LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La razon social debe tener una longitud menor o igual a %s";

    private static final int LONGITUD_TIPO_DOCUMENTO = 2;
    private static final int LONGITUD_MINIMA_NUMERO_DOCUMENTO = 3;
    private static final int LONGITUD_MAXIMA_NUMERO_DOCUMENTO = 16;

    private static final int LONGITUD_MINIMA_RAZON_SOCIAL = 2;
    private static final int LONGITUD_MAXIMA_RAZON_SOCIAL = 80;

    private Long id;
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private LocalDateTime fechaCreacion;

    public Compania(Long id, String tipodocumento, String numerodocumento, String razonsocial, LocalDateTime fechaCreacion) {
        validarObligatorio(tipodocumento, SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO);
        validarObligatorio(numerodocumento, SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO);
        validarObligatorio(razonsocial, SE_DEBE_INGRESAR_LA_RAZON_SOCIAL);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        validarLongitudIgual(tipodocumento,
                LONGITUD_TIPO_DOCUMENTO,
                String.format(EL_TIPO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_IGUAL_A, LONGITUD_TIPO_DOCUMENTO));

        validarLongitud(numerodocumento,
                LONGITUD_MINIMA_NUMERO_DOCUMENTO,
                String.format(EL_NUMERO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MINIMA_NUMERO_DOCUMENTO));
        validarLongitudMaxima(numerodocumento,
                LONGITUD_MAXIMA_NUMERO_DOCUMENTO,
                String.format(EL_NUMERO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MAXIMA_NUMERO_DOCUMENTO));

        validarLongitud(razonsocial,
                LONGITUD_MINIMA_RAZON_SOCIAL,
                String.format(LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MINIMA_RAZON_SOCIAL));
        validarLongitudMaxima(razonsocial,
                LONGITUD_MAXIMA_NUMERO_DOCUMENTO,
                String.format(LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MAXIMA_RAZON_SOCIAL));

        this.id = id;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.razonsocial = razonsocial;
        this.fechaCreacion = fechaCreacion;
    }
}
