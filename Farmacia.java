/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmaciaapp;

import java.io.Serializable;
import java.util.ArrayList;

public class Farmacia {

    private ArrayList<Medicamento> conjMedicamentos;
    private ArrayList<Receta> conjRecetas;
    private ArrayList<Medico> conjMedicos;
    private InterfaceES modo;
    private CrearArchSecuencialSerializable crearArchArrayList;
    private LeerArchSecuencialSerializable leerArchArrayList;

    public Farmacia(InterfaceES m) {    // constructor
        modo = m;
        conjMedicamentos = new ArrayList<Medicamento>();
        conjRecetas = new ArrayList<Receta>();
        conjMedicos = new ArrayList<Medico>();

        char resp = modo.leerDatoChar("Está creado el archivo de Recetas ?(s/n): ");
        if (resp == 's') {
            leerArchArrayList = new LeerArchSecuencialSerializable("Recetas.ser");
            leerArchArrayList.abrirArchivo();
            conjRecetas = (ArrayList<Receta>) leerArchArrayList.leerArrayList();
            leerArchArrayList.cerrarArchivo();
           
        } 

        resp = modo.leerDatoChar("Está creado el archivo Medicamentos ?(s/n): ");
        if (resp == 's') {
            leerArchArrayList = new LeerArchSecuencialSerializable("Medicamentos.ser");
            leerArchArrayList.abrirArchivo();
            conjMedicamentos = (ArrayList<Medicamento>) leerArchArrayList.leerArrayList();
            leerArchArrayList.cerrarArchivo();
            modo.mostrarCadena(conjMedicamentos.toString());

        } else {
            leerMedicamentoDesdeTeclado();
        }

        resp = modo.leerDatoChar("Esta creado el archivos Medicos? (s/n)");

        if (resp == 's') {
            leerArchArrayList = new LeerArchSecuencialSerializable("Medicos.ser");
            leerArchArrayList.abrirArchivo();
            conjMedicos = (ArrayList<Medico>) leerArchArrayList.leerArrayList();
            leerArchArrayList.cerrarArchivo();
            modo.mostrarCadena(conjMedicos.toString());
        } else {
            leerMedicoDesdeTeclado();
        }

    }

    public void leerMedicamentoDesdeTeclado() {

        char resp = 's';
        while (resp == 's') {
            Medicamento m = new Medicamento(modo.leerDatoEntero("Ingrese codigo de medicamento: "),
                    leerMedicamento(),
                    leerLaboratorio(),
                    modo.leerDatoEntero("Ingrese el stock de medicamentos: "));
            // cargando 

            conjMedicamentos.add(m);

            resp = modo.leerDatoChar("Desea seguir ingresando medicamentos ?(s/n): ");
        }
        grabarArrayListMedicamentos();
        modo.mostrarCadena(conjMedicamentos.toString());
    }

    public void leerMedicoDesdeTeclado() {

        char resp = 's';

        while (resp == 's') {
            Medico m = new Medico(modo.leerCadena("Ingrese nombre del medico: "),
                    modo.leerDatoEntero("ingrese el numero de registro"),
                    leerEspecialidad());

            // cargando 
            conjMedicos.add(m);

            resp = modo.leerDatoChar("Desea seguir ingresando medicos ?(s/n): ");
        }
        grabarArrayListMedicos();
        modo.mostrarCadena(conjMedicos.toString());
    }

