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
    static JdbcConnectionPool pool = new JdbcConnectionPool();
   
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection connection = pool.getConnectionFromPool();
        return connection;
    }

    public static void returnConnection(Connection connection) {
        pool.returnConnectionToPool(connection);
    }
}
