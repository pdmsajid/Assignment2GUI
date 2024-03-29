/**
 * this class abstract of athlete and official
 * 
 * @author Kalinga
 *
 */
public abstract class Participant {
	private String ID;
	private String participantType;	
	private String name;	
	private int age;
	private String state;

	public String getParticipantType() {
		return participantType;
	}

	public void setParticipantType(String participantType) {
		this.participantType = participantType;
	}

	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Participant(String ID,String participantType, String name, int age, String state) {

		this.ID = ID;		
		this.participantType = participantType;
		this.name = name;
		this.age = age;
		this.state = state;

	}

}