    public void menu() {
        

        String menuOpciones = "Ingrese una opción: \n"
                + "1- Efectuar una receta\n"
                + "2- Buscar Recetas por pediatra\n"
                + "3- Nombre del Paciente y Medico que receto Amoxidal\n"
                + "4- Listado medicamentos\n"
                + "5- Mostrar todos los datos\n"
                + "6- Dar de baja una receta\n"
                + "7- Salir\n";
        int opcion = modo.leerDatoEntero(menuOpciones);
        while (opcion > 0 && opcion < 7) {
            switch (opcion) {
                case 1:
                    leerRecetaDesdeTeclado();
                    break;
                case 2:
                    buscarRecetasPorPediatra();
                    break;
                case 3:
                    buscarRecetaConAmoxidal();

                    break;
                case 4:
                    modo.mostrarCadena(conjMedicamentos.toString());
                    break;
                case 5:
                    modo.mostrarCadena(conjMedicamentos.toString());
                    modo.mostrarCadena(conjMedicos.toString());
                    modo.mostrarCadena(conjRecetas.toString());
                    break;
                case 6:
                    darDeBajaUnaReceta();

                    break;
                case 7:
                    recetasConMedicamentosDelExterior();
                    break;


            }
            opcion = modo.leerDatoEntero(menuOpciones);
        }
    }

    //
    public String leerEspecialidad() {
        String s = "Ingrese especialidad: "
                + "\n 1-Pediatra"
                + "\n 2-Clinico"
                + "\n 3-Traumatologo";

        int esp = modo.leerDatoEntero(s);
        while (esp > 3 && esp < 0) {
            esp = modo.leerDatoEntero("Codigo erroneo\n" + s);
        }
        switch (esp) {
            case 1:
                return "Pediatra";
            case 2:
                return "Clinico";
            case 3:
                return "Traumatologo";
            default:
                return s;
        }
    }

    public String leerMedicamento() {
        String s = "Ingrese medicamento: "
                + "\n 1-Amoxidal"
                + "\n 2-Omeprazol"
                + "\n 3-Ramipril";

        int med = modo.leerDatoEntero(s);
        while (med > 3 && med < 0) {
            med = modo.leerDatoEntero("Codigo erroneo\n" + s);
        }
        switch (med) {
            case 1:
                return "Amoxidal";
            case 2:
                return "Omeprazol";
            case 3:
                return "Ramipril";
            default:
                return s;
        }
    }

    public String leerLaboratorio() {
        String s = "Ingrese Laboratorio: "
                + "\n 1-Bayer"
                + "\n 2-Bagó"
                + "\n 3-Roche";

        int lab = modo.leerDatoEntero(s);
        while (lab > 3 && lab < 0) {
            lab = modo.leerDatoEntero("Codigo erroneo\n" + s);
        }
        switch (lab) {
            case 1:
                return "Bayer";
            case 2:
                return "Bagó";
            case 3:
                return "Roche";
            default:
                return s;
        }
    }

    //
    public void leerRecetaDesdeTeclado() {
        int sigReceta = conjRecetas.isEmpty() ? 1 : (conjRecetas.get(conjRecetas.size() - 1)).getNroReceta() + 1;
        char resp = 's';
        Medicamento m;
        int cant, stock;
        int codMedicamento;
        Medico medico;
        Receta rec = new Receta();
        rec.setNroReceta(sigReceta);
        int nroRegMedico = modo.leerDatoEntero("Numero registro del medico\n");
        medico = buscarMedico(nroRegMedico);
        while (medico == null) {
            nroRegMedico = modo.leerDatoEntero(conjMedicos.toString() + "\nNumero registro del medico incorrecto\n Ingrese nuevamente");
            medico = buscarMedico(nroRegMedico);
        }

        rec.setNroRegMedico(nroRegMedico);
        rec.setNomPaciente(modo.leerCadena("Nombre del paciente\n"));
        while (resp == 's') {
            codMedicamento = modo.leerDatoEntero("Ingrese codigo de medicamento a recetar\n");
            m = buscarMedicamentoPorCodigo(codMedicamento);

            if (m == null) {
                modo.mostrarCadena("Medicamento inexistente");
            } else {
                cant = modo.leerDatoEntero("Ingrese la cantidad del medicamento");
                if (cant > (stock = m.getStock())) {
                    modo.mostrarCadena("La cantidad ingresada supera el stock de " + stock);
                } else {
                    rec.getVccm().add(new CodigoCantMedicamento(codMedicamento, cant));
                    m.setStock(stock - cant);
                }
            }
            resp = modo.leerDatoChar("Desea seguir ingresando Medicamentos a la receta[s/n] ?");
        }
        if (!rec.getVccm().isEmpty()) {
            conjRecetas.add(rec);
            grabarArrayListRecetas();
            grabarArrayListMedicamentos();
        }

        modo.mostrarCadena(conjRecetas.toString());
    }
    //

