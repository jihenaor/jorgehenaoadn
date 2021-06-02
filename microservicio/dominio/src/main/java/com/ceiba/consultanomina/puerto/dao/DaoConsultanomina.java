package com.ceiba.consultanomina.puerto.dao;

import com.ceiba.consultanomina.modelo.dto.DtoConsultanomina;

import java.util.List;

public interface DaoConsultanomina {

    /**
     * Permite listar la nomina de una empresa
     * @return las nominas
     */
    List<DtoConsultanomina> listarnominaasesor();
}
