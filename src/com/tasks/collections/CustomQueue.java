package com.tasks.collections;

import java.util.Arrays;

public class CustomQueue<E> {
    private int first, last, size;
    private Object[] queue;

    public CustomQueue(int size) {
        this.size = size;
        first = last = 0;
        queue = new Object[size];
    }

    public void enqueue(E element) {
        if(size == last) {
            ensureCapacity();
        }
        queue[last++] = element;
    }

    public void dequeue() {
        if(size == 0) {
            System.out.println("Queue is empty");
        } else {
            if (last - 1 >= 0)
                System.arraycopy(queue, 1, queue, 0, last - 1);
            if(last < size) {
                queue[last] = 0;
            }
            --last;
        }
    }

    private void ensureCapacity() {
        size *= 2;
        queue = Arrays.copyOf(queue, size);
    }

    public void firstElement() {
        if(first == last) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("First element: " + queue[first]);
        }
    }

    private void print() {
        System.out.print("[");
        for(int i = first; i < last; i++) {
            if(i != last - 1) {
                System.out.print(queue[i] + ", ");
            } else {
                System.out.print(queue[i]);
            }
        }
        System.out.println("]");
    }
}
