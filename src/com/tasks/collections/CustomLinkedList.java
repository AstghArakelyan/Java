package com.tasks.collections;

public class CustomLinkedList<E> {
    private Node<E> first;
    private Node<E> last;
    private int length;

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            newNode.next = null;
            last = newNode;
        }
        length++;
    }

    public void add(int index, E value) {
        if (index >= 0 && index < length) {
            if (index == 0) {
                addFirst(value);
            } else {
                Node<E> newNode = new Node<>(value);
                Node<E> node = first;
                int i = 0;
                while (i++ < index) {
                    node = node.next;
                }
                node.prev.next = newNode;
                newNode.prev = node.prev;
                node.prev = newNode;
                newNode.next = node;
                length++;
            }
        }
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            newNode.prev = null;
        }
        length++;
    }

    public E remove(int index) {
        if (index >= 0 && index < length) {
            Node<E> removedNode = first;
            int i = 0;
            if (index == 0 && length == 1) {
                first = last = null;
            } else if (index == 0) {
                first.next.prev = null;
                first = first.next;
            } else if (index == length - 1) {
                removedNode = last;
                last.prev.next = null;
                last = last.prev;
            } else {
                while (i++ < index) {
                    removedNode = removedNode.next;
                }
                removedNode.next.prev = removedNode.prev;
                removedNode.prev.next = removedNode.next;
            }
            length--;
            return removedNode.value;
        }
        return null;
    }

    public E removeFirst() {
        if (length > 0) {
            Node<E> removedNode = first;
            if (length == 1) {
                first = last = null;
            } else {
                first.next.prev = null;
                first = first.next;
            }
            length--;
            return removedNode.value;
        }
        return null;
    }

    public E removeLast() {
        if (length > 0) {
            Node<E> removedNode = last;
            if (length == 1) {
                first = last = null;
            } else {
                last.prev.next = null;
                last = last.prev;
            }
            length--;
            return removedNode.value;
        }
        return null;
    }

    public void clear() {
        if (length > 0) {
            Node<E> node = first;
            Node<E> next;
            while (node != null) {
                next = node.next;
                node.value = null;
                node.prev = null;
                node.next = null;
                node = next;
            }
            first = last = null;
            length = 0;
        }
    }

    public int indexOf(E value) {
        int index = 0;
        if(value == null) {
            for (Node<E> node = first; node != null; node = node.next) {
                if (node.value == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> node = first; node != null; node = node.next) {
                if (value.equals(node.value)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

    public E get(int index) {
        Node<E> node = first;
        int i = 0;
        if (index >= 0 && index <= length) {
            while (i++ < index) {
                node = node.next;
            }
            return node.value;
        }
        return null;
    }

    public E getFirst() {
        return first.value;
    }

    public E getLast() {
        return last.value;
    }

    public int size() {
        return length;
    }

    public void print() {
        if (length > 0) {
            Node<E> currentNode = first;
            StringBuilder list = new StringBuilder("[");
            while (currentNode != null) {
                list.append(currentNode.value).append(", ");
                currentNode = currentNode.next;
            }
            System.out.println(list.substring(0, list.lastIndexOf(", ")) + "]");
        } else {
            System.out.println("[]");
        }
    }
}

class Node<E> {
    E value;
    Node<E> prev;
    Node<E> next;

    Node(E value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
