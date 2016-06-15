package nuevaInterfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.TextArea;

public class ventanaPpal extends JFrame {

	//Attributes 
	private static final long serialVersionUID = 1L;
	private String texto = new String("");
	private String titleFile = new String("");
	private JPanel contentPane;
	private JTextField tfArchivo;
	private JTextField tfPatron;
	private JButton btnBuscarArchivo;
	private JRadioButton rdbtnFuerzaBruta, rdbtnBoyermoore, rdbtnKarprabin;
	private JLabel labelTiempo;
	private TextArea textArea;
	private ButtonGroup BGjradio = new ButtonGroup(); //nuevo atributo

	//main window
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaPpal frame = new ventanaPpal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the frame.
	public ventanaPpal() {
		setTitle("Busqueda de Texto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblArchivo = new JLabel("Archivo:");
		lblArchivo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblArchivo.setBounds(58, 29, 46, 14);
		contentPane.add(lblArchivo);
		
		tfArchivo = new JTextField();
		tfArchivo.setEditable(false);
		tfArchivo.setBounds(136, 26, 247, 20);
		contentPane.add(tfArchivo);
		tfArchivo.setColumns(10);
		
		btnBuscarArchivo = new JButton("Buscar archivo");
		btnBuscarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirArchivo();
				setTFArchivo(titleFile);
				setTextArea(texto);
			}
		});
		btnBuscarArchivo.setBounds(410, 25, 129, 23);
		contentPane.add(btnBuscarArchivo);
		
		JLabel lblMetodosDeBusqueda = new JLabel("Metodos de busqueda:");
		lblMetodosDeBusqueda.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMetodosDeBusqueda.setBounds(38, 73, 127, 14);
		contentPane.add(lblMetodosDeBusqueda);
		
		rdbtnFuerzaBruta = new JRadioButton("Fuerza Bruta");
		rdbtnFuerzaBruta.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnFuerzaBruta.setBounds(204, 69, 97, 23);
		contentPane.add(rdbtnFuerzaBruta);
		
		rdbtnBoyermoore = new JRadioButton("Boyer-Moore");
		rdbtnBoyermoore.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnBoyermoore.setBounds(342, 69, 106, 23);
		contentPane.add(rdbtnBoyermoore);
		
		rdbtnKarprabin = new JRadioButton("Kerp-Rabin");
		rdbtnKarprabin.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnKarprabin.setBounds(476, 69, 89, 23);
		contentPane.add(rdbtnKarprabin);
		
		BGjradio.add(rdbtnFuerzaBruta);
		BGjradio.add(rdbtnBoyermoore);
		BGjradio.add(rdbtnKarprabin);
		
		JLabel lblPatronDeBusqueda = new JLabel("Patron de Busqueda:");
		lblPatronDeBusqueda.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPatronDeBusqueda.setBounds(38, 116, 127, 14);
		contentPane.add(lblPatronDeBusqueda);
		
		tfPatron = new JTextField();
		tfPatron.setBounds(175, 113, 291, 20);
		contentPane.add(tfPatron);
		tfPatron.setColumns(10);
		
		JButton btnBuscar = new JButton("BUSCAR");
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBuscar.setBounds(476, 112, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblTiempoDeBusqueda = new JLabel("Tiempo de busqueda:");
		lblTiempoDeBusqueda.setBounds(10, 416, 106, 14);
		contentPane.add(lblTiempoDeBusqueda);
		
		labelTiempo = new JLabel("...");
		labelTiempo.setBounds(126, 416, 149, 14);
		contentPane.add(labelTiempo);
		
		textArea = new TextArea();
		textArea.setBounds(10, 160, 604, 250);
		contentPane.add(textArea);
	}
	
	public void setTextArea(String texto){
		textArea.setText(texto);
	}
	
	public void setTFArchivo(String texto){
		tfArchivo.setText(texto);
	}
	
//	private String abrirArchivo() {
	private void abrirArchivo() {
		  String aux="";   
//		  String texto = "";
		  try
		  {
		   /**llamamos el metodo que permite cargar la ventana*/
		   JFileChooser file=new JFileChooser();
		   file.showOpenDialog(this);
		   /**abrimos el archivo seleccionado*/
		   File abre = file.getSelectedFile();
		   
		   //obtengo nombre del archivo
		   titleFile = abre.getName();
		   
		   /**recorremos el archivo, lo leemos para plasmarlo
		   *en el area de texto*/
		   if(abre!=null)
		   {     
		      FileReader archivos=new FileReader(abre);
		      BufferedReader lee=new BufferedReader(archivos);
		      while((aux=lee.readLine())!=null)
		      {
		         texto+= aux+ "\n";
		      }
		         lee.close();
		    }    
		   }
		   catch(IOException ex)
		   {
		     JOptionPane.showMessageDialog(null,ex+"" +
		           "\nNo se ha encontrado el archivo",
		                 "ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
		    }
//		  return texto;//El texto se almacena en el JTextArea
	}
}
