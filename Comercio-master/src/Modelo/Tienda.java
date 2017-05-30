/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.BDA;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Anita
 */
public class Tienda {

    BDA bdd;
    private final IntegerProperty idTienda = new SimpleIntegerProperty();

    private final StringProperty pueblo = new SimpleStringProperty();
    private final StringProperty direccion = new SimpleStringProperty();
    private final StringProperty telefono = new SimpleStringProperty();
    private final StringProperty codPostal = new SimpleStringProperty();

    public Tienda(int idTienda, String pueblo, String direccion, String telefono, String codPostal) {
        this.idTienda.setValue(idTienda);
        this.pueblo.setValue(pueblo);
        this.direccion.setValue(direccion);
        this.telefono.setValue(telefono);
        this.codPostal.setValue(codPostal);
    }

    public int getIdTienda() {
        return idTienda.get();
    }

    public void setIdTienda(int value) {
        idTienda.set(value);
    }

    public IntegerProperty idTiendaProperty() {
        return idTienda;
    }

    public String getCodPostal() {
        return codPostal.get();
    }

    public void setCodPostal(String value) {
        codPostal.set(value);
    }

    public StringProperty codPostalProperty() {
        return codPostal;
    }

    public String getTelefono() {
        return telefono.get();
    }

    public void setTelefono(String value) {
        telefono.set(value);
    }

    public StringProperty telefonoProperty() {
        return telefono;
    }

    public String getDireccion() {
        return direccion.get();
    }

    public void setDireccion(String value) {
        direccion.set(value);
    }

    public StringProperty direccionProperty() {
        return direccion;
    }

    public String getPueblo() {
        return pueblo.get();
    }

    public void setPueblo(String value) {
        pueblo.set(value);
    }

    public StringProperty puebloProperty() {
        return pueblo;
    }

}
