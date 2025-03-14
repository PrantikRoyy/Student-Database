import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DeleteFrom {

	public static void setSafeUpdateOff() {
		 String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
	     String username = "root"; // Replace with your MySQL username
	     String password = "abc123@"; // Replace with your MySQL password

	     // SQL query
	     System.out.println("Safe Mode Off");
	     String query = "SET sql_safe_updates = 0;";

	     try {
	         // Load MySQL JDBC driver (optional for modern JDBC versions)
	         Class.forName("com.mysql.cj.jdbc.Driver");

	         // Connect to the database
	         Connection connection = DriverManager.getConnection(url, username, password);
	         System.out.println("Connected to the database!");

	         // Execute a query
	         PreparedStatement statement = connection.prepareStatement(query);	            
	         statement.executeUpdate();
	            
	         // Close the connection
	         statement.close();
	         connection.close();
	     } catch (Exception e) {
	    	         
	     }
	}
	
	public static ArrayList<String> DeletePerson(int ID) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "delete from Person where id = ?";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            
            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display result
            if (rowsAffected > 0) {
                System.out.println("User with ID = " + ID + " deleted successfully!");
                output.add("User with ID = " + ID + " deleted successfully!");
            } else {
                System.out.println("No user found with the specified ID = " + ID);
                output.add("No user found with the specified ID = " + ID);
            }
            
            // Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Either input is wrong or other infromation is dependent on this information");
        	output.add("Either input is wrong or other infromation is dependent on this information");
        }
        
        return output;
    }
	
	public static ArrayList<String> DeleteContactInfo(int ID) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "delete from ContactInfo where id = ?";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            
            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display result
            if (rowsAffected > 0) {
                System.out.println("Contact Infromation of user with ID = " + ID + " deleted successfully!");
                output.add("Contact Infromation of user with ID = " + ID + " deleted successfully!");
            } else {
                System.out.println("No Contact Infromation was found of a user with the specified ID = " + ID);
                output.add("No Contact Infromation was found of a user with the specified ID = " + ID);
            }
            
            // Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Either input is wrong or other infromation is dependent on this information");
        	output.add("Either input is wrong or other infromation is dependent on this information");
        }
        
        return output;
    }
	
	public static ArrayList<String> DeleteSchoolRecord(int ID, String SchoolName) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "delete FROM SchoolRecord where id = ? and SchoolName = ?";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, SchoolName);
            
            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display result
            if (rowsAffected > 0) {
                System.out.println("School Record of user with ID = " + ID + " & SchoolName = " + SchoolName + " deleted successfully!");
                output.add("School Record of user with ID = " + ID + " & SchoolName = " + SchoolName + " deleted successfully!");
            } else {
                System.out.println("No School Record was found of a user with the specified ID = " + ID + " & SchoolName = " + SchoolName);
                output.add("No School Record was found of a user with the specified ID = " + ID + " & SchoolName = " + SchoolName);
            }
            
            // Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Either input is wrong or other infromation is dependent on this information");
        	output.add("Either input is wrong or other infromation is dependent on this information");
        }
        
        return output;
    }
	
	public static ArrayList<String> DeleteFaculty(int ID, String SchoolName, int JobID) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "delete FROM Faculty where id = ? and SchoolName = ? and JobID = ?";
        ArrayList<String> output = new ArrayList<>();
        
        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, SchoolName);
            statement.setInt(3, JobID);
            
            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display result
            if (rowsAffected > 0) {
                System.out.println("Faculty Record of user with ID = " + ID + ", SchoolName = " + SchoolName + " & JobID = " + JobID + " deleted successfully!");
                output.add("Faculty Record of user with ID = " + ID + ", SchoolName = " + SchoolName + " & JobID = " + JobID + " deleted successfully!");
            } else {
                System.out.println("No Faculty Record was found of a user with the specified ID = " + ID + ", SchoolName = " + SchoolName + " & JobID = " + JobID);
                output.add("No Faculty Record was found of a user with the specified ID = " + ID + ", SchoolName = " + SchoolName + " & JobID = " + JobID);
            }
            
            // Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Either input is wrong or other infromation is dependent on this information");
        	output.add("Either input is wrong or other infromation is dependent on this information");
        }
        
        return output;
    }
	
	public static ArrayList<String> DeleteStudent(int ID, String SchoolName, String StudentID) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "delete FROM Student where id = ? and SchoolName = ? and StudentID = ?";
        ArrayList<String> output = new ArrayList<>();
        
        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, ID);
            statement.setString(2, SchoolName);
            statement.setString(3, StudentID);
            
            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display result
            if (rowsAffected > 0) {
                System.out.println("Student Record of user with ID = " + ID + ", SchoolName = " + SchoolName + " & StudentID = " + StudentID + " deleted successfully!");
                output.add("Student Record of user with ID = " + ID + ", SchoolName = " + SchoolName + " & StudentID = " + StudentID + " deleted successfully!");
            } else {
                System.out.println("No Student Record was found of a user with the specified ID = " + ID + ", SchoolName = " + SchoolName + " & StudentID = " + StudentID);
                output.add("No Student Record was found of a user with the specified ID = " + ID + ", SchoolName = " + SchoolName + " & StudentID = " + StudentID);
            }
            
            // Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Either input is wrong or other infromation is dependent on this information");
        	output.add("Either input is wrong or other infromation is dependent on this information");
        }
        
        return output;
    }
	
	public static ArrayList<String> ClearTable(String table) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "delete FROM " + table;
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            
            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display result
            if (rowsAffected > 0) {
                System.out.println("All users were removed!");
                output.add("All users were removed!");
            } else {
                System.out.println("There are no users to remove!");
                output.add("There are no users to remove!");
            }
            
            // Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Either input is wrong or other infromation is dependent on this information");
        	output.add("Either input is wrong or other infromation is dependent on this information");
        }
        
        return output;
    }
	
	public static ArrayList<String> ClearTable(String table, String SchoolName) {
    	// Database credentials
        String url = "jdbc:mysql://localhost:3306/StudentDatabase"; // Replace with your DB name
        String username = "root"; // Replace with your MySQL username
        String password = "abc123@"; // Replace with your MySQL password

        // SQL query
        String query = "delete FROM " + table + " where SchoolName = ?";
        ArrayList<String> output = new ArrayList<>();

        try {
            // Load MySQL JDBC driver (optional for modern JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");

            // Execute a query
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, SchoolName);
            
            // Execute the DELETE query
            int rowsAffected = statement.executeUpdate();

            // Display result
            if (rowsAffected > 0) {
                System.out.println("All users were removed!");
                output.add("All users were removed!");
            } else {
                System.out.println("There are no users to remove!");
                output.add("There are no users to remove!");
            }
            
            // Close the connection
            statement.close();
            connection.close();
        } catch (Exception e) {
        	System.out.println("Either input is wrong or other infromation is dependent on this information");
        	output.add("Either input is wrong or other infromation is dependent on this information");
        }
        
        return output;
    }
}




