package utils.Controller;

import java.io.File;


import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import javafx.stage.Stage;

import utils.service.Controlador;


public class VentanaGenerar {
    PrincipalC principal_controller = new PrincipalC();
    Stage stage = new Stage();
    Controlador controlador = new Controlador();
	
  
    

    @FXML
    private Label lblError;

    @FXML
    private Button ButtonBack;

    @FXML
    private Button ButtonGenerate;

    @FXML
    private Button ButtonSave;

    @FXML
    private PasswordField fieldPass1;

    @FXML
    private PasswordField fieldpass2;

    @FXML
    void CallGenerateKeys(ActionEvent event) {
        generarClaves();

    }

    @FXML
    void CallShowPrincipal(ActionEvent event) {
		principal_controller.sendThisController(controlador);
        principal_controller.show();
        this.stage.close();
    }

    public void init(Stage stage, PrincipalC principalC) {
        this.stage=stage;
        principal_controller=principalC;
    }

    @FXML
    void CallSavePublicKey(ActionEvent event) {
        exportarClavePublica();

    }


    


    public void exportarClavePublica()
	{
		//paso 1: obtener identificador (password) de la clave
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Digite el password:");
		JPasswordField pass = new JPasswordField(10);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[]{"OK", "Cancelar"};
		int option = JOptionPane.showOptionDialog(null, panel, "Clave",JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[1]);
		if(option == 0) 
		{
		    String password = new String(pass.getPassword());
		    
		    
		    JOptionPane.showMessageDialog(null, "Seleccione donde quiere guardar el archivo");
				
			//paso 2: seleccionar nombre de archivo para guardar
			JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("Guardar archivo");   
			 
			int seleccion = fc.showSaveDialog(null);
			 
			if (seleccion == JFileChooser.APPROVE_OPTION) 
			{
			    File fichero = fc.getSelectedFile();
			    String rutaClavePublica = fichero.getAbsolutePath();
                
                
			    try 
			    {
					controlador.exportarClavePublica(rutaClavePublica, password);
					JOptionPane.showMessageDialog(null, "Clave exportada exitosamente","Respuesta",JOptionPane.INFORMATION_MESSAGE);
				} 
			    catch (Exception e) 
			    {
					
			    	JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			    
			}    
		}
	}

    public void generarClaves() 
	{
		String pass1 = fieldPass1.getText();
        String pass2= fieldpass2.getText();

		
		if(pass1.equals("") || pass2.equals(""))
		{
			lblError.setText("La contraseña no puede estar vacia");
            lblError.setVisible(true);
        
		}
		else
		{
			if(pass1.equals(pass2)==false)
			{
                lblError.setText("Las contraseñas no coinciden");
				lblError.setVisible(true);
			}
			else
			{
                lblError.setVisible(false);
                controlador.generarClave(pass1);
				System.out.println("Pass impreso en la clase ventana al generar las claves--"+pass1);
                JOptionPane.showMessageDialog(null, "Claves Generadas Correctamente");
				
				
				
				fieldPass1.setText("");
				fieldpass2.setText("");
                

			}
		}
	}


	

    
   


}
