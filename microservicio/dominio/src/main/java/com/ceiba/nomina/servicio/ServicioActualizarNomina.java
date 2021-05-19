package com.ceiba.nomina.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;

public class ServicioActualizarNomina {

    private static final String LA_NOMINA_YA_EXISTE_EN_EL_SISTEMA = "La nomina ya existe en el sistema";

    private final RepositorioNomina repositorioNomina;

    public ServicioActualizarNomina(RepositorioNomina repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public void ejecutar(Nomina nomina) {
        validarExistenciaPrevia(nomina);
        this.repositorioNomina.actualizar(nomina);
    }

    private void validarExistenciaPrevia(Nomina nomina) {
        boolean existe = this.repositorioNomina.existeExcluyendoId(nomina.getId(),
                nomina.getDocumentoempleado(),
                nomina.getPeriodo(),
                nomina.getCompaniaid());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_NOMINA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
