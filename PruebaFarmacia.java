/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciaapp;

        
/**
 *2
 * @author Liz
 */
public class PruebaFarmacia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    InterfaceES modo = new EntradaSalidaVentana();
  
        char resp = modo.leerDatoChar("Ingrese modo de visualización: ((v)ventana/(c)consola) ");
        if(resp=='c'){
            modo = new EntradaSalidaConsola();
        }
        
        
       Farmacia ABC = new Farmacia(modo);
        ABC.menu();
        
    }
    
}
