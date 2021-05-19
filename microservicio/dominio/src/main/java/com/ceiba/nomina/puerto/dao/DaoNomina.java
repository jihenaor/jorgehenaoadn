package com.ceiba.nomina.puerto.dao;

import com.ceiba.nomina.modelo.dto.DtoNomina;

import java.util.List;

public interface DaoNomina {

    /**
     * Permite listar la nomina de una empresa
     * @return las nominas
     */
    List<DtoNomina> listar();
}
