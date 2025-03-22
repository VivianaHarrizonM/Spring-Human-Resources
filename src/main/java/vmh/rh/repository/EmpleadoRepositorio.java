package vmh.rh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vmh.rh.model.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {

}
