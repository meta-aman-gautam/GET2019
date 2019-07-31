import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**zoo management which add cage in the zones and animals in the cages .
 * 
 * @author Aman Gautam
 * 
 * Dated 24/07/2019
 *
 */
public class Zoo {
	final int MAXNOZONES = 3; 
	final int MAXNOCAGES = 3; 
	final int MAXNOANIMALS = 3;
	
	Scanner sc = new Scanner(System.in);
	
	String zoneCategory;
	int noOfCages;
	boolean park,canteen ;
	float weight =(float)22.2;
	int countZone=0, age=22;
	
	//list of ZONES
	private List<Zone> listOfZones = new ArrayList<>();
		
	private Cage cage ;
	private Zone zone ;
	private Animal animal;
	/*
	 * ZOne is add by user input and cages or also created based on user 
	 * requirements.
	 */
	public void addZone() {
		System.out.println("enter the category of zone : ");
		zoneCategory = sc.next();
		System.out.println("enter the number of cages in zone : ");
		noOfCages = sc.nextInt();
		System.out.println("want to add park in zone [yes/no]: ");
		park = sc.nextBoolean();
		System.out.println("want to add canteen in zone [yes/no]: ");
		canteen = sc.nextBoolean();
		listOfZones.add(new Zone(zoneCategory, noOfCages, park, canteen));
		System.out.println("zone added successfully.. ");
		listOfZones.add(zone =new Zone(zoneCategory,noOfCages, park, canteen));
		zone.noOfCages=3;
	}
	
	/*
	 * Factory Design Pattern , used to create object of animal
	 * type , it get animal type and animal name from user and
	 * return objects of the same animal type 
	 */
	 public Animal getAnimalFactory(String animalType ,String name){  

		if (animalType == null) {
			throw new AssertionError("Animal type cannot be empty ");

		} else if (animalType.equalsIgnoreCase("PEACOCK")) {
			return new Peacock(name, weight, age);

		} else if (animalType.equalsIgnoreCase("SNAKE")) {
			return new Snake(name, weight, age);

		} else if (animalType.equalsIgnoreCase("LION")) {
			return new Lion(name, weight, age );

		} else if (animalType.equalsIgnoreCase("ELEPHANT")) {
			return new Elephant(name, weight, age);

		} else if (animalType.equalsIgnoreCase("CROCODILE")) {
			return new Crocodile(name, weight, age);

		} else {
			throw new AssertionError("We do not have this animal ");
		}
	}
	 
	 /*
	  * add animal to the zone and cage
	  */
	public void addAnimal(String animalType ,String name){
		for(int count_zone =1;count_zone<listOfZones.size();count_zone++){
			if(zone.getZoneCapacity()<MAXNOZONES && getAnimalFactory(animalType, name).getCategory()==zone.getZoneCategory()){
		
				listOfZones.get(count_zone); 
				System.out.println("count i ->"+listOfZones.get(count_zone));
				for(int count_cage=1;count_cage<zone.getListOfCages().size();count_cage++) {
					if(animalType == cage.getCageType() && cage.getCageCapacity()<MAXNOCAGES) {
						
						zone.getListOfCages().add(new Cage(name, animalType));
						
						zone.getListOfCages().get(count_cage);
						System.out.println("count j ->"+zone.getListOfCages().get(count_cage));
						for(int count_animal=1;count_animal<cage.getListOfAnimal().size();count_animal++) {
							if(animal.getAnimalCapacity()<MAXNOANIMALS) {
								cage.setListOfAnimal(getAnimalFactory(animalType, name));//add animal
								zone.getListOfCages().get(count_cage).cageCapacity--;
								System.out.println(animalType+" added to cage type");
							}
						}//added cage
					}
				}//added zone
					
			}
			else {
				throw new AssertionError("Sorry animal with this name doesn't exist");
			}
		}
	}
	
	/*
	 * get sound of the  animal
	 */
	public String getSound(String animalName,String animalType) {
		String sound = getAnimalFactory(animalType, animalName).getSound();
		return sound;
	}
	
}
