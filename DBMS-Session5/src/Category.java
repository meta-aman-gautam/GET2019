
/**
 * The Class Category.
 */
public class Category {

	String categoryName ;
	String NoOfCategories;
	
	/**
	 * Instantiates a new category.
	 *
	 * @param categoryName the category name
	 * @param NoOfCategories the no of categories
	 */
	public Category(String categoryName ,String NoOfCategories){
		this.categoryName=categoryName;
		this.NoOfCategories=NoOfCategories;
	}

	//getter/setter
	public String getCategoryName() {
		return categoryName;
	}

	public String getNoOfCategories() {
		return NoOfCategories;
	}
}
