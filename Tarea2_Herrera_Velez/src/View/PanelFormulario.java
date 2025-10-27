package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelFormulario extends JPanel {
	// Referencias directas a los componentes
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtIsbn;
    private JComboBox<String> comboGenero;
    private JSpinner spinnerAnio;
    private JTextArea txtAreaDescripcion;
    private JButton btnInsertarInicio;
    private JButton btnInsertarFinal;
    private JButton btnEliminar;
    private JButton btnBuscar;
    
    public PanelFormulario() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setBackground(new Color(245, 250, 255));
        
        // Inicializar componentes con nombres más claros
        txtTitulo = new JTextField(20);
        txtAutor = new JTextField(20);
        txtIsbn = new JTextField(20);
        String[] generos = {"Seleccione género", "Ficción", "No Ficción", "Ciencia Ficción", "Fantasía", "Misterio", "Romance", "Biografía", "Historia", "Ciencia"};
        comboGenero = new JComboBox<>(generos);
        SpinnerNumberModel model = new SpinnerNumberModel(2024, 1000, 2024, 1);
        spinnerAnio = new JSpinner(model);
        txtAreaDescripcion = new JTextArea(5, 20);
        txtAreaDescripcion.setLineWrap(true);
        txtAreaDescripcion.setWrapStyleWord(true);
        
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setBackground(Color.WHITE);
        panelPrincipal.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Formulario de Ingreso de Libros");
        lblTitulo.setBounds(70, 10, 300, 25);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(new Color(60, 90, 150));
        panelPrincipal.add(lblTitulo);
        
        // Configurar posición de los componentes
        txtTitulo.setBounds(130, 59, 200, 25);
        txtAutor.setBounds(130, 95, 200, 25);
        txtIsbn.setBounds(130, 130, 200, 25);
        comboGenero.setBounds(130, 165, 200, 25);
        spinnerAnio.setBounds(130, 200, 200, 25);
        txtAreaDescripcion.setBounds(130, 235, 200, 120);
        
        // Aplicar estilos comunes a los campos de texto
        Component[] campos = {txtTitulo, txtAutor, txtIsbn};
        for (Component campo : campos) {
            if (campo instanceof JTextField) {
                ((JTextField) campo).setFont(new Font("Arial", Font.PLAIN, 12));
                ((JTextField) campo).setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(150, 150, 150)),
                    BorderFactory.createEmptyBorder(3, 5, 3, 5)
                ));
            }
        }
        
        // Estilizar comboBox
        comboGenero.setBackground(Color.WHITE);
        comboGenero.setFont(new Font("Arial", Font.PLAIN, 12));
        comboGenero.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(150, 150, 150)),
            BorderFactory.createEmptyBorder(3, 5, 3, 5)
        ));
        
        // Estilizar spinner
        spinnerAnio.setFont(new Font("Arial", Font.PLAIN, 12));
        
        // Estilizar área de texto
        txtAreaDescripcion.setFont(new Font("Arial", Font.PLAIN, 12));
        txtAreaDescripcion.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(150, 150, 150)),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        txtAreaDescripcion.setBackground(new Color(250, 255, 250));
        
        // Agregar componentes al panel principal
        panelPrincipal.add(txtTitulo);
        panelPrincipal.add(txtAutor);
        panelPrincipal.add(txtIsbn);
        panelPrincipal.add(comboGenero);
        panelPrincipal.add(spinnerAnio);
        panelPrincipal.add(txtAreaDescripcion);
        
        // Etiquetas
        String[] etiquetas = {"Título:", "Autor:", "ISBN:", "Género:", "Año:", "Descripción:"};
        int[] posY = {60, 95, 130, 165, 200, 235};
        
        for (int i = 0; i < etiquetas.length; i++) {
            JLabel label = new JLabel(etiquetas[i]);
            label.setFont(new Font("Arial", Font.BOLD, 14));
            label.setForeground(new Color(80, 80, 80));
            label.setBounds(30, posY[i], 90, 25);
            panelPrincipal.add(label);
        }
        
        // Botones de operaciones
        btnInsertarInicio = new JButton("Insertar Inicio");
        btnInsertarFinal = new JButton("Insertar Final");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");
        
        // Posicionar botones
        btnInsertarInicio.setBounds(30, 370, 100, 30);
        btnInsertarFinal.setBounds(140, 370, 100, 30);
        btnEliminar.setBounds(250, 370, 80, 30);
        btnBuscar.setBounds(340, 370, 80, 30);
        
        // Estilizar botones
        estilizarBotonOperacion(btnInsertarInicio, new Color(80, 160, 80));
        estilizarBotonOperacion(btnInsertarFinal, new Color(60, 140, 220));
        estilizarBotonOperacion(btnEliminar, new Color(220, 80, 60));
        estilizarBotonOperacion(btnBuscar, new Color(220, 160, 60));
        
        // Agregar botones al panel
        panelPrincipal.add(btnInsertarInicio);
        panelPrincipal.add(btnInsertarFinal);
        panelPrincipal.add(btnEliminar);
        panelPrincipal.add(btnBuscar);
        
        add(panelPrincipal, BorderLayout.CENTER);
    }
    
    // GETTERS CORREGIDOS - Ahora retornan las referencias directas
    public String getTitulo() {
        return txtTitulo.getText().trim();
    }

    public String getAutor() {
        return txtAutor.getText().trim();
    }

    public String getIsbn() {
        return txtIsbn.getText().trim();
    }

    public String getGenero() {
        return comboGenero.getSelectedIndex() > 0 ? comboGenero.getSelectedItem().toString() : "";
    }

    public int getAnio() {
        return (int) spinnerAnio.getValue();
    }

    public String getDescripcion() {
        return txtAreaDescripcion.getText().trim();
    }

    // GETTERS para botones - ahora retornan las referencias directas
    public JButton getBtnInsertarInicio() {
        return btnInsertarInicio;
    }

    public JButton getBtnInsertarFinal() {
        return btnInsertarFinal;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    // Método para limpiar el formulario
    public void clearForm() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtIsbn.setText("");
        comboGenero.setSelectedIndex(0);
        spinnerAnio.setValue(2024);
        txtAreaDescripcion.setText("");
    }
    
    private void estilizarBotonOperacion(JButton boton, Color colorBase) {
        boton.setFont(new Font("Arial", Font.BOLD, 11));
        boton.setBackground(colorBase);
        boton.setForeground(Color.WHITE);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(colorBase.darker()),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        boton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(colorBase.brighter());
            }
            public void mouseExited(MouseEvent e) {
                boton.setBackground(colorBase);
            }
        });
    }
    
    
}