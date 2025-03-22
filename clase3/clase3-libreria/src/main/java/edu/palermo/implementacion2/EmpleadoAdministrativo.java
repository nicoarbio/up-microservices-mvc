package edu.palermo.implementacion2;

public class EmpleadoAdministrativo extends Empleado {

    private Empresa empresa;

    public EmpleadoAdministrativo(String nombre, String apellido, int edad, Contratacion tipoDeContratacion) {
        super(nombre, apellido, edad, tipoDeContratacion);
    }

    @Override
    public String toString() {
        return "[ADMINISTRATIVO] " + super.toString();
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

    public void setEmpresa(Empresa empresa) {
        if (empresa == null) {
            throw new IllegalArgumentException("La empresa no puede ser nula");
        }
        this.empresa = empresa;
    }

}
