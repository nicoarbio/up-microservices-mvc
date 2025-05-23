package edu.palermo.clase4.repository;

import edu.palermo.clase4.model.Empleado;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class EmpresaRepository {

    private Set<Empleado> empleados;

    public void agregarEmpleado(Empleado empleado) {
        if (!empleados.add(empleado)) {
            throw new IllegalArgumentException("El empleado ya se encuentra en la empresa");
        }
    }

    public Set<Empleado> getAllEmpleados() {
        return empleados;
    }

}
