package com.ceiba.nomina.servicio;

import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;

public class ServicioEliminarNomina {

    private final RepositorioNomina repositorioNomina;

    public ServicioEliminarNomina(RepositorioNomina repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public void ejecutar(Long id) {
        this.repositorioNomina.eliminar(id);
    }
}
