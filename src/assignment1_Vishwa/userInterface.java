package assignment1_Vishwa;

import java.net.URL;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class userInterface extends javafx.application.Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
		URL res = this.getClass().getResource("layout_A1.fxml");
		Parent root = FXMLLoader.load(res);
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setTitle("My Phone Book!");
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
