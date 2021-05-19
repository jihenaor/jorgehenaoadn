package com.ceiba.nomina.servicio;

import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.nomina.servicio.testdatabuilder.NominaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioActualizarNominaTest {

    @Test
    public void validarNominaExistenciaPreviaTest() {
        // arrange
        Nomina nomina = new NominaTestDataBuilder().conId(1L).build();
        RepositorioNomina repositorioNomina = Mockito.mock(RepositorioNomina.class);
        Mockito.when(repositorioNomina.existeExcluyendoId(
                Mockito.anyLong(),
                Mockito.anyString(),
                Mockito.anyString(),
                Mockito.anyLong())).thenReturn(true);
        ServicioActualizarNomina servicioActualizarNomina = new ServicioActualizarNomina(repositorioNomina);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarNomina.ejecutar(nomina), ExcepcionDuplicidad.class,"La nomina ya existe en el sistema");
    }
}
