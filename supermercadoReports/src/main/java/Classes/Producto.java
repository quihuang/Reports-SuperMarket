/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author quihu
 */
public class Producto {
    
    private int id;
    private String nombre;
    private int valorUnitario;
    private int stock;
    private String idProveedor;

    public Producto(int id, String nombre, int valorUnitario, int stock, String idProveedor) {
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

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }    
    
}