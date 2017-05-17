import java.text.DecimalFormat;
import java.util.Random;

/**
 * 
 * @author Kalinga
 *
 */
public class Swimmer extends Athlete {
	//private int min = 100;
	//private int max = 200;
	final private double min = 100.00;
	final private double max = 200.00;
	DecimalFormat dComplete = new DecimalFormat(".#");

	public Swimmer(String ID,String participantType,String name,int age, String state) {
		super(ID,participantType, name, age, state);
	}

	@Override
	public void compete() {
		Random ran = new Random();
		//competeTime = ran.nextInt((max - min) + 1) + min;
		double rancompeteTime = Double.parseDouble((dComplete.format(ran.nextDouble()*(max-min) + min)));
		competeTime = rancompeteTime;

	}

}
