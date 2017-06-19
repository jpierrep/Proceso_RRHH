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
public class Remuneraciones {
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        FileMannager file=new FileMannager();
        
        String[] as=file.getFirstLine();
        String[] asd=file.getLineas();
       
        for (String a:as){
           System.out.println(a);  
        }
        for (String a:asd){
           System.out.println(a);  
        }
         

    
    }
    
    

    
}
