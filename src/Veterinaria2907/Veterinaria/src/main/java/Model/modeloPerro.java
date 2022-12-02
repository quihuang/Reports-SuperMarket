/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Dog;
import Classes.Pet;
import Classes.ReporteRaza;
import Classes.Reportes.ReportBreed;
import Classes.Reportes.ReportBreedPie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class modeloPerro {
    
    Database bd;
    Connection conexion;
    
    public modeloPerro(){
        this.bd = new Database();
        this.conexion = bd.getConnection();
    }
    
    public boolean crear(Dog dog){
        try {
            String query = "INSERT INTO pet (name, born_year, color, health_status) VALUES ( ?, ?, ?, ?)";
            PreparedStatement statementPet = this.conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementPet.setString(1, dog.getName());
            statementPet.setInt(2, dog.getBornYear());
            statementPet.setString(3, dog.getColor());
            statementPet.setInt(4, dog.getHealthStatus());
            
            int rowsInserted = statementPet.executeUpdate();
            
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statementPet.getGeneratedKeys();
                if (generatedKeys.next()) {
                    
                    int codePet = generatedKeys.getInt(1);
                    
                    query = "INSERT INTO dog (breed, pedigree, code_pet) VALUES (?, ?, ?)";
                    PreparedStatement statementDog = this.conexion.prepareStatement(query);                    
                    statementDog.setInt(1, dog.getBreed());
                    statementDog.setBoolean(2, dog.getPedigree());
                    statementDog.setInt(3, codePet);
                    
                    int rowsInsertedDog = statementDog.executeUpdate();
                    
                    return (rowsInserted > 0 && rowsInsertedDog > 0);
                                                            
                }
            }
            return false;
        } catch (SQLException e) {
            return false;
        }        
    }
    
    public Dog obtenerPerro(int codigo){
        try{
            String query = "SELECT code, name, born_year, color, health_status, breed, pedigree FROM pet INNER JOIN dog ON pet.code = dog.code_pet WHERE code = ? AND status = 'A' ";
            PreparedStatement statementDog = this.conexion.prepareStatement(query);
            statementDog.setInt(1, codigo);
            
            ResultSet result = statementDog.executeQuery();
            
            if( result.next() ){
                
                Dog perro = new Dog();
                
                perro.setCode( result.getInt(1) );
                perro.setName( result.getString(2) );
                perro.setBornYear( result.getInt(3) );
                perro.setColor( result.getString(4) );
                perro.setHealthStatus( result.getInt(5) );
                perro.setBreed( result.getInt(6) );
                perro.setPedigree( result.getBoolean(7) );
                
                return perro;
                
            }else{
                return null;
            }
            
        }catch(SQLException e){
            System.out.println("Ocurrio un error: " + e.getMessage() );
            return null;
        }
    }
            
    public int actualizar(Dog dog){
        try {
            String queryPet = "UPDATE pet SET name = ?, born_year = ?, color = ?, health_status = ? WHERE code = ?";
            PreparedStatement statementPet = this.conexion.prepareStatement(queryPet);
            statementPet.setString(1, dog.getName());
            statementPet.setInt(2, dog.getBornYear());
            statementPet.setString(3, dog.getColor());
            statementPet.setInt(4, dog.getHealthStatus());
            statementPet.setInt(5, dog.getCode());

            String queryDog = "UPDATE dog SET breed = ?, pedigree = ? WHERE code_pet = ?";
            PreparedStatement statementDog = this.conexion.prepareStatement(queryDog);
            statementDog.setInt(1, dog.getBreed());
            statementDog.setBoolean(2, dog.getPedigree());
            statementDog.setInt(3, dog.getCode());
            
            int rowsUpdatedPet = statementPet.executeUpdate();
            int rowsUpdatedDog = statementDog.executeUpdate();
            
            if (rowsUpdatedPet > 0 || rowsUpdatedDog > 0)
                return 3;
            else
                return 1;
            
        } catch (SQLException e) {
            return 2;
        }
    }
    
    public Dog obtener(int code){
        
        Dog dog = null;
        try {
            String query = "SELECT code, name, born_year, color, health_status, id, breed, pedigree FROM pet AS p INNER JOIN dog AS d on p.code = d.code_pet WHERE p.code = ? ";
            PreparedStatement statementPet = this.conexion.prepareStatement(query);
            statementPet.setInt(1, code);            
            
            ResultSet result = statementPet.executeQuery();
            
            while (result.next()) {
                int petCode = result.getInt(1);
                String petName = result.getString(2);
                int petBornYear = result.getInt(3);
                String petColor = result.getString(4);
                int petHealthStatus = result.getInt(5);
                int dogId = result.getInt(6);
                int petBreed = result.getInt(7);
                Boolean petPedigree = result.getBoolean(8);
                
                dog = new Dog(dogId, petBreed, petPedigree, petCode, petName, petBornYear, petColor, petHealthStatus);
            }
            return dog;
        } catch (SQLException e) {
            return dog;
        }        
    }
    
    public LinkedList<Dog> getAll(){
        
        LinkedList<Dog> dogList = new LinkedList<Dog>();
        
        try{
            
            String query = "SELECT code, name, born_year, color, health_status, breed, pedigree FROM pet AS p INNER JOIN dog AS d on p.code = d.code_pet WHERE status = 'A' ";
            PreparedStatement statementPet = this.conexion.prepareStatement(query);
            
            ResultSet rs = statementPet.executeQuery();
            
            while( rs.next() ){
                
                Dog perro = new Dog();
                
                perro.setCode( rs.getInt("code") );
                perro.setName( rs.getString("name") );
                perro.setBornYear( rs.getInt("born_year") );
                perro.setColor( rs.getString("color") );
                perro.setHealthStatus( rs.getInt("health_status") );
                perro.setBreed( rs.getInt("breed") );
                perro.setPedigree( rs.getBoolean("pedigree") );
                
                dogList.add(perro);
                
            }
            
            return dogList;
            
        }catch(SQLException e){
            return dogList;
        }
        
    }
    
    public LinkedList<Dog> obtenerListado(){
        
        LinkedList<Dog> dogList = new LinkedList<>();
        
        try {
            String query = "SELECT code, name, born_year, color, health_status, breed, pedigree FROM pet AS p INNER JOIN dog AS d on p.code = d.code_pet WHERE status = 'A' ";
            PreparedStatement statementPet = this.conexion.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();
            
            while (result.next()) {
                
                Dog perro = new Dog();
                
                perro.setCode( result.getInt(1) );
                perro.setName( result.getString(2) );
                perro.setBornYear( result.getInt(3) );
                perro.setColor( result.getString(4) );
                perro.setHealthStatus( result.getInt(5) );
                perro.setBreed( result.getInt(6) );
                perro.setPedigree( result.getBoolean(7) );
                                
                dogList.add(perro);
            }
            
            return dogList;
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    public Dog[] obtenerListadoPorNombre(String nombre){
        return null;
    }
    
    public Dog[] obtenerListadoPorRaza(String raza){
        return null;
    }
    
    public int eliminar(int codigo) throws SQLException{        
        try {
            String queryPet = "DELETE FROM pet WHERE code = ?";
            PreparedStatement statementPet = this.conexion.prepareStatement(queryPet);
            statementPet.setInt(1, codigo);
            
            String queryDog = "DELETE FROM dog WHERE code_pet = ?";
            PreparedStatement statementDog = this.conexion.prepareStatement(queryDog);
            statementDog.setInt(1, codigo);
            
            int rowsDeletedDog = statementDog.executeUpdate();
            int rowsDeletedPet = statementPet.executeUpdate();
                        
            if (rowsDeletedPet > 0 && rowsDeletedDog > 0)
                return 2;
            else
                return 1;
            
        }catch(SQLException e) {            
            throw e;
        }
    }
    
    public int eliminarLogico(int codigo) throws SQLException{
        try{
            String queryPet = "UPDATE pet SET status = 'E' WHERE code = ?";
            PreparedStatement statementPet = this.conexion.prepareStatement(queryPet);
            statementPet.setInt(1, codigo);
            
            int rowsDeletedPet = statementPet.executeUpdate();
            
            if (rowsDeletedPet > 0)
                return 2;
            else
                return 1;
            
        }catch (SQLException e) {
            throw e;
        }
    }
    
    public LinkedList<ReporteRaza> reporteRazaMascota(){
        
        LinkedList<ReporteRaza> reporte = new LinkedList<>();
        
        try {
            String query = "SELECT COUNT(*) as total, breed FROM dog GROUP BY breed";
            PreparedStatement statementPet = this.conexion.prepareStatement(query);
            ResultSet result = statementPet.executeQuery();
            
            while (result.next()) {
                
                ReporteRaza report = new ReporteRaza();
                
                report.setCantidad( result.getInt("total") );
                report.setRaza( result.getString("breed") );
                                
                reporte.add(report);
            }
            
            return reporte;
            
        } catch (SQLException e) {
            return null;
        }
    }
    
    public LinkedList<Dog> obtenerListadoPerros() throws SQLException{
        
        LinkedList<Dog> listadoPerros = new LinkedList<Dog>();
        
        try{
            String query = "SELECT code, name, born_year, color, health_status, breed, pedigree FROM pet INNER JOIN dog ON pet.code = dog.code_pet ";            
            PreparedStatement statementDog = this.conexion.prepareStatement(query);
            
            ResultSet result = statementDog.executeQuery();
            
            while( result.next() ){
                
                Dog dog = new Dog();
                
                dog.setCode( result.getInt("code") );
                dog.setName( result.getString("name") );
                dog.setBornYear(result.getInt("born_year") );
                dog.setColor(result.getString("color") );
                dog.setHealthStatus(result.getInt("health_status") );
                dog.setBreed(result.getInt("breed") );
                dog.setPedigree(result.getBoolean("pedigree") );
                
                listadoPerros.add(dog);
                
            }
            
            return listadoPerros;            
            
        }catch(SQLException e){
           throw e;
           //Insertar en un log el error, archivo plano
        }
        
    }
    
    public LinkedList<ReportBreed> getBreedReport() throws SQLException{
        
        LinkedList<ReportBreed> listReport = new LinkedList<ReportBreed>();
        
        try{
            String query = "SELECT\n" +
                            "CASE \n" +
                            "	WHEN breed = 1 THEN 'Criollo' \n" +
                            "    WHEN breed = 2 THEN 'Labrador'\n" +
                            "    WHEN breed = 3 THEN 'Pincher'\n" +
                            "    WHEN breed = 4 THEN 'Beagle'\n" +
                            "    WHEN breed = 5 THEN 'Bulldog'\n" +
                            "    WHEN breed = 6 THEN 'Pitbull'\n" +
                            "    ELSE 'Otro'    \n" +
                            "END AS breed, \n" +
                            "COUNT(*) AS cantidad\n" +
                            "FROM dog\n" +
                            "GROUP BY breed";
            
            PreparedStatement statementReport = this.conexion.prepareStatement(query);
            
            ResultSet result = statementReport.executeQuery();
            
            while( result.next() ){
                
                ReportBreed tmpReport = new ReportBreed();
                
                tmpReport.setBreed( result.getString("breed") );
                tmpReport.setCount( result.getInt("cantidad"));
                
                listReport.add(tmpReport);                
            }
            
            return listReport;
            
        }catch(SQLException e){
           throw e;
           //Insertar en un log el error, archivo plano
        }
        
        
    }
    
    public LinkedList<ReportBreedPie> getDataBreed() throws SQLException{
        
        LinkedList<ReportBreedPie> listBreed = new LinkedList<ReportBreedPie>();
        
        try{
            
            String query = "SELECT\n" +
                            "CASE \n" +
                            "	WHEN breed = 1 THEN 'Criollo' \n" +
                            "    WHEN breed = 2 THEN 'Labrador'\n" +
                            "    WHEN breed = 3 THEN 'Pincher'\n" +
                            "    WHEN breed = 4 THEN 'Beagle'\n" +
                            "    WHEN breed = 5 THEN 'Bulldog'\n" +
                            "    WHEN breed = 6 THEN 'Pitbull'\n" +
                            "    ELSE 'Otro'    \n" +
                            "END AS breed, \n" +
                            "COUNT(*) AS count\n" +
                            "FROM dog\n" +
                            "GROUP BY breed";
            
            PreparedStatement statementBreed = this.conexion.prepareStatement(query);
            
            ResultSet result = statementBreed.executeQuery();
            
            while( result.next() ){
                
                ReportBreedPie temp = new ReportBreedPie();
                temp.setBreed( result.getString("breed") );
                temp.setCount( result.getInt("count") );
                
                listBreed.add(temp);
            }
            
            return listBreed;
            
        }catch(SQLException e){
            throw e;
        }
        
    }

}
