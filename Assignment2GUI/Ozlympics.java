
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

/**
 * Main class
 * 
 * @author Kalinga
 *
 */

public class Ozlympics extends Application {
	public Stage myStage;// Keep primary stage

	/**
	 * Load first stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			myStage = primaryStage;
			Parent root = (Parent) FXMLLoader.load(getClass().getResource("/application/OzlympicsFXML.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
		MainController main = new MainController();
		SelectedGameController se = new SelectedGameController();

	}

	/**
	 * Load game initial results showing fxml file
	 * 
	 * @throws IOException
	 */
	public void gameIntialResults() throws IOException {
		Stage popupInitialResult = new Stage();
		Parent root6 = (Parent) FXMLLoader.load(getClass().getResource("/application/InitialResults.fxml"));
		popupInitialResult.initModality(Modality.APPLICATION_MODAL);
		popupInitialResult.setTitle("Game Results");
		Scene sce1 = new Scene(root6);
		popupInitialResult.setScene(sce1);
		popupInitialResult.show();
	}

	/**
	 * Load error message interface
	 * 
	 * @param message
	 * @throws IOException
	 */
	public void messageShowing(String message) throws IOException {
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
