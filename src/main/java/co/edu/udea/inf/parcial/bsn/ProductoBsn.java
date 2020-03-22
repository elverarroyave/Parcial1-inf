package co.edu.udea.inf.parcial.bsn;

import co.edu.udea.inf.parcial.model.Producto;
import co.edu.udea.inf.parcial.persistence.MatrizHash;
import javafx.fxml.FXML;

public class ProductoBsn {

    static MatrizHash matrizHash = new MatrizHash();

    public void save(Producto producto){
        matrizHash.almacenar(producto);
    }

    public Producto consultar(Producto producto) {
        return matrizHash.consultar(producto);
    }
}
