/**
 * Abstract class Reptile has inheritance 
 * 
 *  @author Aman Gautam
 *  
 *  dated 24/07/2019
 */
public abstract class Reptile extends Animal{
	
	private static final String Reptile = null;
	String innateFeature ;
	
	public Reptile(){
		this.innateFeature ="Lays EGGS and covered in special skin made up of scales, bony plates, or a combination of both ";
	}

	public String getInnateFeature() {
		return innateFeature;
	}
	
	public abstract String getSound();
	
	public String getCategory() {
		return Reptile ;
	}
	
}
