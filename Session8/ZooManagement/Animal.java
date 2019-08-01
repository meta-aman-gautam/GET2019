/**
 * Abstract class Animal is base class
 * 
 *  @author Aman Gautam
 *  
 *  dated 24/07/2019
 */
public abstract class Animal {
	
	private int id , animalCapacity =0 ;

	public Animal(){
		this.id++; 
		this.animalCapacity++;	
	}
	
	public int getId() {
		return id;
	}

	public int getAnimalCapacity() {
		return animalCapacity;
	}
	
	/**
	 * abstract method to return the sound of animals
	 * @return the sound of given animal
	 */
	abstract String getSound();
	
	abstract String getCategory();


}