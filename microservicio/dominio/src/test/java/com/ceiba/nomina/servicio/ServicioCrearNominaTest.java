package com.ceiba.nomina.servicio;

import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.servicio.ServicioActualizarCompania;
import com.ceiba.compania.servicio.ServicioCrearCompania;
import com.ceiba.compania.servicio.ServicioEliminarCompania;
import com.ceiba.compania.servicio.testdatabuilder.CompaniaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.nomina.servicio.testdatabuilder.NominaTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class ServicioCrearNominaTest {

    private static final String SE_DEBE_INGRESAR_EL_DOCUMENTO_DEL_EMPLEADO = "Se debe ingresar el documento del empleado";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DE_LA_NOMINA = "Se debe ingresar el valor de la nomina";
    private static final String EL_VALOR_DE_LA_NOMINA_DEBE_SER_MAYOR_IGUAL_CERO = "El valor de la nomina debe ser mayor igual a cero";
    private static final String SE_DEBE_INGRESAR_UN_PERIODO = "Se debe ingresar un periodo";
    private static final String EL_PERIODO_DEBE_TERNER_UNA_LONGITUD_6 = "El periodo debe tener una longitud de 6 digitos";
    private static final String EL_IDCOMPANIA_ES_REQUERIDO = "Se debe ingresar el identificador de la compañia";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación de la nomina";


    @Mock
    private RepositorioNomina repositorioNomina;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void validarDocumentoEmpladoRequeridoTest() {
        // arrange
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conDocumentoempleado(null);
        // act - assert
        BasePrueba.assertThrows(() -> nominaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
                "Se debe ingresar el documento del empleado");
    }

    @Test
    public void validarValorNominaRequeridoTest() {
        // arrange
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conValor(null);
        // act - assert
        BasePrueba.assertThrows(() -> nominaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
                "Se debe ingresar el valor de la nomina");
    }

    @Test
    public void validarValorNominaPoitivoRequeridoTest() {
        // arrange
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conValor(-1D);
        // act - assert
        BasePrueba.assertThrows(() -> nominaTestDataBuilder.build(), ExcepcionValorInvalido.class,
                "El valor de la nomina debe ser mayor igual a cero");
    }

    @Test
    public void validarPeriodoRequeridoTest() {
        // arrange
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conPeriodo(null);
        // act - assert
        BasePrueba.assertThrows(() -> nominaTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar un periodo");
    }

    @Test
    public void validarPeriodoLongitud6Test() {
        // arrange
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conPeriodo("2020");
        // act - assert
        BasePrueba.assertThrows(() -> nominaTestDataBuilder.build(), ExcepcionLongitudValor.class, "El periodo debe tener una longitud de 6 digitos");
    }

    @Test
    public void validarIdEmpresaRequeridoTest() {
        // arrange
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conCompaniaid(null);
        // act - assert
        BasePrueba.assertThrows(() -> nominaTestDataBuilder.build(), ExcepcionValorObligatorio.class,
                "Se debe ingresar el identificador de la compañia");
    }

    @Test
    public void validarNominaExistenciaPreviaTest() {
        // arrange
        Nomina nomina = new NominaTestDataBuilder().build();
        RepositorioNomina repositorioNomina = Mockito.mock(RepositorioNomina.class);
        Mockito.when(repositorioNomina.existe(Mockito.anyString(),
                                    Mockito.anyString(),
                                    Mockito.anyLong())).thenReturn(true);
        ServicioCrearNomina servicioCrearNomina = new ServicioCrearNomina(repositorioNomina);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearNomina.ejecutar(nomina), ExcepcionDuplicidad.class,
                "La nomina ya existe en el sistema");
    }

    @Test
    public void validarFechaMayorDia14Test() {
        // arrange
        LocalDateTime fecha =
                LocalDateTime.of(2019, 03, 28, 0, 0, 0, 0);
        NominaTestDataBuilder nominaTestDataBuilder = new NominaTestDataBuilder().conFecha(fecha);
        RepositorioNomina repositorioNomina = Mockito.mock(RepositorioNomina.class);
        ServicioCrearNomina servicioCrearNomina = new ServicioCrearNomina(repositorioNomina);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearNomina.ejecutar(nominaTestDataBuilder.build()), RuntimeException.class,
                "La fecha de registro no puede ser superior al dia 14");
    }


    @Test
    public void validarCrearNominaTest() {
        // arrange
        Nomina nomina = new NominaTestDataBuilder().build();
        Mockito.when(repositorioNomina.crear(nomina)).thenReturn(1L);
        ServicioCrearNomina servicioCrearNomina = new ServicioCrearNomina(repositorioNomina);
        // act - assert
        servicioCrearNomina.ejecutar(nomina);
        verify(repositorioNomina, times(1)).crear(nomina);
    }

    @Test
    public void validarActualizarNominaTest() {
        // arrange
        Nomina nomina = new NominaTestDataBuilder().build();
        doNothing().when(repositorioNomina).actualizar(any(Nomina.class));
        ServicioActualizarNomina servicioActualizarNomina = new ServicioActualizarNomina(repositorioNomina);
        // act - assert
        servicioActualizarNomina.ejecutar(nomina);
        verify(repositorioNomina, times(1)).actualizar(any(Nomina.class));
    }

    @Test
    public void validarEliminarNominaTest() {
        // arrange
        doNothing().when(repositorioNomina).eliminar(anyLong());
        ServicioEliminarNomina servicioEliminarNomina = new ServicioEliminarNomina(repositorioNomina);
        // act - assert

        servicioEliminarNomina.ejecutar(anyLong());
        verify(repositorioNomina, times(1)).eliminar(anyLong());
    }

}
