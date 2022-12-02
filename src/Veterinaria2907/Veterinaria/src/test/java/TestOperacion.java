/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Dog;
import Classes.Operacion;
import Model.modeloPerro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author zambr
 */
public class TestOperacion {
    
    Operacion op;
            
    public TestOperacion() {
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
        op = new Operacion();
        
        long resultSuma = op.Sumar(1, 2);
        assertEquals( 3, resultSuma );
    }
    
    @Test
    public void sumaLista() {
        op = new Operacion();
        
        long resultSuma = op.Sumar( new long[]{ 2, -2, 1, 3, -4 } );
        
        assertEquals( 0, resultSuma );
    }
    
    @Test
    public void sumaListaVacio() {
        op = new Operacion();
        
        long resultSuma = op.Sumar( new long[]{ } );
        
        assertEquals( 0, resultSuma );
    }
    
    @Test
    public void dividir() {
        op = new Operacion();
        
        double result = op.Dividir(12, 2 );
        
        assertEquals( 6.0, result, 0.000000001 );
    }
    
    @Test (expected = ArithmeticException.class)
    public void dividirExcepcion() {
        op = new Operacion();
        
        double result = op.Dividir(12, 0 );
        
        assertEquals( ArithmeticException.class, result);
    }
    
    @Test
    public void guardarPerro() {
        
        modeloPerro mPerro = new modeloPerro();
        
        Dog perro = new Dog();
        
        perro.setCode(1);
        perro.setColor("Gris");
        perro.setBornYear(2012);
        perro.setPedigree(true);
        perro.setBreed(2);
        perro.setHealthStatus(3);
        perro.setName("Negro");
        
        assertEquals( true, mPerro.crear(perro) );
        
    }
    
}
