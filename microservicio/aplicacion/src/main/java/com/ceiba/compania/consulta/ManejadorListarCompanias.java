package com.ceiba.compania.consulta;

import com.ceiba.compania.modelo.dto.DtoCompania;
import com.ceiba.compania.puerto.dao.DaoCompania;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCompanias {

    private final DaoCompania daoCompania;

    public ManejadorListarCompanias(DaoCompania daoCompania){
        this.daoCompania = daoCompania;
    }

    public List<DtoCompania> ejecutar(){ return this.daoCompania.listar(); }
}
