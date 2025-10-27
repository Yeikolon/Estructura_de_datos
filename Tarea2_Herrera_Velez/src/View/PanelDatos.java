package View;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class PanelDatos{
    
	 	public JPanel panelContenido;
	    private JTable tablaLibros;
	    private DefaultTableModel modeloTabla;
	    private JTextArea areaDetalles;
	    private JButton btnRefrescar;
	    private JButton btnLimpiarTabla;
	    
	    public PanelDatos() {
	        panelContenido = new JPanel(new BorderLayout());
	        panelContenido.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
	        panelContenido.setBackground(new Color(245, 250, 255));
	        
	        String[] columnas = {"Título", "Autor", "ISBN", "Año", "Género"};
	        modeloTabla = new DefaultTableModel(columnas, 0) {
	            @Override 
	            public boolean isCellEditable(int row, int column) { 
	                return false; 
	            }
	        };
	        
	        tablaLibros = new JTable(modeloTabla);
	        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        tablaLibros.setFont(new Font("Arial", Font.PLAIN, 12));
	        tablaLibros.setRowHeight(25);
	        tablaLibros.setSelectionBackground(new Color(200, 220, 255));
	        tablaLibros.setSelectionForeground(Color.BLACK);
	        tablaLibros.setGridColor(new Color(220, 220, 220));
	        
	        //Ajustar ancho de las columnas
	        tablaLibros.getColumnModel().getColumn(0).setPreferredWidth(150); // Título
	        tablaLibros.getColumnModel().getColumn(1).setPreferredWidth(120); // Autor
	        tablaLibros.getColumnModel().getColumn(2).setPreferredWidth(100); // ISBN
	        tablaLibros.getColumnModel().getColumn(3).setPreferredWidth(60);  // Año
	        tablaLibros.getColumnModel().getColumn(4).setPreferredWidth(100); // Género
	        
	        JTableHeader header = tablaLibros.getTableHeader();
	        header.setFont(new Font("Arial", Font.BOLD, 13));
	        header.setBackground(new Color(70, 130, 180));
	        header.setForeground(Color.WHITE);
	        header.setReorderingAllowed(false);
	        
	        areaDetalles = new JTextArea(8, 30);
	        areaDetalles.setEditable(false);
	        areaDetalles.setLineWrap(true);
	        areaDetalles.setWrapStyleWord(true);
	        areaDetalles.setText("Seleccione un libro para ver sus detalles...");
	        areaDetalles.setFont(new Font("Arial", Font.PLAIN, 12));
	        areaDetalles.setBackground(new Color(250, 255, 250));
	        areaDetalles.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(new Color(200, 220, 240)),
	            BorderFactory.createEmptyBorder(8, 8, 8, 8)
	        ));
	        
	        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	        splitPane.setDividerSize(6);
	        splitPane.setBackground(new Color(220, 230, 240));
	        
	        JPanel panelTabla = new JPanel(new BorderLayout());
	        panelTabla.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
	            "LISTA DE LIBROS",
	            javax.swing.border.TitledBorder.LEFT,
	            javax.swing.border.TitledBorder.TOP,
	            new Font("Arial", Font.BOLD, 14),
	            new Color(60, 100, 150)
	        ));
	        panelTabla.setBackground(Color.WHITE);
	        panelTabla.add(new JScrollPane(tablaLibros), BorderLayout.CENTER);
	        
	        JPanel panelDetalles = new JPanel(new BorderLayout());
	        panelDetalles.setBorder(BorderFactory.createTitledBorder(
	            BorderFactory.createLineBorder(new Color(70, 130, 180), 2),
	            "DETALLES DEL LIBRO",
	            javax.swing.border.TitledBorder.LEFT,
	            javax.swing.border.TitledBorder.TOP,
	            new Font("Arial", Font.BOLD, 14),
	            new Color(60, 100, 150)
	        ));
	        panelDetalles.setBackground(Color.WHITE);
	        panelDetalles.add(new JScrollPane(areaDetalles), BorderLayout.CENTER);
	        
	        splitPane.setTopComponent(panelTabla);
	        splitPane.setBottomComponent(panelDetalles);
	        splitPane.setDividerLocation(300);
	        
	        // Crear botones
	        btnRefrescar = new JButton("Refrescar");
	        btnLimpiarTabla = new JButton("Limpiar");

	        estilizarBoton(btnRefrescar, new Color(70, 130, 180));
	        estilizarBoton(btnLimpiarTabla, new Color(200, 80, 80));

	        JPanel panelBotonesTabla = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	        panelBotonesTabla.setBackground(Color.WHITE);
	        panelBotonesTabla.add(btnRefrescar);
	        panelBotonesTabla.add(btnLimpiarTabla);

	        panelTabla.add(panelBotonesTabla, BorderLayout.SOUTH);
	        panelContenido.add(splitPane, BorderLayout.CENTER);
	    }
	    
	    // Getters para acceder a los componentes
	    public JTable getTablaLibros() {
	        return tablaLibros;
	    }
	    
	    public DefaultTableModel getModeloTabla() {
	        return modeloTabla;
	    }
	    
	    public JTextArea getAreaDetalles() {
	        return areaDetalles;
	    }
	    
	    public JButton getBtnRefrescar() {
	        return btnRefrescar;
	    }
	    
	    public JButton getBtnLimpiarTabla() {
	        return btnLimpiarTabla;
	    }
	    
	    private void estilizarBoton(JButton boton, Color colorBase) {
	        boton.setFont(new Font("Arial", Font.BOLD, 12));
	        boton.setBackground(colorBase);
	        boton.setForeground(Color.WHITE);
	        boton.setFocusPainted(false);
	        boton.setBorder(BorderFactory.createCompoundBorder(
	            BorderFactory.createLineBorder(colorBase.darker()),
	            BorderFactory.createEmptyBorder(5, 10, 5, 10)
	        ));
	        boton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        
	        boton.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                boton.setBackground(colorBase.brighter());
	            }
	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                boton.setBackground(colorBase);
	            }
	        });
	    }
	
}

















