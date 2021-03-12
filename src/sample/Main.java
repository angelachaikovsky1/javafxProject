package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The Main class is responsible for setting the stage and starting the UI with the sample.fxml file.
 * It also sets the appropriate window size and displays the UI when run.
 * @author Angela Chaikovsky, Hemanthvarma Bhupatiraju
 */
public class Main extends Application {

    /**
     * The function start is responsible for some key starting points of the front end in
     * connection with the backend, as well as displaying the initial window size.
     * @param primaryStage the primary stage for display
     * @throws Exception a potential exception upon error
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Payroll Processing");
        primaryStage.setScene(new Scene(root, 601, 750));
        primaryStage.show();

    }

    /**
     * Acts as the driving function for the entire program
     * @param args the arguments sent into the program upon execution
     */
    public static void main(String[] args) {
        launch(args);
    }
}
