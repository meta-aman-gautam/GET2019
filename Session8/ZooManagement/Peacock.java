/**
 * Peacock class which is inherited to BIRD
 * 
 * @author Aman Gautam
 * 
 * date 24/07/2019
 *
 */
public class Peacock extends Bird {
	String name ,sound,type ;
	float weight ;
	int age ;
	
	
	public Peacock(String name ,float weight ,int age ){
		this.name =name ;
		this.weight=weight;
		this.age = age;
		this.sound = "screams" ;
		this.type = "Peacock";
		this.innateFeature = getInnateFeature();
	}

	/**
	 * method to return the sound of animals 
	 * @return the sound of given animal
	 */
	public String getSound() {
		return this.sound ;
	}

}
