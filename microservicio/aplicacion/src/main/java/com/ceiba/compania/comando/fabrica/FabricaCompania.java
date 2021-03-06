package com.ceiba.compania.comando.fabrica;

import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.modelo.entidad.Compania;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaCompania {

    public Compania crear(ComandoCompania comandoCompania) {
        return new Compania(
                comandoCompania.getId(),
                comandoCompania.getTipodocumento(),
                comandoCompania.getNumerodocumento(),
                comandoCompania.getRazonsocial(),
                comandoCompania.getAnalistaid(),
                LocalDateTime.now()
        );
    }

}
