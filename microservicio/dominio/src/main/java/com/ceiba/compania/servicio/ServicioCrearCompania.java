package com.ceiba.compania.servicio;

import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;


public class ServicioCrearCompania {

    private static final String LA_COMPANIA_YA_EXISTE_EN_EL_SISTEMA = "La compañia ya existe en el sistema";
    private static final String EL_ANALISTA_SUPERA_EL_NUMERO_EMPRESAS = "El analista supera el tope de empresas asignadas";

    private final RepositorioCompania repositorioCompania;

    public ServicioCrearCompania(RepositorioCompania repositorioCompania) {
        this.repositorioCompania = repositorioCompania;
    }

    public Long ejecutar(Compania compania) {
        validarExistenciaPrevia(compania);
        validarNumeroEmpresasAsignadas(compania);
        return this.repositorioCompania.crear(compania);
    }

    private void validarExistenciaPrevia(Compania compania) {
        boolean existe = this.repositorioCompania.existe(compania.getNumerodocumento());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPANIA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


    private void validarNumeroEmpresasAsignadas(Compania compania) {
        if (compania.getAnalistaid() != null) {
            int numeroEmpresasAnalista = this.repositorioCompania.contarEmpresasAnalista(compania.getAnalistaid());
            int limite = ServicioActualizarAnalistaCompania.LIMITE.LIMITE_EMPRESAS_ANALISTA.valor;
            if (numeroEmpresasAnalista >= limite) {
                throw new ExcepcionValorInvalido(EL_ANALISTA_SUPERA_EL_NUMERO_EMPRESAS);
            }
        }
    }
}
