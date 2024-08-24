package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import utils.service.DigitalSignature;

public class VentanaFirma {
    PrincipalC principal_controller = new PrincipalC();
    Stage stage = new Stage();

    DigitalSignature firmarDigitalmente = new DigitalSignature();
    String publickeyString;
    String privateKeyString;
    String textoFirmado;

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

    // ----------------------------------------------------------------------------------------------/
    @FXML
    void callBuscarDocument(ActionEvent event) {

    }

    @FXML
    void callFirmDoc(ActionEvent event) {

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

    public void init(Stage stage, PrincipalC principalC) {
        principal_controller=principalC;
        this.stage=stage;
    }

}
