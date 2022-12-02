/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Classes.Proveedor;
import Classes.Reportes.ReportListadoProducto;
import Classes.Reportes.ReporteProveedor;
import Model.modeloProveedor;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author quihu
 */
public class CtrlProveedor {

    private modeloProveedor modeloProveedor;

    public CtrlProveedor() {
        modeloProveedor = new modeloProveedor();
    }

    public int registrarProveedor(Proveedor objectProveedor) {

        int result = modeloProveedor.crear(objectProveedor);

        return result;
    }

    public Proveedor buscarProveedor(String nit) {

        Proveedor result = modeloProveedor.obtenerProveedor(nit);

        if (result.getNit() == null) {
            return null;
        } else {
            return result;
        }
    }

    public int actualizar(Proveedor objectProveedor) {

        int result = modeloProveedor.actualizar(objectProveedor);

        return result;
    }

    public int eliminar(String nit) {
        try {
            int result = modeloProveedor.elimnar(nit);

            return result;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public LinkedList<ReporteProveedor> obtenerReporteProveedor() throws SQLException{
        
        try{
            return this.modeloProveedor.obtenerReporteProveedor();
        }catch(SQLException e){
            throw e;
        }
    }
    
    public LinkedList<ReportListadoProducto> obtenerReporteListadoProducto() throws SQLException{
        
        try{
            return this.modeloProveedor.obtenerReporteListadoProductos();
        }catch(SQLException e){
            throw e;
        }
        
    }
}
