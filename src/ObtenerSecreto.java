
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivan
 */
public class ObtenerSecreto {
    static Scanner lee = new Scanner(System.in);
    public static void main(final String[] args) {
        BigInteger secreto;
        int partes,soluciones,tmp;
        String primo,parcial;
        BigInteger bigPrimo;
        ArrayList arrPart = new ArrayList();
        
        System.out.print("Introduzca el numero primo secreto: ");  
        primo = lee.next();
        bigPrimo = new BigInteger(primo);
        while(bigPrimo.isProbablePrime(50)==false){
            System.out.print("El numero Introducido no es un numero primo correcto\nIntroduzca el numero primo secreto: ");
            primo = lee.next();
            bigPrimo = new BigInteger(primo);
        }
        System.out.print("\n");
        System.out.print("Introduzca el numero total de partes en las que se dividio el secreto: ");
        partes = lee.nextInt();
        System.out.print("\n");
        System.out.print("Intrduzca el numero de soluciones minimas para obtener el secreto: ");
        soluciones = lee.nextInt();
        System.out.print("\n");
        System.out.println("Le vamos a pedir: "+soluciones+" soluciones de las "+partes+" partes del secreto");
       
        for(int i=0;i<soluciones;i++){
            tmp = i+1;
            System.out.print("Solucion "+tmp+" : ");
            parcial = lee.next();
            arrPart.add(parcial);
        }
        
        Shamir shamir = new Shamir(soluciones,partes);
        secreto = shamir.unirPartes(arrPart, bigPrimo);
        
        System.out.println("El secreto es: "+secreto);
        
        
    }
    
}
