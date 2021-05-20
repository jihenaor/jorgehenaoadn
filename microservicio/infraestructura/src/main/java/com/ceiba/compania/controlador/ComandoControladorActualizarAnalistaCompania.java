package com.ceiba.compania.controlador;

import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.comando.manejador.ManejadorActualizarAnalistaCompania;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companias")
@Api(tags = { "Controlador comando actualizar compania"})
public class ComandoControladorActualizarAnalistaCompania {

    private final ManejadorActualizarAnalistaCompania manejadorActualizarAnalistaCompania;


    @Autowired
    public ComandoControladorActualizarAnalistaCompania(ManejadorActualizarAnalistaCompania manejadorActualizarAnalistaCompania) {
        this.manejadorActualizarAnalistaCompania = manejadorActualizarAnalistaCompania;
    }

	@PutMapping(value="/{id}/{analistaid}")
	@ApiOperation("Actualizar analista Compania")
	public void actualizar(@RequestBody ComandoCompania comandoCompania,
						   @PathVariable Long id,
						   @PathVariable Long analistaid) {
		comandoCompania.setId(id);
		comandoCompania.setAnalistaid(analistaid);
		manejadorActualizarAnalistaCompania.ejecutar(comandoCompania);
	}
}
