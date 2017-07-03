/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Registro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author jpierre
 */
public class GetData extends Dao  {
    
    
          public List<Registro> getVarFichaMes(String fecha,String variables,int empresa){
       
                      String[] newFormFecha =fecha.split("/"); //fecha viene en formato mm/yyyy y el de la query debe ser yyyymmdd
         String fechaFormat=newFormFecha[1]+newFormFecha[0];
             // System.out.println("fechamesBDVar"+fechaFormat);
              
        Statement stmt = null;
        ResultSet rs = null;      
      List<Registro> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        stmt = this.con.createStatement();
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                String queryString = "SELECT [FICHA] \n" +
"       ,[VARIABLE_CODI]\n" +
"      ,[VARIABLE_MONTO]\n" +
"      \n" +
"\n" +
"  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO] where  DIA_DESC='HASTA MES EN CURSO' and ESTADO_PER='V' \n" +
"  and EMP_CODI="+empresa+" and FECHA='"+fechaFormat+"01' and (VARIABLE_CODI IN ("+variables+") or variable_codi='H303') ";
                
          // System.out.println(queryString);
            
            
      rs = stmt.executeQuery(queryString);      
            
            while (rs.next()) {
                String ficha=rs.getObject(1).toString();
                String variable=rs.getObject(2).toString();
              
             //   String nombre_cuenta=rs.getObject(2).toString();
          String monto=rs.getObject(3).toString();
          Registro reg=new Registro(fecha, empresa, variable, monto, ficha);
          lista.add(reg);
                
         //     Registro mov=new Registro(num_cuenta, centroCosto, area, fecha, empresaMov, debe, haber);
          //      lista.add(mov);
            } 

          //  System.out.println(" la lista es ");
          //  for (String list: lista){
          //      System.out.println("relato"+list);
          //  }
            
            
            /*stmt.setString(4, usuario.getRut())*/
     
            System.out.println("biiieennntoo");

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return lista;
    }
    
//          
//          public List<Registro> getVarFichaMes(String fecha,String variables,String ficha,int empresa){
//       
//                      String[] newFormFecha =fecha.split("/"); //fecha viene en formato mm/yyyy y el de la query debe ser yyyymmdd
//         String fechaFormat=newFormFecha[1]+newFormFecha[0];
//             // System.out.println("fechamesBDVar"+fechaFormat);
//              
//        Statement stmt = null;
//        ResultSet rs = null;      
//      List<Registro> lista= new ArrayList();   
//    try{
//           
//   
//        this.Conectar();
//      
//        stmt = this.con.createStatement();
//      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
//            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
//                String queryString = "SELECT \n" +
//"       [VARIABLE_CODI]\n" +
//"      ,[VARIABLE_MONTO]\n" +
//"      ,[AREA_CODI]\n" +
//"\n" +
//"  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO] where  DIA_DESC='HASTA MES EN CURSO' and ESTADO_PER='V' and\n" +
//" FICHA= '"+ficha+"' and EMP_CODI="+empresa+" and FECHA='"+fechaFormat+"01' and VARIABLE_CODI IN ("+variables+")";
//                
//          // System.out.println(queryString);
//            
//            
//      rs = stmt.executeQuery(queryString);      
//            
//            while (rs.next()) {
//                String variable=rs.getObject(1).toString();
//             //   String nombre_cuenta=rs.getObject(2).toString();
//          String monto=rs.getObject(2).toString();
//          Registro reg=new Registro(fecha, empresa, variable, monto, ficha);
//          lista.add(reg);
//                
//         //     Registro mov=new Registro(num_cuenta, centroCosto, area, fecha, empresaMov, debe, haber);
//          //      lista.add(mov);
//            } 
//
//          //  System.out.println(" la lista es ");
//          //  for (String list: lista){
//          //      System.out.println("relato"+list);
//          //  }
//            
//            
//            /*stmt.setString(4, usuario.getRut())*/
//     
//            System.out.println("biiieennntoo");
//
//         } catch (SQLException e) {
//           
//        }  finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                    rs = null;
//                }
//                if (stmt != null) {
//                    stmt.close();
//                    stmt = null;
//                }
//                if (con != null) {
//                    con.close();
//                    con = null;
//                }
//            } catch (SQLException e) {
//            }
//        }
//    
//     return lista;
//    }
//    
          
      
          
          public List<Registro> InsertTransac(List<Registro> listaReg, String Proceso,int idTransact){
          
              
              
               String ProcesoBD="";
          switch(Proceso){
              case "Liquidaciones": ProcesoBD="L";
              case "Reliquidaciones": ProcesoBD="R";
              
          }
              
        PreparedStatement stmt = null;      
      List<Registro> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                String queryString = "Insert into [Inteligencias_transac].[dbo].[RRHH_Archivos_Rem]  \n" +
"      ([ID_TRANSAC],[PROCESO]\n" +
"      ,[FECHA_TRANSAC]\n" +
"      ,[FECHA_DATOS]\n" +
"      ,[FICHA]\n" +
"      ,[VARIABLE_CODI]\n" +
"      ,[VARIABLE_MONTO]"+
"       ,[EMP_CODI])"
                        
        + "Values (?,?,?,?,?,?,?)  ";
                
            Calendar cal = Calendar.getInstance(); 
           java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());              
                
          // System.out.println(queryString);
          
          stmt = this.con.prepareStatement(queryString);
            
            int i=0;

            for (Registro reg:listaReg) {
               stmt.setInt(1, idTransact);
                stmt.setString(2, ProcesoBD);
               stmt.setTimestamp(3,timestamp);
               stmt.setString(4, reg.getFecha());
                stmt.setString(5,reg.getFicha());
              stmt.setString(6,reg.getVariable());
              stmt.setString(7,reg.getValor());
              stmt.setInt(8,reg.getEmpresa());
       
          stmt.addBatch();
          i++;
          if (i % 100 == 0 || i == listaReg.size()) {
                stmt.executeBatch(); // Execute every 100 items.
            }
                
        
            } 

  
     
            System.out.println("Insert Ok");

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return lista;
    }   
          
     
    
    
          public int getMaxTrasac(){
       
          
             int idTransact=0;
              
        Statement stmt = null;
        ResultSet rs = null;      
      List<Registro> lista= new ArrayList();   
    try{
           
   
        this.Conectar();
      
        stmt = this.con.createStatement();
      //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
                String queryString = "select (max(ID_TRANSAC)+1) as ID from [Inteligencias_transac].[dbo].[RRHH_Archivos_Rem]";
                
          // System.out.println(queryString);
            
            
      rs = stmt.executeQuery(queryString);      
            
            while (rs.next()) {
             idTransact=Integer.parseInt(rs.getObject(1).toString());
               
            } 

          System.out.println("idTransact"+idTransact);

         } catch (SQLException e) {
           
        }  finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
                if (con != null) {
                    con.close();
                    con = null;
                }
            } catch (SQLException e) {
            }
        }
    
     return idTransact;
    }  
          
}
