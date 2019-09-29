/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaestados;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Sergio
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        MaquinaEstados maquinaEstados = new MaquinaEstados();
        List<Character> listaCaracteresAdmitidos = maquinaEstados.getListaCaracteresAdmitidos();
        String cadenaPrincipal = "";
        String cadena;
        boolean result;
        Data data = Data.getInstance();
        
        System.out.println("Introduzca número de cadenas a comprobar:");
        cadena = scanner.nextLine(); 
        try
        {
            int contador = Integer.parseInt(cadena);
            for(int i=0; i< contador; i++)
            {
                System.out.println("Introduzca una cadena:"); 
                cadena = scanner.nextLine();  
                result = maquinaEstados.compruebaCadena(cadena);
                if(result)
                {
                    System.out.println("Cadena válida.");
                }
                else
                {
                    System.out.println("Cadena inválida.");
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("La cadena introducida no es un número.");
        }
        System.out.println("Se desea limitar el número de cadenas a imprimir (Introduzca Si o No):");
        cadena = scanner.nextLine();
        try
        {
            System.out.println("Introduzca el máximo número de caracteres admitidos:");
            int maxCaracteres = Integer.parseInt(scanner.nextLine());
            if(cadena.equals("Si") || cadena.equals("si") || cadena.equals("SI")|| cadena.equals("sI"))
            {
                System.out.println("Introduzca el número máximo de cadenas a imprimir:");
                int maxNumCadenas = Integer.parseInt(scanner.nextLine());
                if(maxCaracteres > 0 && maxNumCadenas > 0)
                {
                    for(int i=0; i< maxCaracteres; i++)
                    {
                        maquinaEstados.comprobarCadena(cadenaPrincipal, i, listaCaracteresAdmitidos, maquinaEstados.getEstadoInicial(), maxNumCadenas, data);
                    }
                }
                else
                {
                    throw new Exception("Número negativo o 0.");
                }
            }
            else if(cadena.equals("No") || cadena.equals("no") || cadena.equals("NO") || cadena.equals("nO"))
            {
                for(int i=0; i< maxCaracteres; i++)
                {
                    maquinaEstados.comprobarCadena(cadenaPrincipal, i, listaCaracteresAdmitidos, maquinaEstados.getEstadoInicial());
                }
            }
            else
            {
                throw new Exception("Cadena distinta de sí o no.");
            }
        }
        catch(Exception e)
        {
            System.out.println("Alguna de las cadenas introducidas no es válida.");
        }
    }
}
