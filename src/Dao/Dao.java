/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
    
    
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean existe = false;
    
//         public void Conectar(){
//             
//         }
//         
//         public void Cerrar(){
//             
//         }
        
    public void Conectar(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppf?user=pma&password=pmapass");
            
          
            
//linea conexion bd  
             
          
            
            
        } catch (SQLException e) {
            System.out.println("error"+e);
            
   
        
        }
        
        
        
        
        
    }
    
    public void Cerrar(){
        try{
       if(con!=null){
           if(con.isClosed() == false){
            con.close();
            } 
        }
        } catch (SQLException e) {
            System.out.println("error"+e);
            
        } 
    }
    
}
