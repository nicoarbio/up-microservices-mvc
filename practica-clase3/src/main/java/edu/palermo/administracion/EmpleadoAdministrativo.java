package edu.palermo.administracion;

import edu.palermo.Empleado;

public class EmpleadoAdministrativo {

    private Empleado empleado;
    private Empresa empresa;

    public EmpleadoAdministrativo(Empleado empleado, Empresa empresa) {
        this.empleado = empleado;
        this.empresa = empresa;
    }

    /**
     + darDeAltaEmpleado()
     + obtenerSalariosTotales()
     */

    public void darDeAltaEmpleado(Empleado empleado) {
        System.out.println("Agregando empleado: " + empleado.toString());
        empresa.agregarEmpleado(empleado);
    }

    public double obtenerSalariosTotales() {
        return empresa.obtenerSalariosTotales();
    }


}
