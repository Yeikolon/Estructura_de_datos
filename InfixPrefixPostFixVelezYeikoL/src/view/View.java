package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnConvertir;
	private JButton btnLimpiar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 953, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Infix Expression");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Sans", Font.BOLD, 22));
		lblNewLabel.setBounds(172, 44, 183, 54);
		panel.add(lblNewLabel);
		
		JLabel lblExpresinPostfija = new JLabel("Postfix Expression");
		lblExpresinPostfija.setForeground(Color.WHITE);
		lblExpresinPostfija.setFont(new Font("Lucida Sans", Font.BOLD, 22));
		lblExpresinPostfija.setBounds(545, 44, 215, 54);
		panel.add(lblExpresinPostfija);
		
		btnConvertir = new JButton("Convert");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConvertir.setBackground(SystemColor.textHighlight);
		btnConvertir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConvertir.setBounds(376, 353, 89, 23);
		panel.add(btnConvertir);
		
		btnLimpiar = new JButton("Clean");
		btnLimpiar.setBackground(new Color(255, 99, 71));
		btnLimpiar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpiar.setBounds(475, 353, 89, 23);
		panel.add(btnLimpiar);
		
		textField = new JTextField();
		textField.setBounds(170, 109, 183, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblResultado = new JLabel("Result");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Lucida Sans", Font.BOLD, 22));
		lblResultado.setBounds(172, 177, 89, 54);
		panel.add(lblResultado);
		
		JLabel lblExpresinPrefija = new JLabel("Prefix Expression");
		lblExpresinPrefija.setForeground(Color.WHITE);
		lblExpresinPrefija.setFont(new Font("Lucida Sans", Font.BOLD, 22));
		lblExpresinPrefija.setBounds(545, 177, 202, 54);
		panel.add(lblExpresinPrefija);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(172, 242, 183, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(545, 109, 183, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(545, 242, 183, 20);
		panel.add(textField_3);
	}
	
	public JButton getBtnConvertir() {
	    return btnConvertir;
	}

	public JButton getBtnLimpiar() {
	    return btnLimpiar;
	}

	public JTextField getTextFieldInfija() {
	    return textField; 
	}

	public JTextField getTextFieldPostfija() {
	    return textField_2; 
	}

	public JTextField getTextFieldResultado() {
	    return textField_1;
	}

	public JTextField getTextFieldPrefija() {
	    return textField_3;
	}
}
