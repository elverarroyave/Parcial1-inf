package co.edu.udea.inf.parcial.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ContenedorPrincipalController {

    @FXML
    private BorderPane contenedorPrincipal;


    public void mnuSalir(){ System.exit(0);}

    public void mnuConsultar(){
        try{
            AnchorPane consultar = FXMLLoader.load(getClass().getClassLoader().getResource( "view/consultar-view.fxml"));
            contenedorPrincipal.setCenter(consultar);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mnuCrear(){
        try{
            AnchorPane crear = FXMLLoader.load(getClass().getClassLoader().getResource( "view/crear-view.fxml"));
            contenedorPrincipal.setCenter(crear);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
