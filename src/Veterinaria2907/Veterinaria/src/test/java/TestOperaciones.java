/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Dog;
import Classes.Operaciones;
import Controller.ctlPerro;
import Model.modeloPerro;
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
public class TestOperaciones {
    
    Operaciones operacion;
    
    @InjectMocks
    ctlPerro perroController;

    @Mock
    modeloPerro modeloPerro;
    
    public TestOperaciones() {
        perroController = new ctlPerro();
        operacion = new Operaciones();        
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
    public void TestSumaBasica() {        
        assertEquals( 2, operacion.sumar(1, 1) );        
    }
    
    @Test
    public void TestSumaLista() {
        assertEquals( 15, operacion.sumarLista( new int[]{1, 2, 3, 4, 5} ) );        
    }
    
    @Test
    public void TestSumaListaVacio() {
        assertEquals( 0, operacion.sumarLista( new int[]{} ) );        
    }
    
    @Test
    public void TestSumaListaConSigno() {
        assertEquals( 5, operacion.sumarLista( new int[]{-1, 2, 3, -4, 5} ) );        
    }
    
    @Test (expected = ArithmeticException.class)
    public void TestDivisionCero(){
        assertEquals( ArithmeticException.class ,operacion.dividir(1, 0) );
    }
    
    @Test
    public void TestConsultarPerro(){
        
        //Objeto fantasma, mock, simulando que retorna de la BD
        Dog perro = new Dog();
        
        perro.setCode( 123 );
        perro.setName("Sasha");
        perro.setBornYear(2012);
        perro.setColor("Negro");
        perro.setPedigree(true);
        perro.setBreed(4);
        perro.setHealthStatus(1);
        
        Mockito.when(this.modeloPerro.obtenerPerro(123)).thenReturn( perro );
        assertEquals("Sasha", this.perroController.buscarPerroCodigo(456).getName());
    }
    
}
