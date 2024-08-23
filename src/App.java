import utils.Controller.*;
import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application{

    public void start(Stage primaryStage) throws IOException {
        Controller controller = new Controller();
        Progress frame = new Progress(null,null);
        frame.setVisible(true);
        controller.showWindow1();
       
        
    }

    public static void main(String [] args){
        launch(args);
    }

}
