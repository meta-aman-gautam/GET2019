import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The Class JDBC_Connection.
 * @author Aman Gautam
 */
public class JDBC_Connection {

	static final String driver = "com.mysql.jdbc.Driver";
	static final String host= "jdbc:mysql://localhost:3306/";
	static String dbName = "storefront";
	static String mysqlURL = host+dbName ;
	static String userId = "root";
	
	static String password = "1083543569";
	Connection connObj;	
	
	/**
	 * Instantiates a new JDBC_connection.
	 */
	public JDBC_Connection(){
		try{
			Class.forName(driver);
			connObj = DriverManager.getConnection(mysqlURL, userId, password);
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Connection method.
	 *
	 * @return the connection
	 */
	public Connection connection(){
		return connObj ;
	}
	
}
