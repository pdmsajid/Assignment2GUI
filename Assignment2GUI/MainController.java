import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MainController implements Initializable{
	static String selectedGame;
	static int gameCategory;
	@FXML
	private Button newGamebtn;
	
	@FXML
	private Button selectRunningbtn;
	
	@FXML
	private Button selectSwimmingbtn;
	
	@FXML
	private Button selectCyclingbtn;
	
	Ozlympics game = new Ozlympics();
	Stage stage = game.myStage;
	
	@FXML
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
	@FXML
	public void selectGame(ActionEvent event) throws IOException{
		if(event.getSource()== selectRunningbtn){
			selectedGame = "Select Running and Super Athletes between 4 to 8 and one Official for this Running Game ";
			gameCategory =1;
			stage = (Stage) selectRunningbtn.getScene().getWindow();
			Parent root2 = (Parent)FXMLLoader.load(getClass().getResource("/application/RunningGame.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			
			stage.setScene(scene2);
			stage.show();
			}
	}
	@FXML
	public void selectSwimmingGame(ActionEvent event) throws IOException{
		
		if(event.getSource()== selectSwimmingbtn){
			selectedGame ="Select Swimming and Super Athletes between 4 to 8 and one Official for this Swimming Game";
			gameCategory =2;
			stage = (Stage) selectSwimmingbtn.getScene().getWindow();
			Parent root2 = (Parent)FXMLLoader.load(getClass().getResource("/application/RunningGame.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			
			stage.setScene(scene2);
			stage.show();
			}
	}
	@FXML
	public void selectCyclingGame(ActionEvent event) throws IOException{
		if(event.getSource()== selectCyclingbtn){
			selectedGame ="Select Cycling and Super Athletes between 4 to 8 and one Official for this Cycling Game";
			gameCategory =3;
			stage = (Stage) selectCyclingbtn.getScene().getWindow();
			Parent root2 = (Parent)FXMLLoader.load(getClass().getResource("/application/RunningGame.fxml"));
			Scene scene2 = new Scene(root2);
			scene2.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
			
			stage.setScene(scene2);
			stage.show();
			}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
