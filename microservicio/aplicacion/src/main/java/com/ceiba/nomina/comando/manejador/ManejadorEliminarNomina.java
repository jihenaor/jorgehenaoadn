package com.ceiba.nomina.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.nomina.servicio.ServicioEliminarNomina;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarNomina implements ManejadorComando<Long> {

    private final ServicioEliminarNomina servicioEliminarNomina;

    public ManejadorEliminarNomina(ServicioEliminarNomina servicioEliminarNomina) {
        this.servicioEliminarNomina = servicioEliminarNomina;
    }

    public void ejecutar(Long idNomina) {
        this.servicioEliminarNomina.ejecutar(idNomina);
    }
}
