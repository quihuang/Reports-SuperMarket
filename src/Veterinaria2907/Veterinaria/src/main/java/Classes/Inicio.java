/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Scanner;

/**
 *
 * @author zambr
 */
public class Inicio {
    
    public static void main(String[] args){
        
        Pet mascota = new Pet();
        
        mascota.setName("Sasha");
        mascota.setColor("Blanco, Cafe, Negro");
        mascota.setBornYear(2013);
        mascota.setCode(1);
        mascota.setHealthStatus(1);
        
        System.out.println( mascota.getFullPet() );
        
        Pet mascota5 = new Pet("Sasha","Blanco, Cafe, Negro",123,2013,1);
        
        System.out.println( mascota5.getFullPet() );
        
        Pet gato = new Pet();
        
        gato.setName("Michin");
        gato.setColor("Blanco");
        gato.setBornYear(2018);
        gato.setCode(2);
        gato.setHealthStatus(1);
        
        System.out.println( gato.getFullPet() );
        
        System.out.println("El nombre es: " + mascota.getName());
        System.out.println("El color es: " + mascota.getColor());
        
        Pet mascota2 = new Pet();
        
        System.out.println( mascota2.getFullPet() );
        
        Pet mascota3 = new Pet("Manchas","Amarillo, Negro", 123, 2022, 1);
        
        mascota3.setName("BocaNegra");
        System.out.println( mascota3.getFullPet() );
        
        Pet mascota4 = new Pet("Muñeca", 1);
        
        System.out.println( mascota4.getFullPet() );
        
        Cat michin = new Cat("Michin Pet");
        
        michin.setName("Michin");
        michin.setColor("Blanco");
        michin.setHealthStatus(1);
        michin.setBornYear(2022);
        
        System.out.println( michin.getFullPet() );
        
        Dog sasha = new Dog();
        
        sasha.setName("Sasha");
        sasha.setColor("Blanco con negro y cafe");
        sasha.setHealthStatus(2);
        sasha.setBornYear(2013);
        
        System.out.println( sasha.getFullPet() );
        
        Cat gatoNegro = new Cat("Gato negro","Blanco", 456, 2015, 1);
        
        System.out.println( gatoNegro.getFullPet() );
        System.out.println("El sonido del gato es: " + gatoNegro.Sound() );
        System.out.println( gatoNegro.getFullPet("Este nombre es por sobrecarga") );
        System.out.println( gatoNegro.getFullPet(2021) );
        
        //Ciclo completo
        Doctor doctor = new Doctor("Juan Zambrano", "Lic 123456");        
        Veterinary sedeCentro = new Veterinary("Medicina canina", "9876543", "Calle falsa 123", doctor);
        
        sedeCentro.setPet(gatoNegro);
        System.out.println( sedeCentro.getSoundPet() ) ;
        
        sedeCentro.setPet(sasha);
        System.out.println( sedeCentro.getSoundPet() ) ;
        
    }   
    
    /*
    public static void main(String[] args){
        
        //Captura de datos
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Digite el nombre de su mascota: ");
        String nombre = entrada.nextLine();
        
        System.out.println("Digite el año de nacimiento: ");
        int anio = entrada.nextInt();
        
        System.out.println("Digite el color: ");
        String color = entrada.nextLine();
        
        System.out.println("Digite el estado de salud: ");
        String estado = entrada.nextLine();
        
        //Gestion de objetos
        Pet mascota = new Pet();
        
        mascota.setName(nombre);
        mascota.setCode(1);
        mascota.setColor(color);
        mascota.setBornYear(anio);
        mascota.setHealthStatus(estado);
        
        //String nombreMascota = mascota.getName();        
        //System.out.println("Su mascota se llama: " + nombreMascota);
        
        System.out.println(mascota.getFullPet());
        
        //Clase heredada
        Cat michin = new Cat();
        
        michin.setName("Michin");
        michin.setBornYear(2021);
        michin.setColor("Blanco, Negro");
        michin.setHealthStatus("Delicado");
        michin.setCode(2);
        michin.setBreed("El gato no ha bebido agua");
        
        System.out.println(michin.getFullPet());
        System.out.println(michin.getBreed());
        
    }*/
}
