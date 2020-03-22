package co.edu.udea.inf.parcial.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import co.edu.udea.inf.parcial.model.Producto;

public class MatrizHash {

    private int bkfr;
    private int m;
    private Producto[][] datos;

    public MatrizHash() {
        bkfr = 10;
        m = 100;
        datos = new Producto[m][bkfr];
        llenarDesdeArchivo();
    }

    private void llenarDesdeArchivo() {
        try {
            Path archivo = Paths.get("productos.txt");
            List<String> texto = Files.readAllLines(archivo);
            Producto producto = new Producto();
            for (String cadena : texto) {
                String[] parts = cadena.split(";");
                producto.setCodigo(Integer.parseInt(parts[0]));
                producto.setDescripcion(parts[1]);
                producto.setMarca(parts[2]);
                producto.setContenido(Integer.parseInt(parts[3]));
                producto.setUnidadDeMedida(parts[4]);
                producto.setCategoria(parts[5]);

                String[] precio = parts[6].split(",");
                if (precio.length > 1) {
                    producto.setPrecio(Double.parseDouble(precio[0] + "." + precio[1]));
                } else {
                    producto.setPrecio(Double.parseDouble(precio[0]));
                }
                almacenar(producto);
            }
        } catch (IOException e) {

        }
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
            boolean insert = false;
            System.out.println("Dato colisionado");
            while (!insert && bucket < m) {
                bucket++;
                for (j = 0; j < bkfr; j++) {
                    if (datos[bucket][j] == null) {
                        datos[bucket][j] = producto;
                        insert = true;
                    }
                }
            }
        }
    }

    public  Producto consultar(Producto producto) {
        int bucket = func(producto.getCategoria());
        int j;
        for (j = 0; j < bkfr; j++) {
            if (datos[bucket][j] == null) {
                System.out.println("Dato no encontrado");
                return null;
            } else if (producto.getCodigo() == datos[bucket][j].getCodigo()) {
                System.out.println("Encontrado en: " + bucket + ", " + j);
                return datos[bucket][j];
            }
        }
        if (j == bkfr) {
            while (bucket < m) {
                bucket++;
                for (j = 0; j < bkfr; j++) {
                    if (datos[bucket][j].getCodigo() == producto.getCodigo()) {
                        return datos[bucket][j];
                    }
                }
            }
        }
        return null;
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