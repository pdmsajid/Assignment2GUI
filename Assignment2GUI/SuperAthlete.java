import java.text.DecimalFormat;
import java.util.Random;

/**
 * 
 * @author Kalinga
 *
 */
public class SuperAthlete extends Athlete {

	private int type; // super athlete sprinter, swimmer or cyclist selection
	private double ranTime = 0.0; // random time
	DecimalFormat dComplete = new DecimalFormat(".#");
	/**
	 * 
	 * @param ID
	 * @param name
	 * @param age
	 * @param state
	 * @param type
	 */
	public SuperAthlete(String ID,String participantType, String name, int age, String state, int type) {
		super(ID,participantType,name, age, state);
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public void compete() {
		if (type == 1) {
			ranTime = getRandom(10.00, 20.00);
			competeTime = ranTime;
		} else if (type == 2) {
			ranTime = getRandom(100.00, 200.00);
			competeTime = ranTime;
		} else if (type == 3) {
			ranTime = getRandom(500.00, 800.00);
			competeTime = ranTime;
		} else {
			ranTime = 0;
		}

	}

	/**
	 * random time generator
	 * 
	 * @param min is compete time minimum value	             
	 * @param max is compete time max value	            
	 * @return
	 */
	public double getRandom(double min, double max) {
		Random ran = new Random();
		//return ran.nextInt((max - min) + 1) + min;
		double rancompeteTime = Double.parseDouble((dComplete.format(ran.nextDouble()*(max-min) + min)));
		return rancompeteTime;
	}
}
