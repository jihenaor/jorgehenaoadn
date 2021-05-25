package com.ceiba.compania.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compania.servicio.testdatabuilder.CompaniaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ServicioCrearCompaniaTest {

    @Mock
    private RepositorioCompania repositorioCompania;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void validarTipoDocumentoLongitud2Test() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder().conTipodocumento("XXX");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "El tipo de documento debe tener una longitud igual a 2");
    }

    @Test
    public void validarCompaniaConDocumentoTipoNitTest() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder()
                .conTipodocumento("NI")
                .conNumerodocumento("8");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "El numero de documento no tiene la longitud esperada");
    }

    @Test
    public void validarCompaniaConDocumentoTipoCC9DigitosTest() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder()
                .conTipodocumento("CC")
                .conNumerodocumento("123456789");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "El numero de documento no tiene la longitud esperada");
    }

    @Test
    public void validarCompaniaConDocumentoTipoCCMenor3DigitosTest() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder()
                .conTipodocumento("CC")
                .conNumerodocumento("12");
        // act - assert
        BasePrueba.assertThrows(companiaTestDataBuilder::build,
                ExcepcionLongitudValor.class,
                "El numero de documento no tiene la longitud esperada");
    }

    @Test
    public void validarCompaniaConDocumentoTipoCCMayor10DigitosTest() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder()
                .conTipodocumento("CC")
                .conNumerodocumento("1234567890");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "El numero de documento no tiene la longitud esperada");
    }

    @Test
    public void validarCompaniaConDocumentoTipoIndefinidoTest() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder()
                .conTipodocumento("XX")
                .conNumerodocumento("123456789");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionValorInvalido.class,
                "Se debe ingresar tipo de documento valido");
    }

    @Test
    public void validarRazonsocialLongitudMenor2Test() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder().conRazonSocial("A");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "La razon social debe tener una longitud mayor o igual a 2");
    }

    @Test
    public void validarRazonsocialLongitudMenorMayor80Test() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder()
                                                            .conRazonSocial("AKLDJF KLAÑSDFJKLÑAS DJFKLÑASJD ÑFLKASJDFL ÑKASJD ÑFLKAJSDFKLÑ JASDKLÑFJ ASDKLÑJF AKLÑSDJF LÑKASDJF KLÑASDJFKL ÑASJDFKL ÑASDJLÑKF JSDL");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "La razon social debe tener una longitud menor o igual a 80");
    }

    @Test
    public void validarCompaniaExistenciaPreviaTest() {
        // arrange
        Compania compania = new CompaniaTestDataBuilder().build();
        RepositorioCompania repositorioCompania = Mockito.mock(RepositorioCompania.class);
        Mockito.when(repositorioCompania.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCompania servicioCrearCompania = new ServicioCrearCompania(repositorioCompania);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompania.ejecutar(compania),
                ExcepcionDuplicidad.class,
                "La compañia ya existe en el sistema");
    }

    @Test
    public void validarCrearCompaniaTest() {
        // arrange
        Compania compania = new CompaniaTestDataBuilder().build();
        Mockito.when(repositorioCompania.crear(compania)).thenReturn(1L);
        ServicioCrearCompania servicioCrearCompania = new ServicioCrearCompania(repositorioCompania);
        // act - assert
        servicioCrearCompania.ejecutar(compania);
        verify(repositorioCompania, times(1)).crear(compania);
    }

    @Test
    public void validarActualizarCompaniaTest() {
        // arrange
        Compania compania = new CompaniaTestDataBuilder().build();
        doNothing().when(repositorioCompania).actualizar(any(Compania.class));
        ServicioActualizarCompania servicioActualizarCompania = new ServicioActualizarCompania(repositorioCompania);
        // act - assert
        servicioActualizarCompania.ejecutar(compania);
        verify(repositorioCompania, times(1)).actualizar(any(Compania.class));
    }

    @Test
    public void validarEliminarCompaniaTest() {
        // arrange
        doNothing().when(repositorioCompania).eliminar(anyLong());
        ServicioEliminarCompania servicioEliminarCompania = new ServicioEliminarCompania(repositorioCompania);
        // act - assert

        servicioEliminarCompania.ejecutar(1L);
        verify(repositorioCompania, times(1)).eliminar(anyLong());
    }
}
