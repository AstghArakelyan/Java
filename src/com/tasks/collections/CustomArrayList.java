package com.tasks.collections;

import java.util.Arrays;

public class CustomArrayList<E> {
    private int size;
    private Object[] objects;
    private final int DEFAULT_CAPACITY = 10;

    public CustomArrayList() {
        objects = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        objects = Arrays.copyOf(objects, size * 2);
    }

    public void add(E element) {
        if (objects.length == size) {
            ensureCapacity();
        }
        objects[size++] = element;

    }

    public E set(int index, E element) {
        if(index >= 0 && index < size) {
            E oldElement = (E) objects[index];
            objects[index] = element;
            return oldElement;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeByElement(E element) {
        int index = indexOf(element);
        if(index > 0) {
            removeByIndex(index);
        } else {
            System.out.println("The ArrayList doesn't contain this element");
        }
    }

    public void removeByIndex(int index) {
        if(index >= 0 && index < size) {
            for(int i = index; i < size - 1; i++) {
                objects[i] = objects[i + 1];
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (objects[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (objects[i] == element) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void print() {
        System.out.print("[");
        for(int i = 0; i < size; i++) {
            if(i != size - 1) {
                System.out.print(objects[i] + ", ");
            } else {
                System.out.print(objects[i]);
            }
        }
        System.out.println("]");
    }
}
