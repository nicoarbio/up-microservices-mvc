package edu.palermo.clase4.model;

public class ContratacionFreelance implements Contratacion {

    private double sueldoPorHora;
    private int horasTrabajadas;

    public ContratacionFreelance(double sueldoPorHora, int horasTrabajadasInicial) {
        this.setSueldoPorHora(sueldoPorHora);
        this.setHorasTrabajadas(horasTrabajadasInicial);
    }

    @Override
    public double calcularSueldo() {
        return this.getSueldoPorHora() * this.getHorasTrabajadas();
    }

    @Override
    public String toString() {
        return "ContratacionFreelance{" +
                "sueldoPorHora='" + sueldoPorHora + '\'' +
                ", horasTrabajadas='" + horasTrabajadas + '\'' +
                '}';
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

}
