

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

public class SelectedGameController implements Initializable{
	@FXML
	private TableView<Athlete> table;	
	@FXML
	private TableColumn<Athlete, String> iD;
	@FXML
	private TableColumn<Athlete, String> participantType;
	@FXML
	private TableColumn<Athlete, String> name;
	@FXML
	private TableColumn<Athlete, Integer> age;
	@FXML
	private TableColumn<Athlete, String> state;	
	@FXML
	private Button selectRunningbtn;
	
	
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
	@FXML
	private Button nextbtn;
	
	Ozlympics game = new Ozlympics();
	Stage stage = game.myStage;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iD.setCellValueFactory(new PropertyValueFactory<>("ID"));
		participantType.setCellValueFactory(new PropertyValueFactory<>("participantType"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		state.setCellValueFactory(new PropertyValueFactory<>("state"));
		Database db = new Database();
		
		table.setItems(db.getAthlete());
		
	}
	//new ------------------------------------------------------------
	private ObservableList<Athlete> athleteSelected = null; 
	ObservableList<Athlete> allAthlete = FXCollections.observableArrayList();
	boolean value = true;
	ArrayList<Athlete> selected = new ArrayList<Athlete>();
	public void addAthleteToTable(ActionEvent event){
		if(event.getSource()== addbtn){
		
		
	//	if (value){
			
			allAthlete = table.getItems();
			//allAthlete = table.getSelectionModel().getSelectedItems();
			//allAthlete = null;
			athleteSelected = table.getSelectionModel().getSelectedItems();
			
			
			
			
			value = false;
	//	}
		
		//table.getSelectionModel().clearSelection();
		//athleteSelected.add();
		
		
		for(Athlete row : athleteSelected){
			selected.add(row);
			System.out.println(row.getName());
			//if(row != null){
			   allAthlete.add(row);
			//}
		}
		//if(!selected.isEmpty()){
			System.out.println("not null");
			selectedID.setCellValueFactory(new PropertyValueFactory<>("ID"));
			selectedParticipantType.setCellValueFactory(new PropertyValueFactory<>("participantType"));
			selectedName.setCellValueFactory(new PropertyValueFactory<>("name"));
		selectedAthleteTable.setItems(allAthlete);	
		//}
		}
	}
//---------------------------------------------------------------------------------------------	
	private ArrayList<Athlete> addedAthletes = new ArrayList<Athlete>();
	private ObservableList<Athlete> obaddedAthletes = FXCollections.observableArrayList();
	public void addingAthletes(ActionEvent event){
		Athlete ath = table.getSelectionModel().getSelectedItem();
		addedAthletes.add(ath);
		
		System.out.println(ath.getName());
		for (Athlete a : addedAthletes){
			System.out.println(a.getName());
			
		}
		obaddedAthletes.add(ath);
		// new code 
		
		selectedID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		selectedParticipantType.setCellValueFactory(new PropertyValueFactory<>("participantType"));
		selectedName.setCellValueFactory(new PropertyValueFactory<>("name"));
		selectedAthleteTable.setItems(obaddedAthletes);	
		
	}
	public ArrayList<Athlete> getSelectedAthletes(){
		return addedAthletes;
	}
	public void nextOfficialSelect(ActionEvent event) throws IOException{
		if(event.getSource()== nextbtn){
			stage = (Stage) nextbtn.getScene().getWindow();
			Parent root3 = (Parent)FXMLLoader.load(getClass().getResource("/application/OfficialsSelect.fxml"));
			Scene scene3 = new Scene(root3);
			scene3.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());			
			stage.setScene(scene3);
			stage.show();
			}
	}

}
