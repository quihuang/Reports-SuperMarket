/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Proveedor;
import Classes.Reportes.ReportListadoProducto;
import Classes.Reportes.ReporteProveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class ProveedorModel {
    
    Database db;
    Connection conexion;
    
    public ProveedorModel(){
        db = new Database();
        conexion = db.getConnection();
    }
    
    public LinkedList<Proveedor> obtenerListado() throws SQLException{
        LinkedList<Proveedor> list = new LinkedList<Proveedor>();
        
        try{
            
            String query = " SELECT id, nit, razon_social, direccion, telefono FROM proveedor";
            PreparedStatement statement = this.conexion.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                
                Proveedor temp = new Proveedor();
                temp.setId( result.getInt("id") );
                temp.setNit( result.getString("nit") );
                temp.setRazonSocial( result.getString("razon_social"));
                temp.setDireccion( result.getString("direccion"));
                temp.setTelefono( result.getString("telefono"));
                
                list.add(temp);
                
            }
            
            return list;
            
        }catch(SQLException e){
            throw e;
        }
    }
    
    public LinkedList<ReporteProveedor> obtenerReporteProveedor() throws SQLException{
        
        LinkedList<ReporteProveedor> list = new LinkedList<ReporteProveedor>();
        
        try{
            
            String query = "SELECT razon_social, COUNT(producto.id) AS cantidad\n" +
                            "FROM proveedor INNER JOIN producto ON proveedor.id = producto.id_proveedor\n" +
                            "GROUP BY razon_social";
            PreparedStatement statement = this.conexion.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                
                ReporteProveedor temp = new ReporteProveedor();
                temp.setRazonSocial( result.getString("razon_social"));
                temp.setCantidad( result.getInt("cantidad") );
                
                list.add(temp);
                
            }
            
            return list;
            
        }catch(SQLException e){
            throw e;
        }
        
    }
    
    public LinkedList<ReportListadoProducto> obtenerReporteListadoProductos() throws SQLException{
        
        LinkedList<ReportListadoProducto> list = new LinkedList<ReportListadoProducto>();
        
        try{
            
            String query = "SELECT nit, razon_social, direccion, telefono, nombre, valor_unitario, stock\n" +
                            "FROM proveedor INNER JOIN producto ON proveedor.id = producto.id_proveedor\n" +
                            "WHERE stock > 30";
            PreparedStatement statement = this.conexion.prepareStatement(query);
            
            ResultSet result = statement.executeQuery();
            
            while( result.next() ){
                
                ReportListadoProducto temp = new ReportListadoProducto();
                temp.setNit( result.getString("nit") );
                temp.setRazonSocial( result.getString("razon_social"));
                temp.setDireccion( result.getString("direccion"));
                temp.setTelefono( result.getString("telefono"));
                temp.setNombre( result.getString("nombre"));
                temp.setValorUnitario( result.getInt("valor_unitario"));
                temp.setStock( result.getInt("stock"));
                
                list.add(temp);
                
            }
            
            return list;
            
        }catch(SQLException e){
            throw e;
        }
        
    }
    
}