    public void buscarRecetasPorPediatra() {

        int i = 0;
        String s = " ";
        Medico medico;

        while (i < conjRecetas.size()) {
            medico = buscarMedico(conjRecetas.get(i).getNroRegMedico());
            if (medico != null) {

                if (medico.getEspecialidad().equalsIgnoreCase("Pediatra")) {
                    s += "Pediatra" + medico.getNomMedico() + conjRecetas.get(i).getVccm() + "\n";
                }
            }
            i++;
            modo.mostrarCadena(s);
        }//

    }

    public Medicamento buscarMedicamentoPorCodigo(int cod) {
        int i = 0;

        while (i < conjMedicamentos.size() && conjMedicamentos.get(i).getCodigo() != cod) {

            i++;
        }
        if (i >= conjMedicamentos.size()) {
            return null;
        } else {
            return conjMedicamentos.get(i);
        }
    }

    public int buscarCodMedicamentoPorNombre(String nomMedicamento) {
        int i = 0;

        while (i < conjMedicamentos.size() && !conjMedicamentos.get(i).getNombre().equalsIgnoreCase(nomMedicamento)) {

            i++;
        }
        if (i >= conjMedicamentos.size()) {
            return -1;
        } else {
            return conjMedicamentos.get(i).getCodigo();
        }
    
    }



    public Medico buscarMedico(int numReg) {
        int i = 0;

        while (i < conjMedicos.size() && conjMedicos.get(i).getNroRegistro() != numReg) {

            i++;
        }
        if (i >= conjMedicos.size()) {
            return null;
        } else {
            return conjMedicos.get(i);
        }
    }

    public Medicamento buscarMedicamento(int cod) { 
        int i = 0;
        while (i < conjMedicamentos.size() && conjMedicamentos.get(i).getCodigo() != cod) {
            i++;
        }
        if (i >= conjMedicamentos.size()) {
            return null;
        } else {
            return conjMedicamentos.get(i);
        }
    }

    private void buscarRecetaConAmoxidal() {
        int i = 0;
        String s = "\n Medicos y Pacientes recetados con Amoxidal: ";
        int codAmoxidal = buscarCodMedicamentoPorNombre("Amoxidal");

        while (i < conjRecetas.size()) {

            if (encuentroAmoxidal(conjRecetas.get(i).getVccm(), codAmoxidal)) {
                s += "Paciente: " + conjRecetas.get(i).getNomPaciente() + " Medico: " + (buscarMedico(conjRecetas.get(i).getNroRegMedico())).getNomMedico() + "\n";
            }
            i++;
        }
        modo.mostrarCadena(s);
    }

    private boolean encuentroAmoxidal(ArrayList<CodigoCantMedicamento> vccm, int codMedicamento) {
        int i = 0;

        while (i < vccm.size() && vccm.get(i).getCodigoMedicamento() != codMedicamento) {
            i++;
        }
        return i < vccm.size();
    }
    
    public void recetasConMedicamentosDelExterior() {
        boolean medicamentoDelExterior=false;
        String mensaje = "";
        String mensajeAux = "";
        
        for (int i = 0; i < conjMedicos.size(); i++) {

            mensajeAux = "\nMedico: " + conjMedicos.get(i).getNomMedico();
         medicamentoDelExterior=false;

            for (int y = 0; y < conjRecetas.size(); y++) {

                if (conjMedicos.get(i).getNroRegistro()== conjRecetas.get(y).getNroRegMedico()) {

                    for (int z = 0; z < conjRecetas.get(y).getVccm().size(); z++) {

                        if (siEsDelExterior(conjRecetas.get(y).getVccm().get(z).getCodigoMedicamento()) == true) {
                          
                            medicamentoDelExterior=true;
                            
                          break;
                           
                        }

                    }

                }
            }

            if (medicamentoDelExterior==true) {

                mensaje += mensajeAux;
            }

        }
        
        modo.mostrarCadena(mensaje);
    }
    
    

