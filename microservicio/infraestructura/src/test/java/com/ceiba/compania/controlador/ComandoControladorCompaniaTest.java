package com.ceiba.compania.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.compania.servicio.testdatabuilder.ComandoCompaniaTestDataBuilder;
import com.ceiba.compania.comando.ComandoCompania;
import com.ceiba.compania.controlador.ComandoControladorCompania;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCompania.class)
public class ComandoControladorCompaniaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoCompania compania = new ComandoCompaniaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/companias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(compania)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoCompania compania = new ComandoCompaniaTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/companias/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(compania)))
                .andExpect(status().isOk());
    }
/*
    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/companias/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

 */
}
