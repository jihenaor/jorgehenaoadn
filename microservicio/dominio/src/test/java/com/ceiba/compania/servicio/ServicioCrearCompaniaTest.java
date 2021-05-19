package com.ceiba.compania.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compania.servicio.testdatabuilder.CompaniaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.compania.servicio.ServicioCrearCompania;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCompaniaTest {

    @Test
    public void validarTipoDocumentoLongitud2Test() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder().conTipodocumento("124");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "El tipo de documento debe tener una longitud igual a 2");
    }

    @Test
    public void validarNumeroDocumentoLongitudMenorIgual3Test() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder().conNumerodocumento("8");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "El numero de documento debe tener una longitud mayor o igual a 3");
    }

    @Test
    public void validarNumeroDocumentoLongitudMenorMayor16Test() {
        // arrange
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder().conNumerodocumento("12345678901234567");
        // act - assert
        BasePrueba.assertThrows(() -> companiaTestDataBuilder.build(),
                ExcepcionLongitudValor.class,
                "El numero de documento debe tener una longitud menor o igual a 16");
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
        CompaniaTestDataBuilder companiaTestDataBuilder = new CompaniaTestDataBuilder().conRazonSocial("AKLDJF KLAÑSDFJKLÑAS DJFKLÑASJD ÑFLKASJDFL ÑKASJD ÑFLKAJSDFKLÑ JASDKLÑFJ ASDKLÑJF AKLÑSDJF LÑKASDJF KLÑASDJFKL ÑASJDFKL ÑASDJLÑKF JSDL");
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
}
