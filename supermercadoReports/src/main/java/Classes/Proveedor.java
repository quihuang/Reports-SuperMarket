/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Classes;

import java.util.LinkedList;

/**
 *
 * @author quihu
 */
public class Proveedor{
    
    private String nit;
    private String razonSocial;
    private String telefono;
    private String correoElectronico;
    private String representante;
    private String sitioWeb;
    private Direccion direccion;
    private LinkedList<Producto> listaProducto = new LinkedList<Producto>();
    
    public Proveedor(){
    }
    
    public Proveedor(String nit, String razonSocial, String telefono, String correoElectronico, String representante, String sitioWeb, Direccion direccion, String cll_cra, String numero, String barrio, String ciudad) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.representante = representante;
        this.sitioWeb = sitioWeb;
        this.direccion = direccion;
    }

    public Proveedor(String nit, String razonSocial, String telefono, String correoElectronico, String representante, String sitioWeb, Direccion direccion) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.representante = representante;
        this.sitioWeb = sitioWeb;
        this.direccion = direccion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public LinkedList<Producto> getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(LinkedList<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }
    
    public void setAdicionaarProductoLista(Producto producto){
        this.listaProducto.add(producto);
    }

}