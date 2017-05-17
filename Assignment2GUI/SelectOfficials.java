import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SelectOfficials implements Initializable{
	@FXML
	private TableView<Athlete> table;	
	@FXML
	private TableColumn<Athlete, String> iD;	
	@FXML
	private TableColumn<Athlete, String> name;
	@FXML
	private TableColumn<Athlete, Integer> age;
	@FXML
	private TableColumn<Athlete, String> state;		
	
	//new
	@FXML
	private TableView<Athlete> selectedAthleteTable;
	@FXML
	private TableColumn<Athlete, String> selectedID;
	@FXML
	private TableColumn<Athlete, String> selectedParticipantType;
	@FXML
	private TableColumn<Athlete, String> selectedName;
	@FXML
	private Button addbtn;
	
	Ozlympics game = new Ozlympics();
	Stage stage = game.myStage;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iD.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		state.setCellValueFactory(new PropertyValueFactory<>("state"));
		Database db = new Database();
		
		table.setItems(db.getAthlete());
		
	}
}
