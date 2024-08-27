package utils.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utils.service.Controlador;

public class PrincipalC {
    Stage stage = new Stage();
    LoginC controller = new LoginC();
    Controlador controlador;

    @FXML
    private Button ButtonDisconect;

    @FXML
    private Button ButtonGenerate;

    @FXML
    private Button ButtonVerify;

    @FXML
    private Button ButtonVerify1;

    @FXML
    private Label lbluser;

    @FXML
    private TextField textfield2;

    @FXML
    private AnchorPane VentanaP;
    String nombreuser;



 //------------------------------------------------------------------------------------------- /

    @FXML
    void CallGenerateKey(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/view/VentanaGenerar.fxml"));
        Parent root = loader.load();
        VentanaGenerar controller = loader.getController();
        Scene scene= new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add(getClass().getResource("/visual/Style/VentanaGenerar.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Generacion de Claves");
        Image icon = new Image("/Img/iconCreateUser.png");
        stage.getIcons().add(icon);
        controller.init(stage,this);
        stage.show();
        this.stage.close();


    }
    @FXML
    void call_firm(ActionEvent event)throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/view/VentanaFirma.fxml"));
        Parent root = loader.load();
        VentanaFirma controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add(getClass().getResource("/visual/Style/ventanaFirma.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Ventana Firma");
        Image icon = new Image("/Img/firma.jpg");
        stage.getIcons().add(icon);
        controller.init(stage,this,controlador);
        stage.show();
        this.stage.close();
    }

    @FXML
    void call_verificy(ActionEvent event) throws Exception {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/visual/view/VentanaVerificar.fxml"));
        Parent root= loader.load();
        VentanaVerificar controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        scene.getStylesheets().add(getClass().getResource("/visual/Style/ventanaVerificar.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Ventana Verificar");
        Image icon = new Image("/Img/firma.jpg");
        stage.getIcons().add(icon);
        controller.init(stage,this);
        stage.show();
        this.stage.close();

    }
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
    
    public void sendThisController(Controlador controlador) {
       this.controlador=controlador;
    }


    
}
