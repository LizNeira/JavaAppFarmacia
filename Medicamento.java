/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciaapp;

import java.io.Serializable;

/**
 *
 * @author Liz
 */
public class Medicamento implements Serializable{

    private int codigo;
    private String nombre;
    private String laboratorio;
    private String paisOrigen;
    private int stock;

    public Medicamento(int codigo, String nombre, String laboratorio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.laboratorio = laboratorio;
        this.stock = stock;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }
    

    @Override
    public String toString() {
        return "Medicamento{" + "codigo=" + codigo + ", nombre=" + nombre + ", laboratorio=" + laboratorio + ", stock=" + stock + '}';
    }
    
    
    
    
}
