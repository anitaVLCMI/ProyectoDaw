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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Borja
 */
public class Trabajador {

    private final IntegerProperty idTrabajador= new SimpleIntegerProperty();
    private final StringProperty nombre = new SimpleStringProperty();
    private final StringProperty puesto = new SimpleStringProperty();
    private final StringProperty dniNie = new SimpleStringProperty();
    private final DoubleProperty salario = new SimpleDoubleProperty();
    private final StringProperty contraseña = new SimpleStringProperty();
    private final IntegerProperty idHorario = new SimpleIntegerProperty();
    private final IntegerProperty idTienda = new SimpleIntegerProperty();
    
    public Trabajador(String dniNie, String contraseña) {
        this.dniNie.setValue(dniNie);
        this.contraseña.setValue(contraseña);
    }

    public Trabajador(int idTrabajador, String nombre, String puesto, String dniNie, Double salario, String contraseña, int idTienda, int idHorario) {
        this.idTrabajador.setValue(idTrabajador);
        this.nombre.setValue(nombre);
        this.puesto.setValue(puesto);
        this.dniNie.setValue(dniNie);
        this.salario.setValue(salario);
        this.contraseña.setValue(contraseña);
        this.idTienda.setValue(idTienda);
        this.idHorario.setValue(idHorario);
    }
    
    public Trabajador(int idTrabajador, String nombre, String puesto, String dniNie, Double salario, String contraseña) {
        this.idTrabajador.setValue(idTrabajador);
        this.nombre.setValue(nombre);
        this.puesto.setValue(puesto);
        this.dniNie.setValue(dniNie);
        this.salario.setValue(salario);
        this.contraseña.setValue(contraseña);
    }
    
    public Trabajador(int idTrabajador, String nombre, String puesto, Double salario, String contraseña) {
        this.idTrabajador.setValue(idTrabajador);
        this.nombre.setValue(nombre);
        this.puesto.setValue(puesto);
        this.salario.setValue(salario);
        this.contraseña.setValue(contraseña);
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
    

    public int getIdHorario() {
        return idHorario.get();
    }

    public void setIdHorario(int value) {
        idHorario.set(value);
    }

    public IntegerProperty idHorarioProperty() {
        return idHorario;
    }

    public String getContraseña() {
        return contraseña.get();
    }

    public void setContraseña(String value) {
        contraseña.set(value);
    }

    public StringProperty contraseñaProperty() {
        return contraseña;
    }
    

    public double getSalario() {
        return salario.get();
    }

    public void setSalario(double value) {
        salario.set(value);
    }

    public DoubleProperty salarioProperty() {
        return salario;
    }
    

    public String getDNI() {
        return dniNie.get();
    }

    public void setDNI(String value) {
        dniNie.set(value);
    }

    public StringProperty DNIProperty() {
        return dniNie;
    }
    

    public String getPuesto() {
        return puesto.get();
    }

    public void setPuesto(String value) {
        puesto.set(value);
    }

    public StringProperty puestoProperty() {
        return puesto;
    }
    

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String value) {
        nombre.set(value);
    }

    public StringProperty nombreProperty() {
        return nombre;
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

    @Override
    public String toString() {
        return " "+ getIdTrabajador()+" "+ this.getNombre()+ " "+ this.getPuesto()+ " "+this.getContraseña()+"\n";
    }
    
            
}
