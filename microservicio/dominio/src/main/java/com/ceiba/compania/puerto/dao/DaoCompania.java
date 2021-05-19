package com.ceiba.compania.puerto.dao;

import com.ceiba.compania.modelo.dto.DtoCompania;

import java.util.List;

public interface DaoCompania {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoCompania> listar();
}
