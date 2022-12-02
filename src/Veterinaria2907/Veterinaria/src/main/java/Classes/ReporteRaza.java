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
public class ReporteRaza {
    private int cantidad;
    private String raza;

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public ReporteRaza(int cantidad, String raza) {
        this.cantidad = cantidad;
        this.raza = raza;
    }
    
    public ReporteRaza() {
     
    }
    
}
