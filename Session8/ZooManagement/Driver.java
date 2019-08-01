import java.util.Scanner;

/**
 * Driver class which is used to drive Zoo class
 * 
 *  @author Aman Gautam
 *  
 *  dated 24/07/2019
 */
public class Driver {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		Zoo z=new Zoo();
		
		z.addZone();
		System.out.println("enter animal type");
		String animalType =sc.next();
		System.out.println("enter animal name");
		String animalName =sc.next();
		
		z.addAnimal(animalType, animalName);
		z.getSound(animalName, animalType);

	}

}
