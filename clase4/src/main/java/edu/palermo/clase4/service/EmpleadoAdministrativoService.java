package edu.palermo.clase4.service;

import edu.palermo.clase4.model.Empleado;
import edu.palermo.clase4.model.administracion.EmpleadoAdministrativo;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoAdministrativoService {

    private EmpleadoAdministrativo empleadoAdministrativo;

    public EmpleadoAdministrativoService(EmpleadoAdministrativo empleadoAdministrativo) {
        this.empleadoAdministrativo = empleadoAdministrativo;
    }

    public void darDeAltaEmpleado(Empleado empleado) {
        empleadoAdministrativo.darDeAltaEmpleado(empleado);
    }

}
