import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainController {
	
	@FXML
	private Button newGamebtn;
	
	@FXML
	private Button selectRunningbtn;
	
	
	Ozlympics game = new Ozlympics();
	Stage stage = game.myStage;	
	public void newGame(ActionEvent event) throws IOException{
			
		//game.selectMenu();
		if(event.getSource()== newGamebtn){
		stage = (Stage) newGamebtn.getScene().getWindow();
		Parent root1 = (Parent)FXMLLoader.load(getClass().getResource("/application/NewGame.fxml"));
		Scene scene1 = new Scene(root1);
		scene1.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
		
		stage.setScene(scene1);
		stage.show();
		}
		
	}
	public void selectGame(ActionEvent event) throws IOException{
		if(event.getSource()== selectRunningbtn){
			stage = (Stage) selectRunningbtn.getScene().getWindow();
			Parent root2 = (Parent)FXMLLoader.load(getClass().getResource("/application/RunningGame.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			
			stage.setScene(scene2);
			stage.show();
			}
	}
	
}
