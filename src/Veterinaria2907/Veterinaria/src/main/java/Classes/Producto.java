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
public class Producto {
    
    private int id;
    private String nombre;
    private int valorUnitario;
    private int stock;
    private int idProveedor;

    public Producto(int id, String nombre, int valorUnitario, int stock, int idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.valorUnitario = valorUnitario;
        this.stock = stock;
        this.idProveedor = idProveedor;
    }
    
    public Producto(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }    
    
}
