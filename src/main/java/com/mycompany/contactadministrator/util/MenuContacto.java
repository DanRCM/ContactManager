package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.model.ContactoEmpresa;
import com.mycompany.contactadministrator.model.ContactoPersona;

import java.util.Scanner;

public class MenuContacto {

    public static void añadirContacto(OurCircularDoubleList<Contacto> contactos) {
        mostrarOpcionesContacto();
        System.out.print("Ingrese el número del contacto a crear: ");
        int n = Inputs.pedirInputNumerico();
        ContactFactory contactFactory = new ContactFactory();
        Contacto nuevoContacto = null;

        if (n == 1) {
            nuevoContacto = contactFactory.crearContactoPersona();
        } else if (n == 2) {
            nuevoContacto = contactFactory.crearContactoEmpresa();
        } else {
            System.out.println("Opción no válida.");
            return;
        }

        // Preguntar si desea añadir contactos asociados
        Scanner scanner = new Scanner(System.in);
        int opcionAsociados = 0; // Inicializar variable

        do {
            System.out.print("¿Desea añadir un contacto asociado? [1] Sí [2] No: ");
            if (scanner.hasNextInt()) {
                opcionAsociados = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                if (opcionAsociados != 1 && opcionAsociados != 2) {
                    System.out.println("Ingrese una de las dos opciones numéricas.");
                }
            } else {
                System.out.println("Ingrese una de las dos opciones numéricas.");
                scanner.next(); // Limpiar el buffer de entrada
            }
        } while (opcionAsociados != 1 && opcionAsociados != 2);

        while (opcionAsociados == 1) {
            buscarYAgregarContactoAsociado(contactos, nuevoContacto);
            do {
                System.out.print("¿Desea añadir otro contacto asociado? [1] Sí [2] No: ");
                if (scanner.hasNextInt()) {
                    opcionAsociados = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    if (opcionAsociados != 1 && opcionAsociados != 2) {
                        System.out.println("Ingrese una de las dos opciones numéricas.");
                    }
                } else {
                    System.out.println("Ingrese una de las dos opciones numéricas.");
                    scanner.next(); // Limpiar el buffer de entrada
                }
            } while (opcionAsociados != 1 && opcionAsociados != 2);
        }

        contactos.agregarUltimo(nuevoContacto);
        System.out.println("Contacto añadido: " + nuevoContacto.getNombre());
        System.out.println();
    }

    private static void buscarYAgregarContactoAsociado(OurCircularDoubleList<Contacto> contactos, Contacto nuevoContacto) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre o apellido del contacto a asociar: ");
        String terminoBusqueda = scanner.nextLine().toLowerCase();

        boolean encontrado = false;
        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();

        // Guardar el primer contacto para evitar el bucle infinito
        if (!iterator.hasNext()) {
            System.out.println("No hay contactos disponibles para buscar.");
            return;
        }

        Contacto primerContacto = iterator.next();
        Contacto inicioContacto = primerContacto; // Guardar el contacto inicial

        do {
            // Comprobar el contacto actual
            String nombre = primerContacto.getNombre().toLowerCase();
            String apellido = primerContacto.getApellido().toLowerCase();

            if (nombre.contains(terminoBusqueda) || apellido.contains(terminoBusqueda)) {
                System.out.println("Contacto encontrado: " + primerContacto);
                nuevoContacto.agregarContactoAsociado(primerContacto);
                encontrado = true;
                break; // Salir después de agregar el contacto asociado
            }

            // Avanzar al siguiente contacto
            if (iterator.hasNext()) {
                primerContacto = iterator.next();
            } else {
                break; // Salir si no hay más contactos
            }

        } while (primerContacto != inicioContacto); // Comprobar si hemos vuelto al inicio

        if (!encontrado) {
            System.out.println("No se encontraron contactos que coincidan con la búsqueda.");
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