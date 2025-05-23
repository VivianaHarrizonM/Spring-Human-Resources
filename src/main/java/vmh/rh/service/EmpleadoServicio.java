package vmh.rh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vmh.rh.model.Empleado;
import vmh.rh.repository.EmpleadoRepositorio;

import java.util.List;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{
  @Autowired
  private EmpleadoRepositorio empleadoRepositorio;

  @Override
  public List<Empleado> listarEmpleados() {
    return empleadoRepositorio.findAll();
  }

  @Override
  public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
    Empleado empleado = empleadoRepositorio.findById(idEmpleado).orElse(null);
    return empleado;
  }

  @Override
  public Empleado guardarEmpleado(Empleado empleado) {
    return empleadoRepositorio.save(empleado);
  }

  @Override
  public void eliminarEmpleado(Empleado empleado) {
    empleadoRepositorio.delete(empleado);
  }
}
