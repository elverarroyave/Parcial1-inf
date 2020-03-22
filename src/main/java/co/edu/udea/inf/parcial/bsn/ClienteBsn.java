package co.edu.udea.inf.parcial.bsn;

import co.edu.udea.inf.parcial.dao.ClienteDAO;
import co.edu.udea.inf.parcial.dao.impl.ClienteDAOList;
import co.edu.udea.inf.parcial.model.Cliente;

public class ClienteBsn {

    ClienteDAO clienteDAO = new ClienteDAOList();

    public void registrarCliente(Cliente cliente){
        clienteDAO.guardarCliente(cliente);
    }
}
