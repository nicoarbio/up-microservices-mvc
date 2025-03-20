package edu.palermo;

public class EmpleadoFreelance implements Empleado {

    private String nombre;
    private String apellido;
    private int edad;
    private double sueldoPorHora;
    private int horasTrabajadas;

    public EmpleadoFreelance(String nombre, String apellido, int edad, double sueldoPorHora, int horasTrabajadasInicial) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEdad(edad);
        this.setSueldoPorHora(sueldoPorHora);
        this.setHorasTrabajadas(horasTrabajadasInicial);
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

    public double getSueldoPorHora() {
        return sueldoPorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public int aumentarHorasTrabajadasEn(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        }
        horasTrabajadas += horas;
        return horasTrabajadas;
    }

    public int restarHorasTrabajadasEn(int horas) {
        if (horas < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        } else if (horas > horasTrabajadas) {
            throw new IllegalArgumentException("No se pueden restar más horas de las trabajadas");
        }
        horasTrabajadas -= horas;
        return horasTrabajadas;
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

    public void setHorasTrabajadas(int horasTrabajadas) {
        if (horasTrabajadas < 0) {
            throw new IllegalArgumentException("Las horas no pueden ser negativas");
        }
        this.horasTrabajadas = horasTrabajadas;
    }

    public void setSueldoPorHora(double sueldoPorHora) {
        if (sueldoPorHora < 0) {
            throw new IllegalArgumentException("El sueldo por hora no puede ser negativo");
        }
        this.sueldoPorHora = sueldoPorHora;
    }

    @Override
    public double calcularSueldo() {
        return sueldoPorHora * horasTrabajadas;
    }

    @Override
    public String toString() {
        return "EmpleadoFreelance{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", sueldoPorHora=" + sueldoPorHora +
                ", horasTrabajadas=" + horasTrabajadas +
                ", sueldo=" + calcularSueldo() +
                '}';
    }

}
