/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Borja
 */
public class Ruta {
    private Integer id;
    private  Double kilometros;
    private   Integer trabajador;
    private  Integer minutos;
    private Double gastos;

    public Ruta(Integer id, Double kilometros, Integer trabajador, Integer minutos, Double gastos) {
        this.id = id;
        this.kilometros = kilometros;
        this.trabajador = trabajador;
        this.minutos = minutos;
        this.gastos = gastos;
    }
    

    public Integer getId() {
        return id;
    }

    public Double getKilometros() {
        return kilometros;
    }

    public Integer getTrabajador() {
        return trabajador;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public Double getGastos() {
        return gastos;
    }
    
    
}
