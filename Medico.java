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
public class Medico implements Serializable{
    private String nomMedico;
private int nroRegistro;
private String especialidad;

    public Medico(String nomMedico, int nroRegistro, String especialidad) {
        this.nomMedico = nomMedico;
        this.nroRegistro = nroRegistro;
        this.especialidad = especialidad;
    }

    public String getNomMedico() {
        return nomMedico;
    }

    public void setNomMedico(String nomMedico) {
        this.nomMedico = nomMedico;
    }

    public int getNroRegistro() {
        return nroRegistro;
    }

    public void setNroRegistro(int nroRegistro) {
        this.nroRegistro = nroRegistro;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Medico{" + "nomMedico=" + nomMedico + ", nroRegistro=" + nroRegistro + ", especialidad=" + especialidad + '}';
    }



}
























































