package com.ceiba.compania.puerto.repositorio;

import com.ceiba.compania.modelo.entidad.Compania;

public interface RepositorioCompania {
    /**
     * Permite crear una compania
     * @param compania
     * @return el id generado
     */
    Long crear(Compania compania);

    /**
     * Permite actualizar una compania
     * @param compania
     */
    void actualizar(Compania compania);

    /**
     * Permite eliminar una compania
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe una compania por el numero de documento
     * @param numerodocumento
     * @return si existe o no
     */
    boolean existe(String numerodocumento);

    /**
     * Permite validar si existe una compania con un documento excluyendo un id
     * @param numerodocumento
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String numerodocumento);

    /**
     * Permite contar el numero de empresas asignadas a un analista
     * @param analistaid
     * @return numero de ocurrencias
     */
    int contarEmpresasAnalista(Long analistaid);
}
