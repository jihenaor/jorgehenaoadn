package com.ceiba.nomina.puerto.repositorio;

import com.ceiba.nomina.modelo.entidad.Nomina;

public interface RepositorioNomina {
    /**
     * Permite crear una nomina
     * @param nomina
     * @return el id generado
     */
    Long crear(Nomina nomina);

    /**
     * Permite actualizar un usuario
     * @param nomina
     */
    void actualizar(Nomina nomina);

    /**
     * Permite eliminar una nomina
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una nomina para un empleado en un periodo en una compañia
     * @param documentoempleado
     * @param periodo
     * @param companiaid
     * @return si existe o no
     */
    boolean existe(String documentoempleado, String periodo, Long companiaid);

    /**
     * Permite validar si existe una nomina de un empleado en un periodo excluyendo un id
     * @param documentoempleado
     * @param periodo
     * @param companiaid
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String documentoempleado, String periodo, Long companiaid);

}
