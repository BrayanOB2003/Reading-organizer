package ui;

import java.net.URL;
import java.nio.file.Paths;

import gui.mainScreenGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private mainScreenGUI mainControllerGUI;
	
	public Main() {
		mainControllerGUI = new mainScreenGUI();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/interfaces/main.fxml"));
		fxmlLoader.setController(mainControllerGUI);
		
		Parent root = fxmlLoader.load();
		
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Reading organizer");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}