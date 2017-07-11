/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import Dao.GetData;
import Model.Registro;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author jpierre
 */
public class ProcessMannager extends FileMannager {

    List<Registro> registrosReliq = new ArrayList();
    List<Registro> registrosDiferencia = new ArrayList();
    List<String> distinctFichas = new ArrayList();
    GetData getdata = new GetData();
    Functions functions = new Functions();

    public ProcessMannager() {
        super();
    }

    public void cargaDistinctFichas() {

        for (Registro reg : super.registros) {

            //    if(!distinctFichas.contains(reg.getFicha())&&reg.getEmpresa()==this.getEmpresa()){
            if (!distinctFichas.contains(reg.getFicha())) {

                distinctFichas.add(reg.getFicha());
            }
        }

        for (String ficha : distinctFichas) {
            System.out.println("fichas" + ficha);
        }

    }

    public void getVarFicha(String variables) {
        System.out.println("testing variables: " + variables);

        cargaDistinctFichas();

        //  for(String ficha:distinctFichas){ // por cada ficha carga las variables
        //       List<Registro> regFicha=getdata.getVarFichaMes(fecha, variables,ficha, empresa);
        //   List<Registro> regTemp= new ArrayList<>(registrosReliq);
        //  regTemp.addAll(regFicha);
        //registros de la base de datos, que hay que comparar con lo del archivo 
        //   registrosReliq=regTemp;
        registrosReliq = getdata.getVarFichaMes(fecha, variables, empresa);

        List<Registro> regFicha = new ArrayList<>();
        List<Registro> regTemp = new ArrayList<>();
        for (String ficha : distinctFichas) { // por cada ficha carga las variables
            regFicha = buscaRegistrosFicha(ficha);

            //List<Registro> regTemp= new ArrayList<>(regFicha);
            regTemp.addAll(regFicha);

        }
        //registros de la base de datos, que hay que comparar con lo del archivo 
        registrosReliq = regTemp;

        for (Registro register : registrosReliq) {
            System.out.println("Registro " + register.getFicha() + "Variable " + register.getVariable() + " Valor" + register.getValor());

        }

    }

    public void añadeDiffRel() {

        List<Registro> regDiff = new ArrayList<>();
        // Por cada registro que viene del archivo (reliq) buscamos en el resultado de las variables
        for (Registro regRel : registros) {
            //for(Registro reg: registros){
            //    if(reg.getFicha().equals(regRel.getFicha())&&reg.getVariable().equals(regRel.getVariable())){
            //       Registro regDiferencia=(Registro)functions.deepClone(reg);

            //  }}
            System.out.println("buscando diff" + regRel.getFicha() + regRel.getVariable());

            String variableBuscar = regRel.getFicha() + regRel.getVariable();

            List<Registro> list = buscaRegistros(variableBuscar);
            if (!list.isEmpty()) {
                //Solo si ambos caracteres son numericos se suman 
                //      if (java.util.regex.Pattern.matches("\\d+", list.get(0).getValor())&&java.util.regex.Pattern.matches("\\d+", regRel.getValor())){

                Registro regDiferencia = (Registro) functions.deepClone(regRel);
                float nuevoValor = Float.parseFloat(regDiferencia.getValor()) + Float.parseFloat(list.get(0).getValor());

                regDiferencia.setValor(Float.toString(nuevoValor));
                regDiff.add(regDiferencia);

            }

            // }
        }

        registrosDiferencia = regDiff;

        for (Registro reg : registrosDiferencia) {
            System.out.println("DIFFERENCIA var: " + reg.getVariable() + " valor: " + reg.getValor() + " fecha" + reg.getFecha() + " ficha:" + reg.getFicha());

        }

        for (Registro reg : registros) {
            System.out.println("REG ARCHIVO var: " + reg.getVariable() + " valor: " + reg.getValor() + " fecha" + reg.getFecha() + " ficha:" + reg.getFicha());

        }

        for (Registro reg : registrosReliq) {
            System.out.println("BASE DATOS var: " + reg.getVariable() + " valor: " + reg.getValor() + " fecha" + reg.getFecha() + " ficha:" + reg.getFicha());

        }

    }

    public List<Registro> buscaRegistros(String fichaVariable) {
        // List<Registro> list= registrosReliq.stream().filter(a -> Objects.equals(a.getFicha()+a.getVariable(),"CONTRAVA01P050")).collect(Collectors.toList());

        List<Registro> list = registrosReliq.stream().filter(a -> Objects.equals(a.getFicha() + a.getVariable(), fichaVariable)).collect(Collectors.toList());

        System.out.println("dentro busca");
        for (Registro reg : list) {
            System.out.println(reg.getFicha() + " " + reg.getValor());
        }

        return list;

    }

    public List<Registro> buscaRegistrosFicha(String ficha) {
        // List<Registro> list= registrosReliq.stream().filter(a -> Objects.equals(a.getFicha()+a.getVariable(),"CONTRAVA01P050")).collect(Collectors.toList());

        List<Registro> list = registrosReliq.stream().filter(a -> Objects.equals(a.getFicha(), ficha)).collect(Collectors.toList());

        System.out.println("dentro busca");
        for (Registro reg : list) {
            System.out.println(reg.getFicha() + " " + reg.getValor());
        }

        return list;

    }

    public void generaLogRel(String procesoForm, int empresa, String fecha, String path, String nombreArch) {

        //  int id=  this.getdata.getMaxTrasac();
        int id = getdata.InsertTransac(procesoForm, empresa, fecha, path, nombreArch);
        this.getdata.InsertArchivosTransac(registrosDiferencia, "RegDiff", id);
        this.getdata.InsertArchivosTransac(registros, "RegArchivo", id);
        this.getdata.InsertArchivosTransac(registrosReliq, "RegBD", id);

    }
    
       public void generaLogLiq(String procesoForm, int empresa, String fecha, String path, String nombreArch) {

        //  int id=  this.getdata.getMaxTrasac();
        int id = getdata.InsertTransac(procesoForm, empresa, fecha, path, nombreArch);
        this.getdata.InsertArchivosTransac(registros, "Liq", id);
   

    }
    
    
      public boolean IsvalidVariablesMapping(String[] texto,int empresa){
            
            boolean valid=true;
            for(String var:texto){
                if (!getdata.existsVariable(empresa,var)&&!var.equals(""))
                    return false;
            }

        return valid;
    }
      
      public String getVariablesError(String[] texto,int empresa){
            
            String invalid="";
            for(String var:texto){
                if (!getdata.existsVariable(empresa,var)&&!var.equals("")){
                   if(!invalid.equals("")){
                    invalid=invalid+","+var;
                   }else{
                            invalid=var;
                            }  
                }
            }    

        return invalid;
    }

}
