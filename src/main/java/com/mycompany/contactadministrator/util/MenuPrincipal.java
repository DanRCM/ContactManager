package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.util.VCard.VCardExporter;

public class MenuPrincipal {

    public static void mostrarOpcionesPrincipales() {
        System.out.println("Bienvenido a ContactManager! ");

        System.out.println("[1] Ver contactos");
        System.out.println("[2] Buscar contactos");
        System.out.println("[3] Ordenar contactos segun criterios");
        System.out.println("[4] Filtrar contactos segun criterios");
        System.out.println("[5] Exportar los contactos a vCard");
        System.out.println("[6] Cerrar ContactManager y guardar lista de contactos.");
        System.out.println("");
    }

    public static void ejecutarMenu(OurCircularDoubleList<Contacto> contactos) {
        int opcion;
        do {
            mostrarOpcionesPrincipales();
            opcion = Inputs.pedirInputNumerico();
            switch (opcion) {
                case 1:
                    MenuContactos.mostrarMenuContactos(contactos);
                    break;
                case 2:
                    MenuContactos.buscarContactos(contactos);
                    break;
                case 3:
                    MenuOrdenar.ejecutarMenuOrdenar(contactos);
                    break;
                case 4:
                    MenuFiltro.filtrarContactos(contactos);
                    break;
                case 5:
                    VCardExporter.exportToVCard(contactos);
                    break;
                case 6:
                    System.out.println("Cerrando el programa...");
                    Serializador.serializarLista(contactos, "contactos.p1");
                    break;
                default:
                    System.out.println("Opción no válida \n ");
            }
        } while (opcion != 6);
    }
}
