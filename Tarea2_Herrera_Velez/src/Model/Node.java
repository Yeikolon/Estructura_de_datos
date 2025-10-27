package Model;

public class Node {
    private Book data;
    private Node next;
    
    
    public Node() {
        data = null;
        next = null;
    }
    
    public Node(Book data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public void setData(Book data) {
        this.data = data;
    }
    
    public Book getData() {
        return data;
    }
    
    public Node getNext() {
        return next;
    }
}