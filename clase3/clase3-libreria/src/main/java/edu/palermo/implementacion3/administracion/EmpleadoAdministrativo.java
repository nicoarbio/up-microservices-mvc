package edu.palermo.implementacion3.administracion;

import edu.palermo.implementacion3.Empleado;

public class EmpleadoAdministrativo {

    private Empleado empleado;
    private Empresa empresa;

    protected EmpleadoAdministrativo(Empleado empleado, Empresa empresa) {
        this.setEmpleado(empleado);
        this.setEmpresa(empresa);
    }

    @Override
    public String toString() {
        return "[ADMINISTRATIVO de " + empresa.toString() + "] " + empleado.toString();
    }

    public void darDeAltaEmpleado(Empleado empleado) {
        if (empresa == null) {
            throw new IllegalArgumentException("El empleado administrativo no tiene empresa vinculada para dar de alta otros empleados");
        }
        empresa.agregarEmpleado(empleado);
    }

    public double obtenerSalariosTotales() {
        if (empresa == null) {
            throw new IllegalArgumentException("Este empleado administrativo no tiene una empresa asignada");
        }
        return empresa.obtenerSalariosTotales();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpresa(Empresa empresa) {
        if (empresa == null) {
            throw new IllegalArgumentException("La empresa no puede ser nula");
        }
        this.empresa = empresa;
    }

    public void setEmpleado(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        this.empleado = empleado;
    }

}
