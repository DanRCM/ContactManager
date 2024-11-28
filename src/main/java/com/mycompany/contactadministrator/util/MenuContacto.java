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
        int opcionAsociados;

        do {
            System.out.print("¿Desea añadir un contacto asociado? [1] Sí [2] No: ");
            String input = scanner.nextLine(); // Leer toda la línea
            try {
                opcionAsociados = Integer.parseInt(input); // Convertir a entero
                if (opcionAsociados != 1 && opcionAsociados != 2) {
                    System.out.println("Ingrese una de las dos opciones numéricas (1 o 2).");
                    opcionAsociados = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("No se admiten caracteres que no sean 1 o 2. Intente de nuevo.");
                opcionAsociados = 0;

            }
        } while (opcionAsociados != 1 && opcionAsociados != 2);

        while (opcionAsociados == 1) {
            buscarYAgregarContactoAsociado(contactos, nuevoContacto);
            // Preguntar si desea añadir otro contacto asociado
            do {
                System.out.print("¿Desea añadir otro contacto asociado? [1] Sí [2] No: ");
                String input = scanner.nextLine(); // Leer toda la línea
                try {
                    opcionAsociados = Integer.parseInt(input); // Convertir a entero
                    if (opcionAsociados != 1 && opcionAsociados != 2) {
                        System.out.println("Ingrese una de las dos opciones numéricas (1 o 2).");
                        opcionAsociados = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("No se admiten caracteres que no sean 1 o 2. Intente de nuevo.");
                    opcionAsociados = 0;
                }
            } while (opcionAsociados != 1 && opcionAsociados != 2);

            // Si la opción es 2, salimos del bucle
            if (opcionAsociados == 2) {
                break;
            }
        }

        contactos.agregarUltimo(nuevoContacto);
        System.out.println("Contacto añadido: " + nuevoContacto.getNombre());
        System.out.println();
    }

    protected static void buscarYAgregarContactoAsociado(OurCircularDoubleList<Contacto> contactos, Contacto contactoPrincipal, String terminoBusqueda) {
        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        boolean encontrado = false;

        if (!iterator.hasNext()) {
            System.out.println("No hay contactos disponibles para buscar.");
            return;
        }

        Contacto primerContacto = iterator.next();
        Contacto inicioContacto = primerContacto; // Guardar el inicio para evitar bucles infinitos.

        do {
            String nombre = primerContacto.getNombre().toLowerCase();
            String apellido = primerContacto.getApellido().toLowerCase();

            if (nombre.contains(terminoBusqueda.toLowerCase()) || apellido.contains(terminoBusqueda.toLowerCase())) {
                System.out.println("Contacto encontrado: " + primerContacto.getNombre() + " " + primerContacto.getApellido());
                contactoPrincipal.agregarContactoAsociado(primerContacto);
                System.out.println("Contacto asociado añadido exitosamente.");
                encontrado = true;
                break;
            }

            primerContacto = iterator.next();
        } while (primerContacto != inicioContacto);

        if (!encontrado) {
            System.out.println("No se encontraron contactos que coincidan con la búsqueda.");
        }
    }

    private static void buscarYAgregarContactoAsociado(OurCircularDoubleList<Contacto> contactos, Contacto nuevoContacto) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre o apellido del contacto a asociar: ");
        String terminoBusqueda = scanner.nextLine().toLowerCase();

        // Verificar que el término de búsqueda no esté vacío
        if (terminoBusqueda.trim().isEmpty()) {
            System.out.println("El término de búsqueda no puede estar vacío.");
            return;
        }

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

            if (nombre.equals(terminoBusqueda) || apellido.equals(terminoBusqueda)) {
                System.out.println("Contacto encontrado: " + primerContacto);
                nuevoContacto.agregarContactoAsociado(primerContacto);
                encontrado = true;
                System.out.println("Contacto asociado añadido exitosamente.");
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