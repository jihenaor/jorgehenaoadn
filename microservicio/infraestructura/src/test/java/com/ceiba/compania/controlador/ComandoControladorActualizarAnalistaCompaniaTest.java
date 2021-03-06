package com.ceiba.compania.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.servicio.testdatabuilder.ComandoCompaniaTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCompania.class)
public class ComandoControladorActualizarAnalistaCompaniaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 1L;
        Long analistaid = 1L;
        ComandoCompania compania = new ComandoCompaniaTestDataBuilder()
                .conNumerodocumento("816609903")
                .conId(id)
                .conAnalistaid(analistaid)
                .build();

        // act - assert
        mocMvc.perform(put("/companias/{id}/{analistaid}", id, analistaid)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(compania)))
                .andExpect(status().isOk());
    }
}
