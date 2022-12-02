/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes.Reportes;

/**
 *
 * @author zambr
 */
public class ReportListadoProducto {
    
    private String nit;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private String nombre;
    private int valorUnitario;
    private int stock;

    public ReportListadoProducto(String nit, String razonSocial, String direccion, String telefono, String nombre, int valorUnitario, int stock) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.stock = stock;
    }
    
    public ReportListadoProducto(){
        
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
