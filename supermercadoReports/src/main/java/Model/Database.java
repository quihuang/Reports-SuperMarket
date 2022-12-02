/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author quihuang
 */
public class Database {
     
    //Conexión a base de datos
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String user = "root";
    private String password = "Ceq03119";
    private String database = "proveedores";
    private String url = "jdbc:mysql://localhost:3306/" + database;    
    private Connection connection;
    
    public Connection getConnection(){        
        
        try{
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            return this.connection;
        }
        catch(SQLException e){
            System.out.println("Error Base Datos: " + e.getSQLState());
            return null;
        }
    }
    
}
