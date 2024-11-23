package com.mycompany.contactadministrator.util;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import com.mycompany.contactadministrator.ContactAdministratorApp;
import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.model.ContactoEmpresa;
import com.mycompany.contactadministrator.model.ContactoPersona;

public class Menu {

    public static void ejecutarMenu(OurCircularDoubleList<Contacto> contactos) {

        Scanner input = new Scanner(System.in);
        int i = -1;

        while (i != 4) {
            mostrarOpcionesPrincipales();
            i = Inputs.pedirInputNumerico();
            if (i == 1) {
                OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();

                int j = -1;
                while (j != 5) {
                    System.out.println(iterator.peek());
                    mostrarOpcionesContactos();
                    j = Inputs.pedirInputNumerico();
                    if(j == 1){
                        System.out.println("Siguiente contacto: ");
                        iterator.next();
                    } else if (j == 2) {
                        System.out.println("Contacto anterior: ");
                        iterator.previous();
                    } else if (j == 3) {
                        System.out.println( "Editando contacto: ");
                    } else if (j== 4) {
                        System.out.println("Eliminando contacto: ");
                        iterator.remove();
                    } else if (j == 5) {
                        System.out.println("Añadiendo contacto: ");
                        añadirContacto(contactos);
                    } else if (j == 6) {
                        System.out.println("Regresando al menu principal");
                    } else {
                        System.out.println("Elije una opcion correcta.");
                    }
                }
            }
        }

    }

    public static void mostrarOpcionesContactos() {
        System.out.println("Opciones para manejar contactos: ");
        System.out.println("[1] Siguiente >>");
        System.out.println("[2] << Anterior");
        System.out.println("[3] Editar contacto.");
        System.out.println("[4] Borrar contacto.");
        System.out.println("[5] Añadir contacto.");
        System.out.println("[6] Regresar al menu principal.");
        System.out.println("");
    }

    public static void mostrarOpcionesPrincipales() {
        System.out.println("Bienvenido a ContactManager! ");
        System.out.println("[1] Ver contactos");
        System.out.println("[2] Buscar contactos");
        System.out.println("[3] Ordenar contactos");
        System.out.println("[4] Cerrar ContactManager");
        System.out.println("");
    }

	public static void añadirContacto(OurCircularDoubleList<Contacto> contactos) {
	    Menu.mostrarOpcionesContacto();
	    System.out.print("Ingrese el numero del contacto a crear: ");
	    int n = Inputs.pedirInputNumerico();
	
	    if (n == 1) {
	        ContactoPersona p = ContactAdministratorApp.contactoPersona();
	        contactos.agregarUltimo(p);
	        System.out.println();
	        contactos.printList();
	        mostrarOpcionesContactos();
	    } else if (n == 2) {
	        ContactoEmpresa e = ContactAdministratorApp.contactoEmpresa();
	        contactos.agregarUltimo(e);
	        System.out.println();
	        contactos.printList();
	        mostrarOpcionesContactos();
	    }
	}

	public static void mostrarOpcionesContacto() {
	    System.out.println("");
	    System.out.println("Opciones de contacto: ");
	    System.out.println("1. Persona");
	    System.out.println("2. Empresa");
	    System.out.println("");
	}

}
