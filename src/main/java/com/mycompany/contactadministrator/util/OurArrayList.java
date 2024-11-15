package com.mycompany.contactadministrator.util;

import java.lang.reflect.Array;
import java.util.Iterator;

public class OurArrayList<E> implements Iterable<E> {
    private E[] array;
    private int size = 0;
    private int capacidad;
    private Class<E> tipo;

    public OurArrayList(Class<E> tipo) {
        this(tipo, 10);
    }

    @SuppressWarnings("unchecked")
    public OurArrayList(Class<E> tipo, int capacidadInicial) {
        this.tipo = tipo;
        this.capacidad = capacidadInicial;
        this.array = (E[]) Array.newInstance(tipo, capacidad);
    }

    public void agregar(E elemento) {
        if (size == capacidad) {
            expandirCapacidad();
        }
        array[size] = elemento;
        size++;
    }

    @SuppressWarnings("unchecked")
    private void expandirCapacidad() {
        capacidad = capacidad + (capacidad / 2);
        E[] nuevoArray = (E[]) Array.newInstance(tipo, capacidad);
        System.arraycopy(array, 0, nuevoArray, 0, size);
        array = nuevoArray;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public E obtener(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return array[index];
    }

    // nuestra implementacion del método iterator
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No hay más elementos");
                }
                return array[index++];
            }
        };
    }
}
