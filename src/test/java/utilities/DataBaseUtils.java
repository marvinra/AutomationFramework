package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class DataBaseUtils extends Base {

    ReadPropertyFile readPropertyFile = new ReadPropertyFile();

    String URL, username, password;
    String URL3D, username3d, password3d;
    String QDURL, usernameQd, passwordQd;

    public static Connection connection;
    public static Connection connection2;
    public static Connection connection3;

    public synchronized void startDBConnection(){
        try{

            /**DB for CM3D*/
            URL = readPropertyFile.getDBconnection();
            username3d = readPropertyFile.getDBusername();
            password3d = readPropertyFile.DBpassword();


            Class.forName("com.informix.jdbc.IfxDriver");
            connection = DriverManager.getConnection(URL, username, password);

        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void stopDBConnection(){

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public List<Map<String, String>> executeDBCommandForListMapOutput(String command){
        List<Map<String, String>> listOutputMap = new ArrayList<Map<String,String>>();
        Statement statement;
        String columnname;
        Object output = null;
        String outputvalue;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(command);

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while (resultSet.next()){
                Map<String, String> outputMap = new TreeMap<String, String>();
                for (int i = 1; i <= columnCount; i++ ) {
                    columnname = rsmd.getColumnName(i);

                    output = resultSet.getObject(i);
                    outputvalue = String.valueOf(output);
                    outputMap.put(columnname, outputvalue);
                }
                listOutputMap.add(outputMap);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

		return listOutputMap;
}

  public String executeDBCommand(String command){
        Statement statement;
        Object result = null;
        try {
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(command);
        while (resultSet.next())
        {
        result = resultSet.getObject(1);
        result = String.valueOf(result);
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        return (String) result;
        }

    public List<String> executeDBCommandForListOfStringsOutput(String command){
        List<String> outputList = new ArrayList<String>();
        Statement statement;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                outputList.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outputList;
    }

    public List<String> executeDBCommandForListOfStringsOutput2(String command){
        List<String> outputList = new ArrayList<String>();
        Statement statement;
        try {
            statement = connection2.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                outputList.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outputList;
    }

    public List<String> executeDBCommandForListOfStringsOutput3(String command){
        List<String> outputList = new ArrayList<String>();
        Statement statement;
        try {
            statement = connection3.createStatement();
            ResultSet resultSet = statement.executeQuery(command);
            while (resultSet.next()){
                outputList.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return outputList;
    }

    public void executeDeleteUpdateInsertDBCommand(String command){
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(command);
        } catch (SQLException e) {
            System.out.println("[ DATABASE COMMAND ERROR ]");
            e.printStackTrace();
        }

    }

}

