/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Model.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 *
 * @author zambr
 */

public class Main{

    //Inicio del programa
    public static void main(String[] args){
        
        //Conexión a base de datos
        Database db = new Database();        
        Connection cn = db.getConnection();
        
        if ( cn != null ){
            System.out.println("Se conecto a la base de datos");
        }else{
            System.out.println("No se pudo conectar a la bd");
        }
        
        Operacion op = new Operacion();
        
        long resultSuma = op.Sumar(1, 2);
        long[] listaNumeros = new long[]{2, 4, 5};   
        long resultSumaLista = op.Sumar( listaNumeros );
        double division = 0;
        
        try{
            division = op.Dividir(12, 2);    
        }catch(ArithmeticException e){
            System.out.println("Ocurrio una excepción. " + e.getMessage());
        }
        
        System.out.println("La suma es: " + resultSuma);
        System.out.println("La lista de suma es: " + resultSumaLista);
        System.out.println("La division es: " + division);
        
        /*
        //Captura de datos
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite el nombre de su mascota: ");
        String nombre = entrada.nextLine();
        
        int anioNacimiento = 0;
        boolean validacionAnioNacimiento = false;
        while( validacionAnioNacimiento == false){
            try{
                System.out.println("Digite el año de nacimiento de su mascota: ");
                anioNacimiento = Integer.parseInt(entrada.nextLine());
                validacionAnioNacimiento = true;
            }catch(Exception e){
                System.out.println("Debe digitar solo numeros enteros");
            }
        }
                
        System.out.println("Digite el color de su mascota: ");
        String color = entrada.nextLine();
        
        System.out.println("Digite el estado de salud de su mascota: ");
        String estado = entrada.nextLine();
        
        System.out.println("Digite el codigo interno de su mascota: ");
        int codigo = entrada.nextInt();
        
       
        /*
        mascota1.setName("Pelusa");
        
        System.out.println("El nombre de la mascota 1 es: " + mascota1.getName());
        System.out.println("El nombre de la mascota 2 es: " + mascota2.getName());
        System.out.println("El nombre de la mascota 3 es: " + mascota3.getName());
        System.out.println("El nombre de la mascota 4 es: " + mascota4.getName());
        */
    }
    
}


