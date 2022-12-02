/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Dog;
import Classes.ReporteRaza;
import Classes.Reportes.ReportBreed;
import Classes.Reportes.ReportBreedPie;
import Model.modeloPerro;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class ctlPerro {
    
    private modeloPerro modeloPerro;
    
    public ctlPerro(){
        this.modeloPerro = new modeloPerro();
    }
    
    public boolean registrarPerro(Dog objectDog){
        
        //Validar que el objeto de tipo perro es correcto
        
        boolean result = modeloPerro.crear(objectDog);
        
        return result;
        
    }
    
    public int eliminarPerro(int codigo){
        
        //Validar si existe el dato
        try{            
            int result = modeloPerro.eliminar(codigo);                            
            return result;            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public LinkedList<Dog> buscarGeneral(){        
        return this.modeloPerro.getAll();
    }
    
    public Dog buscarPerroCodigo(int codigo){    
        
        //Validar antes de enviar al modelo
        
        Dog perro = modeloPerro.obtenerPerro(codigo);
        
        return perro;
        
    }
    
    public String actualizar(Dog dog){
        
        // Validar el objeto dog
        
        Dog result = this.buscarPerroCodigo(dog.getCode());

        if( result != null ){
            int resultModel = modeloPerro.actualizar(dog);
            if(resultModel == 3)
                return "";
            else
                return "Ocurrio un error al actualizar la mascota";
        }else{
            return "La mascota a actualizar no existe";
        }
    }
    
    public int eliminar(int codigo){
        
        try{
            return modeloPerro.eliminar(codigo);            
        }catch(SQLException e){
            return 0;
        }
        
    }
    
    public int eliminarLogico(int codigo){
        try{
            return this.modeloPerro.eliminarLogico(codigo);
        }catch(SQLException e){
            return 0;
        }        
    }
    
    public LinkedList<ReporteRaza> generarReporteRaza(){        
        return this.modeloPerro.reporteRazaMascota();
    }
    
    public LinkedList<Dog> obtenerListado() throws SQLException{
        
        try{
            LinkedList<Dog> result = this.modeloPerro.obtenerListadoPerros();            
            return result;
        }catch(SQLException e){
            throw e;
        }
        
    }
    
    public LinkedList<Dog> obtenerListadoException() throws SQLException{        
        LinkedList<Dog> result = this.modeloPerro.obtenerListadoPerros();            
        return result;        
    }
    
    public LinkedList<ReportBreedPie> getBreedReport() throws SQLException{
        
        try{
            LinkedList<ReportBreedPie> listBreed = this.modeloPerro.getDataBreed();
            return listBreed;
        }catch(SQLException e){
            throw e;
        }
        
    }
    
}
