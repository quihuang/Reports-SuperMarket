/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.HealthStatus;
import Model.modelHealthStatus;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class ctlHealthStatus {
 
    private modelHealthStatus modelHs;
    
    public ctlHealthStatus(){
        modelHs = new modelHealthStatus();
    }
    
    public LinkedList<HealthStatus> getAll(){        
        return modelHs.getAll();        
    }
    
}
