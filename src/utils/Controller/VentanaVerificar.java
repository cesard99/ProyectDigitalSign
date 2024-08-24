package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class VentanaVerificar{
    PrincipalC principal_controller= new PrincipalC();
    Stage stage = new Stage();

    @FXML
    private Button ButtonComprob;

    @FXML
    private Button ButtonLoadElements;

    @FXML
    private Button ButtonSearhDocum;

    @FXML
    private Button ButtonVolver;

    @FXML
    private Label lblShowAddress;

    @FXML
    private Label lblShowNotification;

    @FXML
    void callLoadElements(ActionEvent event) {

    }

    @FXML
    void callSearchDocument(ActionEvent event) {

    }

    @FXML
    void callShowPrincipal(ActionEvent event) {
        principal_controller.show();
        this.stage.close();
    }

    @FXML
    void call_comprob(ActionEvent event) {

    }

    public void init(Stage stage, PrincipalC principalC) {
        this.stage=stage;
        principal_controller=principalC;
    }

}
