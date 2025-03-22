package edu.palermo.implementacion1;

public interface Empleado {

    public double calcularSueldo();

    String getNombre();

    String getApellido();

    int getEdad();

    default void validateNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo ni vacío");
        }
    }

    default void validateApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede ser nulo ni vacío");
        }
    }

    default void validateEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("No puede ser menor de edad");
        }
    }

}
