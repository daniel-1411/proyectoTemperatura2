/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectotemperatura;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Minikane
 */
public class ClasePrincipal extends Application implements PeticionXML.ComunicacionPedirClima, PeticionXML2.ComunicacionPedirClima{
    PeticionXML p;
    PeticionXML2 p2;
    ChoiceBox cb_p,cb_m;
    Label lb1_provincias,lb1_municipios;
    static TableView tv;
    static VBox vbox=null;
   public static void main(String[] args) {
        launch(args);
        
    }
   
   
   
    @Override
    public void start(Stage stage) throws Exception {
        //Conexion
        AccesoBD.conectar();
        //Choice y label de provincias
        lb1_provincias=new Label("Provincias");
        ArrayList<String> array_provincias=AccesoBD.recogerDatosProvincias();
        cb_p=new ChoiceBox();
        cb_p.setItems(FXCollections.observableList(array_provincias));
        //Coice y label de municipios 
        lb1_municipios=new Label("Provincias");
        ArrayList<String> array_municipios=AccesoBD.recogerDatosProvincias();
        cb_m=new ChoiceBox();
        cb_m.setItems(FXCollections.observableList(array_provincias));
        //Peticiones
        p=new PeticionXML(new ClasePrincipal());
        PeticionXML.pedirProvicias();
        p2=new PeticionXML2(new ClasePrincipal());
        PeticionXML2.pedirMunicipios();
        //Hace la web
        VBox v=new VBox(30);
        vbox=v;
        v.getChildren().addAll(lb1_provincias,cb_p);
        Scene escena=new Scene(v,500,400);
        stage.setScene(escena);
        stage.show();
    }
    
    
    public static void imprimirDatos(ClaseRaiz r)
    {
        System.out.println("DATOS: "+r);
    }

    @Override
    public void mostrarDatos(ClaseRaiz r) {
        System.out.println("DATOS: "+r);
    }

    @Override
    public void mostrarDatos(ClaseRaiz2 r) {
        System.out.println("DATOS MUNICIPIOS: "+r);
    }
}