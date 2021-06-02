package com.ceiba.consultanomina.comando.fabrica;

import com.ceiba.consultanomina.comando.ComandoConsultanomina;
import com.ceiba.consultanomina.modelo.entidad.Consultanomina;
import com.ceiba.consultanomina.modelo.entidad.Consultanomina;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaConsultanomina {

    public Consultanomina crear(ComandoConsultanomina comandoConsultanomina) {
        return new Consultanomina(
                comandoConsultanomina.getTipodocumento(),
                comandoConsultanomina.getNumerodocumento(),
                comandoConsultanomina.getRazonsocial(),
                comandoConsultanomina.getAnalistaid(),
                comandoConsultanomina.getId(),
                comandoConsultanomina.getDocumentoempleado(),
                comandoConsultanomina.getPeriodo(),
                comandoConsultanomina.getValor(),
                comandoConsultanomina.getCompaniaid(),
                LocalDateTime.now()
        );
    }

}
