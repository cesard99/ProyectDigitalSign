package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalC {
    Stage stage = new Stage();
    LoginC controller = new LoginC();

    @FXML
    private Button ButtonAlice;

    @FXML
    private Label lbluser;

    @FXML
    private Button ButtonCreateAdmin;

    @FXML
    private Button ButtonCreateUser;

    @FXML
    private Button ButtonDisconect;

    @FXML
    private AnchorPane VentanaP;
    String nombreuser;




    @FXML
    void ClosedThisWindows(ActionEvent event) {
        controller.RestartTextFields();
        controller.show();
        this.stage.close();

    }

    public void init(Stage stage,String nombre,LoginC loginC) {
        this.stage = stage;
        lbluser.setText( "Usuario:"+ nombre);
        this.nombreuser=nombre;
        controller= loginC;

    }

    public void show() {
        this.stage.show();
    }


    
}
