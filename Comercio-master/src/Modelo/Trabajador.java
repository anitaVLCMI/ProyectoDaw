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

    private final IntegerProperty idTrabajador= new SimpleIntegerProperty();;
    private final StringProperty nombre = new SimpleStringProperty();;
    private final StringProperty puesto = new SimpleStringProperty();;
    private final StringProperty DNI = new SimpleStringProperty();;
    private final DoubleProperty salario = new SimpleDoubleProperty();;
    private final StringProperty contraseña = new SimpleStringProperty();;

//    public Trabajador(int idTrabajador, String nombre, String puesto, String DNI, Double salario, String contraseña) {
//        this.idTrabajador.setValue(idTrabajador);
//        this.nombre.setValue(nombre);
//        this.puesto.setValue(puesto);
//        this.DNI.setValue(DNI);
//        this.salario.setValue(salario);
//        this.contraseña.setValue(contraseña);
//    }

    public Trabajador(int idTrabajador, String contraseña) {
        this.idTrabajador.setValue(idTrabajador);
        this.contraseña.setValue(contraseña);
    }

    public Trabajador(int idTrabajador, String nombre, String puesto, String dni, Double salario, String contraseña) {
        this.idTrabajador.setValue(idTrabajador);
        this.nombre.setValue(nombre);
        this.puesto.setValue(puesto);
        this.DNI.setValue(dni);
        this.salario.setValue(salario);
        this.contraseña.setValue(contraseña);
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
        return DNI.get();
    }

    public void setDNI(String value) {
        DNI.set(value);
    }

    public StringProperty DNIProperty() {
        return DNI;
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
        return "Trabajador{" + "id=" + this.idTrabajador + ", contra=" + this.contraseña + '}';
    }
    
    
            
}
