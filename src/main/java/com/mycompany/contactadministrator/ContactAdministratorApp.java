package com.mycompany.contactadministrator;

import com.mycompany.contactadministrator.model.*;
import com.mycompany.contactadministrator.util.Inputs;
import com.mycompany.contactadministrator.util.Menu;
import com.mycompany.contactadministrator.util.OurCircularDoubleList;
import com.mycompany.contactadministrator.util.Serializador;

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
public class ContactAdministratorApp extends Application {

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
        // launch();

        OurCircularDoubleList<Contacto> contactos = Serializador.deserializarLista("contactos.p1");

        Menu.ejecutarMenu(contactos);
        // Menu.mostrarOpcionesContactos();
        // int i = -1;
        // Scanner input = new Scanner(System.in);
        // while (i != 2) {
        //     System.out.print("Ingrese el numero de la opcion a realizar: ");
        //     i = Inputs.pedirInputNumerico();

        //     if (i == 1) {
        //         Menu.añadirContacto(contactos);

        //     }
        //     if (i == 2) {
        //         System.out.println("Cerrando el programa...");
        //         Serializador.serializarLista(contactos, "contactos.p1");
        //         break;
        //     } else {
        //         System.out.println("Input no valido \n ");
        //         Menu.mostrarOpcionesContactos();
        //     }
        // }

    }

    public static OurCircularDoubleList<Contacto> cargarDatos() {
        Direccion direccionPersona = new Direccion("Calle Ficticia 123",
                "https://maps.google.com/?q=Calle+Ficticia+123");

        ContactoPersona contactoPersona = new ContactoPersona("Juan", "Pérez", direccionPersona, "Amigo", "30/08/2005");
        contactoPersona.agregarTelefono("123456789");
        contactoPersona.agregarEmail(new Email("juan@ejemplo.com", "personal"));
        contactoPersona.agregarRedSocial(new RedSocial("Twitter", "@juanperez"));
        contactoPersona.agregarFoto(new Foto("foto1.jpg"));

        Direccion direccionEmpresa = new Direccion("Avenida Empresa 456",
                "https://maps.google.com/?q=Avenida+Empresa+456");

        ContactoEmpresa contactoEmpresa = new ContactoEmpresa("Carlos", "Gómez", direccionEmpresa, "TechCorp",
                "Gerente de TI", "Estados Unidos");
        contactoEmpresa.agregarTelefono("987654321");
        contactoEmpresa.agregarEmail(new Email("carlos@techcorp.com", "corporativo"));
        contactoEmpresa.agregarRedSocial(new RedSocial("LinkedIn", "carlos-gomez"));
        contactoEmpresa.agregarFoto(new Foto("foto2.jpg"));

        // hacermos la lista
        OurCircularDoubleList<Contacto> contactos = new OurCircularDoubleList<>();

        // anadimos los contactos
        contactos.agregarUltimo(contactoPersona);
        contactos.agregarUltimo(contactoEmpresa);

        contactos.printList();

        return contactos;

    }

    public static ContactoPersona contactoPersona() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el nombre: ");
        String n = input.nextLine();
        System.out.println("Ingresa el apellido: ");
        String a = input.nextLine();
        System.out.println("Ingresa la direccion: ");
        String d1 = input.nextLine();
        System.out.println("Ingresa el link de la direccion: ");
        String d2 = input.nextLine();
        Direccion d = new Direccion(d1, d2);
        System.out.println("Ingresa la relacion con la persona: ");
        String r = input.nextLine();
        System.out.println("Ingresa su fecha de cumpleaños: ");
        String fc = input.nextLine();
        ContactoPersona contacto = new ContactoPersona(n, a, d, r, fc);
        System.out.println("Ingresa el telefono: ");
        String t = input.nextLine();
        contacto.agregarTelefono(t);
        System.out.println("Ingresa el email: ");
        String e1 = input.nextLine();
        System.out.println("Ingresa el tipo de email: ");
        String e2 = input.nextLine();
        contacto.agregarEmail(new Email(e1, e2));
        System.out.println("Ingresa el ususario de una red social: ");
        String s1 = input.nextLine();
        System.out.println("Ingresa el nombre de la red social: ");
        String s2 = input.nextLine();
        contacto.agregarRedSocial(new RedSocial(s2, s1));
        System.out.println("Ingresa la direccion de una foto: ");
        String f = input.nextLine();
        contacto.agregarFoto(new Foto(f));

        return contacto;
    }

    public static ContactoEmpresa contactoEmpresa() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa el nombre: ");
        String n = input.nextLine();
        System.out.println("Ingresa el apellido: ");
        String a = input.nextLine();
        System.out.println("Ingresa la direccion: ");
        String d1 = input.nextLine();
        System.out.println("Ingresa el link de la direccion: ");
        String d2 = input.nextLine();
        Direccion d = new Direccion(d1, d2);
        System.out.println("Ingresa el nombre de la empresa: ");
        String ne = input.nextLine();
        System.out.println("Ingresa el cargo en la empresa: ");
        String c = input.nextLine();
        System.out.println("Ingresa el pais de la empresa: ");
        String p = input.nextLine();
        ContactoEmpresa contacto = new ContactoEmpresa(n, a, d, ne, c, p);
        System.out.println("Ingresa el telefono: ");
        String t = input.nextLine();
        contacto.agregarTelefono(t);
        System.out.println("Ingresa el email: ");
        String e1 = input.nextLine();
        System.out.println("Ingresa el tipo de email: ");
        String e2 = input.nextLine();
        contacto.agregarEmail(new Email(e1, e2));
        System.out.println("Ingresa el ususario de una red social: ");
        String s1 = input.nextLine();
        System.out.println("Ingresa el nombre de la red social: ");
        String s2 = input.nextLine();
        contacto.agregarRedSocial(new RedSocial(s2, s1));
        System.out.println("Ingresa la direccion de una foto: ");
        String f = input.nextLine();
        contacto.agregarFoto(new Foto(f));

        return contacto;
    }

}