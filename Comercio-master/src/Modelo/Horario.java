/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Anita
 */
public class Horario {

    private final IntegerProperty idHorarios = new SimpleIntegerProperty();
    private final StringProperty horaEntrada = new SimpleStringProperty();
    private final StringProperty horaSalida = new SimpleStringProperty();
    private final StringProperty fechaInicio = new SimpleStringProperty();
    private final StringProperty fechaSalida = new SimpleStringProperty();

      public Horario(int idHorarios, String horaEntrada, String horaSalida, String fechaInicio, String fechaSalida) {
        this.idHorarios.setValue(idHorarios);
        this.horaEntrada.setValue(horaEntrada);
        this.horaSalida.setValue(horaSalida);
        this.fechaInicio.setValue(fechaInicio);
        this.fechaSalida.set(fechaSalida);
    }

    

   
    

    public String getFechaSalida() {
        return fechaSalida.get();
    }

    public void setFechaSalida(String value) {
        fechaSalida.set(value);
    }

    public StringProperty fechaSalidaProperty() {
        return fechaSalida;
    }
    

    public String getFechaInicio() {
        return fechaInicio.get();
    }

    public void setFechaInicio(String value) {
        fechaInicio.set(value);
    }

    public StringProperty fechaInicioProperty() {
        return fechaInicio;
    }
    
    

    public String getHoraSalida() {
        return horaSalida.get();
    }

    public void setHoraSalida(String value) {
        horaSalida.set(value);
    }

    public StringProperty horaSalidaProperty() {
        return horaSalida;
    }
    
    

    public String getHoraEntrada() {
        return horaEntrada.get();
    }

    public void setHoraEntrada(String value) {
        horaEntrada.set(value);
    }

    public StringProperty horaEntradaProperty() {
        return horaEntrada;
    }
    
    

    public int getIdHorarios() {
        return idHorarios.get();
    }

    public void setIdHorarios(int value) {
        idHorarios.set(value);
    }

    public IntegerProperty idHorariosProperty() {
        return idHorarios;
    }


 
    
    
    

  
   
 
   
    
    
    
}
