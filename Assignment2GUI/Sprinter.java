import java.text.DecimalFormat;
import java.util.Random;

/**
 * 
 * @author Kalinga
 *
 */
public class Sprinter extends Athlete {
	//int min = 10;
	//int max = 20;
	final private double min = 10.00;
	final private double max = 20.00;
	DecimalFormat dComplete = new DecimalFormat(".#");
	public Sprinter(String ID, String participnatType,String name, int age, String state) {
		super(ID,participnatType,name, age, state);
	}

	@Override
	public void compete() {
		Random ran = new Random();
		//competeTime = ran.nextInt((max - min) + 1) + min;
		double rancompeteTime = Double.parseDouble((dComplete.format(ran.nextDouble()*(max-min) + min)));
		competeTime = rancompeteTime;
	}
}
