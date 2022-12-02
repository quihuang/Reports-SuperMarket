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
public class Dog extends Pet {
    
    private int id;
    private int breed;
    private boolean pedigree;
    
    public Dog(){
        
    }
    
    public Dog(int id, int breed, boolean pedigree, int code, String name, int bornYear, String color, int healthStatus){        
        super(name, color, code, bornYear, healthStatus);
        this.id = id;
        this.breed = breed;
        this.pedigree = pedigree;
    }
    
    public void WalkAround(){
        
    }
    
    @Override
    public String Sound(){
        return "Woof Woof";
    }

    public int getBreed() {
        return breed;
    }

    public void setBreed(int breed) {
        this.breed = breed;
    }

    public boolean getPedigree() {
        return pedigree;
    }

    public void setPedigree(boolean pedigree) {
        this.pedigree = pedigree;
    }
    
    @Override
    public int getNumberOfBones(){
        return 321;
    }
    
    @Override
    public String getAnimalType(){
        return "Perro";
    }
    
}
