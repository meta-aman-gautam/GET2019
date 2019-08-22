import java.io.ObjectInputStream.GetField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Driver Class 
 * @author Aman Gautam
 */
public class Driver {
	
	static final JDBC_Connection JC = new JDBC_Connection();
	static Scanner sc = new Scanner(System.in);
	static String inputString=null ;
	static MyQueries mq = new MyQueries();
	
	/**
	 * The Initialization of main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			ResultSet resultSet;
			System.out.println("Choose -> [\n1 -> Assignment_1\n2 -> Assignment_2\n3 -> Assignment_3\n4 -> Assignment_4]");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				List<OrderDetails> orderList =firstAssignment(2);
				String answer ="";
				for(int count_i=0;count_i<orderList.size();count_i++){
					answer = answer+orderList.get(count_i).orderId+" -- "+orderList.get(count_i).order_date+" -- "+orderList.get(count_i).total_price +"\n";
				}
				System.out.println(answer);
				break;
				
			case 2:
				int[] product_id = new int[] { 1, 1, 1, 1, 1, 2, 2, 2, 2, 2 };
				String[] imgUrl = new String[] { "/image1.3", "/image1.4",
						"/image1.5", "/image1.6", "/image1.7", "/image2.7",
						"/image2.7", "/image2.7", "/image2.7", "/image2.7" };
				String answer1 = secondAssignment(product_id ,imgUrl);
				System.out.println(answer1);
				break;

			case 3:
				System.out.println("No of values DELETED Are :"+ thirdAssignment());
				break;
				
			case 4:
				List<Category> categoryList = forthAssignment();
				String answer11 ="";
				for(int count_i=0;count_i<categoryList.size();count_i++){
					answer11 = answer11+categoryList.get(count_i).categoryName+"---->"+categoryList.get(count_i).NoOfCategories +"\n";
				}
				System.out.println(answer11);
				break;
				
			default :
				System.out.println("Invalid Choice : ");
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	/**
	 * showImages method show the images table .
	 *
	 * @throws Exception the exception
	 */
	public static void showImages() throws Exception{
		try{
			Statement statement = JC.connection().createStatement();
			inputString = mq.showImage();
			ResultSet resultSet = statement.executeQuery(inputString);
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+ " " + resultSet.getString(2));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * showProduct method show the product table .
	 *
	 * @throws Exception the exception
	 */
	public static void showProduct() throws Exception{
		try{
			Statement statement = JC.connection().createStatement();
			inputString = mq.showProduct();
			ResultSet resultSet = statement.executeQuery(inputString);

			while(resultSet.next()){
				System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * First assignment->Given the id of a user, fetch all orders (Id, Order Date, Order Total) 
	 * of that user which are in shipped state. Orders should be sorted by 
	 * order date column in chronological order.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public static List<OrderDetails> firstAssignment(int id) throws Exception{
		List<OrderDetails> order_list = new ArrayList<>();
		try{
			Statement statement = JC.connection().createStatement();
			System.out.print("Enter the id >>");
			inputString = mq.firstQuery(id);
			ResultSet resultSet = statement.executeQuery(inputString);
			while (resultSet.next()) {
				order_list.add(new OrderDetails(resultSet.getString("order_id")
						,resultSet.getDate("order_date")
						, resultSet.getString("order_total")));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return order_list;
	}
	
	/**
	 * Second assignment-> Insert five or more images of a product 
	 * using batch insert technique.
	 *
	 * @throws Exception the exception
	 */
	public static String secondAssignment(int[] product_id,String[] imgUrl ) throws Exception{
		String image_list = "";
		
	
		inputString  = mq.secondQuery();
		try{
			PreparedStatement prestmt = JC.connection().prepareStatement(inputString);
			JC.connection().setAutoCommit(false);

			for(int count_i =0 ;count_i<product_id.length;count_i++){
				prestmt.setInt(1, product_id[count_i]);
				prestmt.setString(2 , imgUrl[count_i]);
				image_list = image_list + product_id[count_i]+"\t"+imgUrl[count_i]+"\n";
				prestmt.addBatch();
			}
			prestmt.executeBatch();
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return image_list;
	}
	
	/**
	 * Third assignment-> Delete all those products which were not ordered 
	 * by any Shopper in last 1 year. Return the number of products deleted.
	 *
	 * @return answer
	 * @throws SQLException 
	 */
	public static int thirdAssignment() throws Exception{
		int answer = 0 ;
		try{
			Statement statement = JC.connection().createStatement();
			JC.connection().setAutoCommit(false);
			inputString  = mq.showForeignKeyChecks();
			statement.executeQuery(inputString);
			inputString  = mq.thirdQuery();
			answer = statement.executeUpdate(inputString);
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return answer;
	}
	
	/**
	 * Forth assignment -> Select and display the category title of all
	 * top parent categories sorted alphabetically and the count of 
	 * their child categories.
	 *
	 * @return the list
	 * @throws Exception the exception
	 */
	public static List<Category> forthAssignment() throws Exception{
		List<Category> listofCategory =new ArrayList<>();
		try{
			inputString = mq.forthQuery();
			Statement statement = JC.connection().createStatement();
			ResultSet resultSet = statement.executeQuery(inputString);
			while(resultSet.next()){
				listofCategory.add(new Category(resultSet.getString(1),resultSet.getString(2)));
			}
		}
		catch(SQLException e){
			e.getMessage();
		}
		return listofCategory;
	}
}
