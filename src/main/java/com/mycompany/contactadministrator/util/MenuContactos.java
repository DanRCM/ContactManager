package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;

public class MenuContactos {

    public static void mostrarMenuContactos(OurCircularDoubleList<Contacto> contactos) {
        if (contactos.estaVacia()) {
            System.out.println("No hay contactos disponibles: ");
            mostrarOpcionesSinContactos(contactos);
        }

        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        int opcion;
        boolean hasContact = true;

        do {
            if (hasContact) {
                System.out.println(iterator.peek()); // Muestra el contacto actual
            } else {
                System.out.println("No hay más contactos.");
            }
            mostrarOpcionesContactos();
            opcion = Inputs.pedirInputNumerico();
            hasContact = manejarOpcionesContactos(contactos, iterator, opcion);
        } while (opcion != 6);
    }

    private static boolean manejarOpcionesContactos(OurCircularDoubleList<Contacto> contactos,
                                                    OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator, int opcion) {
        switch (opcion) {
            case 1: // Siguiente contacto
                if (iterator.hasNext()) {
                    iterator.next(); // Mueve el iterador al siguiente
                } else {
                    System.out.println("No hay más contactos.");
                    return false; // Indica que no hay contacto actual
                }
                break;
            case 2: // Contacto anterior
                    iterator.previous(); // Mueve el iterador al anterior
                break;
            case 3:
                System.out.println("Editando contacto: ");
                // Implementar lógica de edición
                break;
            case 4:
                System.out.println("Eliminando contacto: ");
                iterator.remove(); // Elimina el contacto actual
                break;
            case 5:
                System.out.println("Añadiendo contacto: ");
                MenuContacto.añadirContacto(contactos);
                break;
            case 6:
                System.out.println("Regresando al menú principal");
                return false; // Indica que se está regresando
            default:
                System.out.println("Elige una opción correcta.");
        }
        return true; // Indica que hay un contacto actual
    }

    private static void mostrarOpcionesSinContactos(OurCircularDoubleList<Contacto> contactos) {
        System.out.println("Opciones: ");
        System.out.println("[1] Añadir Contacto");
        System.out.println("[2] Regresar al menú principal");
        int opcion = Inputs.pedirInputNumerico();
        if (opcion == 1) {
            MenuContacto.añadirContacto(contactos);
        }
    }

    public static void mostrarOpcionesContactos() {
        System.out.println("Opciones para manejar contactos: ");
        System.out.println("[1] Siguiente >>");
        System.out.println("[2] << Anterior");
        System.out.println("[3] Editar contacto (no funcional)");
        System.out.println("[4] Borrar contacto.");
        System.out.println("[5] Añadir contacto.");
        System.out.println("[6] Regresar al menú principal.");
        System.out.println("");
    }
}