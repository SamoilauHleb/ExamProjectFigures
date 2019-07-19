package figuresapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Figures extends Application {
    public static void main(String[] args) {

        launch();
    }

    @Override
    public void start(Stage open) throws Exception {
        open.setTitle("Figures");
        Parent root = FXMLLoader.load(getClass().getResource("/views/MainScreenView.fxml"));
        open.setScene(new Scene(root, 1024, 600));
        open.setResizable(false);
        open.show();
    }
}
