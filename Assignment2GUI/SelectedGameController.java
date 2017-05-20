

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
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
	
	//Selected Official Table
	@FXML
	private TableView<Official> selectedOfficialTable;
	@FXML
	private TableColumn<Official, String> selectedIDOfficial;	
	@FXML
	private TableColumn<Official, String> selectedNameOfficial;
	@FXML
	private Button addbtnOfficial;
	
	@FXML
	private Button removeAthletebtn;
	
	@FXML
	private Button removeOfficialbtn;
	
	@FXML
	private Label gameCategory;
	
	Ozlympics game = new Ozlympics();
	Stage stage = game.myStage;
	Database db = new Database();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//intial column set for Athlete Table
		iD.setCellValueFactory(new PropertyValueFactory<>("ID"));
		participantType.setCellValueFactory(new PropertyValueFactory<>("participantType"));
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		state.setCellValueFactory(new PropertyValueFactory<>("state"));
		
		
		table.setItems(FXCollections.observableList(db.getAthlete()));
		
		//Official Table making
		iDOfficial.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		nameOfficial.setCellValueFactory(new PropertyValueFactory<>("name"));
		ageOfficial.setCellValueFactory(new PropertyValueFactory<>("age"));
		stateOfficial.setCellValueFactory(new PropertyValueFactory<>("state"));
		
		
		tableOfficial.setItems(db.getOfficial());
		
		//initial column set for selectedAthletes Table
		selectedID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		selectedParticipantType.setCellValueFactory(new PropertyValueFactory<>("participantType"));
		selectedName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//initial column set for Officials Table
		selectedIDOfficial.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		selectedNameOfficial.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		gameCategory.setText(MainController.selectedGame);
		
	}
	// add athlets	
	
	ArrayList<Athlete> addedAthletes = new ArrayList<Athlete>();
	
	
	@FXML
	public void addingAthletes(ActionEvent event) throws IOException {
		ObservableList<Athlete> allAthletes = table.getItems();
		//ObservableList<Athlete> selectedAth = table.getSelectionModel().getSelectedItems();
		
		ObservableList<Athlete> allAthletesinselectedTable = selectedAthleteTable.getItems();
		
		Athlete ath = table.getSelectionModel().getSelectedItem();		
		try {
			if (ath.getParticipantType() == MainController.gameCategoryType){ 
			ObservableList<Athlete> selectedAth = table.getSelectionModel().getSelectedItems();
			selectedAth.forEach(allAthletesinselectedTable::add);
			selectedAth.forEach(allAthletes::remove);
			addedAthletes.add(ath);
			}
			else if(ath.getParticipantType() == "super"){ 
				ObservableList<Athlete> selectedAth = table.getSelectionModel().getSelectedItems();
				selectedAth.forEach(allAthletesinselectedTable::add);
				selectedAth.forEach(allAthletes::remove);
				addedAthletes.add(ath);
				}
			else {
				throw new WrongTypeException ("Wrong Paticipant Type Insert");
			}
		} catch (WrongTypeException e) {				
			game.messageShowing(e.getMessage());
			
		}
		
		
		
		for (Athlete a : addedAthletes){
			System.out.println(a.getName());
			System.out.println(addedAthletes.size());
		}
		
		
		//selectedAth.forEach(allAthletesinselectedTable::add);
		//selectedAth.forEach(allAthletes::remove);
	}	
	// remove athletes
	@FXML
	public void removingAthletes(ActionEvent event){
		ObservableList<Athlete> allAthletes = selectedAthleteTable.getItems();
		ObservableList<Athlete> selectedAth = selectedAthleteTable.getSelectionModel().getSelectedItems();
		ObservableList<Athlete> allAthletesinTable = table.getItems();		
		Athlete ath = selectedAthleteTable.getSelectionModel().getSelectedItem();		
		addedAthletes.remove(ath);		
		selectedAth.forEach(allAthletesinTable::add);
		selectedAth.forEach(allAthletes::remove);
	}	
	
	//Officical add button 
	
	private ArrayList<Official> addedOfficial = new ArrayList<Official>();
	
	@FXML
	public void addingOfficial(ActionEvent event) throws IOException{		
		ObservableList<Official> allOfficails = tableOfficial.getItems();
		//ObservableList<Official> selectedOfficials = tableOfficial.getSelectionModel().getSelectedItems();
		ObservableList<Official> allOfficialinselectedOfficialTable = selectedOfficialTable.getItems();
		Official offic = tableOfficial.getSelectionModel().getSelectedItem();
		
		try {
			if(addedOfficial.size()<1){ 				
			ObservableList<Official> selectedOfficials = tableOfficial.getSelectionModel().getSelectedItems();
			addedOfficial.add(offic);
			selectedOfficials.forEach(allOfficialinselectedOfficialTable::add);
			selectedOfficials.forEach(allOfficails::remove);
			}
			else{
				throw new MoreOfficials("You can't put more than 1 Refree");
			}
		} catch (MoreOfficials e) {
			game.messageShowing(e.getMessage());
		}
		
		
		for (Official a : addedOfficial){
			System.out.println(a.getName());
			
		}		
		
		
	}
	// Official remove
	@FXML
	public void removingOfficial(ActionEvent event){
		ObservableList<Official> allOfficial = selectedOfficialTable.getItems();
		ObservableList<Official> selectedOfficial = selectedOfficialTable.getSelectionModel().getSelectedItems();
		ObservableList<Official> allOfficialinOfficialTable = tableOfficial.getItems();
		Official Offic = selectedOfficialTable.getSelectionModel().getSelectedItem();
		addedAthletes.remove(Offic);		
		selectedOfficial.forEach(allOfficialinOfficialTable::add);
		selectedOfficial.forEach(allOfficial::remove);
	}	
	
	// Game Starting 
	
	private int i = 1 ;
	CheckAthleteNumbers ch = new CheckAthleteNumbers();
	@FXML
	public void gameStart(ActionEvent event) throws IOException{
		String gameID = null;
		if (event.getSource() == gameStartbtn){		
			if(MainController.gameCategoryValue == 1){ 
			 gameID = "R0" + i;
			i++;			
			}
			else if (MainController.gameCategoryValue == 2){
			   gameID = "S0" + i;
				i++;
			}	
			else if (MainController.gameCategoryValue == 3){
			   gameID = "C0" + i;
				i++;
			}
			else{
				gameID = "No ID";
			}
			System.out.println("sdklfjlskjglskjglsdjkg"+addedAthletes.size());
			System.out.println("ofice"+addedOfficial.size());
			
			try{
				ch.checkNumerOfAthletes(addedAthletes.size());
				ArrayList<Athlete> gameAthlete = addedAthletes;				
				ArrayList<Official> ref = addedOfficial;
				ObservableList<Athlete> athleteList = FXCollections.observableList(addedAthletes);
				
				
				ResultsShowController rs = new ResultsShowController();
				
				Sport sp = new Sport(gameID, gameAthlete, ref.get(0));
				sp.startGame();
				
				rs.sportDetails(athleteList);
				rs.setObersvableList(athleteList);
				
				Ozlympics ob = new Ozlympics();
				ob.gameIntialResults();
					
				
			}catch(GameFullException e){
				System.out.println(e.getMessage());
				game.messageShowing(e.getMessage());
			} catch (TooFewAthleteException e) {
				System.out.println(e.getMessage());
				game.messageShowing(e.getMessage());
			} 
			
			//ArrayList<Athlete> gameAthlete = addedAthletes;
			
			//ArrayList<Official> ref = addedOfficial;	
			/**
			System.out.println(gameAthlete.get(0).getName());
			System.out.println(gameAthlete.get(1).getName());
			System.out.println(gameAthlete.get(2).getName());
			System.out.println(ref.get(0).getName());
			
			Sport sp = new Sport(gameID, gameAthlete, ref.get(0));
			sp.startGame();
			System.out.println(gameAthlete.get(0).getCompeteTime());
			System.out.println(sp.getWinner().getName());
			
			System.out.println(gameAthlete.get(0).getPoint());
			System.out.println(gameAthlete.get(1).getPoint());
			System.out.println(gameAthlete.get(2).getPoint());
			System.out.println(sp.getReferee().getName());
			
			
			System.out.println(sp.getGameID());			
		
														**/
			/**
			ObservableList<Athlete> athleteList = FXCollections.observableList(addedAthletes);
			
			
			ResultsShowController rs = new ResultsShowController();
			
			rs.sportDetails(athleteList);
			rs.setObersvableList(athleteList);
			
			Ozlympics ob = new Ozlympics();
			ob.gameIntialResults();
				
			**/
			
		}
	}

}
