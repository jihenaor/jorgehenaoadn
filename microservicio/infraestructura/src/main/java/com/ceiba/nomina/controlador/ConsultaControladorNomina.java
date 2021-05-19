package com.ceiba.nomina.controlador;

import java.util.List;

import com.ceiba.nomina.consulta.ManejadorListarNomina;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.nomina.modelo.dto.DtoNomina;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nominas")
@Api(tags={"Controlador consulta nomina"})
public class ConsultaControladorNomina {

    private final ManejadorListarNomina manejadorListarNominas;

    public ConsultaControladorNomina(ManejadorListarNomina manejadorListarNominas) {
        this.manejadorListarNominas = manejadorListarNominas;
    }

    @GetMapping
    @ApiOperation("Listar Nominas")
    public List<DtoNomina> listar() {
        return this.manejadorListarNominas.ejecutar();
    }

}
