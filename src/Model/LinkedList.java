package model;

public class LinkedList <T>{
    private Node <T> head;
    private int size = 0;

    public Node<T> getHead() {
        return head;
    }
    public void setHead(Node<T> head) {
        this.head = head;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    public void appendToTail(T value){
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Node<T> findByValue(T value){
        Node<T> current = head;
        while (current != null) {
            if (current.getValue().equals(value)) {
                return current; 
            }
            current = current.getNext();
        }
        return null; 
    }

    public void deleteByValue (T value){
        if (head == null) return;
        if (head.getValue().equals(value)) {
            head = head.getNext();
            size--;
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue().equals(value)) {
                current.setNext(current.getNext().getNext());
                size--;
                return;
            }
            current = current.getNext();
        }
    }
    
    public void print(){
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}
