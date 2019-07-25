/**
 * Parrot class which is inherited to BIRD
 * 
 * @author Aman Gautam
 * 
 * date 24/07/2019
 *
 */
public class Parrot extends Bird{
	String name ,sound ,type;
	float weight ;
	int age ;


	public Parrot(String name ,float weight ,int age){
		this.name =name ;
		this.weight=weight;
		this.age = age;
		this.sound = "Squeaks" ;
		this.type = "Parrot";
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
