/**
 * Crocodile class which is inherited to Reptile
 * 
 * @author Aman Gautam
 * 
 * date 24/07/2019
 *
 */
public class Crocodile extends Reptile {
	String name ,sound ,type;
	float weight ;
	int age ;

	public Crocodile(String name ,float weight ,int age){
		this.name =name ;
		this.weight=weight;
		this.age = age;
		this.sound = "bellows" ;
		this.type = "Crocodile";
		this.innateFeature = getInnateFeature();
	}

	/**
	 * method to return the sound of animals 
	 * @return the sound of given animal
	 */
	public String getSound() {
		return this.sound;
	}
}
