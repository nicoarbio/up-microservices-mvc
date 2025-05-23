package edu.palermo.clase4.service;

import edu.palermo.clase4.model.Empleado;
import edu.palermo.clase4.model.administracion.EmpleadoAdministrativo;
import edu.palermo.clase4.model.administracion.Empresa;
import edu.palermo.clase4.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpleadoAdministrativo convertirEmpleadoAdministrativo(Empresa empresa, Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        } else {
            this.agregarEmpleado(empleado);
            var administrativo = new EmpleadoAdministrativo(empleado, empresa);
            System.out.println("La empresa " + empresa + ", tiene un nuevo empleado administrativo: " + administrativo);
            return administrativo;
        }
    }

    protected void agregarEmpleado(Empleado empleado) {
        System.out.println("Dando de alta empleado: " + empleado.toString());
        empresaRepository.agregarEmpleado(empleado);
    }


}
