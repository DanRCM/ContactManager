package com.mycompany.contactadministrator.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mycompany.contactadministrator.model.Contacto;

public class Serializador {
    private Serializador(){}

    @SuppressWarnings("unchecked")
    public static OurCircularDoubleList<Contacto> deserializarLista(String archivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (OurCircularDoubleList<Contacto>) in.readObject(); // Lee el objeto y lo convierte a una lista
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al deserializar la lista: " + e.getMessage());
            return DataLoader.cargarDatos();
        }
    }

    public static void serializarLista(OurCircularDoubleList<Contacto> lista, String ruta) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta))) {
            out.writeObject(lista);
        } catch (IOException e) {
            System.err.println("Error al serializar la lista: " + e.getMessage());
        }
    }
}
