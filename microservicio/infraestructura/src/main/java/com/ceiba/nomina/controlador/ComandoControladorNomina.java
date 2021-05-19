package com.ceiba.nomina.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.nomina.comando.ComandoNomina;
import com.ceiba.nomina.comando.manejador.ManejadorActualizarNomina;
import com.ceiba.nomina.comando.manejador.ManejadorCrearNomina;
import com.ceiba.nomina.comando.manejador.ManejadorEliminarNomina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/nominas")
@Api(tags = { "Controlador comando nomina"})
public class ComandoControladorNomina {

    private final ManejadorCrearNomina manejadorCrearNomina;
	private final ManejadorEliminarNomina manejadorEliminarNomina;
	private final ManejadorActualizarNomina manejadorActualizarNomina;

    @Autowired
    public ComandoControladorNomina(ManejadorCrearNomina manejadorCrearNomina,
									ManejadorEliminarNomina manejadorEliminarNomina,
									ManejadorActualizarNomina manejadorActualizarNomina) {
        this.manejadorCrearNomina = manejadorCrearNomina;
		this.manejadorEliminarNomina = manejadorEliminarNomina;
		this.manejadorActualizarNomina = manejadorActualizarNomina;
    }

    @PostMapping
    @ApiOperation("Crear Nomina")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoNomina comandoNomina) {
        return manejadorCrearNomina.ejecutar(comandoNomina);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Nomina")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarNomina.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Nomina")
	public void actualizar(@RequestBody ComandoNomina comandoNomina, @PathVariable Long id) {
		comandoNomina.setId(id);
		manejadorActualizarNomina.ejecutar(comandoNomina);
	}
}
