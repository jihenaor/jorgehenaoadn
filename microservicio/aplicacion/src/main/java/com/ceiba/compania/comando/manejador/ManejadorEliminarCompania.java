package com.ceiba.compania.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.compania.servicio.ServicioEliminarCompania;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarCompania implements ManejadorComando<Long> {

    private final ServicioEliminarCompania servicioEliminarCompania;

    public ManejadorEliminarCompania(ServicioEliminarCompania servicioEliminarCompania) {
        this.servicioEliminarCompania = servicioEliminarCompania;
    }

    public void ejecutar(Long idCompania) {
        this.servicioEliminarCompania.ejecutar(idCompania);
    }
}
