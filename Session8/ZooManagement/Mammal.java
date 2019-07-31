/**
 * Abstract class Mammal has inheritance 
 * 
 *  @author Aman Gautam
 *  
 *  dated 24/07/2019
 */
public abstract class Mammal extends Animal{
	
	private static final String Mammal = null;
	String innateFeature ;
	
	public Mammal(){
		this.innateFeature ="Does NOT lay EGGS and presence of mammary glands which in females ";
	}

	public String getInnateFeature() {
		return innateFeature;
	}
	
	public abstract String getSound();
	
	public String getCategory() {
		return Mammal ;
	}
	
	
}
