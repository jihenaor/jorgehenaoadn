package com.ceiba.nomina.comando.fabrica;

import com.ceiba.nomina.modelo.entidad.Nomina;
import org.springframework.stereotype.Component;

import com.ceiba.nomina.comando.ComandoNomina;

import java.time.LocalDateTime;

@Component
public class FabricaNomina {

    public Nomina crear(ComandoNomina comandoNomina) {
        return new Nomina(
                comandoNomina.getId(),
                comandoNomina.getDocumentoempleado(),
                comandoNomina.getPeriodo(),
                comandoNomina.getValor(),
                comandoNomina.getCompaniaid(),
                LocalDateTime.now()
        );
    }

}
