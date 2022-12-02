/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Classes.Operacion;
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
public class TestCrearPerro {
    
    Operacion operacion;
    
    public TestCrearPerro() {
        operacion = new Operacion();
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Metodo inicio de clase");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Metodo final de clase");
    }
    
    @Before
    public void setUp() {
        System.out.println("Inicio de metodo");
    }
    
    @After
    public void tearDown() {
        System.out.println("Fin de metodo");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void PruebaSumarListaNumeros() {
        long[] listaNumeros = new long[]{1, 2, 3, 4, 5, 6};
        assertEquals(21, operacion.Sumar(listaNumeros));
    }

    @Test
    public void PruebaSumarNumeros() {
        long num1 = 3;
        long num2 = 5;
        assertEquals(8, operacion.Sumar(num1, num2));
    }
    
    @Test
    public void PruebaRestarNumeros(){
        long num1 = 3;
        long num2 = 5;
        assertEquals(-2, operacion.Restar(num1, num2));
    }
    
    @Test
    public void PruebaMultiplicarNumeros(){
        long num1 = 3;
        long num2 = 5;
        assertEquals(15, operacion.Multiplicar(num1, num2));
    }
    
    @Test
    public void PruebaMultiplicarListaNumeros(){
        long[] listaNumeros = new long[]{1, 2, 3, 4, 5, 6};
        assertEquals(720, operacion.Multiplicar(listaNumeros));
    }
    
    @Test
    public void PruebaDividirNumeros(){
        long num1 = 10;
        long num2 = 5;
        assertEquals(2, operacion.Dividir(num1, num2), 0.000000001);
    }
    
    @Test (expected = ArithmeticException.class)
    public void PruebaDividirNumerosException(){
        long num1 = 10;
        long num2 = 0;
        assertEquals(ArithmeticException.class, operacion.Dividir(num1, num2));
    }
    
}
