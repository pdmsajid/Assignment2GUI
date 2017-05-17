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
	private TableView<Official> table;	
	@FXML
	private TableColumn<Official, String> iD;	
	@FXML
	private TableColumn<Official, String> name;
	@FXML
	private TableColumn<Official, Integer> age;
	@FXML
	private TableColumn<Official, String> state;		
	
	//new
	@FXML
	private TableView<Official> selectedOfficialTable;
	@FXML
	private TableColumn<Official, String> selectedID;	
	@FXML
	private TableColumn<Official, String> selectedName;
	@FXML
	private Button addbtn;
	@FXML
	private Button gameStartbtn;
	
	Ozlympics game = new Ozlympics();
	Stage stage = game.myStage;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iD.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		state.setCellValueFactory(new PropertyValueFactory<>("state"));
		Database db = new Database();
		
		table.setItems(db.getOfficial());
		
	}
	
	private ArrayList<Official> addedOfficial = new ArrayList<Official>();
	private ObservableList<Official> obaddedOfficial= FXCollections.observableArrayList();
	public void addingOfficial(ActionEvent event){
		Official offic = table.getSelectionModel().getSelectedItem();
		addedOfficial.add(offic);
		
		System.out.println(offic.getName());
		for (Official a : addedOfficial){
			System.out.println(a.getName());
			
		}
		obaddedOfficial.add(offic);
		// new code 
		
		selectedID.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		selectedName.setCellValueFactory(new PropertyValueFactory<>("name"));
		selectedOfficialTable.setItems(obaddedOfficial);	
		
	}
	public ArrayList<Official> getSelectedOfficial(){
		
	return addedOfficial;
		
	}
	public void gameStart(ActionEvent event){
		if (event.getSource() == gameStartbtn){
			SelectedGameController sg = new SelectedGameController();
			String gameID = "SP1";
			ArrayList<Athlete> gameAthlete = sg.addedAthletes;
			ArrayList<Official> ref = getSelectedOfficial();
			sg.getSelectedAthletes();
			Database dbb = new Database();
			//System.out.println(gameAthlete.get(0).getName());
			//System.out.println(gameAthlete.get(1).getName());
			//System.out.println(gameAthlete.get(2).getName());
			System.out.println(ref.get(0).getName());
			
			//Sport sp = new Sport(gameID, gameAthlete, ref.get(0));
			//sp.startGame();
		}
	}
}
