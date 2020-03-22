package co.edu.udea.inf.parcial.controller;

import co.edu.udea.inf.parcial.bsn.ProductoBsn;
import co.edu.udea.inf.parcial.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ProductoController {

    @FXML
    private TextField txtCCodigo;

    @FXML
    private TextField txtCCategoria;

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtDescripcion;

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtContenido;

    @FXML
    private TextField txtUM;

    @FXML
    private TextField txtCategoria;

    @FXML
    private TextField txtPrecio;

    ProductoBsn productoBsn = new ProductoBsn();

    public void crearProducto(){

        int codigo = Integer.parseInt(txtCodigo.getText());
        String descripcion = txtDescripcion.getText();
        String marca = txtMarca.getText();
        int contenido = Integer.parseInt(txtContenido.getText());
        String mu = txtUM.getText();
        String categoria = txtCategoria.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        Producto producto = new Producto(codigo,descripcion,marca,contenido,mu,categoria,precio);

        productoBsn.save(producto);

        System.out.println("Se ha creado el objeto correctamente y se comunico al conrolador");
    }

    public void consultar(){
        int cCodigo = Integer.parseInt(txtCCodigo.getText());
        String cCategoria = txtCCategoria.getText();
        Producto producto = new Producto();
        producto.setCodigo(cCodigo);
        producto.setCategoria(cCategoria);

    }

}
