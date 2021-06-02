package com.ceiba.consultanomina.consulta;

import com.ceiba.consultanomina.modelo.dto.DtoConsultanomina;
import com.ceiba.consultanomina.puerto.dao.DaoConsultanomina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarConsultanomina {

    private final DaoConsultanomina daoConsultanomina;

    public ManejadorListarConsultanomina(DaoConsultanomina daoNomina){
        this.daoConsultanomina = daoNomina;
    }

    public List<DtoConsultanomina> ejecutar(){ return this.daoConsultanomina.listarnominaasesor(); }
}
