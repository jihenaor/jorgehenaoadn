package com.ceiba.consultanomina.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.consultanomina.modelo.dto.DtoConsultanomina;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoConsultanomina implements RowMapper<DtoConsultanomina>, MapperResult {

    @Override
    public DtoConsultanomina mapRow(ResultSet resultSet, int rowNum) throws SQLException {


        String tipodocumento = resultSet.getString("tipodocumento");
        String numerodocumento = resultSet.getString("numerodocumento");
        String razonsocial = resultSet.getString("razonsocial");
        Long analistaid = resultSet.getLong("analistaid");

        Long id = resultSet.getLong("id");
        String documentoempleado = resultSet.getString("documentoempleado");
        String periodo = resultSet.getString("periodo");
        Double valor = resultSet.getDouble("valor");
        Long companiaid = resultSet.getLong("companiaid");

        return new DtoConsultanomina(tipodocumento,
                numerodocumento,
                razonsocial,
                analistaid,
                id,
                documentoempleado, periodo, valor, companiaid);
    }

}
