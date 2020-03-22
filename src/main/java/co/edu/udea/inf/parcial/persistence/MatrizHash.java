package co.edu.udea.inf.parcial.persistence;

import co.edu.udea.inf.parcial.model.Producto;

public class MatrizHash {

    private int bkfr;
    private int m;
    private Producto[][] datos;

    public MatrizHash() {
        bkfr = 10;
        m = 100;
        datos = new Producto[m][bkfr];
    }

    public void almacenar(Producto producto) {
        int bucket = func(producto.getCategoria());
        int j;
        for (j = 0; j < bkfr; j++) {
            if (datos[bucket][j] == null) {
                System.out.println("Dato alamcenado en " + bucket + ", " + j + " -> " + producto.getCodigo());
                datos[bucket][j] = producto;
                break;
            }
            System.out.println("Datos sinonimos");
        }
        if (j == bkfr) {
            System.out.println("Dato colisionado");
            // What do we do?
        }
    }

    public boolean consultar(Producto producto) {
        int bucket = func(producto.getCategoria());
        int j;
        for (j = 0; j < bkfr; j++) {
            if (datos[bucket][j] == null) {
                System.out.println("Dato no encontrado");
                return false;
            } else if (producto.getCodigo() == datos[bucket][j].getCodigo()) {
                System.out.println("Encontrado en: " + bucket + ", " + j);
                return true;
            }
        }

        if (j == bkfr) {
           // Search it in overflow 
        }
        return false;
    }

    private int func(String categoria) {
        int suma = 0;
        for (int i = 0; i < categoria.length(); i++) 
            suma+=categoria.charAt(i);
        String digito = String.valueOf(suma).substring(0,1);
        int digitoEntero = Integer.parseInt(digito);
        return digitoEntero;
    } 
}