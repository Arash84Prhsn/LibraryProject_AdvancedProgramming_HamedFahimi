// A queue implemented using a linked list structure.
public class Queue<T> {

    private class Node<T> {

        private T element;
        private Node<T> next;

        public Node(T element, Node<T> next) {
            this.element = element;
            this.next = next;
        }

        public void setElement(T element) {this.element = element;}
        public void setNext(Node<T> next) {this.next = next;}

        public T getElement() {return element;}
        public Node<T> getNext() {return next;}

    }

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public Queue(){}

    public boolean isEmpty() {return size==0;}

    public T peek() {
        if (isEmpty()) return null;

        return head.getElement();
    }

    public void enqueue(T newElement) {
        
        Node<T> newNode = new Node(newElement, null);

        if (isEmpty()) {
            
            head = newNode;
            tail = newNode;
            head.setNext(tail);  
            size++; 
            return;
        }

        tail.setNext(newNode);
        tail = newNode;
        size++;
    }

    public T dequeue() {
        
        if (isEmpty()) return null;

        T item = head.getElement();
        head = head.next;
        size--;
        return item;
    }

    public void enqueue(T[] items) {
        for (T i : items)
            this.enqueue(i);
    }
}