package co.edu.udea.inf.parcial.bsn;

import co.edu.udea.inf.parcial.dao.EmpleadoDAO;
import co.edu.udea.inf.parcial.dao.impl.EmpleadoDAOList;
import co.edu.udea.inf.parcial.model.Empleado;

public class EmpleadoBsn {

    EmpleadoDAO empleadoDAO = new EmpleadoDAOList();

    public void registraEmpleado(Empleado empleado) {
        empleadoDAO.guardarEmpleado(empleado);
    }
}
