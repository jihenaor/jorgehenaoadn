package com.ceiba.compania.modelo.entidad;


import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudIgual;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarLongitudMaxima;

@Getter
public class Compania {
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO = "Se debe ingresar el tipo de documento";
    private static final String SE_DEBE_INGRESAR_TIPO_DE_DOCUMENTO_VALIDO = "Se debe ingresar tipo de documento valido";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO = "Se debe ingresar el número de documento";
    private static final String SE_DEBE_INGRESAR_LA_RAZON_SOCIAL = "Se debe ingresar la razón social";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION;

    private static final String EL_TIPO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_IGUAL_A;
    private static final String EL_NUMERO_DE_DOCUMENTO_NO_TIENE_LA_LONGITUD_ESPERADA;

    static {
        SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
        EL_TIPO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "El tipo de documento debe tener una longitud igual a %s";
        EL_NUMERO_DE_DOCUMENTO_NO_TIENE_LA_LONGITUD_ESPERADA = "El numero de documento no tiene la longitud esperada";
    }

    private static final String LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A = "La razon social debe tener una longitud mayor o igual a %s";
    private static final String LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La razon social debe tener una longitud menor o igual a %s";

    private static final int LONGITUD_TIPO_DOCUMENTO = 2;

    private static final int LONGITUD_MINIMA_RAZON_SOCIAL = 2;
    private static final int LONGITUD_DOCUMENTO_TIPO_NIT = 9;
    private static final int LONGITUD_MAXIMA_RAZON_SOCIAL = 80;

    private Long id;
    private String tipodocumento;
    private String numerodocumento;
    private String razonsocial;
    private Long analistaid;
    private LocalDateTime fechaCreacion;

    public Compania(Long id, String tipodocumento, String numerodocumento, String razonsocial, Long analistaid, LocalDateTime fechaCreacion) {
        this.id = id;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.razonsocial = razonsocial;
        this.analistaid = analistaid;

        this.fechaCreacion = fechaCreacion;

        validarAtributosRequeridos();

        validarLongitudAtributos();
    }

    private void validarAtributosRequeridos() {
        validarObligatorio(tipodocumento, SE_DEBE_INGRESAR_EL_TIPO_DE_DOCUMENTO);
        validarObligatorio(numerodocumento, SE_DEBE_INGRESAR_EL_NUMERO_DE_DOCUMENTO);
        validarObligatorio(razonsocial, SE_DEBE_INGRESAR_LA_RAZON_SOCIAL);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
    }

    private void validarLongitudAtributos() {

        validarLongitudIgual(tipodocumento, LONGITUD_TIPO_DOCUMENTO, String.format(EL_TIPO_DE_DOCUMENTO_DEBE_TENER_UNA_LONGITUD_IGUAL_A, LONGITUD_TIPO_DOCUMENTO));

        validarLongitudDocumento();

        validarLongitud(razonsocial, LONGITUD_MINIMA_RAZON_SOCIAL, String.format(LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MENOR_O_IGUAL_A, LONGITUD_MINIMA_RAZON_SOCIAL));

        validarLongitudMaxima(razonsocial, LONGITUD_MAXIMA_RAZON_SOCIAL, String.format(LA_RAZON_SOCIAL_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A, LONGITUD_MAXIMA_RAZON_SOCIAL));
    }

    private void validarLongitudDocumento() {
        switch (tipodocumento) {
            case "NI":
                validarLongitudIgual(numerodocumento,
                        LONGITUD_DOCUMENTO_TIPO_NIT,
                        String.format(EL_NUMERO_DE_DOCUMENTO_NO_TIENE_LA_LONGITUD_ESPERADA, LONGITUD_DOCUMENTO_TIPO_NIT));
                break;
            case "CC":
                if (numerodocumento.length() <1 || numerodocumento.length() == 9 || numerodocumento.length() > 10) {
                    throw new ExcepcionLongitudValor(EL_NUMERO_DE_DOCUMENTO_NO_TIENE_LA_LONGITUD_ESPERADA);
                }
                break;
            default:
                throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_TIPO_DE_DOCUMENTO_VALIDO);
        }
    }
}
