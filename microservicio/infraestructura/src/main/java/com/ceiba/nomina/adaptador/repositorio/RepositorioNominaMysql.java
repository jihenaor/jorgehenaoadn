package com.ceiba.nomina.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioNominaMysql implements RepositorioNomina {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="nomina", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="nomina", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="nomina", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="nomina", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="nomina", value="existeExcluyendoId") 
    private static String sqlExisteExcluyendoId;

    public RepositorioNominaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Nomina nomina) {
        return this.customNamedParameterJdbcTemplate.crear(nomina, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String documentoempleado, String periodo, Long companiaid) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("documentoempleado", documentoempleado);
        paramSource.addValue("periodo", periodo);
        paramSource.addValue("companiaid", companiaid);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Nomina nomina) {
        this.customNamedParameterJdbcTemplate.actualizar(nomina, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id,
                                      String documentoempleado,
                                      String periodo,
                                      Long companiaid) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("documentoempleado", documentoempleado);
        paramSource.addValue("periodo", periodo);
        paramSource.addValue("companiaid", companiaid);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
