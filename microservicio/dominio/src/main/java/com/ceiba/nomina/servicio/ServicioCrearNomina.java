package com.ceiba.nomina.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearNomina {

    private static final String LA_NOMINA_YA_EXISTE_EN_EL_SISTEMA = "La nomina ya existe en el sistema";

    private final RepositorioNomina repositorioNomina;

    public ServicioCrearNomina(RepositorioNomina repositorioNomina) {
        this.repositorioNomina = repositorioNomina;
    }

    public Long ejecutar(Nomina nomina) {
        validarFechaCreacion(nomina);
        validarExistenciaPrevia(nomina);
        return this.repositorioNomina.crear(nomina);
    }

    private void validarExistenciaPrevia(Nomina nomina) {
        boolean existe = this.repositorioNomina.existe(
                nomina.getDocumentoempleado(),
                nomina.getPeriodo(),
                nomina.getCompaniaid());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_NOMINA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

     private void validarFechaCreacion(Nomina nomina) {
        if (nomina.getFechaCreacion().getDayOfMonth() > 14) {
            throw new ExcepcionValorInvalido("La fecha de registro no puede ser superior al dia 14");
        }
    }
}
