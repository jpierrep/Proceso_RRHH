/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

/**
 *
 * @author jpierre
 */
public class FileMannager {

 
   
                String Archivo="C.COSTO;NOMBRE;FICHA;DIAS TRABAJADOS;HORAS EXTRAS DEL MES;R;ESTADO BONO ASISTENCIA SI/NO;AGUINALDOS;MOVILIZACION ADICIONAL;BONO CLIENTE;BONO ADICIONAL;BONO CALIDAD;HHEE COMPENSACION FESTIVOS;BONO ASIST. EXT.;DIAS LICENCIA;TRAB.CON LICENCIA\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;ANDRADE HERRERA CRISTIAN ALEJANDRO;CONTRAVA01;30;6;0;;0;0;0;0;0;15;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;BOBADILLA PEREZ CLAUDIO ALEJANDRO;CONTRAVA02;30;6,5;0;;0;0;0;0;0;7,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;CATALAN VARGAS PEDRO BERNARDO;CONTRAVA03;30;32;0;;0;0;0;0;0;6,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;CID RIOS ALFREDO ERNESTO;CONTRAVA04;30;7;0;;0;0;0;0;0;15,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;ALVAREZ LINCOPE HECTOR RUBEN;CONTRAVA11;30;14,5;0;;0;0;0;0;0;7,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;ZUÑIGA GONZALEZ WALTER HERNAN;CONTRAVA12;30;15,5;0;;0;0;0;0;0;15;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;TORRES PATIÑO ALFREDO VALENTIN;CONTRAVA13;30;6;0;;0;0;0;0;0;31;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;BRICEÑO RIVAS LUIS HUMBERTO;CONTRAVA14;30;7;0;;0;0;0;0;0;15,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;PEREZ ACUÑA RIGOBERTO LEONARDO;CONTRAVA15;30;7,5;0;;0;0;0;0;0;15;945-001;0;0";
    
    
                
                  public String getArchivo() {
        return Archivo;
    }

    public void setArchivo(String Archivo) {
        this.Archivo = Archivo;
    }

     public String[] getFirstLine(){
        String[] todasLineas= Archivo.split("\n");
        String[] firstLine=todasLineas[0].split(";");
        
                return firstLine;
     }
     
     public String[] getLineas (){
         return Archivo.split("\n");
         
         
     }
                
}

 