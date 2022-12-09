import java.sql.*;
import java.util.LinkedList;

/**
 * This class is responsible for connecting and sending queries to the database.
 * It also stores the object instances needed for the application to function.
 *@author Renat Oosthuizen
 *@since 13/05/2021
 */
public class DataManager {
	
	//Variables storing the database connection details.
	/**This variable will store the database connection.*/
	private static Connection conn = null;
	/**Java database connect:mysql:ip address of server:port.*/
	private static final String url = ""; 
	/**Name of the database.*/
	private static final String dbName = ""; 
	/**Client side java driver to be used for the database connection.*/
	private static final String driver = "com.mysql.cj.jdbc.Driver"; 
	/**Username to login to database.*/
	private static final String userName = ""; 
	/**Password to login to database.*/
	private static final String password = ""; 
	
	//Variables that will store objects.
	/**Instance of the User class that will store the details of the loggedUser.*/
	private User loggedUser = null;
	/**Instance of the User class that will store the details of the coach/secretary currently being viewed/edited.*/
	private User user = null;
	/**Instance of the NonPlayer class that will store the details of the non-player currently being viewed/edited.*/
	private NonPlayer nPlayer = null;
	/**Instance of the JuniorPlayer class that will store the details of the junior player currently being viewed/edited.*/
	private JuniorPlayer jPlayer = null;
	/**Instance of the SeniorPlayer class that will store the details of the senior player currently being viewed/edited.*/
	private SeniorPlayer sPlayer = null;
	/**Instance of the Squad class that will store the details of the squad currently being viewed/edited.*/
	private Squad squad = null;
	

	/**
	 * Function that opens a connection to database, sends query, stores result as a list of objects, closes connection and returns result.
	 * This is used exclusively for queries that return multiple pieces of data.
	 * @param query is the String query that will be sent to the database.
	 * @return result which will contain a LinkedList of objects storing the requested data from the database. This is done as the data format returned is unknown.
	 */
	public LinkedList<Object> sendMultiQuery(String query) {
		
		LinkedList<Object> result = new LinkedList<Object>();
		
	    try //Try connecting.
	    { 
	    	
		    Class.forName(driver);
		    conn = DriverManager.getConnection(url+dbName, userName, password);
		    
		    //Sending a query.
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
	    
		    try //Add all returned data to result.
		    {
		        while ( rs.next() ) 
		        {
		            int numColumns = rs.getMetaData().getColumnCount();
		            
		            for ( int i = 1 ; i <= numColumns ; i++ ) //Loop starts at 1 as column numbers start at 1.
		            {
	
		               result.add(rs.getObject(i)); 
		            }
		        }
		    }
		    catch (Exception e)
		    {

		    	e.printStackTrace();
		    }
		    
		    //Close connection when it is no longer needed to reduce load on database.
		    try 
		    { 
		    	conn.close(); 
		    } 
		    catch (Throwable ignore) 
		    { 
		        // Propagate the original exception instead of this one that will be ignored (but could be logged if needed). 
		    }
		    
	
		}
	    catch (Exception e)
	    {

	    	e.printStackTrace();
	    }
		
		return result; //Return result from database allowing the user to receive the requested data.
	}
	

	/**
	 * Function that opens a connection to database, sends query, stores result, closes connection and returns result.
	 * This is used exclusively for queries that return a single piece of data.
	 * @param query is the String query that will be sent to the database.
	 * @return result which will contain a single piece of data (String) from the database that was requested by the query.
	 */
	public String sendQuery(String query) {
		
		String result = ""; //This will store the data returned by the database.
		
	    try //Try connecting.
	    { 
	    	
		    Class.forName(driver);
		    conn = DriverManager.getConnection(url+dbName, userName, password);
		    
		    //Sending a query.
		    Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
	    
		    try //Add all returned data to result.
		    {
		        while ( rs.next() ) 
		        {
		            int numColumns = rs.getMetaData().getColumnCount();
		            
		            for ( int i = 1 ; i <= numColumns ; i++ ) //Loop starts at 1 because column numbers start at 1.
		            {
	
		               result += (rs.getObject(i)); 
		            }
		        }
		    }
		    catch (Exception e)
		    {

		    	e.printStackTrace();
		    }
		    
		    //Close connection when it is no longer needed to reduce load on database.
		    try 
		    { 
		    	conn.close(); 
		    } 
		    catch (Throwable ignore) 
		    { 
		    	// Propagate the original exception instead of this one that will be ignored (but could be logged if needed). 
		    }
		    
	
	    }
	    catch (Exception e)
	    {

	    	e.printStackTrace();
	    }
		
		return result; //Return result from database allowing the user to receive the requested data.
	}
	

	/**
	 * Function that opens a connection to the database, sends an update query, stores number of lines changed as result, closes connection, returns result.
	 * @param query is the String query that will be sent to the database.
	 * @return result which is '1' if the query executed successfully.
	 */
	public int sendUpdate(String query) {
		
		int result = 0; //Result that will be returned from the database.
		
	    try //Try connecting.
	    { 
	    	
		    Class.forName(driver);
		    conn = DriverManager.getConnection(url+dbName, userName, password);
		    
		    //Sending a query.
		    Statement stmt = conn.createStatement();
		    result = stmt.executeUpdate(query);
		    
			    
		    //Close connection when it is no longer needed to reduce load on database.
		    try 
		    { 
		    	conn.close(); 
		    }
		    catch (Throwable ignore) 
		    { 
		    	// Propagate the original exception instead of this one that will be ignored (but could be logged if needed). 
		    }
		    
	
	    }
	    catch (Exception e)
	    {
	      
	    	e.printStackTrace();
	    }
		
		return result; //Return result from database allowing the user to be informed if the query was successful.
	}

	/*---GETTERS---*/
	
	/**
	 * Getter from the DataManager class.
	 * @return loggedUser
	 */
	public User getLoggedUser() {
		return loggedUser;
	}

	/**
	 * Getter from the DataManager class.
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Getter from the DataManager class.
	 * @return nPlayer
	 */
	public NonPlayer getNPlayer() {
		return nPlayer;
	}

	/**
	 * Getter from the DataManager class.
	 * @return jPlayer
	 */
	public JuniorPlayer getJPlayer() {
		return jPlayer;
	}

	/**
	 * Getter from the DataManager class.
	 * @return sPlayer
	 */
	public SeniorPlayer getSPlayer() {
		return sPlayer;
	}

	/**
	 * Getter from the DataManager class.
	 * @return squad
	 */
	public Squad getSquad() {
		return squad;
	}

	/*---SETTERS---*/
	
	/**
	 * Setter from the DataManager class.
	 * @param loggedUser
	 */
	public void setLoggedUser(User loggedUser) {
		this.loggedUser = loggedUser;
	}

	/**
	 * Setter from the DataManager class.
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Setter from the DataManager class.
	 * @param nPlayer
	 */
	public void setNPlayer(NonPlayer nPlayer) {
		this.nPlayer = nPlayer;
	}

	/**
	 * Setter from the DataManager class.
	 * @param jPlayer
	 */
	public void setJPlayer(JuniorPlayer jPlayer) {
		this.jPlayer = jPlayer;
	}

	/**
	 * Setter from the DataManager class.
	 * @param sPlayer
	 */
	public void setSPlayer(SeniorPlayer sPlayer) {
		this.sPlayer = sPlayer;
	}

	/**
	 * Setter from the DataManager class.
	 * @param squad
	 */
	public void setSquad(Squad squad) {
		this.squad = squad;
	}


}
