package utils.Controller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import utils.service.Controlador;
import utils.service.DigitalSignature;

public class VentanaFirma {
    PrincipalC principal_controller = new PrincipalC();
    Stage stage = new Stage();

    DigitalSignature firmarDigitalmente = new DigitalSignature();
    String publickeyString;
    String privateKeyString;
    String textoFirmado;
    private String rutaArchivo;
    Controlador controlador;
    

    @FXML
    private Button ButtonCancelar;

    @FXML
    private Button ButtonFirm;

    @FXML
    private Button ButtonSave;

    @FXML
    private Button ButtonSearchDoc;

    @FXML
    private Label lbl1;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblShowFirm;

    
    @FXML
    private PasswordField fieldPass;


    // ----------------------------------------------------------------------------------------------/
    @FXML
    void callBuscarDocument(ActionEvent event) {
        subirArchivo();
    }

    @FXML
    void callFirmDoc(ActionEvent event) {
        firmarArchivo();
    }

    @FXML
    void callSaveInBD(ActionEvent event) {

    }

    @FXML
    void ClosedWindows(ActionEvent event) {
        this.stage.close();
        principal_controller.show();
    }

    

    public void ShowFirm(String text) {
        lblShowFirm.setText(text);
        lblShowFirm.setWrapText(true);

    }

    public void init(Stage stage, PrincipalC principalC,Controlador controlador) {
        this.controlador=controlador;
        principal_controller=principalC;
        this.stage=stage;
    }
//-------------------------------------------------------------------------------------------------------------------//
//*Funcionalidades que tienen que ver con la firma */
//-------------------------------------------------------------------------------------------------------------------//

public void subirArchivo(){

    JFileChooser fc=new JFileChooser();
    fc.setDialogTitle("Seleccionar archivo");  
     
    int seleccion=fc.showOpenDialog(null);
     
    if(seleccion==JFileChooser.APPROVE_OPTION)
    { 
        File fichero=fc.getSelectedFile();
        rutaArchivo = fichero.getAbsolutePath(); 
        lblAddress.setText(fichero.getAbsolutePath());
    }
}

 public void firmarArchivo()
	{
		//verificar datos minimos
		String password = fieldPass.getText();
		if(rutaArchivo.equals("") || password.equals("")){
			JOptionPane.showMessageDialog(null, "Para firmar debe seleccionar un archivo y especificar el password de la clave privada",
		    "Error",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			
			JOptionPane.showMessageDialog(null, "Seleccione donde quiere guardar la firma");
			
			//Seleccionar donde guardar la firma
			JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("Guardar archivo");
			 
			int seleccion = fc.showSaveDialog(null);
			 
			if (seleccion == JFileChooser.APPROVE_OPTION) 
			{
			    File fichero = fc.getSelectedFile();
			    String rutaFirma = fichero.getAbsolutePath();
			    
			    //proceder a firmar
			    try 
			    {
					controlador.firmarArchivo(rutaArchivo, rutaFirma, password);
                    JOptionPane.showMessageDialog(null, "Firma generada exitosamente","Respuesta",JOptionPane.INFORMATION_MESSAGE);
					
					rutaArchivo = "";
					lblAddress.setText("");
					fieldPass.setText(""); 
				} 
			    catch (Exception e) 
			    {
			    		JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}













}
