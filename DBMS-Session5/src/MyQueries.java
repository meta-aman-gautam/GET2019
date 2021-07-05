
/**
 * The Class MyQueries.
 * @author Aman Gautam
 */
public class MyQueries {

	/**
	 * First query. Given the id of a user, fetch all orders (Id, Order Date, Order Total) of that user which are in shipped state. 
	 * Orders should be sorted by order date column in chronological order.
	 *
	 * @param userId the user id
	 * @return the string
	 */
	public String firstQuery(int userId){
		String answer = "select cart_id as order_id , "
				        + "date_added as order_date, "
				        + "price * quantity as order_total from cart" 
				        + " where item_status ='shipped' and cart_id = "+userId
				        + " ORDER By date_added Asc;";
		return answer ;		
	}
	
	/**
	 * Second query.Insert five or more images of a product using batch 
	 * insert technique.
	 *
	 * @return the string
	 */
	public String secondQuery (){
		return "INSERT INTO images(product_id , image_src) VALUES(?,?);" ;
	}
	
	/**
	 * Third query.Delete all those products which were not ordered by any Shopper in last 1 year. 
	 * Return the number of products deleted.
	 *
	 * @return the string
	 */
	public String thirdQuery(){
		return "DELETE FROM product WHERE product_id NOT IN (select product_id from cart) and date_added >= CURRENT_DATE- INTERVAL 1 YEAR;";
	}
	
	/**
	 * Forth query.Select and display the category title of all top parent categories sorted 
	 * alphabetically and the count of their child categories.
	 *
	 * @return the string
	 */
	public String forthQuery(){
	    return "SELECT c.category_name ,"
	    		+ "COUNT(c1.parent_id) as child_categories from category c "
	    		+ "LEFT join category c1 ON c.category_id= c1.parent_id  "
	    		+ "AND c.parent_id is null GROUP BY c1.parent_id  "
	    		+ "having COUNT(c1.parent_id)>0 order By c.category_name;";
	}
	
	/**
	 * Sql safe updates query .
	 *
	 * @return the string
	 */
	public String sqlSafeUpdates (){
		return "SET SQL_SAFE_UPDATES=0;";
	}
	
	/**
	 * Show image query.
	 *
	 * @return the string
	 */
	public String showImage (){
		return "SELECT * FROM images;";
	}
	
	/**
	 * Show product query.
	 *
	 * @return the string
	 */
	public String showProduct (){
		return "SELECT * FROM product;";
	}
	
	/**
	 * Show foreign key checks query.
	 *
	 * @return the string
	 */
	public String showForeignKeyChecks (){
		return "SET FOREIGN_KEY_CHECKS=0;";
	}
}
