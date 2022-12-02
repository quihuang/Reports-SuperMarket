/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author quihu
 */
public class Direccion {
   
    private String cll_cra;
    private String numero;
    private String barrio;
    private String ciudad;
    
    public Direccion(){
        
    }

    public Direccion(String cll_cra, String numero, String barrio, String ciudad) {
        this.cll_cra = cll_cra;
        this.numero = numero;
        this.barrio = barrio;
        this.ciudad = ciudad;
    }

    public String getCll_cra() {
        return cll_cra;
    }

    public void setCll_cra(String cll_cra) {
        this.cll_cra = cll_cra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
