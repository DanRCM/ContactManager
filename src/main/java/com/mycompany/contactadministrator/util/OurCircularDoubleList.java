/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.contactadministrator.util;

class NodoDobleCircular<E> {
    E dato;                    
    NodoDobleCircular<E> siguiente; 
    NodoDobleCircular<E> anterior;  

    // Constructor 
    public NodoDobleCircular(E dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}

/**
 *
 * @author EIMMY OCHOA
 */
public class OurCircularDoubleList<E> {
    private NodoDobleCircular<E> cabeza; 
    private int tamaño;    

    // Constructor para inicializar la lista como vacía
    public OurCircularDoubleList() {
        this.cabeza = null;
        this.tamaño = 0;
    }

    // Método para añadir un elemento al final de la lista
    public void agregar(E dato) {
        NodoDobleCircular<E> nuevoNodo = new NodoDobleCircular<>(dato);
        if (cabeza == null) {          
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior; 
            cola.siguiente = nuevoNodo;   
            nuevoNodo.anterior = cola;     
            nuevoNodo.siguiente = cabeza;   
            cabeza.anterior = nuevoNodo;     
        }
        tamaño++;
    }

    // Método para añadir un elemento al inicio de la lista
    public void agregarPrimero(E dato) {
        NodoDobleCircular<E> nuevoNodo = new NodoDobleCircular<>(dato);
        if (cabeza == null) {       
            cabeza = nuevoNodo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior; 
            nuevoNodo.siguiente = cabeza;    
            nuevoNodo.anterior = cola;      
            cola.siguiente = nuevoNodo;    
            cabeza.anterior = nuevoNodo;    
            cabeza = nuevoNodo;      
        }
        tamaño++;
    }

    // Método para obtener el primer elemento de la lista
    public E obtenerPrimero() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.dato;
    }

    // Método para obtener el último elemento de la lista
    public E obtenerUltimo() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        return cabeza.anterior.dato; 
    }

    // Método para eliminar el primer elemento de la lista
    public E eliminarPrimero() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cabeza.dato;
        if (cabeza.siguiente == cabeza) {
            cabeza = null;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior;
            cabeza = cabeza.siguiente;   
            cabeza.anterior = cola;    
            cola.siguiente = cabeza;  
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para eliminar el último elemento de la lista
    public E eliminarUltimo() {
        if (cabeza == null) {
            throw new IllegalStateException("La lista está vacía");
        }
        E datoEliminado = cabeza.anterior.dato;
        if (cabeza.siguiente == cabeza) { 
            cabeza = null;
        } else {
            NodoDobleCircular<E> cola = cabeza.anterior;
            cola.anterior.siguiente = cabeza;  
            cabeza.anterior = cola.anterior;  
        }
        tamaño--;
        return datoEliminado;
    }

    // Método para verificar si un elemento está en la lista
    public boolean contiene(E dato) {
        if (cabeza == null) return false;

        NodoDobleCircular<E> actual = cabeza;
        do {
            if (actual.dato.equals(dato)) {
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        return false; 
    }

    // Método para obtener el tamaño actual de la lista
    public int tamano() {
        return tamaño;
    }

    // Método para verificar si la lista está vacía
    public boolean estaVacia() {
        return tamaño == 0;
    }

    // Método para imprimir la lista completa desde la cabeza hasta la cola
    public void printList() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        NodoDobleCircular<E> actual = cabeza;
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println("(cabeza)"); 
    }

    // Método para imprimir la lista completa desde la cola hasta la cabeza (recorrido inverso)
    public void printListReverse() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }
        NodoDobleCircular<E> actual = cabeza.anterior; // Comienza desde la cola
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.anterior;
        } while (actual != cabeza.anterior);
        System.out.println("(cabeza en reversa)"); // Indicar el final de la lista y referencia inversa
    }
    
}
