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
public class Veterinary {
    
    private String name;
    private String phone;
    private String address;
    private Pet pet;
    private Doctor doctor;
    
    public void petCare(){
        
    }
    
    public Veterinary(Doctor doctor){
        this.doctor = doctor;
    }
    
    public Veterinary(String name, String phone, String address, Doctor doctor){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.doctor = doctor;
    }
    
    public void setPet(Pet pet){
        this.pet = pet;
    }
    
    public Pet getPet(){
        return this.pet;
    }
    
    public String getSoundPet(){
        return "El sonido de " + pet.getName() + " es " + pet.Sound();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
