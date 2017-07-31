/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openshift;

/**
 *
 * @author nagelsm
 */
public class Configuration {
 public String DB_USER_NAME ;
 public String DB_PASSWORD ;
 public String DB_URL;
 public String DB_DRIVER;
 public Integer DB_MAX_CONNECTIONS;

 public Configuration(){
  init();
 }

 private static Configuration configuration = new Configuration();

 public static Configuration getInstance(){ 
  return configuration;
 }

 private void init(){
  DB_USER_NAME = System.getenv("PGPASSWORD");
  DB_PASSWORD = System.getenv("POSTGRESQL_USER");
  DB_URL = "jdbc:postgresql://" + System.getenv("POSTGRESQL_SERVICE_HOST")+"/" 
                    + System.getenv("POSTGRESQL_DATABASE");
  DB_DRIVER = "org.postgresql.Driver";
  DB_MAX_CONNECTIONS = 5;
 }     
}
