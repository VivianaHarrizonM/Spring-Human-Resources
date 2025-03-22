package vmh.rh.service;

import vmh.rh.model.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
  public List<Empleado> listarEmpleados();

  public Empleado buscarEmpleadoPorId(Integer idEmpleado);

  public Empleado guardarEmpleado(Empleado empleado);

  public void eliminarEmpleado(Empleado empleado);
}
