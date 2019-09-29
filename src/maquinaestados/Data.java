/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquinaestados;

/**
 *
 * @author Sergio
 */
public class Data {
    private static Data instance;
    private Integer numCadenasRealizadas;

    /**Devuelve una instancia del Objeto Dat
     * @return */
    public static synchronized Data getInstance()
    {
        if(instance == null)
        {
            instance = new Data();
        }
        return instance;
    }
    
    public Data() {
        numCadenasRealizadas = 0;
    }

    /**Devuelve el número de cadenas realizadas/mostradas por pantalla hasta el moment
     * @return */
    public Integer getNumCadenasRealizadas() {
        return numCadenasRealizadas;
    }

    /**Ajusta el nuevo valor para el número de cadenas realizadas/mostradas por pantalla hasta el moment
     * @param counter*/
    public void setNumCadenasRealizadas(Integer counter) {
        this.numCadenasRealizadas = counter;
    }
    
    
}
