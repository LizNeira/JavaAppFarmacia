
package farmaciaapp;


public interface InterfaceES {
    String leerCadena(String mensaje);

    void mostrarCadena(String mensaje);

    int leerDatoEntero(String mensaje);
    
    public float leerDatoFloat(String mensaje);
    
    //public long leerDatoLong(String mensaje);
    
    public char leerDatoChar(String mensaje);

    @Override
    public String toString();
    
}
