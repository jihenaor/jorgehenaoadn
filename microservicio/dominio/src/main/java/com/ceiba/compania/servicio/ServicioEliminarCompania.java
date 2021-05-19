package com.ceiba.compania.servicio;

import com.ceiba.compania.puerto.repositorio.RepositorioCompania;

public class ServicioEliminarCompania {

    private final RepositorioCompania repositorioNomina;

    public ServicioEliminarCompania(RepositorioCompania repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public void ejecutar(Long id) {
        this.repositorioNomina.eliminar(id);
    }
}
