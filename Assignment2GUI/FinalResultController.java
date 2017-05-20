import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FinalResultController implements Initializable{
	
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
	@FXML 
	private TableColumn<Athlete, Integer> competeTime;
	@FXML
	private TableColumn<Athlete, Integer> points;
	@FXML
	private Button mainMenu;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		iD.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		state.setCellValueFactory(new PropertyValueFactory<>("state"));
		competeTime.setCellValueFactory(new PropertyValueFactory<>("competeTime"));
		points.setCellValueFactory(new PropertyValueFactory<>("point"));
		
	//	table.setItems(FXCollections.observableList(db.getAthlete()));
		
	}
	

}
