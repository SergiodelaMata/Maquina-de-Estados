/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaestados;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class AFD {
    List <Character> alfabeto;
    List <Character> caracteresExpresionRegular;
    List <Integer> listaEstados;
    Integer estadoInicial;
    List <Integer> listaEstadosFinales;
    HashMap <Integer, HashMap<Character, Integer>> matriz;

    
    public AFD()
    {
        this.alfabeto = new ArrayList<>();
        this.caracteresExpresionRegular = new ArrayList<>();
        this.listaEstados = new ArrayList<>();
        this.estadoInicial = 0;
        this.listaEstadosFinales = new ArrayList<>();
        this.matriz = new HashMap<>();
    }
    
    /**Carga los caracteres que admitirá nuestro alfabeto*/
    public void cargarAlfabeto()
    {
        alfabeto.add('a'); //Ejemplo PL1
        alfabeto.add('b'); //Ejemplo PL1
        alfabeto.add('c'); //Ejemplo PL1
        alfabeto.add('d'); //Ejemplo PL1
        alfabeto.add('e'); //Ejemplo PL1
        alfabeto.add('f'); //Ejemplo PL1
        alfabeto.add('g'); //Ejemplo PL1
        alfabeto.add('h'); //Ejemplo PL1
        alfabeto.add('i'); //Ejemplo PL1
        alfabeto.add('j'); //Ejemplo PL1
        alfabeto.add('k'); //Ejemplo PL1
        alfabeto.add('l'); //Ejemplo PL1
        alfabeto.add('m'); //Ejemplo PL1
        alfabeto.add('n'); //Ejemplo PL1
        alfabeto.add('ñ'); //Ejemplo PL1
        alfabeto.add('o'); //Ejemplo PL1
        alfabeto.add('p'); //Ejemplo PL1
        alfabeto.add('q'); //Ejemplo PL1
        alfabeto.add('r'); //Ejemplo PL1
        alfabeto.add('s'); //Ejemplo PL1
        alfabeto.add('t'); //Ejemplo PL1
        alfabeto.add('u'); //Ejemplo PL1
        alfabeto.add('v'); //Ejemplo PL1
        alfabeto.add('w'); //Ejemplo PL1
        alfabeto.add('x'); //Ejemplo PL1
        alfabeto.add('y'); //Ejemplo PL1
        alfabeto.add('z'); //Ejemplo PL1
        
    }
    
    /**Carga los caracteres que admitirá nuestra expresión regular*/
    public void cargarCaracterExpresionRegular()
    {
        caracteresExpresionRegular.add('a'); //Ejemplo PL1
        caracteresExpresionRegular.add('b'); //Ejemplo PL1
        caracteresExpresionRegular.add('c'); //Ejemplo PL1
        caracteresExpresionRegular.add('m'); //Ejemplo PL1
        caracteresExpresionRegular.add('n'); //Ejemplo PL1
        caracteresExpresionRegular.add('o'); //Ejemplo PL1
        caracteresExpresionRegular.add('p'); //Ejemplo PL1
        caracteresExpresionRegular.add('q'); //Ejemplo PL1
    }
    
    /**Carga todos los estados que dispondrá la matriz*/
    public void cargarEstados()
    {
        for(int i= 0; i<=16; i++)
        {
            listaEstados.add(i);
        }
    }
    
    /**Carga el estado inicial de nuestra matriz del AF
     * @param posicionInicial*/
    public void establecerQi(int posicionInicial)
    {
        this.estadoInicial = posicionInicial;
    }
    
    /**Carga todos los estados finales de la matriz del AFD*/
    public void establecerQf()
    {
        listaEstadosFinales.add(4); // Ejemplo PL1
        listaEstadosFinales.add(5); // Ejemplo PL1
        listaEstadosFinales.add(6); // Ejemplo PL1
        listaEstadosFinales.add(7); // Ejemplo PL1
        listaEstadosFinales.add(8); // Ejemplo PL1
        listaEstadosFinales.add(11); // Ejemplo PL1
        listaEstadosFinales.add(12); // Ejemplo PL1
        listaEstadosFinales.add(13); // Ejemplo PL1
        listaEstadosFinales.add(14); // Ejemplo PL1
        listaEstadosFinales.add(15); // Ejemplo PL1
        
    }
    
    /**Inicializa la matriz del AFD*/
    public void inicializarMatriz()
    {
        for(int i=0; i< listaEstados.size(); i++)
        {
            matriz.put(listaEstados.get(i), new HashMap<>());
        }
    }
    
    /**Carga la matriz del AFD rellenando para cada estado, a que estados pasaría junto con el caracter que lo haría posible*/
    public void cargarMatriz()
    {
        matriz.get(0).put('a', 1); //Ejemplo PL1
        matriz.get(1).put('a', 3); //Ejemplo PL1
        matriz.get(1).put('b', 2); //Ejemplo PL1
        matriz.get(2).put('c', 9); //Ejemplo PL1
        matriz.get(2).put('m', 5); //Ejemplo PL1
        matriz.get(2).put('n', 7); //Ejemplo PL1
        matriz.get(2).put('o', 8); //Ejemplo PL1
        matriz.get(2).put('p', 4); //Ejemplo PL1
        matriz.get(2).put('q', 6); //Ejemplo PL1
        matriz.get(3).put('a', 3); //Ejemplo PL1
        matriz.get(3).put('b', 2); //Ejemplo PL1
        matriz.get(4).put('b', 10); //Ejemplo PL1
        matriz.get(5).put('b', 10); //Ejemplo PL1
        matriz.get(6).put('b', 10); //Ejemplo PL1
        matriz.get(7).put('b', 10); //Ejemplo PL1
        matriz.get(8).put('b', 10); //Ejemplo PL1
        matriz.get(9).put('c', 9); //Ejemplo PL1
        matriz.get(9).put('m', 5); //Ejemplo PL1
        matriz.get(9).put('n', 7); //Ejemplo PL1
        matriz.get(9).put('o', 8); //Ejemplo PL1
        matriz.get(9).put('p', 4); //Ejemplo PL1
        matriz.get(9).put('q', 6); //Ejemplo PL1
        matriz.get(10).put('c', 16); //Ejemplo PL1
        matriz.get(10).put('m', 12); //Ejemplo PL1
        matriz.get(10).put('n', 14); //Ejemplo PL1
        matriz.get(10).put('o', 15); //Ejemplo PL1
        matriz.get(10).put('p', 11); //Ejemplo PL1
        matriz.get(10).put('q', 13); //Ejemplo PL1
        matriz.get(11).put('b', 10); //Ejemplo PL1
        matriz.get(12).put('b', 10); //Ejemplo PL1
        matriz.get(13).put('b', 10); //Ejemplo PL1
        matriz.get(14).put('b', 10); //Ejemplo PL1
        matriz.get(15).put('b', 10); //Ejemplo PL1
        matriz.get(16).put('c', 16); //Ejemplo PL1
        matriz.get(16).put('m', 12); //Ejemplo PL1
        matriz.get(16).put('n', 14); //Ejemplo PL1
        matriz.get(16).put('o', 15); //Ejemplo PL1
        matriz.get(16).put('p', 11); //Ejemplo PL1
        matriz.get(16).put('q', 13); //Ejemplo PL1
        
        
    }
    
    /**Devuelve el siguiente estado de un caracter de acuerdo con el estado proporcionad
     * @param estado
     * @param character
     * @return */
    public Integer getSiguienteEstado(Integer estado, Character character)
    {
        return matriz.get(estado).get(character);
    }
    
    /**Carga los caracteres que admitirá nuestro alfabet
     * @param estado
     * @return*/
    public boolean isFinal(Integer estado)
    {
        return listaEstadosFinales.contains(estado);
    }
    
    /**Devuelve el estado inicial de la matriz del AF
     * @return*/
    public Integer getEstadoInicial()
    {
        return estadoInicial;
    }
    
    /**Comprueba si una caracter se encuentra dentro del alfabet
     * @param character
     * @return */
    public boolean isLetter(Character character)
    {
        boolean verificar = false;
        int contador = 0;
        while(contador != alfabeto.size()-1 && !verificar)
        {
            if(character.equals(alfabeto.get(contador)))
            {
                verificar = true;
            }
            contador++;
        }
        return alfabeto.contains(character);
    }
    
    /**Devuelve una lista de los caracteres que admite la expresión regular del alfabeto del AF
     * @return*/
    public List<Character> getListaCaracteresAdmitidos()
    {
        List<Character> listaCaracteres = new ArrayList<>();
        for(int i=0; i<alfabeto.size();i++)
        {
           if(isLetter(alfabeto.get(i)))
           {
               listaCaracteres.add(alfabeto.get(i));
           }
        }
        
        return listaCaracteres;
    }
}
