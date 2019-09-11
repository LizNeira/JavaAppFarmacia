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
public class CodigoCantMedicamento implements Serializable {

    private int codigoMedicamento;
    private int cant;

    public CodigoCantMedicamento(int codigoMedicamento, int cant) {
        this.codigoMedicamento = codigoMedicamento;
        this.cant = cant;
    }

    public int getCodigoMedicamento() {
        return codigoMedicamento;
    }

    public void setCodigoMedicamento(int codigoMedicamento) {
        this.codigoMedicamento = codigoMedicamento;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public String toString() {
        return  "codigoMedicamento=" + codigoMedicamento + ", cant=" + cant + '\n';
    }

    
    
    

}
