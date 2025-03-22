package edu.palermo.implementacion2;

public class Empleado {

    private String nombre;
    private String apellido;
    private int edad;
    private Contratacion tipoDeContratacion;

    public Empleado(String nombre, String apellido, int edad, Contratacion tipoDeContratacion) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
        this.setTipoDeContratacion(tipoDeContratacion);
    }

    public double calcularSueldo() {
        return tipoDeContratacion.calcularSueldo();
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", tipoDeContratacion=" + tipoDeContratacion.toString() +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser nulo ni vacío");
        }
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("No puede ser menor de edad");
        }
        this.edad = edad;
    }

    public void setTipoDeContratacion(Contratacion tipoDeContratacion) {
        if (tipoDeContratacion == null) {
            throw new IllegalArgumentException("El tipo de contratación no puede ser nula");
        }
        this.tipoDeContratacion = tipoDeContratacion;
    }

}
