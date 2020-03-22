package co.edu.udea.inf.parcial.bsn;

import co.edu.udea.inf.parcial.dao.ClienteDAO;
import co.edu.udea.inf.parcial.dao.impl.ClienteDAOList;
import co.edu.udea.inf.parcial.model.Producto;

public class ClienteBsn {

    ClienteDAO clienteDAO = new ClienteDAOList();

    public void registrarCliente(Producto producto){
        clienteDAO.guardarCliente(producto);
    }
}
