/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author zambr
 */
public class Operaciones {
    
    public int sumar(int num1, int num2){
        return num1 + num2;
    }
    
    public int sumarLista( int[] numeros){
        int resultado = 0;
        for( int numero :numeros ){
            resultado = resultado + numero;
        }        
        return resultado;
    }
    
    public double dividir(long num1, long num2){
        try{
            return num1 / num2;
        }catch(ArithmeticException e){
            throw e;
        }
    }
}
