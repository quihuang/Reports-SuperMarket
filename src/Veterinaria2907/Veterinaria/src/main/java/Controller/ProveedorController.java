/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.Reportes.ReportListadoProducto;
import Classes.Reportes.ReporteProveedor;
import Model.ProveedorModel;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author zambr
 */
public class ProveedorController {
    
    ProveedorModel model;
    
    public ProveedorController(){
        model = new ProveedorModel();
    }
    
    public LinkedList<ReporteProveedor> obtenerReporteProveedor() throws SQLException{
        
        try{
            return this.model.obtenerReporteProveedor();
        }catch(SQLException e){
            throw e;
        }
        
    }
    
    public LinkedList<ReportListadoProducto> obtenerReporteListadoProducto() throws SQLException{
        
        try{
            return this.model.obtenerReporteListadoProductos();
        }catch(SQLException e){
            throw e;
        }
        
    }
    
}
