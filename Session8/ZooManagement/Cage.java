import java.util.ArrayList;
import java.util.List;

/**Cage is class which is used to put animals in the zoo, only a single type 
 * of animal can come in single type of cage. 
 * 
 * @author Aman Gautam
 * 
 * dated 24/07/2019
 */
public class Cage {
	
	int cageCapacity ;
	String cageType ,animalName;
	
	private List<Animal> listOfAnimal = new ArrayList<>() ;
	
	public Cage(String animalName ,String cageType){
		this.cageType =cageType;
		this.animalName =animalName;
		this.cageCapacity =0;
	}

	public String getCageType() {
		return cageType;
	}

	public void setCageType(String cageType) {
		this.cageType = cageType;
	}

	public List<Animal> getListOfAnimal() {
		return listOfAnimal;
	}

	public void setListOfAnimal(Animal animal) {
		this.listOfAnimal.add(animal);
	}

	public int getCageCapacity() {
		return cageCapacity;
	}

	public String getAnimalName() {
		return animalName;
	}	
}
