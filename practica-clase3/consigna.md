Maven - Práctica
El sistema requiere poder interactuar con los empleados de una empresa, de dicha empresa se sabe su nombre (dato obligatorio) y año de inicio de actividad (obligatorio) y rubro.
Los empleados tendrán nombre, apellido y edad como datos obligatorios, pero existen empleados que trabajan por hora a un precio hora fijo y empleados que ganan un sueldo fijo, independientemente del tipo, saben calcular su sueldo.
Existe un empleado administrativo que se encarga de dar de alta nuevos empleados en la empresa y determinar el salario total que la empresa tiene que pagar dados todos sus empleados.
Consignas:
Codificar la lógica solicitada en el enunciado en un proyecto individual que sea luego empaquetado por Maven, manejar excepciones donde crea conveniente.
Generar un nuevo proyecto Maven que tome la dependencia del punto anterior y simule la interacción entre los objetos del model.


Maven - Práctica
Empresa
- nombre (dato obligatorio)
- año de inicio de actividad (obligatorio)
- rubro.

Empleados
- nombre
- apellido
- edad
- por hora a un precio hora fijo
- sueldo fijo
+ calcularSueldo()

Empleado administrativo
+ darDeAltaEmpleado()
+ obtenerSalariosTotales()


Los empleados tendrán nombre, apellido y edad como datos obligatorios, pero existen empleados que trabajan por hora a un precio hora fijo y empleados que ganan un sueldo fijo, independientemente del tipo, saben calcular su sueldo.
Existe un empleado administrativo que se encarga de dar de alta nuevos empleados en la empresa y determinar el salario total que la empresa tiene que pagar dados todos sus empleados.
Consignas:
Codificar la lógica solicitada en el enunciado en un proyecto individual que sea luego empaquetado por Maven, manejar excepciones donde crea conveniente.
Generar un nuevo proyecto Maven que tome la dependencia del punto anterior y simule la interacción entre los objetos del model.
