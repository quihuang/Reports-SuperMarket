/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class Proveedor {
    
    private int id;
    private String nit;
    private String razonSocial;
    private String direccion;
    private String telefono;
    private LinkedList<Producto> listaProducto = new LinkedList<Producto>();

    public Proveedor(int id, String nit, String razonSocial, String direccion, String telefono) {
        this.id = id;
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public LinkedList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(LinkedList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public void setAdicionarProductoLista(Producto producto){
        this.listaProducto.add(producto);
    }
    
    public Proveedor(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
}
