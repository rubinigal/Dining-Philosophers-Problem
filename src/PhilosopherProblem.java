import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PhilosopherProblem extends Application{
	
	public void start(Stage stage) throws Exception{
		Parent root = (Parent)
		FXMLLoader.load(getClass().getResource("PhilosopherProblem.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("PhilosopherProblem");
		stage.setScene(scene);
		stage.show();
		stage.setOnCloseRequest(event -> {
		    System.exit(0);
		});

	}
	public static void main(String[] args) {
		launch(args);
		System.out.println();
	}
}
