/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Dog;
import Classes.Operacion;
import Controller.ctlPerro;
import Model.Database;
import Model.modeloPerro;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author zambr
 */
@RunWith(MockitoJUnitRunner.class)
public class TestOperacion2 {
    
    Operacion op = new Operacion();
    
    @InjectMocks
    ctlPerro perroController;
    
    @Mock
    modeloPerro mp;
    
    public TestOperacion2() {
        perroController = new ctlPerro();
        mp = new modeloPerro();
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
    public void suma() {
        
        long resultadoSuma = op.Sumar(-1, -5);
        assertEquals( -6, resultadoSuma );    
    }
    
    @Test
    public void sumaLista() {
        
        long[] listaNumeros = new long[]{2, 4, 5};   
        long resultSumaLista = op.Sumar( listaNumeros );
        
        assertEquals( 11, resultSumaLista );    
    }
    
    @Test
    public void dividir(){
        
        double resultDividir = op.Dividir(12, 2);
        assertEquals( 6, resultDividir, 0.000000001);        
    }
    
    @Test (expected = ArithmeticException.class)
    public void dividirCero(){
        
        double resultDividir = op.Dividir(12, 0);
        assertEquals( ArithmeticException.class , resultDividir);        
    }
    
    @Test
    public void conexionBD(){
        Database db = new Database();
        Connection con = db.getConnection();
        
        assertNotEquals( null , con);        
    }
    
    @Test
    public void actualizarNoExiste(){
        
        Dog perro = new Dog();
        
        modeloPerro mp = new modeloPerro();
        
        int result = mp.actualizar(perro);
        
        assertEquals( 1, result );
    }
    
    @Test
    public void actualizarVacio(){
        
        Dog perro = new Dog();
        
        modeloPerro mp = new modeloPerro();
        
        int result = mp.actualizar(perro);
        
        assertEquals( 1, result);
        
    }
        
    @Test
    public void actualizarOK(){
        
        Dog perro = new Dog();
        
        perro.setCode( 25 );
        perro.setName( "Muñeca" );
        perro.setBornYear( 2012 );
        perro.setColor( "Blanco" );
        perro.setHealthStatus( 4 );
        perro.setBreed( 3 );
        perro.setPedigree( true );
        
        modeloPerro mp = new modeloPerro();
        
        int result = mp.actualizar(perro);
        
        assertEquals( 3, result );
        
    }
    
    @Test
    public void actualizarError(){
        
        Dog perro = new Dog();
        
        perro.setCode( 25 );
        perro.setName( "Muñeca modificado" );
        perro.setBornYear( 2018 );
        perro.setColor( "Caramelo" );
        perro.setHealthStatus( 4 );
        perro.setBreed( 3 );
        perro.setPedigree( true );
        
        modeloPerro mp = new modeloPerro();
        
        int result = mp.actualizar(perro);
        
        assertEquals( 2, result );
        
    }
    
    @Test
    public void eliminarOK(){
        
        modeloPerro mp = new modeloPerro();
        int result = 0;
        try{
            result = mp.eliminarLogico(32);
        }catch(SQLException e){
            
        }
        
        assertEquals(2, result);                
    }
    
    @Test
    public void eliminarNoExiste(){
        
        modeloPerro mp = new modeloPerro();
        int result = 0;
        try{
            result = mp.eliminarLogico(100);
        }catch(SQLException e){
            
        }
        
        assertEquals(1, result);                
    }
    
    @Test (expected = SQLException.class)
    public void eliminarExcepcion() throws SQLException{
        
        modeloPerro mp = new modeloPerro();
        
        assertEquals(SQLException.class, mp.eliminarLogico(23));                
    }
    
    @Test
    public void mockEliminar() throws SQLException{
        
        Mockito.when( this.mp.eliminarLogico(100)).thenReturn(1);
        
        assertEquals( 1, this.perroController.eliminarLogico(100));
        
    }
    
}
