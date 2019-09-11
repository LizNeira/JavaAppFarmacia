/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciaapp;

import java.io.Serializable;
import java.util.ArrayList;


public class Receta implements Serializable{
    
 private int nroReceta;
 private int nroRegMedico;
 private ArrayList<CodigoCantMedicamento> vccm ;
 private String nomPaciente;

    public Receta(int nroReceta, int nroRegMedico,String nomPaciente) {
        this.nroReceta = nroReceta;
        this.nroRegMedico = nroRegMedico;
        this.nomPaciente = nomPaciente;
        vccm = new ArrayList<CodigoCantMedicamento>();
    }

    public Receta() {
         vccm = new ArrayList<CodigoCantMedicamento>();
    }

    public int getNroReceta() {
        return nroReceta;
    }

    public void setNroReceta(int nroReceta) {
        this.nroReceta = nroReceta;
    }

    public int getNroRegMedico() {
        return nroRegMedico;
    }

    public void setNroRegMedico(int nroRegMedico) {
        this.nroRegMedico = nroRegMedico;
    }

    public ArrayList<CodigoCantMedicamento> getVccm() {
        return vccm;
    }

    public void setVccm(ArrayList<CodigoCantMedicamento> vccm) {
        this.vccm = vccm;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    @Override
    public String toString() {
        return "Receta{" + "nroReceta=" + nroReceta + ", nroRegMedico=" + nroRegMedico + ", vccm=" + vccm.toString() + ", nomPaciente=" + nomPaciente + '}';
    }

 
}
