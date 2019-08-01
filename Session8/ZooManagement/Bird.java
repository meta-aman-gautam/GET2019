
/**
 * Abstract class Bird has inheritance 
 * 
 *  @author Aman Gautam
 *  
 *  dated 24/07/2019
 */
public abstract class Bird extends Animal {
	
	private static final String Bird = null;
	String innateFeature ;
	
	public Bird(){
		this.innateFeature ="Lays EGGS and characterised by feathers, toothless beaked jaws";
	}

	public String getInnateFeature() {
		return innateFeature;
	}
	
	public abstract String getSound();
	
	public String getCategory() {
		return Bird ;
	}
	
}
