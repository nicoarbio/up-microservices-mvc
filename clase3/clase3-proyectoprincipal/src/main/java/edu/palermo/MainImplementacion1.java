package edu.palermo;

import edu.palermo.implementacion1.Empleado;
import edu.palermo.implementacion1.EmpleadoFreelance;
import edu.palermo.implementacion1.EmpleadoRelacionDependencia;
import edu.palermo.implementacion1.administracion.EmpleadoAdministrativo;
import edu.palermo.implementacion1.administracion.Empresa;

public class MainImplementacion1 {

    public static void main(String[] args) {
        System.out.println("Prueba con implementación 1");
        Empresa up = new Empresa("Palermo", "2021", "Educación");

        Empleado nico = new EmpleadoFreelance("Nico", "Palermo", 25, 1000, 10);
        Empleado mati = new EmpleadoFreelance("Mati", "Palermo", 25, 1000, 10);
        Empleado juan = new EmpleadoFreelance("Juan", "Palermo", 25, 1000, 10);
        Empleado chris = new EmpleadoRelacionDependencia("Chris", "Palermo", 25, 50000);
        Empleado adam = new EmpleadoRelacionDependencia("Adam", "Palermo", 25, 60000);

        EmpleadoAdministrativo admin = new EmpleadoAdministrativo(nico, up);

        up.setEmpleadoAdministrativo(admin);

        admin.darDeAltaEmpleado(nico);
        admin.darDeAltaEmpleado(mati);
        admin.darDeAltaEmpleado(juan);
        admin.darDeAltaEmpleado(chris);
        admin.darDeAltaEmpleado(adam);
    }

}
