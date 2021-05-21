package com.ceiba.compania.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.comando.manejador.ManejadorActualizarCompania;
import com.ceiba.compania.comando.manejador.ManejadorCrearCompania;
import com.ceiba.compania.comando.manejador.ManejadorEliminarCompania;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companias")
@Api(tags = { "Controlador comando compania"})
public class ComandoControladorCompania {

    private final ManejadorCrearCompania manejadorCrearCompania;
	private final ManejadorEliminarCompania manejadorEliminarCompania;
	private final ManejadorActualizarCompania manejadorActualizarCompania;

    @Autowired
    public ComandoControladorCompania(ManejadorCrearCompania manejadorCrearCompania,
									  ManejadorEliminarCompania manejadorEliminarCompania,
									  ManejadorActualizarCompania manejadorActualizarCompania) {
        this.manejadorCrearCompania = manejadorCrearCompania;
		this.manejadorEliminarCompania = manejadorEliminarCompania;
		this.manejadorActualizarCompania = manejadorActualizarCompania;
    }

    @PostMapping
    @ApiOperation("Crear Compania")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCompania comandoCompania) {
		return manejadorCrearCompania.ejecutar(comandoCompania);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Compania")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCompania.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Compania")
	public void actualizar(@RequestBody ComandoCompania comandoCompania,@PathVariable Long id) {
		comandoCompania.setId(id);
		manejadorActualizarCompania.ejecutar(comandoCompania);
	}
}
