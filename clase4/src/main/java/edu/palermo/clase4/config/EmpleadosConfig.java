package edu.palermo.clase4.config;

import edu.palermo.clase4.model.ContratacionFreelance;
import edu.palermo.clase4.model.Empleado;
import edu.palermo.clase4.model.administracion.EmpleadoAdministrativo;
import edu.palermo.clase4.model.administracion.Empresa;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmpleadosConfig {

    @Bean
    public Empleado nico() {
        return new Empleado("Nico", "Palermo", 25, new ContratacionFreelance(1000, 10));
    }

}
