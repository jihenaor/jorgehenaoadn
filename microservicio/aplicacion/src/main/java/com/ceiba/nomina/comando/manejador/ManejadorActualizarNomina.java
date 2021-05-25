package com.ceiba.nomina.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.nomina.modelo.entidad.Nomina;
import com.ceiba.nomina.servicio.ServicioActualizarNomina;
import org.springframework.stereotype.Component;

import com.ceiba.nomina.comando.ComandoNomina;
import com.ceiba.nomina.comando.fabrica.FabricaNomina;

@Component
public class ManejadorActualizarNomina implements ManejadorComando<ComandoNomina> {

    private final FabricaNomina fabricaNomina;
    private final ServicioActualizarNomina servicioActualizarNomina;

    public ManejadorActualizarNomina(FabricaNomina fabricaNomina, ServicioActualizarNomina servicioActualizarNomina) {
        System.out.println("Paso por consructor-ManejadorActualizarNomina ");
        this.fabricaNomina = fabricaNomina;
        this.servicioActualizarNomina = servicioActualizarNomina;
    }

    public void ejecutar(ComandoNomina comandoNomina) {
        System.out.println("Paso por ejecutar-ManejadorActualizarNomina ");
        Nomina nomina = this.fabricaNomina.crear(comandoNomina);
        this.servicioActualizarNomina.ejecutar(nomina);
    }
}
