package utils.Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.service.DigitalSignature;


public class VentanaFirma {
    PrincipalC controller = new PrincipalC();
    Stage stage = new Stage();
  
    DigitalSignature firmarDigitalmente = new DigitalSignature();
    String publickeyString;
    String privateKeyString;
    String textoFirmado;
    LoginC controlLogin = new LoginC();
    int nombreuser;

    @FXML
    private Button ButtonCancelar;

    @FXML
    private Button ButtonGenerate;

    @FXML
    private Button ButtonSave;

    @FXML
    private Label label2;

    @FXML
    private Label lbl1;
    @FXML
    private Label lblShowFirm;
    

    @FXML
    private TextField textfieldText;

    @FXML
    private TextField textfield2;

    @FXML
    void ClosedWindows(ActionEvent event) {
        this.stage.close();
        controller.show();
    }

    
    public void inicio(Stage stage, String nombre ,PrincipalC principalC) {
       this.stage= stage;
       controller=principalC;
       
    }
    
    public void ShowFirm(String text){
        lblShowFirm.setText(text);
        lblShowFirm.setWrapText(true);
        
    }


}
