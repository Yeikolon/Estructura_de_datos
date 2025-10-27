package View;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.*;

import Controller.BookController;

public class Ventana extends JFrame {
    public Ventana() {
        setTitle("SISTEMA DE BIBLIOTECA - GESTIÓN DE LIBROS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 650);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(240, 245, 250));
        
        PanelFormulario panelFormulario = new PanelFormulario();
        PanelDatos panelDatos = new PanelDatos();
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelFormulario, panelDatos.panelContenido);
        splitPane.setDividerLocation(450);
        splitPane.setDividerSize(8);
        splitPane.setBackground(new Color(220, 230, 240));
        splitPane.setBorder(BorderFactory.createLineBorder(new Color(180, 200, 220), 2));
        add(splitPane, BorderLayout.CENTER);


     // Crear el controlador
        BookController controller = new BookController(panelFormulario, panelDatos);
        
        // Conectar los listeners de los botones del formulario
        setupFormularioListeners(controller, panelFormulario, panelDatos);
        
        // Conectar los listeners de los botones del panel de datos
        setupDatosListeners(controller, panelFormulario, panelDatos);
    }

    private void setupFormularioListeners(BookController controller, PanelFormulario panelFormulario, PanelDatos panelDatos) {
        JButton btnInsertarInicio = panelFormulario.getBtnInsertarInicio();
        JButton btnInsertarFinal = panelFormulario.getBtnInsertarFinal();
        JButton btnEliminar = panelFormulario.getBtnEliminar();
        JButton btnBuscar = panelFormulario.getBtnBuscar();
        
        if (btnInsertarInicio != null) {
            btnInsertarInicio.addActionListener(e -> controller.onInsertarInicio());
        }
        
        if (btnInsertarFinal != null) {
            btnInsertarFinal.addActionListener(e -> controller.onInsertarFinal());
        }
        
        if (btnEliminar != null) {
            btnEliminar.addActionListener(e -> controller.onEliminar());
        }
        
        if (btnBuscar != null) {
            btnBuscar.addActionListener(e -> controller.onBuscar());
        }
    }
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        SwingUtilities.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }
    
    private void setupDatosListeners(BookController controller, PanelFormulario panelFormulario, PanelDatos panelDatos) {
        
    	JButton btnRefrescar = panelDatos.getBtnRefrescar();
        JButton btnLimpiarTabla = panelDatos.getBtnLimpiarTabla();
        
        if (btnRefrescar != null) {
            btnRefrescar.addActionListener(e -> controller.onRefrescar());
        }
        
        if (btnLimpiarTabla != null) {
            btnLimpiarTabla.addActionListener(e -> controller.onLimpiarTabla());
        }
    }
    

}