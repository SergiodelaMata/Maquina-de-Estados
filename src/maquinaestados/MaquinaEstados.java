/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaestados;

import java.util.List;

/**
 *
 * @author Sergio
 */
public class MaquinaEstados {
    Integer estadoActual;
    AFD automata;
    
    public MaquinaEstados()
    {
        this.estadoActual = 0;
        this.automata = new AFD();
        automata.cargarAlfabeto();
        automata.cargarCaracterExpresionRegular();
        automata.cargarEstados();
        automata.establecerQi(0);
        automata.establecerQf();
        automata.inicializarMatriz();
        automata.cargarMatriz();
    }
    
    /**Ajusta el estado actual de la máquina de estados al estado inicial cuando ésta inicia una comprobación de una cadena*/
    public void inicializar()
    {
        estadoActual = automata.getEstadoInicial();
    }
    
    /**Devuelve si un caracter es admitido por la expresión regular de acuerdo a su estado actual y si tiene un estado al que dirigirs
     * @param character
     * @return */
    public boolean aceptar(Character character)
    {
        boolean verificar;
        try
        { 
            Integer estadoTemp = automata.getSiguienteEstado(estadoActual, character); 
            if(estadoTemp != null)
            {
                estadoActual = estadoTemp;
                verificar = true;
            }
            else
            {
                throw new NullPointerException("No hay siguiente estado");
            }
        } 
        catch(NullPointerException e) 
        { 
            //System.out.println("Caracter no válido. Cadena no válida"); 
            verificar = false;
        } 
        return verificar;
    }
    
    /**Devuelve si un caracter es admitido por la expresión regular de acuerdo a su estado proporcionado y si tiene un estado al que dirigirs
     * @param character
     * @param estado
     * @return */
    public boolean aceptar(Character character, Integer estado)
    {
        boolean verificar;
        try
        { 
            Integer estadoTemp = automata.getSiguienteEstado(estado, character); 
            if(estadoTemp != null)
            {
                //estado = estadoTemp;
                verificar = true;
            }
            else
            {
                throw new NullPointerException("No hay siguiente estado");
            }
        } 
        catch(NullPointerException e) 
        { 
            //System.out.println("Caracter no válido. Cadena no válida"); 
            verificar = false;
        } 
        return verificar;
    }
    
    /**Devuelve si el estado en el que se encuentra es final o n
     * @return */
    public boolean isFinal()
    {
        return automata.isFinal(estadoActual);
    }
    
    /**Verifica si una cadena es válida por nuestra expresión regular o n
     * @param cadena
     * @return */
    public boolean compruebaCadena(String cadena)
    {
        boolean verificar;
        inicializar();
        try
        {
            for(int i=0; i < cadena.length(); i++)
            {
                if(!aceptar(cadena.charAt(i)))
                {
                    throw new Exception("Caracter no válido.");
                }
            }
            if(isFinal())
            {
                verificar = true;
            }
            else
            {
                verificar = false;
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return verificar;
    }
    
    /**Devuelve la lista de caracteres admitidos de nuestra expresión regular en nuestro alfabeto
     * @return  */
    public List<Character> getListaCaracteresAdmitidos()
    {
        
        return automata.getListaCaracteresAdmitidos();
    }
    
    /**Comprueba y muestra las cadenas que son válidas por nuestra expresión regular que tengan un número igual o menor que el proporcionado
     * en el contador y mayor o igual que 0
     * @param cadenaPrincipal
     * @param contador
     * @param listaCaracteresAceptados
     * @param estado*/
    public void comprobarCadena(String cadenaPrincipal, int contador, List<Character> listaCaracteresAceptados, Integer estado)
    {
        String cadenaSecundaria;
        boolean verificar;
        inicializar();
        for(int i=0; i<listaCaracteresAceptados.size();i++)
        {
            if(aceptar(listaCaracteresAceptados.get(i), estado))
            {
                cadenaSecundaria = cadenaPrincipal + listaCaracteresAceptados.get(i);
                if(contador > 0)
                {
                    comprobarCadena(cadenaSecundaria, contador - 1, listaCaracteresAceptados, automata.getSiguienteEstado(estado, listaCaracteresAceptados.get(i)));
                }
                else
                {
                    verificar = compruebaCadena(cadenaSecundaria);
                    if(verificar)
                    {
                        System.out.println(cadenaSecundaria);
                    }
                }
            }
        }
    }
    
    /**Comprueba y muestra las cadenas que son válidas por nuestra expresión regular que tengan un número igual o menor que el proporcionado
     * en el contador y mayor o igual que 0 y si es inferior o igual al límite proporcionado
     * @param cadenaPrincipal
     * @param contador
     * @param listaCaracteresAceptados
     * @param estado
     * @param maxNumCadenas
     * @param data*/
    public void comprobarCadena(String cadenaPrincipal, int contador, List<Character> listaCaracteresAceptados, Integer estado, Integer maxNumCadenas, Data data)
    {
        String cadenaSecundaria;
        boolean verificar;
        inicializar();
        int i = 0;
        while(i < listaCaracteresAceptados.size() && data.getNumCadenasRealizadas() < maxNumCadenas)
        {
            if(aceptar(listaCaracteresAceptados.get(i), estado))
            {
                cadenaSecundaria = cadenaPrincipal + listaCaracteresAceptados.get(i);
                if(contador > 0)
                {
                    comprobarCadena(cadenaSecundaria, contador - 1, listaCaracteresAceptados, automata.getSiguienteEstado(estado, listaCaracteresAceptados.get(i)), maxNumCadenas, data);
                }
                else
                {
                    verificar = compruebaCadena(cadenaSecundaria);
                    if(verificar && maxNumCadenas > data.getNumCadenasRealizadas())
                    {
                        System.out.println(cadenaSecundaria);
                        data.setNumCadenasRealizadas(data.getNumCadenasRealizadas() + 1);
                    }
                }
            }
            i++;
        }
    }
    
    /**Devuelve el estado inicial del AFD
     * @return */
    public Integer getEstadoInicial()
    {
        return automata.getEstadoInicial();
    }
    
    /**Devuelve el estado actual de la máquina de estado
     * @return */
    public Integer getEstadoActual()
    {
        return this.estadoActual;
    }
}
