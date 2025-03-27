package edu.palermo;

import edu.palermo.implementacion3.ContratacionFija;
import edu.palermo.implementacion3.ContratacionFreelance;
import edu.palermo.implementacion3.Empleado;
import edu.palermo.implementacion3.administracion.EmpleadoAdministrativo;
import edu.palermo.implementacion3.administracion.Empresa;

public class MainImplementacion3 {

    public static void main(String[] args) {
        System.out.println("Prueba con implementación 3");
        Empresa up = new Empresa("Palermo", "2021", "Educación");

        Empleado nico = new Empleado("Nico", "Palermo", 25, new ContratacionFreelance(1000, 10));
        Empleado mati = new Empleado("Mati", "Palermo", 25, new ContratacionFreelance(1000, 10));
        Empleado juan = new Empleado("Juan", "Palermo", 25, new ContratacionFreelance(1000, 10));
        Empleado chris = new Empleado("Chris", "Palermo", 25, new ContratacionFija(50000));
        Empleado adam = new Empleado("Adam", "Palermo", 25, new ContratacionFija(60000));

        // En este paso asociamos la empresa con el empleado administrativo
        EmpleadoAdministrativo admin = up.convertirEnAdministrativo(adam);
        System.out.println("NOTA DEBUG: Es el admin que acabamos de convertir, el mismo admin que tiene la empresa? " + admin.equals(up.getAdministrativo()));

        // Al utilizar la arquitectura de paquetes, podemos hacer protegida la creación directa de EmpleadosAdministrativos, dejandole ese poder únicamente a quienes están en dicho paquete: solo la empresa tiene el poder de convertir un empleado en un empleado administrativo
        // Nota: descomentar la linea de abajo para ver el error de compilación:
        // var tmp = new EmpleadoAdministrativo(nico, up);

        // De esta forma podemos agregar empleados a la empresa a través del empleado administrativo
        // Y a su vez vemos como aumentan los salarios totales
        System.out.println("Salarios totales: " + admin.obtenerSalariosTotales());
        admin.darDeAltaEmpleado(nico);
        System.out.println("Salarios totales: " + admin.obtenerSalariosTotales());
        admin.darDeAltaEmpleado(mati);
        System.out.println("Salarios totales: " + admin.obtenerSalariosTotales());
        admin.darDeAltaEmpleado(juan);
        System.out.println("Salarios totales: " + admin.obtenerSalariosTotales());
        admin.darDeAltaEmpleado(chris);
        System.out.println("Salarios totales: " + admin.obtenerSalariosTotales());

        // Si revisamos, al hacer el `setEmpresaToEmpleadoAdministrativo` se da de alta el empleado a la empresa
        // Por lo que si volvemos a darlo de alta fallará
        // (Dado que usamos un Set para almacenar los empleados, donde no se permiten duplicados y nosotros lanzamos una Excepción)
        try {
            System.out.println("Intentando agregar nuevamente a Adam...");
            admin.darDeAltaEmpleado(adam);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }

        try {
            System.out.println("Intentando agregar nuevamente a Nico...");
            admin.darDeAltaEmpleado(nico);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }

    }

}
