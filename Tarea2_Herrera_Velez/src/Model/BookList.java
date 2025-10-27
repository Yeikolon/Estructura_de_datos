package Model;

public class BookList {
    private Node head;
    
    public BookList() {
        head = null;
    }
    
    // Insertar al inicio
    public void insertAtBeginning(Book data) {
        Node newNode = new Node(data, null);
        newNode.setNext(head);
        head = newNode;
    }
    
    // Insertar al final
    public void insertAtEnd(Book data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }
    
    // Eliminar libro por ISBN
    public boolean deleteBook(String isbn) {
    	boolean retorno = true;
        if (head == null) {
        	retorno = false;
        }
        
        if (head.getData().getIsbn().equals(isbn)) {
            head = head.getNext();
            retorno = true;
        }
        
        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().getIsbn().equals(isbn)) {
                current.setNext(current.getNext().getNext());
                retorno = true;
            }
            current = current.getNext();
        }
        return retorno;
    }
    
    // Buscar libro por ISBN
    public Book searchBook(String isbn) {
        Node current = head;
        while (current != null) {
            if (current.getData().getIsbn().equals(isbn)) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    
    // Mostrar todos los libros (para la tabla)
    public Book[] getAllBooks() {
        int count = countBooks();
        if (count == 0) {
            return new Book[0]; // Retornar array vacío en lugar de null
        }
        
        Book[] books = new Book[count];
        Node current = head;
        int index = 0;
        
        while (current != null && index < count) {
            books[index++] = current.getData();
            current = current.getNext();
        }
        return books;
    }
    
    // Contar libros
    public int countBooks() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    
    // Verificar si está vacía
    public boolean isEmpty() {
        return head == null;
    }
}