import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ResultsShowController implements Initializable{

	@FXML
	private Label gameNameLable;
	
	@FXML
	private Label gameID;
	
	@FXML
	private TableView<Athlete> reTable;	
	@FXML
	private TableColumn<Athlete, String> reID;
	@FXML
	private TableColumn<Athlete, String> reName;
	@FXML
	private TableColumn<Athlete, Double> reCompete;	
	@FXML
	private TableColumn<Athlete, Integer> rePoints;
	
	@FXML
	private Label winnerlb1;
	@FXML
	private Label secondlb1;
	@FXML
	private Label thirdlb1;
	
	@FXML
	private ListView<String> listAth;
	
	Database db = new Database();
	
	@FXML
	static ObservableList<Athlete> ath;
	
	ArrayList<Athlete> aaa;
	
	@FXML
	public void sportDetails(ObservableList<Athlete> addedAthletes){
		
		 ath = addedAthletes;
		 System.out.println("this is ob" + ath.get(0).getName());
		// ath = (ObservableList<Athlete>) athleteList;
		// System.out.println("Newwww" + aaa.get(0).competeTime);
		//ath = (ObservableList<Athlete>) sport; 
		//Official offic = (Official) sport.getReferee();
		//String gameID = sport.getGameID();
		//ObservableList<Athlete> ath = FXCollections.observableArrayList(sport);
		

		
	//	obAthleteResult.add(cy1);
		//obAthleteResult.add(cy2);
		//obAthleteResult.add(cy3);
	//	ob1 = obAthleteResult;
	//	System.out.println("dskjflkfjlsk"+ath.get(0).competeTime);
		
		//listAth.getItems().add(ath.get(0).getName());
		
	
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		//obAthleteResult = (ObservableList<Athlete>) sp.getAthlete();
	/*	Athlete cy1 = new Cyclist(ath.get(0).getID().toString(),"Cyclist", "Andy", 23, "vic");
		Athlete cy2 = new Cyclist("cy2","Cyclist", "Peters", 35, "vic");
		Athlete cy3 = new Cyclist("cy3","Cyclist", "Shane Gould", 31, "nsw");
		Athlete cy4 = new Cyclist("cy4","Cyclist", "Ian Thorpe", 24, "nsw");
ObservableList<Athlete> obAthleteResult = FXCollections.observableArrayList();
		*/

		
		//obAthleteResult.add(cy1);
		//obAthleteResult.add(cy2);
		//obAthleteResult.add(cy3);
		//ObservableList<Athlete> ath = FXCollections.observableList(aaa);
		//Obser
		reID.setCellValueFactory(new PropertyValueFactory<>("ID"));			
		reName.setCellValueFactory(new PropertyValueFactory<>("name"));
		reCompete.setCellValueFactory(new PropertyValueFactory<>("competeTime"));
		rePoints.setCellValueFactory(new PropertyValueFactory<>("point"));
		
		reTable.setItems(ath);
		
		//winnerlb1.setText(ath.get(0).getName());
		//secondlb1.setText(ath.get(1).getName());
		//thirdlb1.setText(ath.get(2).getName());
		
	}
	
	public void setObersvableList(ObservableList<Athlete> a){
		
	}

}
