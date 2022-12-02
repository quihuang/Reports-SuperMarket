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
public class Doctor { 
    
    private String name;
    private String licence;
    
    public Doctor(String name, String licence){
        this.name = name;
        this.licence = licence;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getLicence(){
        return this.licence;
    }
    
}
