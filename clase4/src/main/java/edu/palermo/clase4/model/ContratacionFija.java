package edu.palermo.clase4.model;

public class ContratacionFija implements Contratacion {

    private double sueldoFijo;

    public ContratacionFija(double sueldoFijo) {
        this.setSueldoFijo(sueldoFijo);
    }

    @Override
    public double calcularSueldo() {
        return this.getSueldoFijo();
    }

    @Override
    public String toString() {
        return "ContratacionFija{" +
                "sueldoFijo='" + sueldoFijo + '\'' +
                '}';
    }

    public double getSueldoFijo() {
        return sueldoFijo;
    }

    public void setSueldoFijo(double sueldoFijo) {
        if (sueldoFijo < 0) {
            throw new IllegalArgumentException("El sueldo fijo no puede ser negativo");
        }
        this.sueldoFijo = sueldoFijo;
    }

}
