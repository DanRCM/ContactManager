package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;

import java.util.Collections;

public class MenuOrdenar {

    public static void ejecutarMenuOrdenar(OurCircularDoubleList<Contacto> listaC) {
        mostrarOpcionesOrdenamiento();
        manejarOpcionesOrdenamiento(listaC);
        System.out.println("Lista de contactos ordenada:");
        listaC.printList();
        Serializador.serializarLista(listaC, "contactos.p1");
    }

    public static void mostrarOpcionesOrdenamiento() {
        System.out.println("[1] Ordenar por nombre");
        System.out.println("[2] Ordenar por empresa");
        System.out.println("[3] Ordenar por pais");
    }

    public static void manejarOpcionesOrdenamiento(OurCircularDoubleList<Contacto> lista) {
        System.out.println("Elige una forma de ordenar: ");
        int opcion = Inputs.pedirInputNumerico();

        switch (opcion) {
            case 1:
                System.out.println("Ordenando por apellido y nombre: ");
                lista.ordenar(Comparadores.POR_NOMBRE);
                break;
            case 2:
                System.out.println("Ordenando por empresa: ");
                lista.ordenar(Comparadores.POR_EMPRESA);
                break;
            case 3:
                System.out.println("Ordenando por pais: ");
                lista.ordenar(Comparadores.POR_PAIS);
                break;
            default:
                System.out.println("No se escogió una opción válida.");
                break;
        }
    }
}