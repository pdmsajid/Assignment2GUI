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
import javafx.scene.text.Text;

public class ResultsShowController implements Initializable {

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
	Label winnerlb1;
	@FXML
	Label secondlb1;
	@FXML
	Label thirdlb1;

	@FXML
	private ListView<String> listAth;

	Database db = new Database();

	@FXML
	static ObservableList<Athlete> ath;

	ArrayList<Athlete> aaa;

	@FXML
	public void sportDetails(ObservableList<Athlete> addedAthletes) {

		ath = addedAthletes;
		System.out.println("this is ob" + ath.get(0).getName());

	}

	@FXML
	public void clicked() {
		winnerlb1.setText(ath.get(0).getName());
		secondlb1.setText(ath.get(1).getName());
		thirdlb1.setText(ath.get(2).getName());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		reID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		reName.setCellValueFactory(new PropertyValueFactory<>("name"));
		reCompete.setCellValueFactory(new PropertyValueFactory<>("competeTime"));
		rePoints.setCellValueFactory(new PropertyValueFactory<>("point"));

		reTable.setItems(ath);

	}

}
