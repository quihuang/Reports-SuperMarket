package Model;

import Classes.Direccion;
import Classes.Proveedor;
import Classes.Reportes.ReportListadoProducto;
import Classes.Reportes.ReporteProveedor;
import Model.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author quihu
 */
public class modeloProveedor {
    
    Database bd;
    Connection conexion;
    
    public modeloProveedor(){
        this.bd = new Database();
        this.conexion = bd.getConnection();
    }
    
    public int crear(Proveedor proveedor){
        
        try {
            String query = "INSERT INTO direccion (cll_cra, numero, barrio, ciudad) VALUES ( ?, ?, ?, ?)";
            PreparedStatement statementDireccion = this.conexion.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementDireccion.setString(1, proveedor.getDireccion().getCll_cra());
            statementDireccion.setString(2, proveedor.getDireccion().getNumero());
            statementDireccion.setString(3, proveedor.getDireccion().getBarrio());
            statementDireccion.setString(4, proveedor.getDireccion().getCiudad());
            
            int rowsInserted = statementDireccion.executeUpdate();
            
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statementDireccion.getGeneratedKeys();
                if (generatedKeys.next()) {
                    
                    int direccionId = generatedKeys.getInt(1);
                    
                    query = "INSERT INTO proveedor (nit, razon_social, telefono, correo_electronico, representante, sitio_web, direccion_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement statementProveedor = this.conexion.prepareStatement(query);                    
                    statementProveedor.setString(1, proveedor.getNit());
                    statementProveedor.setString(2, proveedor.getRazonSocial());
                    statementProveedor.setString(3, proveedor.getTelefono());
                    statementProveedor.setString(4, proveedor.getCorreoElectronico());
                    statementProveedor.setString(5, proveedor.getRepresentante());
                    statementProveedor.setString(6, proveedor.getSitioWeb());
                    statementProveedor.setInt(7, direccionId);
                    
                    int rowsInsertedProveedor = statementProveedor.executeUpdate();
                    
                    if (rowsInserted > 0 && rowsInsertedProveedor > 0){
                        return 3;
                    }
                    
                    
                                                            
                }
            }
            return 1;
        } catch (SQLException e) {
            return 2;
        }        
        
    }
    
    public Proveedor obtenerProveedor(String nit){
        
        try{
            String query = "select prov.nit, prov.razon_social, prov.telefono, prov.correo_electronico, prov.representante, prov.sitio_web, dic.cll_cra, dic.numero, dic.barrio, dic.ciudad from proveedor prov, direccion dic where prov.direccion_id = dic.id and nit = ?";
            PreparedStatement statementProveedor = this.conexion.prepareStatement(query);            
            statementProveedor.setString(1, nit);
            
            ResultSet result = statementProveedor.executeQuery();
            
            Proveedor proveedor = new Proveedor();
            Direccion direccion = new Direccion();
            
            while( result.next() ){
                
                proveedor.setNit(result.getString(1) );
                proveedor.setRazonSocial(result.getString(2) );
                proveedor.setTelefono(result.getString(3) );
                proveedor.setCorreoElectronico(result.getString(4) );
                proveedor.setRepresentante(result.getString(5) );
                proveedor.setSitioWeb(result.getString(6) );
                direccion.setCll_cra(result.getString(7) );
                direccion.setNumero(result.getString(8) );
                direccion.setBarrio(result.getString(9) );
                direccion.setCiudad(result.getString(10) );
                proveedor.setDireccion(direccion);
                
            }
            
            return proveedor;
            
        }catch(SQLException e){
            System.out.println("Ocurrio un error en el servidor: " + e.getMessage());
            System.out.println(e);
            return null;
        }
    }
    
     public int actualizar(Proveedor proveedor){
        try {
            String query = "UPDATE proveedor SET razon_social = ?, telefono = ?, correo_electronico = ?, representante = ?, sitio_web = ? where nit = ?";
            PreparedStatement statementProveedor = this.conexion.prepareStatement(query);
            statementProveedor.setString(1, proveedor.getRazonSocial());
            statementProveedor.setString(2, proveedor.getTelefono());
            statementProveedor.setString(3, proveedor.getCorreoElectronico());
            statementProveedor.setString(4, proveedor.getRepresentante());
            statementProveedor.setString(5, proveedor.getSitioWeb());
            statementProveedor.setString(6, proveedor.getNit());
            
            int rowsUpdatedProv = statementProveedor.executeUpdate();
            
            query = "select direccion_id from proveedor where nit = ?";
            PreparedStatement statementKeyDirection = this.conexion.prepareStatement(query);
            statementKeyDirection.setString(1, proveedor.getNit());
            
            ResultSet result = statementKeyDirection.executeQuery();
            
            int keyDiretion = 0;
            
            while (result.next()) {
               keyDiretion = result.getInt(1);
            }
            
            query = "UPDATE direccion SET cll_cra = ?, numero = ?, barrio = ?, ciudad = ? where id = ?";
            PreparedStatement statementDireccion = this.conexion.prepareStatement(query);
            statementDireccion.setString(1, proveedor.getDireccion().getCll_cra());
            statementDireccion.setString(2, proveedor.getDireccion().getNumero());
            statementDireccion.setString(3, proveedor.getDireccion().getBarrio());
            statementDireccion.setString(4, proveedor.getDireccion().getCiudad());
            statementDireccion.setInt(5, keyDiretion);
            
            
            int rowsUpdatedDir = statementDireccion.executeUpdate();
            
            if(rowsUpdatedProv > 0 && rowsUpdatedDir > 0){
                return 3;
            }else{
                return 1;
            }
            
            
        } catch (SQLException e) {
            return 2;
        }
    }
     
     
    public int elimnar(String nit) throws SQLException{
        try {
            
            String query = "select direccion_id from proveedor where nit = ?";
            PreparedStatement statementKeyDirection = this.conexion.prepareStatement(query);
            statementKeyDirection.setString(1, nit);
            
            ResultSet result = statementKeyDirection.executeQuery();
            
            int keyDiretion = 0;
            
            while (result.next()) {
               keyDiretion = result.getInt(1);
            }
            
            query = "DELETE FROM proveedor where nit = ?";
            PreparedStatement statementProveedor = this.conexion.prepareStatement(query);
            statementProveedor.setString(1,nit);
            
            int rowsUpdatedProv = statementProveedor.executeUpdate();
            
            query = "DELETE FROM direccion where id = ?";
            PreparedStatement statementDireccion = this.conexion.prepareStatement(query);
            statementDireccion.setInt(1, keyDiretion);
            
            int rowsUpdatedDir = statementDireccion.executeUpdate();
            
            
            if(rowsUpdatedProv > 0 && rowsUpdatedDir > 0){
                return 2;
            }else{
                return 1;
            }
           
            
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public LinkedList<ReporteProveedor> obtenerReporteProveedor() throws SQLException{
        
        LinkedList<ReporteProveedor> list = new LinkedList<ReporteProveedor>();
        
        try{
            
            String query = "SELECT razon_social, COUNT(producto.id) AS cantidad\n" +
                            "FROM proveedor INNER JOIN producto ON proveedor.nit = producto.id_proveedor\n" +
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
            
            String query = "SELECT nit, razon_social, concat(direccion.cll_cra,\" \",direccion.numero,\" \",direccion.barrio,\" \",direccion.ciudad) as direccion,telefono, nombre, valor_unitario, stock\n" +
                           "FROM proveedor INNER JOIN producto ON proveedor.nit = producto.id_proveedor\n" +
                           "INNER JOIN direccion ON proveedor.direccion_id = direccion.id\n" +
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
