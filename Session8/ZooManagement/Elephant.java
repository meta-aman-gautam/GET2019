/**
 * Elephant class which is inherited to Mammal
 * 
 * @author Aman Gautam
 * 
 * date 24/07/2019
 *
 */
public class Elephant extends Mammal {
	String name ,sound ,type;
	float weight ;
	int age ;
	

	public Elephant(String name ,float weight ,int age){
		this.name =name ;
		this.weight=weight;
		this.age = age;
		this.sound = "trumpets" ;
		this.type = "Elephant";
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
