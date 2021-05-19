package com.ceiba.compania.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCompaniaMysql implements RepositorioCompania {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "compania", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace= "compania", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace= "compania", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace= "compania", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace= "compania", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;

    public RepositorioCompaniaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Compania compania) {
        return this.customNamedParameterJdbcTemplate.crear(compania, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String numerodocumento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("numerodocumento", numerodocumento);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Compania compania) {
        this.customNamedParameterJdbcTemplate.actualizar(compania, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String numerodocumento) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("numerodocumento", numerodocumento);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }
}
