package org.openshift;

import java.util.Random;

import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class InsultGenerator {
	public String generateInsult() {
	//	String words[][] = {{"Artless", "Bawdy", "Beslubbering"}, {"Base-court", "Bat-fowling", "Beef-witted"}, {"Apple-john", "Baggage", "Barnacle"}};
		String vowels = "AEIOU";
		String article = "an";
		String theInsult="";
	//	String firstAdjective = words[0][new Random().nextInt(words[0].length)];
	//	String secondAdjective = words[1][new Random().nextInt(words[1].length)];
	//	String noun = words[2][new Random().nextInt(words[2].length)];
	//	if (vowels.indexOf(firstAdjective.charAt(0)) == -1) {
	//		article = "a";
	//	}
	//	return String.format("Thou art %s %s %s %s!", article, firstAdjective, secondAdjective, noun);
                try{
                    String databaseURL = "jdbc:postgresql://";
                    databaseURL += System.getenv("POSTGRESQL_SERVICE_HOST");
                    databaseURL += "/" + System.getenv("POSTGRESQL_DATABASE");
                    String username = System.getenv("POSTGRESQL_USER");
                    String password = System.getenv("PGPASSWORD");
                    Connection connection = DriverManager.getConnection(databaseURL, username,
                    password);
                    if (connection != null) {
			//return "tlukt!!!";
                        String res = "tmacheert";
                        //res=connection.toString();
                        //return res;
                        
                        String SQL = "select sample as s from audiosamples";
                        Statement stmt = connection.createStatement();
                        ResultSet rs = stmt.executeQuery(SQL);
                        while (rs.next()) {
                            theInsult += rs.getString("s <br>");
                        }
                        //theInsult = String.format("Thou art %s %s %s %s!", article,
                        //rs.getString("first"), rs.getString("second"), rs.getString("noun"));
                    }
                    rs.close();
                    connection.close();
                
            } catch (Exception e) {
                return "Database connection problem!";
                //return e.toString();
              }
            return theInsult;
        }

}
