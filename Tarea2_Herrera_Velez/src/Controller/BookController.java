package Controller;

import Model.Book;
import Model.BookList;
import View.PanelFormulario;
import View.PanelDatos;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookController {
	 
	private BookList bookList;
    private PanelFormulario panelFormulario;
    private PanelDatos panelDatos;
    private DefaultTableModel tableModel;

    public BookController(PanelFormulario panelFormulario, PanelDatos panelDatos) {
        this.bookList = new BookList();
        this.panelFormulario = panelFormulario;
        this.panelDatos = panelDatos;
        this.tableModel = panelDatos.getModeloTabla();
        
        initializeController();
    }

    private void initializeController() {
        setupFormularioListeners();
        setupDatosListeners();
    }

    private void setupFormularioListeners() {
        // Los listeners ya se configuran en Ventana
    }

    private void setupDatosListeners() {
        // Los listeners ya se configuran en Ventana
    }

    // Métodos de operaciones con la lista
    public void insertBookAtBeginning(Book book) {
        bookList.insertAtBeginning(book);
        refreshTable();
        showMessage("Libro insertado al inicio correctamente");
    }

    public void insertBookAtEnd(Book book) {
        bookList.insertAtEnd(book);
        refreshTable();
        showMessage("Libro insertado al final correctamente");
    }

    public void deleteBook(String isbn) {
        boolean deleted = bookList.deleteBook(isbn);
        if (deleted) {
            refreshTable();
            showMessage("Libro eliminado correctamente");
        } else {
            showMessage("No se encontró el libro con ISBN: " + isbn);
        }
    }

    public void searchBook(String isbn) {
        Book book = bookList.searchBook(isbn);
        if (book != null) {
            showBookDetails(book);
            showMessage("Libro encontrado: " + book.getTitle());
        } else {
            showMessage("No se encontró el libro con ISBN: " + isbn);
        }
    }

    public void refreshTable() {
        // Limpiar tabla
        tableModel.setRowCount(0);
        
        // Obtener todos los libros y agregarlos a la tabla
        Book[] books = bookList.getAllBooks();
        for (Book book : books) {
            if (book != null) {
                Object[] row = {
                    book.getTitle(),
                    book.getAuthor(),
                    book.getIsbn(),
                    book.getYear(),
                    book.getGenre()
                };
                tableModel.addRow(row);
            }
        }
    }

    public void clearTable() {
        tableModel.setRowCount(0);
        panelDatos.getAreaDetalles().setText("Seleccione un libro para ver sus detalles...");
        showMessage("Tabla limpiada");
    }

    private void showBookDetails(Book book) {
        JTextArea areaDetalles = panelDatos.getAreaDetalles();
        
        String detalles = "Título: " + book.getTitle() + "\n" +
                         "Autor: " + book.getAuthor() + "\n" +
                         "ISBN: " + book.getIsbn() + "\n" +
                         "Género: " + book.getGenre() + "\n" +
                         "Año: " + book.getYear() + "\n" +
                         "Descripción: " + book.getDescription();
        
        areaDetalles.setText(detalles);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(panelFormulario, message, "Información", 
                                    JOptionPane.INFORMATION_MESSAGE);
    }

    public void onInsertarInicio() {
        Book book = getBookFromForm();
        if (validateBook(book)) {
            insertBookAtBeginning(book);
            clearForm();
        }
    }

    public void onInsertarFinal() {
        Book book = getBookFromForm();
        if (validateBook(book)) {
            insertBookAtEnd(book);
            clearForm();
        }
    }

    public void onEliminar() {
        String isbn = getIsbnFromForm();
        if (!isbn.isEmpty()) {
            deleteBook(isbn);
        } else {
            showMessage("Por favor ingrese un ISBN para eliminar");
        }
    }

    public void onBuscar() {
        String isbn = getIsbnFromForm();
        if (!isbn.isEmpty()) {
            searchBook(isbn);
        } else {
            showMessage("Por favor ingrese un ISBN para buscar");
        }
    }

    public void onRefrescar() {
        refreshTable();
    }

    public void onLimpiarTabla() {
        clearTable();
    }

    // MÉTODOS AUXILIARES PRIVADOS
    private Book getBookFromForm() {
        return new Book(
            panelFormulario.getTitulo(),
            panelFormulario.getAutor(),
            panelFormulario.getIsbn(),
            panelFormulario.getGenero(),
            panelFormulario.getAnio(),
            panelFormulario.getDescripcion()
        );
    }

    private String getIsbnFromForm() {
        return panelFormulario.getIsbn();
    }

    private boolean validateBook(Book book) {
    	boolean retorno = true;
        if (book.getTitle().isEmpty()) {
            showMessage("El título es obligatorio");
            retorno = false;
        }
        if (book.getAuthor().isEmpty()) {
            showMessage("El autor es obligatorio");
            retorno = false;
        }
        if (book.getIsbn().isEmpty()) {
            showMessage("El ISBN es obligatorio");
            retorno = false;
        }
        if (book.getGenre().isEmpty()) {
            showMessage("Debe seleccionar un género");
            retorno = false;
        }
        return retorno;
    }

    private void clearForm() {
        panelFormulario.clearForm();
        showMessage("Formulario procesado correctamente");
    }
	    
	    
}
