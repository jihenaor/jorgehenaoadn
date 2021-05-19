package com.ceiba.compania.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compania.servicio.testdatabuilder.CompaniaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.compania.servicio.ServicioActualizarCompania;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarCompaniaTest {

    @Test
    public void validarCompaniaExistenciaPreviaTest() {
        // arrange
        Compania compania = new CompaniaTestDataBuilder().conId(1L).build();
        RepositorioCompania repositorioCompania = Mockito.mock(RepositorioCompania.class);
        Mockito.when(repositorioCompania.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarCompania servicioActualizarCompania = new ServicioActualizarCompania(repositorioCompania);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCompania.ejecutar(compania), ExcepcionDuplicidad.class,"La compañia ya existe en el sistema");
    }
}
