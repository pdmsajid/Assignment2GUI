

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
	private Button gameStartbtn;
	
	
	//Official Table
	@FXML
	private TableView<Official> tableOfficial;	
	@FXML
	private TableColumn<Official, String> iDOfficial;	
	@FXML
	private TableColumn<Official, String> nameOfficial;
	@FXML
	private TableColumn<Official, Integer> ageOfficial;
	@FXML
	private TableColumn<Official, String> stateOfficial;		
	
	//new
	@FXML
	private TableView<Official> selectedOfficialTable;
	@FXML
	private TableColumn<Official, String> selectedIDOfficial;	
	@FXML
	private TableColumn<Official, String> selectedNameOfficial;
	@FXML
	private Button addbtnOfficial;
	
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
		
		//Official Table making
		iDOfficial.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		nameOfficial.setCellValueFactory(new PropertyValueFactory<>("name"));
		ageOfficial.setCellValueFactory(new PropertyValueFactory<>("age"));
		stateOfficial.setCellValueFactory(new PropertyValueFactory<>("state"));
		
		
		tableOfficial.setItems(db.getOfficial());
		
	}
		
	
	ArrayList<Athlete> addedAthletes = new ArrayList<Athlete>();
	private ObservableList<Athlete> obaddedAthletes = FXCollections.observableArrayList();
	public void addingAthletes(ActionEvent event){
		
		Athlete ath = table.getSelectionModel().getSelectedItem();
		addedAthletes.add(ath);
				
		for (Athlete a : addedAthletes){
			System.out.println(a.getName());
			System.out.println(addedAthletes.size());
		}
		obaddedAthletes.add(ath);
		// new code 
		
		selectedID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		selectedParticipantType.setCellValueFactory(new PropertyValueFactory<>("participantType"));
		selectedName.setCellValueFactory(new PropertyValueFactory<>("name"));
		selectedAthleteTable.setItems(obaddedAthletes);	
		
	}
	public void getSelectedAthletes(){
		
		//System.out.println(selectedAth.get(0).getName());
	//return selectedAth;
	}
	/**public void nextOfficialSelect(ActionEvent event) throws IOException{
		if(event.getSource()== nextbtn){
			stage = (Stage) nextbtn.getScene().getWindow();
			Parent root3 = (Parent)FXMLLoader.load(getClass().getResource("/application/OfficialsSelect.fxml"));
			Scene scene3 = new Scene(root3);
			scene3.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());			
			stage.setScene(scene3);
			stage.show();
			}
	}
	**/
	
	//Officical add button 
	
	private ArrayList<Official> addedOfficial = new ArrayList<Official>();
	private ObservableList<Official> obaddedOfficial= FXCollections.observableArrayList();
	public void addingOfficial(ActionEvent event){
		Official offic = tableOfficial.getSelectionModel().getSelectedItem();
		addedOfficial.add(offic);
		
		System.out.println(offic.getName());
		for (Official a : addedOfficial){
			System.out.println(a.getName());
			
		}
		obaddedOfficial.add(offic);
		// new code 
		
		selectedIDOfficial.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		selectedNameOfficial.setCellValueFactory(new PropertyValueFactory<>("name"));
		selectedOfficialTable.setItems(obaddedOfficial);	
		
	}
	
	// Game Starting 
	public void gameStart(ActionEvent event){
		if (event.getSource() == gameStartbtn){			
			String gameID = "SP1";
			ArrayList<Athlete> gameAthlete = addedAthletes;
			ArrayList<Official> ref = addedOfficial;			
			System.out.println(gameAthlete.get(0).getName());
			System.out.println(gameAthlete.get(1).getName());
			System.out.println(gameAthlete.get(2).getName());
			System.out.println(ref.get(0).getName());
			
			Sport sp = new Sport(gameID, gameAthlete, ref.get(0));
			sp.startGame();
			System.out.println(gameAthlete.get(0).getCompeteTime());
			System.out.println(sp.getWinner().getName());
		}
	}

}
