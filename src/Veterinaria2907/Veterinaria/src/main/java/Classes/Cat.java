/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author zambr
 */
public class Cat extends Pet {
    
    private String breed;
    
    public void SelfCleaning(){
        
    }
    
    public Cat(){
        
    }
    
    public Cat(String name){
        this.setName(name);
    }
    
    public Cat(String name, String color, int code, int bornYear, int healthStatus){        
        super(name, color, code, bornYear, healthStatus);
    }
    
    @Override
    public String Sound(){
        return "Miauuuuuuuu";
    }
    
    @Override
    public int getNumberOfBones(){
        return 230;
    }
    
    @Override
    public String getAnimalType(){
        return "Gato";
    }
    
}
