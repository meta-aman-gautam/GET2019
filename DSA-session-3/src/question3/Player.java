package question3;
/**
 * this class represent a bowler
 * @author Aman Gautam
 * Dated 18/08/2019
 */
public class Player {
	
	public String bowlerName;
	public int balls;
	
	/**
	 * Constructor Intialize Bowler Name and Balls 
	 * @param bowlerName name of bowler
	 * @param balls balls left  of a bowler
	 */
	Player(String bowlerName, int balls) {
		this.bowlerName = bowlerName;
		this.balls = balls;
	}


}
