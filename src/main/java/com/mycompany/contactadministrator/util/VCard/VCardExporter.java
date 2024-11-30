package com.mycompany.contactadministrator.util.VCard;

import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.model.ContactoEmpresa;
import com.mycompany.contactadministrator.model.ContactoPersona;
import com.mycompany.contactadministrator.util.OurCircularDoubleList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class VCardExporter {

    public static void exportToVCard(OurCircularDoubleList<Contacto> contactos) {
        if (contactos.estaVacia()) {
            System.out.println("No hay contactos que exportar");
            return;
        }
        File directorio = new File("contactosExportados");
        if (!directorio.exists()) {
            directorio.mkdirs();  // Crea la carpeta si no existe
        }

        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator = contactos.iterator();
        Contacto cabeza = iterator.peek();

        do {
            Contacto actual = iterator.peek();
            try (BufferedWriter bf = new BufferedWriter(new FileWriter("contactosExportados\\"+actual.getNombre()+actual.getApellido()+actual.getTelefonos().obtener(0)+".vcf"))) {
                bf.write("BEGIN:VCARD");
                bf.newLine();
                bf.write("VERSION:4.0");
                bf.newLine();
                if (actual instanceof ContactoPersona || actual instanceof ContactoEmpresa ){ // en caso de que si agreguemos a empresa
                    bf.write("KIND:individual");
                    bf.newLine();
                    bf.write("FN:"+actual.getNombre()+" "+actual.getApellido());
                    bf.newLine();
                    bf.write("ADR:"+";;"+actual.getDireccion().getDireccion()+";;;;"+actual.getDireccion().getPais()+";");
                    bf.newLine();
                    for (int i = 0; i < actual.getTelefonos().size(); i++) {
                        bf.write("TEL;TYPE=home:"+actual.getTelefonos().obtener(i));
                        bf.newLine();
                    }
                    for (int i = 0; i < actual.getEmails().size(); i++) {
                        bf.write("EMAIL:"+actual.getEmails().obtener(i).getDireccion());
                        bf.newLine();
                    }
                    for (int i = 0; i < actual.getRedesSociales().size(); i++) {
                        String tipoSocial = actual.getRedesSociales().obtener(i).getRedSocialNombre().toLowerCase();
                        bf.write("X-SOCIALPROFILE;TYPE="+tipoSocial+":"+actual.getRedesSociales().obtener(i).getIdentificador());
                        bf.newLine();
                    }
                    if (actual instanceof ContactoPersona){
                        ContactoPersona contactoPersona = (ContactoPersona) actual;
                        // Saca la fecha en formato YYYYMMDD
                        anioMesDia anioMesDia = getAnioMesDia(contactoPersona);
                        bf.write("BDAY:" + anioMesDia.y + anioMesDia.m + anioMesDia.d);
                        bf.newLine();
                    } else if (actual instanceof ContactoEmpresa){
                        ContactoEmpresa contactoEmpresa = (ContactoEmpresa) actual;
                        bf.write("ORG:"+VCardEscaper.escape(contactoEmpresa.getNombreEmpresa()));
                        bf.newLine();
                        bf.write("ROLE:"+contactoEmpresa.getCargo());
                        bf.newLine();
                        bf.write("TITLE:" + contactoEmpresa.getCargo());
                        bf.newLine();
                    }




                    OurCircularDoubleList<Contacto> contactosAsociados = actual.getContactosAsociados();
                    if (!contactosAsociados.estaVacia()){
                        OurCircularDoubleList<Contacto>.OurCircularDoubleListIterator iterator2 = contactosAsociados.iterator();
                        Contacto cabeza1 = iterator2.peek();
                        do {
                            Contacto current = iterator2.peek();
                            if (actual instanceof ContactoPersona){
                                ContactoPersona contactoPersona1 = (ContactoPersona) current;
                                bf.write("RELATED;TYPE="+contactoPersona1.getTipoRelacion()+":"+contactoPersona1.getNombre()+" "+contactoPersona1.getApellido());
                                bf.newLine();
                            } else if (actual instanceof ContactoEmpresa){ // por si agregamos otros tipos
                                bf.write( "RELATED:"+current.getNombre()+" "+current.getApellido());
                                bf.newLine();
                            }
                            iterator2.next();
                        } while (iterator2.peek() != cabeza1);
                    }
                }
                bf.write("END:VCARD");
                bf.newLine();
            } catch (IOException e) {
                System.out.println("Error al exportar los contactos");
                throw new RuntimeException(e);
            }


            iterator.next();
        } while (iterator.peek() != cabeza);
        System.out.println("Contactos exportados correctamente. (en carpeta contactosExportados)");
    }

    private static anioMesDia getAnioMesDia(ContactoPersona contactoPersona) { // NO ES MI CULPA DANIEL, asi lo refactorizo intellij
        String y = String.valueOf(contactoPersona.getFechaNacimiento().getYear());
        String m = String.valueOf(contactoPersona.getFechaNacimiento().getMonthValue());
        String d = String.valueOf(contactoPersona.getFechaNacimiento().getDayOfMonth());
        if (m.length() == 1)
            m = "0" + m;
        if (d.length() == 1)
            d = "0" + d;
        return new anioMesDia(y, m, d);
    }

    private static class anioMesDia {
        public final String y;
        public final String m;
        public final String d;

        public anioMesDia(String y, String m, String d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }
    }


}