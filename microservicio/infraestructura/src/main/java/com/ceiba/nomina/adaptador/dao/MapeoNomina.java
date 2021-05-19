package com.ceiba.nomina.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.nomina.modelo.dto.DtoNomina;
import org.springframework.jdbc.core.RowMapper;

public class MapeoNomina implements RowMapper<DtoNomina>, MapperResult {

    @Override
    public DtoNomina mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String documentoempleado = resultSet.getString("documentoempleado");
        String periodo = resultSet.getString("periodo");
        Double valor = resultSet.getDouble("valor");
        Long companiaid = resultSet.getLong("companiaid");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoNomina(id, documentoempleado, periodo, valor, companiaid, fecha);
    }

}
