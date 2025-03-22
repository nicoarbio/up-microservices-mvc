package edu.palermo;

import edu.palermo.implementacion2.ContratacionFija;
import edu.palermo.implementacion2.ContratacionFreelance;
import edu.palermo.implementacion2.Empleado;
import edu.palermo.implementacion2.EmpleadoAdministrativo;
import edu.palermo.implementacion2.Empresa;

public class MainImplementacion2 {

    public static void main(String[] args) {
        System.out.println("Prueba con implementación 2");
        Empresa up = new Empresa("Palermo", "2021", "Educación");

        Empleado nico = new Empleado("Nico", "Palermo", 25, new ContratacionFreelance(1000, 10));
        Empleado mati = new Empleado("Mati", "Palermo", 25, new ContratacionFreelance(1000, 10));
        Empleado juan = new Empleado("Juan", "Palermo", 25, new ContratacionFreelance(1000, 10));
        Empleado chris = new Empleado("Chris", "Palermo", 25, new ContratacionFija(50000));
        EmpleadoAdministrativo adam = new EmpleadoAdministrativo("Adam", "Palermo", 25, new ContratacionFija(60000));

        // En este punto el empleado administrativo no tiene una empresa asociada, por lo que un intento de agregar empleados fallará
        try {
            adam.darDeAltaEmpleado(nico);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }

        // En este paso asociamos la empresa con el empleado administrativo
        up.setEmpresaToEmpleadoAdministrativo(adam);

        // De esta forma podemos agregar empleados a la empresa a través del empleado administrativo
        // Y a su vez vemos como aumentan los salarios totales
        System.out.println("Salarios totales: " + adam.obtenerSalariosTotales());
        adam.darDeAltaEmpleado(nico);
        System.out.println("Salarios totales: " + adam.obtenerSalariosTotales());
        adam.darDeAltaEmpleado(mati);
        System.out.println("Salarios totales: " + adam.obtenerSalariosTotales());
        adam.darDeAltaEmpleado(juan);
        System.out.println("Salarios totales: " + adam.obtenerSalariosTotales());
        adam.darDeAltaEmpleado(chris);
        System.out.println("Salarios totales: " + adam.obtenerSalariosTotales());

        // Si revisamos, al hacer el `setEmpresaToEmpleadoAdministrativo` se da de alta el empleado a la empresa
        // Por lo que si volvemos a darlo de alta fallará
        // (Dado que usamos un Set para almacenar los empleados, donde no se permiten duplicados y nosotros lanzamos una Excepción)
        try {
            System.out.println("Intentando agregar nuevamente a Adam...");
            adam.darDeAltaEmpleado(adam);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }
        try {
            System.out.println("Intentando agregar nuevamente a Nico...");
            adam.darDeAltaEmpleado(nico);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }


    }

}
