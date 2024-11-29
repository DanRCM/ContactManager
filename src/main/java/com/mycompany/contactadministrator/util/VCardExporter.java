package com.mycompany.contactadministrator.util;

import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.model.ContactoEmpresa;
import com.mycompany.contactadministrator.model.ContactoPersona;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class VCardExporter {

    public static void exportToVCard(OurCircularDoubleList<Contacto> contactos) {
        if (contactos.estaVacia()) {
            System.out.println("No hay contactos que exportar");
            return;
        }

        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        Contacto cabeza = iterator.next();

        do {
            Contacto actual = iterator.peek();
            try (BufferedWriter bf = new BufferedWriter(new FileWriter("contactosVCard\\" + generarNombreArchivoConUUID(actual.getNombre())))) {
                bf.write("BEGIN:VCARD");
                bf.newLine();
                bf.write("VERSION:4.0");
                bf.newLine();
                if (actual instanceof ContactoPersona || actual instanceof ContactoEmpresa ){ // en caso de que si agreguemos a empresa
                    bf.write("KIND:individual");
                    bf.newLine();
                    bf.write("FN:"+actual.getNombre()+" "+actual.getApellido());
                    bf.newLine();
                }
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo.");
                throw new RuntimeException(e);
            }


            iterator.next();
        } while (iterator.peek() != cabeza);
    }


    private static String generarNombreArchivoConUUID(String nombre) {
        String uuid = UUID.randomUUID().toString();
        return nombre + "_" + uuid + ".vcf";
    }
}