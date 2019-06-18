
package ar.edu.calculadora.myCalculadora.vista;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.edu.calculadora.myCalculadora.controladores.CalculosControlador;
import ar.edu.calculadora.myCalculadora.modelo.Complejos;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperacionesBasicas extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNro1;
	private JTextField textFieldNro2;
	private JLabel lblOperaciones;
	private JLabel lblNewLabel;
	private JButton btnCancelar;
	private JLabel lblRespuesta;
	private JComboBox<String> comboBox;
	public CalculosControlador calculosControlador = new CalculosControlador();

	/**
	 * Launch the application.
	 */
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperacionesBasicas frame = new OperacionesBasicas();
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
	public OperacionesBasicas() {
		setTitle("Operaciones Basicas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Nro Complejo");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(80, 64, 104, 22);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Nro Complejo");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(80, 130, 104, 22);
		contentPane.add(label_1);
		
		textFieldNro1 = new JTextField();
		textFieldNro1.setBounds(251, 65, 116, 22);
		contentPane.add(textFieldNro1);
		textFieldNro1.setColumns(10);
		
		textFieldNro2 = new JTextField();
		textFieldNro2.setColumns(10);
		textFieldNro2.setBounds(251, 131, 116, 22);
		contentPane.add(textFieldNro2);
		
		lblOperaciones = new JLabel("Operaciones");
		lblOperaciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOperaciones.setBounds(80, 202, 104, 22);
		contentPane.add(lblOperaciones);
		
		
		 comboBox = new JComboBox<String>();
		comboBox.setBounds(251, 203, 116, 22);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("Resultado :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(80, 259, 104, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Limpiar");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			textFieldNro1.setText(null);
			textFieldNro2.setText(null);
			lblRespuesta.setVisible(false);
			
			}
		});
		btnCalcular.setBounds(80, 321, 170, 25);
		contentPane.add(btnCalcular);
		
		btnCancelar  = new JButton("Cancelar");

		btnCancelar.setBounds(328, 321, 182, 25);
		contentPane.add(btnCancelar);
		
		lblRespuesta = new JLabel("respuesta");
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRespuesta.setBounds(196, 260, 537, 16);
		contentPane.add(lblRespuesta);
		lblRespuesta.setVisible(false);
		comboBox.addItem(" ");
	    comboBox.addItem("Sumar");
	    comboBox.addItem("Resta");
	    comboBox.addItem("Multiplicar");
	    comboBox.addItem("Dividir");
	    
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                myBox(evt);
            }
        });
	 
	
	    
	 
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		dispose(); 
			}
		});
		
		
	}
    protected void myBox(ActionEvent evt) {
     
    	//1=Binomica
    	//2=Polar
		Complejos nro1;
		Complejos nro2;  	
		
	int	intNro1 = calculosControlador.isBinomicaPolar(this.textFieldNro1.getText());
	int intNro2 = calculosControlador.isBinomicaPolar(this.textFieldNro2.getText());
		
	if (intNro1==0) {
		
		 lblRespuesta.setText( "Dato ingresado Incorrecto.Formato correcto Binomica (a,b)  Polar[c,dPI]");
		 lblRespuesta.setVisible(true);
		 
	}else if (intNro2==0) {
		
		 lblRespuesta.setText(" Formato correcto:Binomica(a,b)- Polar[c,dPI]");
		 lblRespuesta.setVisible(true);

	}else if (intNro1 != 0 && intNro2 != 0) {
		
	
		
		nro1=calculosControlador.obtenerParteAB(this.textFieldNro1.getText());
	    
		nro2=calculosControlador.obtenerParteAB(this.textFieldNro2.getText());
		
		
    	
		
		
    	switch (comboBox.getSelectedItem().toString()) {
		case  "Sumar":
			         		
			if(intNro1==2) {
				
				nro2.aBinomica(nro1.modulo, nro1.argumento);
			}
     		
             if(intNro2==2) {

            nro2.aBinomica(nro2.modulo, nro2.argumento);
             }
			
	      lblRespuesta.setText(calculosControlador.sumar(nro1, nro2));
	      lblRespuesta.setVisible(true);
			
			break;

			
		case  "Restar":
			
			if(intNro1==2) {
				
				nro1.aBinomica(nro1.modulo, nro1.argumento);
			}
     		
             if(intNro2==2) {

            nro2.aBinomica(nro2.modulo, nro2.argumento);
             }
		      lblRespuesta.setText(calculosControlador.restar(nro1, nro2));
		      lblRespuesta.setVisible(true);	
			
			break;
			
		case  "Multiplicar":
			
			if(intNro1==1) {
				
				nro1.transformarAPolar(nro1.pReal, nro1.pImaginaria);
			}
     		
             if(intNro2==1) {

            	 nro2.transformarAPolar(nro2.pReal, nro2.pImaginaria);
             }
             
             lblRespuesta.setText(calculosControlador.multiplicar(nro1, nro2));
             lblRespuesta.setVisible(true);
			break;
			
		case  "Dividir":
			
			if(intNro1==1) {
				
				nro1.transformarAPolar(nro1.pReal, nro1.pImaginaria);
			}
     		
             if(intNro2==1) {

            	 nro2.transformarAPolar(nro2.pReal, nro2.pImaginaria);
             }
             
             lblRespuesta.setText(calculosControlador.dividir(nro1, nro2));
             lblRespuesta.setVisible(true);
			break;

		default:
			break;
		}
    	
	}
    }

}