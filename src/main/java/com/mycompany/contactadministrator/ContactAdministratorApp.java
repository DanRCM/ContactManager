package com.mycompany.contactadministrator;

import com.mycompany.contactadministrator.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class ContactAdministratorApp extends Application{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ContactAdministratorApp.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //launch();

        Direccion direccionPersona = new Direccion("Calle Ficticia 123", "https://maps.google.com/?q=Calle+Ficticia+123");

        ContactoPersona contactoPersona = new ContactoPersona("Juan", "Pérez", direccionPersona, "Amigo");
        contactoPersona.agregarTelefono("123456789");
        contactoPersona.agregarEmail(new Email("juan@ejemplo.com", "personal"));
        contactoPersona.agregarRedSocial(new RedSocial("Twitter", "@juanperez"));
        contactoPersona.agregarFoto(new Foto("foto1.jpg"));

        contactoPersona.mostrarContacto();

        Direccion direccionEmpresa = new Direccion("Avenida Empresa 456", "https://maps.google.com/?q=Avenida+Empresa+456");

        ContactoEmpresa contactoEmpresa = new ContactoEmpresa("Carlos", "Gómez", direccionEmpresa, "TechCorp", "Gerente de TI");
        contactoEmpresa.agregarTelefono("987654321");
        contactoEmpresa.agregarEmail(new Email("carlos@techcorp.com", "corporativo"));
        contactoEmpresa.agregarRedSocial(new RedSocial("LinkedIn", "carlos-gomez"));
        contactoEmpresa.agregarFoto(new Foto("foto2.jpg"));

        contactoEmpresa.mostrarContacto();
    }

}