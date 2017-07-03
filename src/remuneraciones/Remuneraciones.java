/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jpierre
 */
public class Remuneraciones {
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

      /*  FileMannager file=new FileMannager();
        
        String[] as=file.getFirstLine();
        String[] asd=file.getLineas();
       
        for (String a:as){
           System.out.println(a);  
        }
        for (String a:asd){
           System.out.println(a);  
        }
*/
         
        System.out.println(getCodAux("010.462.229-1"));
       
        SimpleDateFormat formatter = new SimpleDateFormat("yyyymmdd");
        String fecha="20170501";
        try {
        Date fecha2=formatter.parse(fecha);
         Calendar c = Calendar.getInstance();
        c.setTime(fecha2);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat formatter2 = new SimpleDateFormat("ddmmyyyy");
            System.out.println(formatter2.format(c.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    //    LocalDate now = LocalDate.now(); //2015-11-23

        
        System.out.println("entero:"+ Float.parseFloat("29.0"));
    }
    
     public static String getCodAux(String rut){
    String aux=rut.substring(0,rut.length()-2);
    aux=aux.replace(".", ""); // sin puntos
    int auxInt=Integer.parseInt(aux); //quita los 0s del comienzo
    aux=Integer.toString(auxInt); //retorna el string
    return aux;

    
}
}
