/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Dog;
import Classes.Pet;
import Model.modelCat;
import Model.modelDog;

/**
 *
 * @author zambr
 */
public class ctlPet {
    private modelDog modelDog;
    private modelCat modelCat;
    
    public ctlPet() {
        this.modelDog = new modelDog();
        this.modelCat = new modelCat();
    }
    
    public boolean CreatePet(Pet pet) {
        try {
            switch (pet.getAnimalType()) {
                case "Gato":
                    break;
                case "Perro":
                    this.modelDog.CreatePet((Dog)pet);
                    break;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean EditPet(Pet pet) {

        try {
            switch (pet.getAnimalType()) {
                case "Gato":

                    break;
                case "Perro":
                    this.modelDog.EditPet((Dog)pet);
                    break;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean DeletePet(Pet pet) {

        try {
            switch (pet.getAnimalType()) {
                case "Gato":

                    break;
                case "Perro":
                    this.modelDog.DeletePet((Dog)pet);
                    break;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public Pet SearchPet(String code, String type) {
        Pet pet = null;
        try {
            switch (type) {
                case "Gato":

                    break;
                case "Perro":
                    pet = this.modelDog.SearchPet(code);
                    break;
            }
            return pet;
        } catch (Exception e) {
            return null;
        }
    }
}
