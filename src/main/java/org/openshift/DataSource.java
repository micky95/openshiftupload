/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openshift;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;


/**
 *
 * @author nagelsm
 */
public class DataSource {
    private static DataSource datasource;
    private BasicDataSource ds;
    
    private DataSource() throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUsername(System.getenv("POSTGRESQL_USER"));
        ds.setPassword(System.getenv("PGPASSWORD"));
        ds.setUrl("jdbc:postgresql://" + System.getenv("POSTGRESQL_SERVICE_HOST")+"/" 
                    + System.getenv("POSTGRESQL_DATABASE"));
       
     // the settings below are optional -- dbcp can work with defaults
        ds.setMinIdle(5);
        ds.setMaxIdle(20);
        ds.setMaxOpenPreparedStatements(180);

    }

    public static DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.ds.getConnection();
    }
}
