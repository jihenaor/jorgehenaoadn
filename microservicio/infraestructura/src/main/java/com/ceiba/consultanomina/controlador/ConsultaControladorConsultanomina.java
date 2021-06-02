package com.ceiba.consultanomina.controlador;

import com.ceiba.consultanomina.consulta.ManejadorListarConsultanomina;
import com.ceiba.consultanomina.modelo.dto.DtoConsultanomina;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consultanominas")
@Api(tags={"Controlador consulta nomina empresa"})
public class ConsultaControladorConsultanomina {

    private final ManejadorListarConsultanomina manejadorListarConsultanominas;

    public ConsultaControladorConsultanomina(ManejadorListarConsultanomina manejadorListarNominas) {
        this.manejadorListarConsultanominas = manejadorListarNominas;
    }

    @GetMapping
    @ApiOperation("Listar Nominas")
    public List<DtoConsultanomina> listar() {
        return this.manejadorListarConsultanominas.ejecutar();
    }

}
