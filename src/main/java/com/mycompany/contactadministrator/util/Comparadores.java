package com.mycompany.contactadministrator.util;

import java.security.PublicKey;
import java.util.Comparator;

import com.mycompany.contactadministrator.model.Contacto;
import com.mycompany.contactadministrator.model.ContactoEmpresa;
import com.mycompany.contactadministrator.model.ContactoPersona;

public class Comparadores {

    public static final Comparator<Contacto> POR_NOMBRE = new Comparator<Contacto>() {
        public int compare(Contacto c1, Contacto c2){
            String nombrecompletoc1 = c1.getApellido()+c1.getNombre();
            String nombrecompletoc2 = c2.getApellido()+c2.getNombre();
            return nombrecompletoc1.compareToIgnoreCase(nombrecompletoc2);
        }
    };

    public static final Comparator<Contacto> POR_EMPRESA = new Comparator<Contacto>() {
        public int compare(Contacto c1, Contacto c2){
            if(c1 instanceof ContactoPersona){
                return 1;
            }
            if(c2 instanceof ContactoPersona){
                return -1;
            }
            ContactoEmpresa ce1 = (ContactoEmpresa) c1;
            ContactoEmpresa ce2 = (ContactoEmpresa) c2;
            return ce1.getNombreEmpresa().compareToIgnoreCase(ce2.getNombreEmpresa());
        }
    };

    







}
