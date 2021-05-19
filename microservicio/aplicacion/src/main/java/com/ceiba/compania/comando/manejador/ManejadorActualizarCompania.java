package com.ceiba.compania.comando.manejador;

import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.comando.fabrica.FabricaCompania;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.compania.modelo.entidad.Compania;
import com.ceiba.compania.servicio.ServicioActualizarCompania;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCompania implements ManejadorComando<ComandoCompania> {

    private final FabricaCompania fabricaCompania;
    private final ServicioActualizarCompania servicioActualizarCompania;

    public ManejadorActualizarCompania(FabricaCompania fabricaCompania, ServicioActualizarCompania servicioActualizarCompania) {
        this.fabricaCompania = fabricaCompania;
        this.servicioActualizarCompania = servicioActualizarCompania;
    }

    public void ejecutar(ComandoCompania comandoCompania) {
        Compania compania = this.fabricaCompania.crear(comandoCompania);
        this.servicioActualizarCompania.ejecutar(compania);
    }
}
