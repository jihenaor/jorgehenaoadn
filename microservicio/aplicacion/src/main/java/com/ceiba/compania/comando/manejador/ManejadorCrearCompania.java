package com.ceiba.compania.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.comando.fabrica.FabricaCompania;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.servicio.ServicioCrearCompania;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCompania implements ManejadorComandoRespuesta<ComandoCompania, ComandoRespuesta<Long>> {

    private final FabricaCompania fabricaCompania;
    private final ServicioCrearCompania servicioCrearCompania;

    public ManejadorCrearCompania(FabricaCompania fabricaCompania, ServicioCrearCompania servicioCrearCompania) {
        this.fabricaCompania = fabricaCompania;
        this.servicioCrearCompania = servicioCrearCompania;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCompania comandoCompania) {
        Compania compania = this.fabricaCompania.crear(comandoCompania);
        return new ComandoRespuesta<>(this.servicioCrearCompania.ejecutar(compania));
    }
}
