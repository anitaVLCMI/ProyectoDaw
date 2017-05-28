/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Anita
 */
public class Horario {

    private final StringProperty horaEntrada = new SimpleStringProperty();

    public String getHoraEntrada() {
        return horaEntrada.get();
    }

    public void setHoraEntrada(String value) {
        horaEntrada.set(value);
    }

    public StringProperty horaEntradaProperty() {
        return horaEntrada;
    }
   
 
   
    
    
    
}
