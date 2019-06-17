package ar.edu.calculadora.myCalculadora.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class validacion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	
	public String mensaje = "Los campos Re(Z1) y Img(Z1) son obligatorio";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			validacion dialog = new validacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(false);
			dialog.setTitle("Error");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public validacion() {
		setBackground(new Color(128, 0, 128));
		setBounds(100, 100, 582, 158);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblMensajeValTransformacion = new JLabel("mesaje");
			lblMensajeValTransformacion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblMensajeValTransformacion.setForeground(new Color(255, 0, 0));
			lblMensajeValTransformacion.setBounds(50, 25, 338, 50);
			contentPanel.add(lblMensajeValTransformacion);
			lblMensajeValTransformacion.setText(mensaje);
	
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}

}
