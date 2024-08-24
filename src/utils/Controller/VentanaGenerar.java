package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class VentanaGenerar {
    PrincipalC principal_controller = new PrincipalC();
    Stage stage = new Stage();

    @FXML
    private Button ButtonBack;

    @FXML
    private Button ButtonGenerate;

    @FXML
    private PasswordField fieldPass1;

    @FXML
    private PasswordField fieldpass2;

    @FXML
    void CallGenerateKeys(ActionEvent event) {

    }

    @FXML
    void CallShowPrincipal(ActionEvent event) {
        principal_controller.show();
        this.stage.close();
    }

    public void init(Stage stage, PrincipalC principalC) {
        this.stage=stage;
        principal_controller=principalC;
    }



}
