package com.ceiba.consultanomina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.consultanomina.modelo.dto.DtoConsultanomina;
import com.ceiba.consultanomina.puerto.dao.DaoConsultanomina;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoConsultanominaMysql implements DaoConsultanomina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="nomina", value="listarnominaasesor")
    private static String sqlListar;

    public DaoConsultanominaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoConsultanomina> listarnominaasesor() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoConsultanomina());
    }
}
