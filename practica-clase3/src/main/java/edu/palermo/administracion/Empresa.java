package edu.palermo.administracion;

import edu.palermo.Empleado;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nombre;
    private String año;
    private String rubro;
    private List<Empleado> empleados;

    private EmpleadoAdministrativo empleadoAdministrativo;

    public Empresa(String nombre, String año, String rubro) {
        this.nombre = nombre;
        this.año = año;
        this.rubro = rubro;
        this.empleados = new ArrayList<>();
    }

    protected void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
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

    public EmpleadoAdministrativo getEmpleadoAdministrativo() {
        return empleadoAdministrativo;
    }

    public void setEmpleadoAdministrativo(EmpleadoAdministrativo empleadoAdministrativo) {
        if (empleadoAdministrativo == null) {
            throw new IllegalArgumentException("El empleado administrativo no puede ser nulo");
        }
        this.empleadoAdministrativo = empleadoAdministrativo;
    }

}
