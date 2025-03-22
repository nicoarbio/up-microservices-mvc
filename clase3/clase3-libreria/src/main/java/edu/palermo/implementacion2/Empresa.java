package edu.palermo.implementacion2;

import java.util.HashSet;
import java.util.Set;

public class Empresa {

    private String nombre;
    private String año;
    private String rubro;
    private Set<Empleado> empleados;

    public Empresa(String nombre, String año, String rubro) {
        this.nombre = nombre;
        this.año = año;
        this.rubro = rubro;
        this.empleados = new HashSet<>();
    }

    @Override
    public String toString() {
        return nombre + " (" + año + ")";
    }

    public void agregarEmpleado(Empleado empleado) {
        System.out.println("Dando de alta empleado: " + empleado.toString());
        if (!empleados.add(empleado)) {;
            throw new IllegalArgumentException("El empleado ya se encuentra en la empresa");
        }
    }

    public double obtenerSalariosTotales() {
        double salariosTotales = 0;
        for (Empleado empleado : empleados) {
            salariosTotales += empleado.calcularSueldo();
        }
        return salariosTotales;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAño() {
        return año;
    }

    public String getRubro() {
        return rubro;
    }

    public void setEmpresaToEmpleadoAdministrativo(EmpleadoAdministrativo empleadoAdministrativo) {
        if (empleadoAdministrativo == null) {
            throw new IllegalArgumentException("El empleado administrativo no puede ser nulo");
        }
        this.agregarEmpleado(empleadoAdministrativo);
        System.out.println("Vinculando a la empresa "+ this + ", el empleado administrativo: " + empleadoAdministrativo);
        empleadoAdministrativo.setEmpresa(this);
    }

}
