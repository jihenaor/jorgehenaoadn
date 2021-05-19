package com.ceiba.nomina.consulta;

import java.util.List;

import com.ceiba.nomina.puerto.dao.DaoNomina;
import org.springframework.stereotype.Component;

import com.ceiba.nomina.modelo.dto.DtoNomina;

@Component
public class ManejadorListarNomina {

    private final DaoNomina daoNomina;

    public ManejadorListarNomina(DaoNomina daoNomina){
        this.daoNomina = daoNomina;
    }

    public List<DtoNomina> ejecutar(){ return this.daoNomina.listar(); }
}
