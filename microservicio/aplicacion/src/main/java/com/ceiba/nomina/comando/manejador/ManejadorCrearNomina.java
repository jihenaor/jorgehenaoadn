package com.ceiba.nomina.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.servicio.ServicioCrearNomina;
import org.springframework.stereotype.Component;

import com.ceiba.nomina.comando.ComandoNomina;
import com.ceiba.nomina.comando.fabrica.FabricaNomina;

@Component
public class ManejadorCrearNomina implements ManejadorComandoRespuesta<ComandoNomina, ComandoRespuesta<Long>> {

    private final FabricaNomina fabricaNomina;
    private final ServicioCrearNomina servicioCrearNomina;

    public ManejadorCrearNomina(FabricaNomina fabricaNomina, ServicioCrearNomina servicioCrearNomina) {
        this.fabricaNomina = fabricaNomina;
        this.servicioCrearNomina = servicioCrearNomina;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoNomina comandoNomina) {
        Nomina usuario = this.fabricaNomina.crear(comandoNomina);
        return new ComandoRespuesta<>(this.servicioCrearNomina.ejecutar(usuario));
    }
}
