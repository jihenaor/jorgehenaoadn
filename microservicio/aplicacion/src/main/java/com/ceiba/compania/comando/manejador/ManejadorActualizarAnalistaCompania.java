package com.ceiba.compania.comando.manejador;

import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.comando.fabrica.FabricaCompania;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.servicio.ServicioActualizarAnalistaCompania;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarAnalistaCompania implements ManejadorComando<ComandoCompania> {

    private final FabricaCompania fabricaCompania;
    private final ServicioActualizarAnalistaCompania servicioActualizarAnalistaCompania;

    public ManejadorActualizarAnalistaCompania(FabricaCompania fabricaCompania, ServicioActualizarAnalistaCompania servicioActualizarAnalistaCompania) {
        this.fabricaCompania = fabricaCompania;
        this.servicioActualizarAnalistaCompania = servicioActualizarAnalistaCompania;
    }

    public void ejecutar(ComandoCompania comandoCompania) {
        Compania compania = this.fabricaCompania.crear(comandoCompania);
        this.servicioActualizarAnalistaCompania.ejecutar(compania);
    }
}
