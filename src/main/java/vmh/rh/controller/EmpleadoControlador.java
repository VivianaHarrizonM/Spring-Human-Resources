package vmh.rh.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vmh.rh.exeption.RecursoNoEncontradoExepcion;
import vmh.rh.model.Empleado;
import vmh.rh.service.IEmpleadoServicio;

import java.util.List;

@RestController


//http://localhost:8080/rh-app/
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
  private static final Logger logger =
          LoggerFactory.getLogger(EmpleadoControlador.class);

  @Autowired
  private IEmpleadoServicio empleadoServicio;

// http://localhost:8080/rh-app/empleados
  @GetMapping("/empleados")
  public List<Empleado> obtenerEmpleados(){
    var empleados = empleadoServicio.listarEmpleados();
    empleados.forEach(empleado -> logger.info(empleado.toString()));
    return empleados;
  }


  @PostMapping("/empleados")
  public Empleado agregarEmpleado(@RequestBody Empleado empleado){
    logger.info("Empleado a agregar: " + empleado);
    return empleadoServicio.guardarEmpleado(empleado);
  }

  @GetMapping("/empleados/{id}")
  public ResponseEntity<Empleado> obternerEmpleadoPorId(@PathVariable Integer id){
    Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
    if (empleado == null)
        throw new RecursoNoEncontradoExepcion("No se encontro el empleado con el id: " + id);
    return ResponseEntity.ok(empleado);
  }

  @PutMapping("/empleados/{id}")
  public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado
                                                     empleadoRecibido){
    Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
    if (empleado == null)
      throw new RecursoNoEncontradoExepcion("El id ingresado no existe: " + id);
    empleado.setNombre(empleadoRecibido.getNombre());
    empleado.setDepartamento(empleadoRecibido.getDepartamento());
    empleado.setSueldo(empleadoRecibido.getSueldo());
    empleadoServicio.guardarEmpleado(empleado);
    return ResponseEntity.ok(empleado);
    
  }

}
