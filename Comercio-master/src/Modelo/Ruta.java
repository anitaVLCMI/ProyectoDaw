/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Borja
 */
public class Ruta {

    private final IntegerProperty idRuta = new SimpleIntegerProperty();
    private final DoubleProperty kilometro = new SimpleDoubleProperty();
    private final IntegerProperty minuto = new SimpleIntegerProperty();
    private final DoubleProperty gasto = new SimpleDoubleProperty();

    public Ruta(int id, double kilometros, int minutos, double gastos) {
        this.idRuta.setValue(id);
        this.kilometro.setValue(kilometros);
        this.minuto.setValue(minutos);
        this.gasto.setValue(gastos);
    }

    public Ruta(int id) {
       this.idRuta.setValue(id); 
    }
    

    public double getGastos() {
        return gasto.get();
    }

    public void setGastos(double value) {
        gasto.set(value);
    }

    public DoubleProperty gastosProperty() {
        return gasto;
    }

    public int getMinutos() {
        return minuto.get();
    }

    public void setMinutos(int value) {
        minuto.set(value);
    }

    public IntegerProperty minutosProperty() {
        return minuto;
    }

    public double getKilometros() {
        return kilometro.get();
    }

    public void setKilometros(double value) {
        kilometro.set(value);
    }

    public DoubleProperty kilometrosProperty() {
        return kilometro;
    }

    public int getId() {
        return idRuta.get();
    }

    public void setId(int value) {
        idRuta.set(value);
    }

    public IntegerProperty idProperty() {
        return idRuta;
    }

}
