/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Datos.BDA;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author daw
 */
public class Incidencias {

    BDA bdd;

    private final IntegerProperty idIncidencias = new SimpleIntegerProperty();

    private final IntegerProperty idTrabajador = new SimpleIntegerProperty();
    private final StringProperty descripcion = new SimpleStringProperty();
    private final IntegerProperty idTienda = new SimpleIntegerProperty();
    private final StringProperty fecha = new SimpleStringProperty();

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String value) {
        fecha.set(value);
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public Incidencias(int idIncidencias, String descripcion, int idTrabajador, int idTienda, String fecha) {
        this.idIncidencias.setValue(idIncidencias);
        this.descripcion.setValue(descripcion);
        this.idTrabajador.setValue(idTrabajador);
        this.idTienda.setValue(idTienda);
        this.fecha.set(fecha);
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

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String value) {
        descripcion.set(value);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    public int getIdTrabajador() {
        return idTrabajador.get();
    }

    public void setIdTrabajador(int value) {
        idTrabajador.set(value);
    }

    public IntegerProperty idTrabajadorProperty() {
        return idTrabajador;
    }

    public int getIdIncidencias() {
        return idIncidencias.get();
    }

    private void setIdIncidencias(int value) {
        idIncidencias.set(value);
    }

    private IntegerProperty idIncidenciasProperty() {
        return idIncidencias;
    }

    
}
