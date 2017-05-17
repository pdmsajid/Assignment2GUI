/**
 * 
 * @author Kalinga
 *
 */
public class Official extends Participant {
	private int rank;

	public Official(String ID, String name,String participantType, int age, String state, int rank) {
		super(ID, name,participantType, age, state);
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
