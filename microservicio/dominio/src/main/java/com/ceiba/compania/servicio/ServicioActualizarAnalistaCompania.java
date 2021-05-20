package com.ceiba.compania.servicio;

import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioActualizarAnalistaCompania {

    private static final String EL_ANALISTA_SUPERA_EL_NUMERO_EMPRESAS = "El analista supera el tope de empresas asignadas";

    private final RepositorioCompania repositorioNomina;

    public ServicioActualizarAnalistaCompania(RepositorioCompania repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public void ejecutar(Compania compania) {
        validarNumeroEmpresasAsignadas(compania);
        this.repositorioNomina.actualizar(compania);
    }

    private void validarNumeroEmpresasAsignadas(Compania compania) {
        int numeroEmpresasAnalista = this.repositorioNomina.contarEmpresasAnalista(compania.getAnalistaid());
        int limite = 4;
        if(numeroEmpresasAnalista >= limite) {
            throw new ExcepcionValorInvalido(EL_ANALISTA_SUPERA_EL_NUMERO_EMPRESAS);
        }

    }
}
