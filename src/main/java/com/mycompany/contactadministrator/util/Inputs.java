package com.mycompany.contactadministrator.util;

import java.util.Scanner;

public class Inputs {
    /**
     * Pide un numero y valida que sea un numero,
     * puedes mandar strings y no se cae xd
     * 
     * @return -1 si no se ingreso un valor numerico
     */
    public static int pedirInputNumerico() {
        Scanner input = new Scanner(System.in);
        int i = -1;
        try {
            i = input.nextInt();
            input.nextLine();
        } catch (Exception e) {
            input.nextLine();
            System.out.println("Ingrese una opcion numerica.");
        }
        return i;
    }
}
