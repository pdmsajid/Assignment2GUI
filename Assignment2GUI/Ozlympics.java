//package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
//import javafx.scene.layout.BorderPane;


public class Ozlympics extends Application {
	public Stage myStage;
	Scene scene1;
	@Override
	public void start(Stage primaryStage) {
		try {
			myStage = primaryStage;
			//BorderPane root = new BorderPane();
			Parent root = (Parent)FXMLLoader.load(getClass().getResource("/application/OzlympicsFXML.fxml"));
			//Parent root1 = FXMLLoader.load(getClass().getResource("/application/NewGame.fxml"));
			Scene scene = new Scene(root);
		   // scene1 = new Scene(root1);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			//scene1.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);		
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		MainController main =new  MainController();
		SelectedGameController se = new SelectedGameController();
		
	}
	public void selectMenu(){
		System.out.println("sdkflasjk");
		try {			
			//BorderPane root = new BorderPane();
			//Parent root1 = FXMLLoader.load(getClass().getResource("/application/NewGame.fxml"));
			//Scene scene1 = new Scene(root1);
			//scene1.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			//myStage.setScene(scene1);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void gameIntialResults() throws IOException{
		
		Stage popupInitialResult = new Stage();
		Parent root6 = (Parent)FXMLLoader.load(getClass().getResource("/application/InitialResults.fxml"));
		popupInitialResult.initModality(Modality.APPLICATION_MODAL);
		popupInitialResult.setTitle("Game Results");
		Scene sce1 = new Scene(root6);
		popupInitialResult.setScene(sce1);
		popupInitialResult.show(); 
	}
	public void messageShowing(String message) throws IOException{
		Stage messageShow = new Stage();		
		messageShow.initModality(Modality.APPLICATION_MODAL);
		messageShow.setTitle("Worrning Message");
		messageShow.setMinHeight(200);
		messageShow.setMinWidth(400);
		Label l = new Label();		
		l.setText(message);		
		VBox layout = new VBox(100);
		layout.getChildren().addAll(l);
		layout.setAlignment(Pos.CENTER);
		Scene sce2 = new Scene(layout);
		messageShow.setScene(sce2);
		messageShow.show();
	}
	
}
