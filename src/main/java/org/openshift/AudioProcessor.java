package org.openshift;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Random;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import org.openshift.DataSource;


public class AudioProcessor {
    
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
	public String checkConnection() {
	
               
                String res="";
                Connection connection=null;
                try{
                    
                    connection = getConnection();
                    if (connection != null) {
			//return "tlukt!!!";
                        res += " tmacheert ";
                        //res+=connection.toString();
                    }
                    connection.close();
                }
                catch(Exception e){
                    res += "Database connection error!!" + "<br>";
  
                }
                    //rs.close();
                return res;
                
        }
        public String setDPData(byte b) throws IOException, PropertyVetoException{
            String res="";
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = DataSource.getInstance().getConnection();
                String SQL ="insert into audiosamples (sample) values (?);";
                PreparedStatement st= connection.prepareStatement(SQL);
                st.setInt(1, (int)b);
                st.execute();
                res += b + "<br>";
                return res;
            } catch (SQLException e) {
                e.printStackTrace();
                res = "db connection error";
            } finally {
                if (resultSet != null) try { resultSet.close(); } catch (SQLException e) {e.printStackTrace();}
                if (statement != null) try { statement.close(); } catch (SQLException e) {e.printStackTrace();}
                if (connection != null) try { connection.close(); } catch (SQLException e) {e.printStackTrace();}
            }
            return res;
        }
        public String setData(byte b){
            String res="";
                Connection connection=null;
                try{
                    
                    connection = getConnection();
                    if (connection != null) {
			//return "tlukt!!!";
                        res += " tmacheert ";
                        //res+=connection.toString();
                        
                        String SQL ="insert into audiosamples (sample) values (?);";
                        PreparedStatement st= connection.prepareStatement(SQL);
                        st.setInt(1, (int)b);
                        st.execute();
                        //Statement stmt = connection.createStatement();
                        //stmt.executeQuery(SQL);
                        res += b + "<br>";
                        return res;
                        //theInsult = String.format("Thou art %s %s %s %s!", article,
                        //rs.getString("first"), rs.getString("second"), rs.getString("noun"));
                    }
                    connection.close();
                }
                catch(Exception e){
                    res += "Database connection error!!" + "<br>" + e.getMessage();
  
                }
                    //rs.close();
                return res;
        }

}
