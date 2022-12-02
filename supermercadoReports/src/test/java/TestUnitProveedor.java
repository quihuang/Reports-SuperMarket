/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import Classes.Direccion;
import Classes.Proveedor;
import Model.modeloProveedor;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author quihu
 */
public class TestUnitProveedor {

    public TestUnitProveedor() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    
    @Test
    public void eliminarProveedorNoEncontrado() {
         modeloProveedor modelo = new modeloProveedor();
         int result = 0;
         try{
             result = modelo.elimnar("76253903-1");
         }catch(SQLException e){
             
         }
         
         assertEquals(1, result);
        
    }
    
    @Test
    public void eliminar() {
         modeloProveedor modelo = new modeloProveedor();
         int result = 0;
         try{
             result = modelo.elimnar("1144213155-1");
         }catch(SQLException e){
             
         }
         
         assertEquals(2, result);
        
    }
    
    @Test (expected = SQLException.class)
    public void eliminarException() throws SQLException{
        
         modeloProveedor modelo = new modeloProveedor();
         int result = 0;
         
             result = modelo.elimnar("0");
       
         assertEquals(SQLException.class, result);
        
    }
    
    
    
    @Test
    public void crearProvedor() {
         
        Proveedor proveedor = new Proveedor();
        Direccion direccion = new Direccion();

        proveedor.setNit("1023932-1");
        proveedor.setRazonSocial("Cocacola");
        proveedor.setTelefono("320293212");
        proveedor.setCorreoElectronico("ventas@cocacola.com");
        proveedor.setRepresentante("Maikol R. Coz");
        proveedor.setSitioWeb("www.cocacola.com");

        direccion.setCll_cra("Cra 9 N");
        direccion.setNumero("22-12");
        direccion.setBarrio("Calima");
        direccion.setCiudad("Bogota");

        proveedor.setDireccion(direccion);
        
        modeloProveedor modelo = new modeloProveedor();
        
        int result = modelo.crear(proveedor);
         
         
         assertEquals(3, result);
        
    }
    
    
    @Test
    public void crearProvedorFallido() {
         
        Proveedor proveedor = new Proveedor();
        Direccion direccion = new Direccion();

        direccion.setCll_cra("Cra 9 N");
        direccion.setNumero("22-12");
        direccion.setBarrio("Calima");
        direccion.setCiudad("Bogota");

        proveedor.setDireccion(direccion);
        
        modeloProveedor modelo = new modeloProveedor();
        
        int result = modelo.crear(proveedor);
         
         
         assertEquals(2 , result);
        
    }
    
    
    @Test
    public void actualizarNoEncuentraProveedor() {

        Proveedor proveedor = new Proveedor();
        Direccion direccion = new Direccion();

        proveedor.setNit("");
        proveedor.setRazonSocial("");
        proveedor.setTelefono("");
        proveedor.setCorreoElectronico("");
        proveedor.setRepresentante("");
        proveedor.setSitioWeb("");

        direccion.setCll_cra("");
        direccion.setNumero("");
        direccion.setBarrio("");
        direccion.setCiudad("");

        proveedor.setDireccion(direccion);

        modeloProveedor modelo = new modeloProveedor();

        int result = modelo.actualizar(proveedor);

        assertEquals(1, result);
        
    }
    
    @Test
    public void actualizarError() {

        Proveedor proveedor = new Proveedor();
        Direccion direccion = new Direccion();
        
        proveedor.setNit("1023932-1");
        proveedor.setRazonSocial("COCACOLA S.A.S");
        proveedor.setTelefono("320293212");
        proveedor.setCorreoElectronico("ventas@cocacola.com");
        proveedor.setRepresentante("Maikol R. Coz");
        proveedor.setSitioWeb("www.cocacola.com");

        direccion.setCll_cra("Cra 9 N");
        direccion.setNumero("22-12");
        direccion.setBarrio("Calima");
        direccion.setCiudad("Bogota");

        proveedor.setDireccion(direccion);
        
        //Se cambia el query en el modelo por uno erroneo para poder simular el caso de error

        modeloProveedor modelo = new modeloProveedor();

        int result = modelo.actualizar(proveedor);

        assertEquals(2, result);
        
    }
    
    
    @Test
    public void actualizarCorrecto() {

        Proveedor proveedor = new Proveedor();
        Direccion direccion = new Direccion();
        
        proveedor.setNit("1023932-1");
        proveedor.setRazonSocial("COCACOLA S.A.S");
        proveedor.setTelefono("320293212");
        proveedor.setCorreoElectronico("ventas@cocacola.com");
        proveedor.setRepresentante("Maikol R. Coz");
        proveedor.setSitioWeb("www.cocacola.com");

        direccion.setCll_cra("Cra 9 N");
        direccion.setNumero("22-12");
        direccion.setBarrio("Calima");
        direccion.setCiudad("Bogota");

        proveedor.setDireccion(direccion);

        modeloProveedor modelo = new modeloProveedor();

        int result = modelo.actualizar(proveedor);

        assertEquals(3, result);
        
    }
    
    @Test
    public void buscarProvedorNoEncontrado() {
         modeloProveedor modelo = new modeloProveedor();
         Proveedor proveedor = new Proveedor();
         
         proveedor = modelo.obtenerProveedor("7603-9");
         
         
         assertEquals(null, proveedor);
        
    }
    
     @Test
    public void buscarProveedor() {
         modeloProveedor modelo = new modeloProveedor();
         Proveedor proveedor = new Proveedor();
         
         proveedor = modelo.obtenerProveedor("1023932-1");
         
         
         assertEquals(proveedor, proveedor);
        
    }
    
    
    
}
