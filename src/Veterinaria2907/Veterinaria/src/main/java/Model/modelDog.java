/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Dog;
import Classes.Pet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author zambr
 */
public class modelDog {
    
    private Database db;
    private Connection conn;
    
    public modelDog() {
        this.db = new Database();
        this.conn = db.getConnection();
    }
    
    public boolean CreatePet(Dog dog) {
        try {
            
            String queryPet = "INSERT INTO Pet(name, born_year, color, health_status) VALUES( ?, ?, ?, ? )";
            PreparedStatement insertPet = this.conn.prepareStatement(queryPet, Statement.RETURN_GENERATED_KEYS);
            insertPet.setString(1, dog.getName());
            insertPet.setInt(2, dog.getBornYear());
            insertPet.setString(3, dog.getColor());
            insertPet.setInt(4, dog.getHealthStatus());
            
            int rowsInserted = insertPet.executeUpdate();
            
            if(rowsInserted > 0){
                ResultSet generatedKeys = insertPet.getGeneratedKeys();
                
                if (generatedKeys.next()) {
                    int codePet = generatedKeys.getInt(1);

                    //Insertar perro, necesita el id de Pet
                    String queryDog = "INSERT INTO Dog(breed, pedigree, code_pet) VALUES( ?, ?, ? )";
                    PreparedStatement insertDog = this.conn.prepareStatement(queryDog, Statement.RETURN_GENERATED_KEYS);
                    insertDog.setInt(1, dog.getBreed());
                    insertDog.setBoolean(2, dog.getPedigree());
                    insertDog.setInt(3, codePet);

                    int rowsInsertedDog = insertDog.executeUpdate();
                    
                    return rowsInserted > 0 && rowsInsertedDog > 0;

                }
            }
            
            return false;
            
        } catch (SQLException e) {
            return false;
        }
        
    }
    
    public boolean EditPet(Dog dog) {
        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeletePet(Pet pet) {

        try {
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Pet SearchPet(String code) {
        Dog dog = null;
        try {
            return dog;
        } catch (Exception e) {
            return dog;
        }
    }
}
