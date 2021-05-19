package com.ceiba.nomina.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.nomina.puerto.dao.DaoNomina;

import org.springframework.stereotype.Component;

import com.ceiba.nomina.modelo.dto.DtoNomina;

@Component
public class DaoNominaMysql implements DaoNomina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="nomina", value="listar")
    private static String sqlListar;

    public DaoNominaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoNomina> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoNomina());
    }
}
