import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ParticipantDataModel {
	
	private final SimpleStringProperty ID;
	private final SimpleStringProperty name;
	private final SimpleIntegerProperty age;
	private final SimpleStringProperty state;
	public ParticipantDataModel(String iD, String name, Integer age,
			String state) {
		super();
		ID = new SimpleStringProperty(iD);
		this.name = new SimpleStringProperty(name);
		this.age = new SimpleIntegerProperty(age);
		this.state = new SimpleStringProperty(state);
	}
	public SimpleStringProperty getID() {
		return ID;
	}
	public SimpleStringProperty getName() {
		return name;
	}
	public SimpleIntegerProperty getAge() {
		return age;
	}
	public SimpleStringProperty getState() {
		return state;
	}

	

	
}
