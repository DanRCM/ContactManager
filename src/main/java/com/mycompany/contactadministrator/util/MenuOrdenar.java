package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;

import java.util.Collections;

public class MenuOrdenar {

    public static void ejecutarMenuOrdenar(OurCircularDoubleList<Contacto> listaC){
        mostrarOpcionesOrdenamiento();
        manejarOpcionesOrdenamiento(listaC);
    }


    public static void mostrarOpcionesOrdenamiento(){
        System.out.println("[1] Ordenar por nombre");
        System.out.println("[2] Ordenar por empresa");
        System.out.println("[3] Ordenar por pais");
    }

    public static void manejarOpcionesOrdenamiento(OurCircularDoubleList<Contacto> ourCircularDoubleList){

            System.out.println("Elije una forma de ordenar: ");
            int opcion = Inputs.pedirInputNumerico();
        if (opcion == 1) {
                System.out.println("Ordenando por nombre: ");
            Collections.sort(ourCircularDoubleList, Comparadores.POR_NOMBRE);
        }// supongamos que arreglamos este error
            else if (opcion == 2) {
                System.out.println("Ordenando por empresa: ");
                Collections.sort(ourCircularDoubleList,Comparadores.POR_EMPRESA);
            } else if (opcion == 3) {
                System.out.println("Ordenando por pais: ");
                Collections.sort(ourCircularDoubleList,Comparadores.POR_PAIS);
            }else {
                System.out.println("No se escogió una opcion valida. ");
            }

    }

}
