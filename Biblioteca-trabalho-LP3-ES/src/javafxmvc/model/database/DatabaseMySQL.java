package javafxmvc.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Vargas Mesquita
 */
public class DatabaseMySQL implements Database {

    private Connection connection;

    @Override
    public Connection conectar() {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	//Class.forName("com.mysql.cj.jdbc.Driver");
        	this.connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/biblioteca", "root","123456");
            return this.connection;
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
