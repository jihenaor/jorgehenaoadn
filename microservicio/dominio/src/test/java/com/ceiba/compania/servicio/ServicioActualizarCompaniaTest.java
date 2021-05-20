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
    public void validarCompaniaNoExistenciaPreviaTest() {
        // arrange
        Compania compania = new CompaniaTestDataBuilder().conId(1L).build();
        RepositorioCompania repositorioCompania = Mockito.mock(RepositorioCompania.class);
        Mockito.when(repositorioCompania.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarCompania servicioActualizarCompania = new ServicioActualizarCompania(repositorioCompania);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCompania.ejecutar(compania), ExcepcionDuplicidad.class,"La compañia no existe en el sistema");
    }

    @Test
    public void validarContadorEmpresasAsignadasAsesorTest() {
        // arrange
        Compania compania = new CompaniaTestDataBuilder().conAnalistaid(1L).build();
        RepositorioCompania repositorioCompania = Mockito.mock(RepositorioCompania.class);
        Mockito.when(repositorioCompania.contarEmpresasAnalista(Mockito.anyLong())).thenReturn(5);
        ServicioActualizarAnalistaCompania servicioActualizarAnalistaCompania = new ServicioActualizarAnalistaCompania(repositorioCompania);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAnalistaCompania.ejecutar(compania), RuntimeException.class,"El analista supera el tope de empresas asignadas");
    }
}
