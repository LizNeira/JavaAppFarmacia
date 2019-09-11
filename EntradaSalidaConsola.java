
package farmaciaapp;
 import java.util.Scanner;

public class EntradaSalidaConsola implements InterfaceES{
    
    private Scanner a = new Scanner( System.in);
    
    
    @Override
    public String leerCadena(String mensaje){
        System.out.println(mensaje);
        return a.nextLine();
    }
    @Override
    public void mostrarCadena(String mensaje){
        System.out.println(mensaje);
    }
    @Override
    public int leerDatoEntero(String mensaje){
        System.out.println(mensaje);
        return a.nextInt();
    }    

    @Override
    public float leerDatoFloat(String mensaje) {
        System.out.println(mensaje);
        return a.nextFloat();
        
    }
    @Override
    public char leerDatoChar(String mensaje){
        return leerCadena(mensaje).charAt(0);
    }
}
