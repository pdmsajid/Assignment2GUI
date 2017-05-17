import java.text.DecimalFormat;
import java.util.Random;
/**
 * @author Kalinga
 */


public class Cyclist extends Athlete {
	//private int min = 500;
	//private int max = 800;
	final private double min = 500.00;
	final private double max = 800.00;
	DecimalFormat dComplete = new DecimalFormat(".#");
	public Cyclist(String ID,String participantType, String name, int age, String state) {
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
