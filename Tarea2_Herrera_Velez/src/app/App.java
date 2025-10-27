package app;

import javax.swing.SwingUtilities;

import View.Ventana;

public class App {

	public static void main(String[] args) {
		try {
            javax.swing.UIManager.setLookAndFeel(
                javax.swing.UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Ejecutar en el Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            Ventana mainWindow = new Ventana();
            mainWindow.setVisible(true);
        });
	}

}
