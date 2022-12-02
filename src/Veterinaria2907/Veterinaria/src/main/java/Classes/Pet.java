/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Interfaces.IAnimal;
import Interfaces.IVertebrate;

/**
 *
 * @author zambr
 */
public class Pet implements IAnimal, IVertebrate{
    
    //Atributos
    private int code;
    private String name;
    private int bornYear;
    private String color;
    private int healthStatus;
    private int numberOfBones;
    private String animalType;
    private String status;
            
    public Pet(){
        this.name = "";
        this.color = "";
        this.bornYear = 0;
        this.code = 0;
        this.healthStatus = 0;
    }
    
    public Pet(String nombre, String color, int code, int bornYear, int healthStatus){
        this.name = nombre;
        this.color = color;
        this.code = code;
        this.bornYear = bornYear;
        this.healthStatus = healthStatus;
    }
    
    public Pet(String name, int healthStatus){
        this.name = name;
        this.healthStatus = healthStatus;
    }
    
    public void Eat(){
        
    }
    
    public void Move(){
        
    }
    
    public String Sound(){
        return "Generico";
    }
      
    public String getFullPet(){
        return "Su mascota se llama: " + this.getName() 
                + ", el año de nacimiento es: " + this.getBornYear() 
                + ", el color es: " + this.getColor();
    }
    
    public String getFullPet(String name){
        return "Su mascota es: " + name;
    }
    
    public int getFullPet(int bornYear){
        return bornYear + 1;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(int healthStatus) {
        this.healthStatus = healthStatus;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getAnimalType() {
        return this.animalType;
    }
    
    public void setAnimalType(){
        this.animalType = "Generico";
    }

    @Override
    public int getNumberOfBones() {
        return this.numberOfBones;
    }
                  
}
