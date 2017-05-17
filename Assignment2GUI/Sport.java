import java.util.*;
/**
 * class to make different sports
 * @author Kalinga
 *
 */
public class Sport {
	private String gameID;
	private ArrayList<Athlete> pList; // arraylist for list of athletes
	private Participant referee;
	private Athlete winner = null;// winner for game
	private Athlete second = null;// second of game
	private Athlete third = null;// third of game
/**
 * 
 * @param gameID
 * @param game
 * @param ref is referee object
 */
	public Sport(String gameID, ArrayList game, Participant ref) {
		this.gameID = gameID;
		pList = game;
		referee = ref;

	}

	public ArrayList<Athlete> getAthlete() {
		return pList;
	}

	public Athlete getWinner() {
		return winner;
	}

	public Athlete getSeccond() {
		return second;
	}

	public Athlete getThird() {
		return third;
	}

	public Participant getReferee() {
		return referee;
	}
/**
 * game stater 
 */
	public void startGame() {
		for (int i = 0; i < pList.size(); i++) {
			pList.get(i).compete(); // call compete method according to athlete
		}
		sorting();
		setPointsForWinners();
	}
/**
 * sort athletes according to time finished the game
 */
	public void sorting() {
		Collections.sort(pList); // athletes sort according to compete time
		Iterator<Athlete> afterswim = pList.iterator(); // iterate athletes
		System.out.format("%20s%15s%15s", "Name", "AthleteID", "Compete Time");
		System.out.println();
		while (afterswim.hasNext()) {
			Athlete aa = afterswim.next();
			System.out.format("%20s%15s%15s", aa.getName(), aa.getID(), aa.getCompeteTime());
			System.out.println();
		}

	}
/** 	
 * winner point setting for athletes
 */
	public void setPointsForWinners() {
		winner = pList.get(0);
		second = pList.get(1);
		third = pList.get(2);
		int pointsForFirst = pList.get(0).getPoint();
		int pointsForSecond = pList.get(1).getPoint();
		int pointsForThird = pList.get(2).getPoint();
		pointsForFirst += 5; // add 5 points winner
		pointsForSecond += 2;// add 2 points second
		pointsForThird += 1; // add 1 points third
		pList.get(0).setPoint(pointsForFirst);
		pList.get(1).setPoint(pointsForSecond);
		pList.get(2).setPoint(pointsForThird);
		
	}
}
