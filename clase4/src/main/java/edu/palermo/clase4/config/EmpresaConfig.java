package edu.palermo.clase4.config;

import edu.palermo.clase4.model.administracion.Empresa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpresaConfig {

    @Bean
    public Empresa up() {
        return new Empresa("UP", "Universidad de Palermo", "Av. Independencia 1234");
    }

}
