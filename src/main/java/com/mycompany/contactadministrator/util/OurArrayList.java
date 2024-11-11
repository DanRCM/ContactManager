/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.util;

import java.lang.reflect.Array;

/**
 *
 * @author EIMMY OCHOA
 */
public class OurArrayList<E> {
    private E[] array;       
    private int tamaño = 0;   
    private int capacidad;  
    private Class<E> tipo;   

    //Constructor con capacidad predeterminada
    public OurArrayList(Class<E> tipo) {
        this(tipo, 10); 
    }

    // Constructor con capacidad inicial personalizada
    @SuppressWarnings("unchecked")
    public OurArrayList(Class<E> tipo, int capacidadInicial) {
        this.tipo = tipo;
        this.capacidad = capacidadInicial;
        this.array = (E[]) Array.newInstance(tipo, capacidad); // Crear un array de tipo E con la capacidad inicial
    }

    // Método para añadir un elemento al final de la lista
    public void agregar(E elemento) {
        if (tamaño == capacidad) {
            expandirCapacidad(); // Expandir si se alcanza la capacidad
        }
        array[tamaño] = elemento; // Añadir el elemento al final
        tamaño++; // Incrementar el tamaño
    }

    // Método para añadir un elemento en una posición específica
    public void agregarIndex(int index, E elemento) {
        if (index < 0 || index > tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        if (tamaño == capacidad) {
            expandirCapacidad(); 
        }
        
        for (int i = tamaño; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = elemento; 
        tamaño++;
    }

    // Método para obtener el elemento en una posición específica
    public E obtener(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return array[index];
    }

    // Método para establecer un nuevo valor en una posición específica
    public void colocar(int index, E elemento) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        array[index] = elemento;
    }

    // Método para eliminar un elemento en una posición específica
    public E eliminar(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        E elementoEliminado = array[index];
        for (int i = index; i < tamaño - 1; i++) {
            array[i] = array[i + 1];
        }
        array[tamaño - 1] = null; 
        tamaño--;
        return elementoEliminado; 
    }

    // Método para verificar si un elemento está en la lista
    public boolean contiene(E elemento) {
        for (int i = 0; i < tamaño; i++) {
            if (array[i].equals(elemento)) {
                return true; 
            }
        }
        return false;
    }

    // Método para obtener el tamaño actual de la lista
    public int size() {
        return tamaño;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }

    // Método para expandir la capacidad del ArrayList cuando se llena
    @SuppressWarnings("unchecked")
    private void expandirCapacidad() {
        capacidad = capacidad + (capacidad / 2); 
        E[] nuevoArray = (E[]) Array.newInstance(tipo, capacidad); 
        
        for (int i = 0; i < tamaño; i++) {
            nuevoArray[i] = array[i];
        }
        array = nuevoArray; 
    }

    // Método para imprimir la lista completa
    public void printList() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    
}
