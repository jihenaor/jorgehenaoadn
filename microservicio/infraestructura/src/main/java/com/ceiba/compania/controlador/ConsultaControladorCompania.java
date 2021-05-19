package com.ceiba.compania.controlador;

import com.ceiba.compania.consulta.ManejadorListarCompanias;
import com.ceiba.compania.modelo.dto.DtoCompania;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/companias")
@Api(tags={"Controlador consulta compania"})
public class ConsultaControladorCompania {

    private final ManejadorListarCompanias manejadorListarCompanias;

    public ConsultaControladorCompania(ManejadorListarCompanias manejadorListarCompanias) {
        this.manejadorListarCompanias = manejadorListarCompanias;
    }

    @GetMapping
    @ApiOperation("Listar Companias")
    public List<DtoCompania> listar() {
        return this.manejadorListarCompanias.ejecutar();
    }

}
