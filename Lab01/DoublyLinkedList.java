package it.unimi.di.sweng.Lab01;

public class DoublyLinkedList<T> {
    // WE USE FIRST AND LAST AS POINTERS TO THE RELATIVES FIRST NODE AND LAST NODE
    private DNode<T> first; // Primeiro no da lista
    private DNode<T> last;  // Ultimo no da lista
    private int size;       // Tamanho da lista

    // Construtor (cria lista vazia com dois nos sentinelas)
    public DoublyLinkedList() {
        first = new DNode<T>(null, null, null);
        last = new DNode<T>(null, first, null); // Antes do ultimo vem o primeiro
        first.setNext(last); // A seguir ao primeiro vem o ultimo
        size = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return size;
    }

    // Devolve true se a lista estiver vazia ou falso caso contrario
    public boolean isEmpty() {
        return (size == 0);
    }

    // Insert at the front
    public void unshift(T v) {
        if (size==0) {
            DNode<T> newNode = new DNode<>(v, first, last);
            last.setPrev(newNode);
            first.setNext(newNode);
        } else {
            DNode<T> newNode = new DNode<>(v, first, first.getNext());
            first.getNext().setPrev(newNode);
            first.setNext(newNode);
        }
        size++;
    }

    // Insert at the back
    public void push(T v) {
        if (size==0) {
            DNode<T> newNode = new DNode<>(v, first, last);
            last.setPrev(newNode);
            first.setNext(newNode);
        } else{
            DNode<T> newNode = new DNode<>(v, last.getPrev(), last);
            last.getPrev().setNext(newNode);
            last.setPrev(newNode);
        }
        size++;
    }

    // Remove at front
    public T shift() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty list");
        } else {
            if (size == 1) {
                DNode<T> aux = first.getNext();
                first.setNext(last);
                last.setPrev(first);
                size--;
                return aux.getValue();
            } else {
                DNode<T> aux = first.getNext();
                aux.getNext().setPrev(first);
                first.setNext(aux.getNext());
                size--;
                return aux.getValue();
            }
        }
    }

    // Remove at the back
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Empty list");
        } else {
            if (size == 1) {
                DNode<T> aux = last.getPrev();
                first.setNext(last);
                last.setPrev(first);
                size--;
                return aux.getValue();
            } else {
                DNode<T> aux = last.getPrev();
                aux.getPrev().setNext(last);
                last.setPrev(aux.getPrev());
                size--;
                return aux.getValue();
            }
        }
    }


}