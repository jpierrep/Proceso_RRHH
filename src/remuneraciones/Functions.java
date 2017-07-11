/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author jpierre
 */
public class Functions {
    
         public  Object deepClone(Object object) {
   try {
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     ObjectOutputStream oos = new ObjectOutputStream(baos);
     oos.writeObject(object);
     ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
     ObjectInputStream ois = new ObjectInputStream(bais);
     return ois.readObject();
   }
   catch (Exception e) {
     e.printStackTrace();
     return null;
   }
 }
    
         
         public String getNombreEmpresa(int empresa){
             
            
              
                           //genera statement para la ficha si es administrativo o no
        String empSoftland="";   
                           switch (empresa){
                               case 0:empSoftland="GS Seguridad S.A.";
                               break;
                                case 1:empSoftland="GS Tecnologías S.A.";
                               break;
                               case 2:empSoftland="GS OutSourcing S.A.";
                               break;
                               case 3:empSoftland="Odin Ltda.";
                               break;

                           } 
                           
                           return empSoftland;
             
         }
         
         public boolean IsArrayWhite(String[] array){
             boolean isWhite=true;
             for (String var:array){
                 if(!var.equals("")){
                     return false;
                 }
             }
             
             
             return isWhite;
         }
         
         
}
