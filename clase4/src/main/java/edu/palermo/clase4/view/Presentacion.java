package edu.palermo.clase4.view;

import edu.palermo.clase4.model.Contratacion;
import edu.palermo.clase4.model.Empleado;
import edu.palermo.clase4.model.administracion.EmpleadoAdministrativo;
import edu.palermo.clase4.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Presentacion {

    // desde empresa calcular sueldos y agregarlos a la lista

    private final EmpresaService empresaService;

    @Autowired
    public Presentacion(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    public void darAltaEmpleado(Empleado empleado) {


    }









}
