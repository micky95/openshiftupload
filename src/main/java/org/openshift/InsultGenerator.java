package org.openshift;

import java.util.Random;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;


public class InsultGenerator {
    
        public Connection getConnection(){
            try{
                    String databaseURL = "jdbc:postgresql://";
                    databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
                    databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
                    String username = System.getenv("POSTGRESQL_USER");
                    String password = System.getenv("PGPASSWORD");
                    Connection connection = DriverManager.getConnection(databaseURL, username,
                    password);
                    return connection;
            }
            catch(Exception e){e.printStackTrace();
            return null;
            }
        }
	public String testConnection() {
	
               
                Connection connection=null;
                //try{
                    connection = getConnection();
                    if (connection != null) {
			//return "tlukt!!!";
                        String res = "tmacheert";
                        //res=connection.toString();
                        
                        
                        String SQL = "select sample from audiosamples";
                        Statement stmt = connection.createStatement();
    
                        ResultSet rs = stmt.executeQuery(SQL);
                        res= rs.toString();
                        //return res;
                        while (rs.next()) {
                            res += "<br>"+rs.getString("sample");
                        }
                        return res;
                        //theInsult = String.format("Thou art %s %s %s %s!", article,
                        //rs.getString("first"), rs.getString("second"), rs.getString("noun"));
                    }
                    else{
                    return "database connection error!";
                    }
                    connection.close();
                //}
                //catch(Exception e){
                  //  return "Database connection error!!";
                //}
                    //rs.close();
                return null;
                
        }

}