    public String nombreMedicamentoDelExterior(int x) {
        String mensaje ="";

        for (int i = 0; i < conjRecetas.get(x).getVccm().size(); i++) {

            if (siEsDelExterior(conjRecetas.get(x).getVccm().get(i).getCodigoMedicamento()) == true) {

                mensaje +=Integer.toString(buscarCodMedicamentoPorNombre(conjMedicamentos.get(i).getNombre()));
            }

        }

        return mensaje;
    }
    public boolean siEsDelExterior(int cod) {

        for (int x = 0; x < conjMedicamentos.size(); x++) {

            if (cod == conjMedicamentos.get(x).getCodigo()) {
                if (conjMedicamentos.get(x).getPaisOrigen().equals("argentina") == true) {
                    return false;
                }
            }

        }
        return true;

    }


    public void grabarArrayListMedicamentos() {
        crearArchArrayList = new CrearArchSecuencialSerializable("Medicamentos.ser");
        crearArchArrayList.abrirArchivo();
        crearArchArrayList.grabarArrayList(conjMedicamentos);
        crearArchArrayList.cerrarArchivo();

    }

    public void grabarArrayListRecetas() {
        crearArchArrayList = new CrearArchSecuencialSerializable("Recetas.ser");
        crearArchArrayList.abrirArchivo();
        crearArchArrayList.grabarArrayList(conjRecetas);
        crearArchArrayList.cerrarArchivo();

    }

    private void grabarArrayListMedicos() {
        crearArchArrayList = new CrearArchSecuencialSerializable("Medicos.ser");
        crearArchArrayList.abrirArchivo();
        crearArchArrayList.grabarArrayList(conjMedicos);
        crearArchArrayList.cerrarArchivo();
    }

    private void darDeBajaUnaReceta() {

        Receta rec;
        modo.mostrarCadena(conjRecetas.toString());
        int numRec = modo.leerDatoEntero("ingrese el numero de receta a dar de baja");

        rec = buscarReceta(numRec);

        if (rec == null) {
            modo.mostrarCadena("el numero de receta no existe ");
        } else {
            actualizarStockMedicamento(rec.getVccm());
            conjRecetas.remove(rec);
            grabarArrayListMedicamentos();
            grabarArrayListRecetas();
            modo.mostrarCadena("numero de receta " + numRec + " dado de baja exitosamente");

        }
//        int  posNum=buscarReceta(numRec);
//        if(posNum >= conjRecetas.size()){
//            modo.mostrarCadena("el numero de receta no existe ");
//        }
//        else{
//           actualizarStockMedicamento( conjRecetas.get(posNum).getVccm());
//           
//            conjRecetas.remove(posNum);

//            grabarArrayListMedicamentos();
//            grabarArrayListRecetas();
//    
        // modo.mostrarCadena("numero de receta " + numRec + " dado de baja exitosamente");}
        
    }

//      public int buscarReceta(int n) {  
//        int i = 0;
//        while (i < conjRecetas.size() && conjRecetas.get(i).getNroReceta() != n) {
//            i++;
//        }
//        return i;
//    }
    private void actualizarStockMedicamento(ArrayList<CodigoCantMedicamento> vccm) {

        int i = 0;
        while (i < vccm.size()) {
            Medicamento m = buscarMedicamentoPorCodigo(vccm.get(i).getCodigoMedicamento());
            m.setStock(m.getStock() + vccm.get(i).getCant());
            i++;
        }
    }

    public Receta buscarReceta(int num) { // 
        int i = 0;
        while (i < conjRecetas.size() && conjRecetas.get(i).getNroReceta() != num) {
            i++;
        }
        if (i >= conjRecetas.size()) {
            return null;
        } else {
            return conjRecetas.get(i);
        }
    }

}
