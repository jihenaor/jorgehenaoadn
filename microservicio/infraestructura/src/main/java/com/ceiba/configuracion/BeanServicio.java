package com.ceiba.configuracion;

import com.ceiba.compania.puerto.repositorio.RepositorioCompania;
import com.ceiba.compania.servicio.ServicioActualizarAnalistaCompania;
import com.ceiba.compania.servicio.ServicioActualizarCompania;
import com.ceiba.compania.servicio.ServicioCrearCompania;
import com.ceiba.compania.servicio.ServicioEliminarCompania;
import com.ceiba.nomina.puerto.repositorio.RepositorioNomina;
import com.ceiba.nomina.servicio.ServicioActualizarNomina;
import com.ceiba.nomina.servicio.ServicioCrearNomina;
import com.ceiba.nomina.servicio.ServicioEliminarNomina;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearNomina servicioCrearNomina(RepositorioNomina repositorioNomina) {
        return new ServicioCrearNomina(repositorioNomina);
    }

    @Bean
    public ServicioEliminarNomina servicioEliminarNomina(RepositorioNomina repositorioNomina) {
        return new ServicioEliminarNomina(repositorioNomina);
    }

    @Bean
    public ServicioActualizarNomina servicioActualizarNomina(RepositorioNomina repositorioNomina) {
        return new ServicioActualizarNomina(repositorioNomina);
    }

    @Bean
    public ServicioCrearCompania servicioCrearCompania(RepositorioCompania repositorioCompania) {
        return new ServicioCrearCompania(repositorioCompania);
    }

    @Bean
    public ServicioEliminarCompania servicioEliminarCompania(RepositorioCompania repositorioCompania) {
        return new ServicioEliminarCompania(repositorioCompania);
    }

    @Bean
    public ServicioActualizarCompania servicioActualizarCompania(RepositorioCompania repositorioCompania) {
        return new ServicioActualizarCompania(repositorioCompania);
    }

    @Bean
    public ServicioActualizarAnalistaCompania servicioActualizarAnalistaCompania(RepositorioCompania repositorioCompania) {
        return new ServicioActualizarAnalistaCompania(repositorioCompania);
    }
}
