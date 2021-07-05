import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the methods of QueryImplementation class
 * @author Aman Gautam
 */
public class DriverTest {

	Driver assignment ;
	
	@Before
	public void initialize() throws ClassNotFoundException, SQLException
	{
		assignment = new Driver();
	}

	//Test for order details
	@Test
	public void testForFirstAssignment() throws SQLException
	{
		List<OrderDetails> orders = new ArrayList<>();
		try {
			orders = Driver.firstAssignment(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("2", orders.get(0).orderId);
		assertEquals("135000", orders.get(1).total_price);
	}
	
	//Test for inserting images
	@Test
	public void testForSecondAssignment() throws SQLException
	{
		int[] productIds = {1,1,1,1,1};
		String[] imageURLS = {"a", "b", "c", "d", "e"};
		String string ="";
		for(int count_i=0;count_i<productIds.length ;count_i++){
			string =string+productIds[count_i]+"\t"+imageURLS[count_i]+"\n";
		}
		try {
			assertEquals(string, Driver.secondAssignment(productIds ,imageURLS));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Test for deleting products
	@Test
	public void testForThirdAssignment() throws SQLException
	{
		try {
			assertEquals(11, Driver.thirdAssignment());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Test for category details
	@Test
	public void testForForthAssignment() throws Exception
	{
		List<Category> categoryList = new ArrayList<>();
		categoryList = Driver.forthAssignment();
		assertEquals("2", categoryList.get(1).NoOfCategories);
		assertEquals("3", categoryList.get(2).NoOfCategories);
	}
}