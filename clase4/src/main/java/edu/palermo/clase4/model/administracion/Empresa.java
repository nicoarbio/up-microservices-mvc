package edu.palermo.clase4.model.administracion;

import edu.palermo.clase4.model.Empleado;

import java.util.HashSet;
import java.util.Set;

public class Empresa {

    private String nombre;
    private String año;
    private String rubro;
    private EmpleadoAdministrativo administrativo;
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

    protected void agregarEmpleado(Empleado empleado) {
        System.out.println("Dando de alta empleado: " + empleado.toString());
        if (!empleados.add(empleado)) {;
            throw new IllegalArgumentException("El empleado ya se encuentra en la empresa");
        }
    }

    protected double obtenerSalariosTotales() {
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

    public EmpleadoAdministrativo getAdministrativo() {
        return administrativo;
    }

    public EmpleadoAdministrativo convertirEnAdministrativo(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        this.agregarEmpleado(empleado);
        this.administrativo = new EmpleadoAdministrativo(empleado, this);
        System.out.println("La empresa " + this + ", tiene un nuevo empleado administrativo: " + this.administrativo);
        return this.administrativo;
    }

}
