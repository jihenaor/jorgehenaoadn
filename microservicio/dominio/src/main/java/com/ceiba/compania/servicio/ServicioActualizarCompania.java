package com.ceiba.compania.servicio;

import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

public class ServicioActualizarCompania {

    private static final String LA_COMPANIA_NO_EXISTE_EN_EL_SISTEMA = "La compañia no existe en el sistema";
    private static final String EL_ANALISTA_SUPERA_EL_NUMERO_EMPRESAS = "El analista supera el tope de empresas asignadas";

    private final RepositorioCompania repositorioCompania;

    public enum LIMITE {
        LIMITE_EMPRESAS_ANALISTA(4);

        public final int valor;

        private LIMITE(int valor) {
            this.valor = valor;
        }
    }

    public ServicioActualizarCompania(RepositorioCompania repositorioNomina) {
        this.repositorioCompania = repositorioNomina;
    }

    public void ejecutar(Compania compania) {
        validarExistenciaPrevia(compania);
        validarNumeroEmpresasAsignadas(compania);
        this.repositorioCompania.actualizar(compania);
    }

    private void validarExistenciaPrevia(Compania compania) {
        boolean existe = this.repositorioCompania.existeExcluyendoId(compania.getId(), compania.getNumerodocumento());

        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPANIA_NO_EXISTE_EN_EL_SISTEMA);
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
