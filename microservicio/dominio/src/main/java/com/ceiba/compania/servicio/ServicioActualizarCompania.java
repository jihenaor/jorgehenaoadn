package com.ceiba.compania.servicio;

import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCompania {

    private static final String LA_COMPANIA_NO_EXISTE_EN_EL_SISTEMA = "La compañia no existe en el sistema";

    private final RepositorioCompania repositorioNomina;

    public ServicioActualizarCompania(RepositorioCompania repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public void ejecutar(Compania compania) {
        validarExistenciaPrevia(compania);
        this.repositorioNomina.actualizar(compania);
    }

    private void validarExistenciaPrevia(Compania compania) {
//        boolean existe = this.repositorioNomina.existeExcluyendoId(compania.getId(), compania.getNumerodocumento());
        boolean existe = this.repositorioNomina.existe(compania.getNumerodocumento());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_COMPANIA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
