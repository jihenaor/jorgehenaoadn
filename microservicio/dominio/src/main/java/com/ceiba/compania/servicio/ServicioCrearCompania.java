package com.ceiba.compania.servicio;

import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearCompania {

    private static final String LA_COMPANIA_YA_EXISTE_EN_EL_SISTEMA = "La compañia ya existe en el sistema";

    private final RepositorioCompania repositorioCompania;

    public ServicioCrearCompania(RepositorioCompania repositorioCompania) {
        this.repositorioCompania = repositorioCompania;
    }

    public Long ejecutar(Compania compania) {
        validarExistenciaPrevia(compania);
        return this.repositorioCompania.crear(compania);
    }

    private void validarExistenciaPrevia(Compania compania) {
        boolean existe = this.repositorioCompania.existe(compania.getNumerodocumento());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPANIA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
