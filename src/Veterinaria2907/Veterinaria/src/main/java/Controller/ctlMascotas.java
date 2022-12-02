/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Dog;
import Model.modeloPerro;

/**
 *
 * @author zambr
 */
public class ctlMascotas {
    
    private modeloPerro modeloPerro;
    
    public ctlMascotas(){
        modeloPerro = new modeloPerro();
    }
    
    public boolean registroPerro(Dog dog){
        
        //Proceso validación
        
        //Inserto
        return modeloPerro.crear(dog);
        
    }
       
    
}
