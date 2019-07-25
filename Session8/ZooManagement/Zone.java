import java.util.ArrayList;
import java.util.List;

/**zone class which is used to put same category cages ,
 * some zone migth have canteen and park as well
 * 
 * @author Aman Gautam

 * dated - 24/07/2019
 *
 */
public class Zone {
	
	private String zoneCategory ;
	int cageCount =0,zoneCapacity=0,noOfCages;
	private boolean hasCanteen , hasPark;
	
	private List<Cage> listOfCages = new ArrayList<>() ;
	
	public Zone(String zoneCategory ,int noOfCages,boolean hasPark ,boolean hasCanteen ){
		this.noOfCages =noOfCages;
		this.zoneCategory = zoneCategory;
		this.hasCanteen  =hasPark;
		this.hasCanteen  =hasCanteen;
		this.zoneCapacity++ ;	
	}
	//zone Category can be Mammal, Bird or Reptile
	public void setZoneCategory(String zoneCategory) {
		this.zoneCategory = zoneCategory;
	}

	public boolean isHasCanteen() {
		return hasCanteen;
	}

	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}

	public boolean isHasPark() {
		return hasPark;
	}

	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}

	public List<Cage> getListOfCages() {
		return listOfCages;
	}

	public void setListOfCages(List<Cage> listOfCages) {
		this.listOfCages = listOfCages;
	}

	public String getZoneCategory() {
		return zoneCategory;
	}

	public int getCageCount() {
		return cageCount;
	}

	public int getZoneCapacity() {
		return zoneCapacity;
	}
	
}
