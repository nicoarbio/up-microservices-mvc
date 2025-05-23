package edu.palermo.clase4;


import edu.palermo.clase4.model.ContratacionFreelance;
import edu.palermo.clase4.model.Empleado;
import edu.palermo.clase4.model.administracion.Empresa;
import edu.palermo.clase4.view.Presentacion;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main implements InitializingBean {

    ApplicationContext context;
    Empresa up;
    Presentacion presentacion;

    public Main(ApplicationContext applicationContext,
                Empresa up,
                Presentacion presentacion
    ) {
        this.up = up;
        this.context = applicationContext;
        this.presentacion = presentacion;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        context.getBean("nico", Empleado.class);


        Empleado empleadoNico = new Empleado("Nico", "Palermo", 25, new ContratacionFreelance(1000, 10));

        presentacion.darAltaEmpleado(empleadoNico);

    }
}
