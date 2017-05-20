
public class CheckAthleteNumbers {
	
	public void checkNumerOfAthletes(int athnum) throws GameFullException,TooFewAthleteException{
	
	if (athnum < 4){
		throw new TooFewAthleteException("Few Athletes Please insert atleast 4");
	}
	else if (athnum > 8){
		throw new GameFullException("Too many Athlets, allowed only 8");
	}
}
}