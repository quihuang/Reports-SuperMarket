/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.HealthStatus;
import Classes.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class modelHealthStatus {
    
    Database db;
    Connection connection;
    
    public modelHealthStatus(){
        this.db = new Database();
        this.connection = db.getConnection();
    }
    
    public LinkedList<HealthStatus> getAll(){
        
        LinkedList<HealthStatus> hsList = new LinkedList<>();
        
        try{
                        
            String query = " SELECT id, description FROM health_status";
            PreparedStatement statementHS = this.connection.prepareStatement(query);

            ResultSet result = statementHS.executeQuery();
            
            while(result.next()){                
                HealthStatus hs = new HealthStatus();
                hs.setId( result.getInt(1) );
                hs.setDescription( result.getString(2));
                
                hsList.add(hs);
            }
            
            return hsList;
            
        }catch(SQLException e){
            return null;
        }        
        
    }
    
}
