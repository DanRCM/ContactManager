package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.model.ContactoEmpresa;
import com.mycompany.contactadministrator.model.ContactoPersona;

import java.util.Calendar;
import java.util.Scanner;

public class MenuFiltro {
    public static void filtrarContactos(OurCircularDoubleList<Contacto> contactos) {
        if (contactos.estaVacia()) {
            System.out.println("No hay contactos para filtrar.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el criterio de búsqueda:");
        System.out.println("1. Término de búsqueda (nombre, apellido, o empresa)");
        System.out.println("2. País de residencia");
        System.out.println("3. Mes de cumpleaños");
        int opcion = Inputs.pedirInputNumerico();
        OurCircularDoubleList<Contacto> listaFiltrada;
        switch (opcion) {
            case 1:
                System.out.print("Ingrese el término de búsqueda: ");
                String terminoBusqueda = scanner.nextLine().toLowerCase();
                if (terminoBusqueda.isEmpty()) {
                    System.out.println("Ingresa un texto no vacio.");
                    break;
                }
                listaFiltrada = filtrarPorTermino(contactos, terminoBusqueda);
                mostrarListaFiltrada(listaFiltrada);
                break;

            case 2:
                System.out.print("Ingrese el país de residencia: ");
                String pais = scanner.nextLine().toLowerCase();
                if (pais.isEmpty()) {
                    System.out.println("Ingresa un texto no vacio.");
                    break;
                }
                listaFiltrada = filtrarPorPais(contactos, pais);
                mostrarListaFiltrada(listaFiltrada);
                break;

            case 3:
                System.out.print("Ingrese el número del mes (1-12): ");
                int mes = Inputs.pedirInputNumerico();
                if (mes<1 || mes>13){ //verifica si es un mes valido
                    System.out.println("Ingrese un numero de mes valido");
                    break;
                }
                listaFiltrada = filtrarPorMes(contactos, mes);
                mostrarListaFiltrada(listaFiltrada);
                break;

            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void mostrarListaFiltrada(OurCircularDoubleList<Contacto> listaFiltrada) {
        if(listaFiltrada.estaVacia())
            System.out.println("Ningun elemento coincide con el filtro");
        else {
            System.out.println("==============================================");
            System.out.println("Mostrando lista filtrada:");
            System.out.println("Numero de elementos que coinciden con el filtro: " + listaFiltrada.tamano());
            MenuContactos.mostrarMenuContactos(listaFiltrada);
            System.out.println("Saliendo de la lista filtrada.");
            System.out.println("==============================================");
        }
    }


    public static OurCircularDoubleList<Contacto> filtrarPorTermino(OurCircularDoubleList<Contacto> contactos, String termino) {
        System.out.println("Contactos que coinciden con '" + termino + "':");
        OurCircularDoubleList<Contacto> out = new OurCircularDoubleList<>();
        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        Contacto primercontacto = iterator.peek();
        Contacto contacto = iterator.next();
        do {

            if (contacto.getNombre().toLowerCase().contains(termino) ||
                    contacto.getApellido().toLowerCase().contains(termino)) {
                out.agregarUltimo(contacto);
            } else if (contacto instanceof ContactoEmpresa) {
                ContactoEmpresa empresa = (ContactoEmpresa) contacto;
                if (empresa.getNombreEmpresa().toLowerCase().contains(termino)) {
                    out.agregarUltimo(contacto);
                }
            }
            contacto = iterator.next();
        } while (primercontacto != contacto);
        return out;

    }

    public static OurCircularDoubleList<Contacto> filtrarPorPais(OurCircularDoubleList<Contacto> contactos, String pais) {
        System.out.println("Contactos que viven en " + pais + ":");
        OurCircularDoubleList<Contacto> out = new OurCircularDoubleList<>();
        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        Contacto primercontacto = iterator.peek();
        Contacto contacto = iterator.next();
        do {

            if(contacto.getDireccion().getPais().toLowerCase().contains(pais)){
                out.agregarUltimo(contacto);
            }

            contacto = iterator.next();
        } while (primercontacto != contacto);
        return out;
    }

    public static OurCircularDoubleList<Contacto> filtrarPorMes(OurCircularDoubleList<Contacto> contactos, int mes) {
        System.out.println("Contactos con cumpleaños en el mes " + mes + ":");
        OurCircularDoubleList<Contacto> out = new OurCircularDoubleList<>();
        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        Contacto primercontacto = iterator.peek();
        Contacto contacto = iterator.next();
        do {
            if (contacto instanceof ContactoPersona) {
                ContactoPersona contactoPersona = (ContactoPersona) contacto;
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(LocalDateToDateConverter.convertirLocalDateADate(contactoPersona.getFechaNacimiento())); // Pasar de LocalDate a Date para no tener que cambiar la funcion
                int mesCumpleanos = calendar.get(Calendar.MONTH) + 1;
                if (mesCumpleanos == mes) {
                    out.agregarUltimo(contacto);
                }
            }
            contacto = iterator.next();
        } while (primercontacto != contacto);
        return out;

    }
}





