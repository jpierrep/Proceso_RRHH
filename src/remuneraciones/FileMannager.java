/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import Model.Registro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jpierre
 */
public class FileMannager {

 
//   
                String Archivo="C.COSTO;NOMBRE;FICHA;DIAS TRABAJADOS;HORAS EXTRAS DEL MES;R;ESTADO BONO ASISTENCIA SI/NO;AGUINALDOS;MOVILIZACION ADICIONAL;BONO CLIENTE;BONO ADICIONAL;BONO CALIDAD;HHEE COMPENSACION FESTIVOS;BONO ASIST. EXT.;DIAS LICENCIA;TRAB.CON LICENCIA\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;ANDRADE HERRERA CRISTIAN ALEJANDRO;CONTRAVA01;30;50;0;;0;0;0;0;0;15;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;BOBADILLA PEREZ CLAUDIO ALEJANDRO;CONTRAVA02;30;6,5;0;;0;0;0;0;0;7,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;CATALAN VARGAS PEDRO BERNARDO;CONTRAVA03;30;32;0;;0;0;0;0;0;6,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;CID RIOS ALFREDO ERNESTO;CONTRAVA04;30;7;0;;0;0;0;0;0;15,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;ALVAREZ LINCOPE HECTOR RUBEN;CONTRAVA11;30;14,5;0;;0;0;0;0;0;7,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;ZUÑIGA GONZALEZ WALTER HERNAN;CONTRAVA12;30;15,5;0;;0;0;0;0;0;15;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;TORRES PATIÑO ALFREDO VALENTIN;CONTRAVA13;30;6;0;;0;0;0;0;0;31;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;BRICEÑO RIVAS LUIS HUMBERTO;CONTRAVA14;30;7;0;;0;0;0;0;0;15,5;945-001;0;0\n" +
"CONTRALORIA REGIONAL DE VALDIVIA;PEREZ ACUÑA RIGOBERTO LEONARDO;CONTRAVA15;30;7,5;0;;0;0;0;0;0;15;945-001;0;0";
   
    

    
    List<Registro> registros;
    String fecha;
    int empresa;
                
                  public String getArchivo() {
        return Archivo;
    }

    public void setArchivo(String Archivo) {
        this.Archivo = Archivo;
    }

     public String[] getFirstLine(){
        String[] todasLineas= Archivo.split("\n");
        String[] firstLine=todasLineas[0].split(";");
        firstLine=arrayToLowerCase(firstLine);
        
        
                return firstLine;
     }
     
     public String[] getLineas (){
         return Archivo.split("\n");
         
         
     }
     
     
     public void cargaRegistros(){
         List<Registro> lista=new ArrayList();
         
         String[] header=getFirstLine();
         
         String[] lineas=getLineas();
       int fichaIndex=  Arrays.asList(getFirstLine()).indexOf("FICHA");
     
         
      String[] datos= new String[getFirstLine().length]; 
      
        for (int i = 1; i <lineas.length; i++) { //i=1 porque el primero es header // 7 primeras lineas
         datos=lineas[i].split(";");
          
         for(int j = 0; j <datos.length; j++){
       //   Registro registro= new Registro("", "", header[j],j,datos[j], datos[fichaIndex]);
        Registro registro= new Registro("", "", header[j],j,datos[j], datos[fichaIndex]);   
       lista.add(registro);
         }
         
        }
         
         
      registros=lista;
}
    
     
      public void cargaRegistrosMapping(String[] mappings){
          //crea Mapping de registros
        List<Integer> indexesConValores= new ArrayList<Integer>(); // solo los indexes de las columnas con valores, para luego filtrar la lista de registros
          for (int i = 0; i < mappings.length; i++) {
              if(!mappings[i].equals("")){
                  indexesConValores.add(i);
              }
              
          }
          
       List<Registro> lista= new ArrayList();   
       
        for(Registro reg: registros){
            if(indexesConValores.contains(reg.getIndexColumna())){  // solo si tiene Variable asignada se añade a la lista si no no
                reg.setVariable(mappings[reg.getIndexColumna()]);  // se setea el valor de la variable de acuerdo al mapping y a la columna a la que pertenece
                lista.add(reg);  // se añaden los registros que tienen variable asignada
            }
        }
          
          registros=lista;
      }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
        //cada vez que cambie la fecha, se seteará a los registros
        setFechaRegistros();
    }
     
    public void setFechaRegistros(){
    
    for(Registro reg: registros){
        reg.setFecha(fecha);
    }
    
}

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    
        public void setEmpresaRegistros(){
    
    for(Registro reg: registros){
        reg.setEmpresa(empresa);
    }
    
    
}
    
    
    
      //Exporta registros sólo del archivo cargado
     
   public  void exportarRegistros(String path,String nombreArchivo) throws IOException, FileNotFoundException, ClassNotFoundException{
      
        
        
        
 java.util.Date utilDate = new java.util.Date();
 DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
 String fecha=df.format(utilDate);
        
        String realPath; 
        if (path==null){
    String sys = System.getProperty("user.home");    
    realPath=sys+"\\"+nombreArchivo+"-"+fecha+".txt"; // Sustituye "/" por el directorio ej: "/upload"
        }else{
        realPath=path+"\\"+nombreArchivo+"-"+fecha+".txt";
        }
  
        
  //El diccionario
 

 
 
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(realPath);
            pw = new PrintWriter(fichero);

            
               for (Registro reg: registros){
             
             pw.println( reg.getFicha()+","+reg.getVariable()+","+reg.getFecha()+","+reg.getValor());
                
                
            }
            
            
            
            
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        

    }
   
   
   
      //Exporta registros de cualquier objeto List<Registro>
   public  void exportarRegistros(List<Registro> registros,String path,String nombreArchivo) throws IOException, FileNotFoundException, ClassNotFoundException{
      
        
      
        
 java.util.Date utilDate = new java.util.Date();
 DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
 String fecha=df.format(utilDate);
        
        String realPath; 
        if (path==null){
    String sys = System.getProperty("user.home");    
    realPath=sys+"\\"+nombreArchivo+"-"+fecha+".txt"; // Sustituye "/" por el directorio ej: "/upload"
        }else{
        realPath=path+"\\"+nombreArchivo+"-"+fecha+".txt";
        }
  
        
  //El diccionario
 

 
 
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(realPath);
            pw = new PrintWriter(fichero);

            
               for (Registro reg: registros){
             
             pw.println( reg.getFicha()+","+reg.getVariable()+","+reg.getFecha()+","+reg.getValor());
                
                
            }
            
            
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
        

    }
   
   
    public void exportarRegistrosEnVariable(List<Registro> registros,String path,String nombreArchivo,String variable) throws IOException, FileNotFoundException, ClassNotFoundException{
       
        for(Registro reg:registros){
           reg.setVariable(variable);
       }
        
        
       exportarRegistros(registros,path,nombreArchivo);
   } 
   

    private String[] arrayToLowerCase(String[] array) {
         //To change body of generated methods, choose Tools | Templates.
    for (int i = 0; i < array.length; i++) {

            array[i] = array[i].toUpperCase();
    }
     
                return array;
    }
    
   
    
    
    
public   String llenarLista (String realPath){
      
    
        
        List lista= new ArrayList();
       File archivo = null;
       FileReader fr = null;
      BufferedReader br = null;
        String archivoLineas="";
 
      
      
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File (realPath);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
 
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
           // System.out.println(linea);
        // lista.add(linea);
             archivoLineas=archivoLineas+linea+"\n";
         
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
       
       
       System.out.println(archivoLineas);
        
     return archivoLineas;   
    }
        
        
    
    
    
}

 