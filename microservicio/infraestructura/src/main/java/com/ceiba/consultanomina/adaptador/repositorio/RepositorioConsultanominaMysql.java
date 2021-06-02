package com.ceiba.consultanomina.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.consultanomina.puerto.repositorio.RepositorioConsultanomina;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioConsultanominaMysql implements RepositorioConsultanomina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioConsultanominaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
}
