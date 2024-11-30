package com.mycompany.contactadministrator;

import com.mycompany.contactadministrator.model.*;
import com.mycompany.contactadministrator.util.*;

import com.mycompany.contactadministrator.util.VCard.VCardExporter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.Scanner;

/**
 * JavaFX App
 */
public class ContactAdministratorApp{

//    private static Scene scene;
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("primary"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(ContactAdministratorApp.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }

    public static void main(String[] args) {

        OurCircularDoubleList<Contacto> contactos = Serializador.deserializarLista("contactos.p1"); //carga la lista guardada, si no hay, usa DataLoader para generar una

        MenuPrincipal.ejecutarMenu(contactos);
        //launch();
    }
}