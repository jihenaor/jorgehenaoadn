package com.ceiba.compania.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.compania.modelo.dto.DtoCompania;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCompania implements RowMapper<DtoCompania>, MapperResult {

    @Override
    public DtoCompania mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String tipodocumento = resultSet.getString("tipodocumento");
        String numerodocumento = resultSet.getString("numerodocumento");
        String razonsocial = resultSet.getString("razonsocial");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoCompania(id, tipodocumento,numerodocumento, razonsocial, fecha);
    }

}
