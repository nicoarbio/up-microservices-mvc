package edu.palermo.implementacion1;

public class EmpleadoRelacionDependencia implements Empleado {

    private String nombre;
    private String apellido;
    private int edad;
    private double sueldoFijo;

    public EmpleadoRelacionDependencia(String nombre, String apellido, int edad, double sueldoFijo) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
        this.setSueldoFijo(sueldoFijo);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getApellido() {
        return apellido;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    public double getSueldoFijo() {
        return sueldoFijo;
    }

    public void setNombre(String nombre) {
        validateNombre(nombre);
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        validateApellido(apellido);
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        validateEdad(edad);
        this.edad = edad;
    }

    public void setSueldoFijo(double sueldoFijo) {
        if (sueldoFijo < 0) {
            throw new IllegalArgumentException("El sueldo fijo no puede ser negativo");
        }
        this.sueldoFijo = sueldoFijo;
    }

    @Override
    public double calcularSueldo() {
        return sueldoFijo;
    }

    @Override
    public String toString() {
        return "EmpleadoFreelance{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", sueldoFijo=" + sueldoFijo +
                ", sueldo=" + calcularSueldo() +
                '}';
    }

}
