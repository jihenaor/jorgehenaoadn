package com.ceiba.compania.servicio;

import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioActualizarAnalistaCompania {

    private static final String EL_ANALISTA_SUPERA_EL_NUMERO_EMPRESAS = "El analista supera el tope de empresas asignadas";

    private final RepositorioCompania repositorioNomina;

    public enum LIMITE {
        LIMITE_EMPRESAS_ANALISTA(4);

        public final int valor;

        private LIMITE(int valor) {
            this.valor = valor;
        }
    }

    public ServicioActualizarAnalistaCompania(RepositorioCompania repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public void ejecutar(Compania compania) {
        validarNumeroEmpresasAsignadas(compania);
        this.repositorioNomina.actualizar(compania);
    }

    private void validarNumeroEmpresasAsignadas(Compania compania) {
        int numeroEmpresasAnalista = this.repositorioNomina.contarEmpresasAnalista(compania.getAnalistaid());
        int limite = LIMITE.LIMITE_EMPRESAS_ANALISTA.valor;
        if(numeroEmpresasAnalista >= limite) {
            throw new ExcepcionValorInvalido(EL_ANALISTA_SUPERA_EL_NUMERO_EMPRESAS);
        }
    }
}
