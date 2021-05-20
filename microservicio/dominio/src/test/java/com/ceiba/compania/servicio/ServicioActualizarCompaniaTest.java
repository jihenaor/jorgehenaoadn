package com.ceiba.compania.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compania.servicio.testdatabuilder.CompaniaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.compania.servicio.ServicioActualizarCompania;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;


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
        Mockito.when(repositorioCompania.contarEmpresasAnalista(Mockito.anyLong())).thenReturn(4);
        ServicioActualizarAnalistaCompania servicioActualizarAnalistaCompania = new ServicioActualizarAnalistaCompania(repositorioCompania);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAnalistaCompania.ejecutar(compania), RuntimeException.class,"El analista supera el tope de empresas asignadas");
    }

    @Test
    public void validarContadorEmpresasAsignadasValidoAsesorTest() {
        // arrange
        Compania compania = new CompaniaTestDataBuilder().conAnalistaid(1L).build();
        RepositorioCompania repositorioCompania = Mockito.mock(RepositorioCompania.class);
        Mockito.when(repositorioCompania.contarEmpresasAnalista(Mockito.anyLong())).thenReturn(3);
        ServicioActualizarAnalistaCompania servicioActualizarAnalistaCompania = new ServicioActualizarAnalistaCompania(repositorioCompania);
        // act - assert

//        verify(repositorioCompania, times(1)).actualizar(compania);
        servicioActualizarAnalistaCompania.ejecutar(compania);
        verify(repositorioCompania, times(1)).actualizar(compania);
    }
}
