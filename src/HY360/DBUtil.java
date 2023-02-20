package HY360;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;


public class DBUtil {

    //Declare JDBC Driver
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    //Connection
    private static Connection conn = null;
    //Connection String
    private static final String connStr = "jdbc:mysql://localhost:3306/";
    private static String databaseName = "";
    //Connect to DB
    private static String username = "root";

    private static String password = "";

    public static void dbConnect() throws SQLException, ClassNotFoundException {
        //Setting Oracle JDBC Driver
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            throw e;
        }

        //Establish the Oracle Connection using Connection String
        try {
            conn = DriverManager.getConnection(connStr+databaseName, username, password);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }
    //Close Connection
    public static void dbDisconnect() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }


    //DB Execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet and CachedResultSet as null
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs;
        try {
            //Connect to DB
            dbConnect();
            if(!queryStmt.contains("COUNT"))
                System.out.println("Select statement: " + queryStmt + "\n");

            //Create statement
            stmt = conn.createStatement();

            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);

            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
        //Return CachedRowSet
        return crs;
    }

    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB
            dbConnect();
            System.out.println("Update statement: " + sqlStmt + "\n");
            //Create Statement
            stmt = conn.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
    }


    public static void setDatabaseName(String databaseName) {
        DBUtil.databaseName = databaseName;
    }
    public static String getDatabaseName() {
        return databaseName;
    }
    public static String getUsername() {
        return username;
    }
    public static void setUsername(String username) {
        DBUtil.username = username;
    }
    public static String getPassword() {
        return password;
    }
    public static void setPassword(String password) {
        DBUtil.password = password;
    }
}
