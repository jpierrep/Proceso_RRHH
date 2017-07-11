/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Registro;
import Model.Transaccion;
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
public class GetData extends Dao {

    public List<Registro> getVarFichaMes(String fecha, String variables, int empresa) {

        String[] newFormFecha = fecha.split("/"); //fecha viene en formato mm/yyyy y el de la query debe ser yyyymmdd
        String fechaFormat = newFormFecha[1] + newFormFecha[0];
        // System.out.println("fechamesBDVar"+fechaFormat);

        Statement stmt = null;
        ResultSet rs = null;
        List<Registro> lista = new ArrayList();
        try {

            this.Conectar();

            stmt = this.con.createStatement();
            //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
            String queryString = "SELECT [FICHA] \n"
                    + "       ,[VARIABLE_CODI]\n"
                    + "      ,[VARIABLE_MONTO]\n"
                    + "      \n"
                    + "\n"
                    + "  FROM [Inteligencias].[dbo].[RRHH_ESTRUCTURA_SUELDO] where  DIA_DESC='HASTA MES EN CURSO' and ESTADO_PER='V' \n"
                    + "  and EMP_CODI=" + empresa + " and FECHA='" + fechaFormat + "01' and (VARIABLE_CODI IN (" + variables + ") or variable_codi='H303') ";

            // System.out.println(queryString);
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                String ficha = rs.getObject(1).toString();
                String variable = rs.getObject(2).toString();

                //   String nombre_cuenta=rs.getObject(2).toString();
                String monto = rs.getObject(3).toString();
                Registro reg = new Registro(fecha, empresa, variable, monto, ficha);
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

        } finally {
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
    public int InsertTransac(String proceso, int empresa, String fecha, String path, String nombreArch) {

        Integer idTransac = this.getMaxTrasac();

//               String ProcesoBD="";
//          switch(Proceso){
//              case "Liquidaciones": ProcesoBD="L";
//              case "Reliquidaciones": ProcesoBD="R";
//              
//          }
        PreparedStatement stmt = null;
        List<Registro> lista = new ArrayList();
        try {

            this.Conectar();

            //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
            String queryString = "Insert into [Inteligencias_transac].[dbo].[RRHH_Transac] \n"
                    + "      ([ID_TRANSAC]\n"
                    + "      ,[FECHA_TRANSAC]\n"
                    + "      ,[FECHA_DATOS]\n"
                    + "      ,[NOMBRE_ARCHIVO]\n"
                    + "      ,[RUTA_ARCHIVO]"
                    + "      ,[PROCESO]"
                    + "       ,[EMP_CODI])"
                    + "Values (?,?,?,?,?,?,?)  ";

            Calendar cal = Calendar.getInstance();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());

            // System.out.println(queryString);
            stmt = this.con.prepareStatement(queryString);

            stmt.setInt(1, idTransac);
            stmt.setTimestamp(2, timestamp);
            stmt.setString(3, fecha);
            stmt.setString(4, nombreArch);
            stmt.setString(5, path);
            stmt.setString(6, proceso);
            stmt.setInt(7, empresa);

            stmt.execute();
            System.out.println("Insert Ok");

        } catch (SQLException e) {
            System.out.println("SQLState: "
                    + e.getSQLState());
            System.out.println("SQLErrorCode: "
                    + e.getErrorCode());
            e.printStackTrace();

        } finally {
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

        return idTransac;
    }

    public List<Registro> InsertArchivosTransac(List<Registro> listaReg, String Proceso, int idTransact) {

//               String ProcesoBD="";
//          switch(Proceso){
//              case "Liquidaciones": ProcesoBD="L";
//              case "Reliquidaciones": ProcesoBD="R";
//              
//          }
        PreparedStatement stmt = null;
        List<Registro> lista = new ArrayList();
        try {

            this.Conectar();

            //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
            String queryString = "Insert into [Inteligencias_transac].[dbo].[RRHH_Archivos_Rem]  \n"
                    + "      ([ID_TRANSAC],[PROCESO]\n"
                    + "      ,[FECHA_DATOS]\n"
                    + "      ,[FICHA]\n"
                    + "      ,[VARIABLE_CODI]\n"
                    + "      ,[VARIABLE_MONTO]"
                    + "       ,[EMP_CODI])"
                    + "Values (?,?,?,?,?,?,?)  ";

            //   Calendar cal = Calendar.getInstance(); 
            //  java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());              
            // System.out.println(queryString);
            stmt = this.con.prepareStatement(queryString);

            int i = 0;

            for (Registro reg : listaReg) {
                stmt.setInt(1, idTransact);
                stmt.setString(2,Proceso);
                stmt.setString(3, reg.getFecha());
                stmt.setString(4, reg.getFicha());
                stmt.setString(5, reg.getVariable());
                stmt.setString(6, reg.getValor());
                stmt.setInt(7, reg.getEmpresa());

                stmt.addBatch();
                i++;
                if (i % 100 == 0 || i == listaReg.size()) {
                    stmt.executeBatch(); // Execute every 100 items.
                }

            }

            System.out.println("Insert Ok");

        } catch (SQLException e) {
            System.out.println("SQLState: "
                    + e.getSQLState());
            System.out.println("SQLErrorCode: "
                    + e.getErrorCode());
            e.printStackTrace();

        } finally {
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

    public int getMaxTrasac() {

        int idTransact = 0;

        Statement stmt = null;
        ResultSet rs = null;
        List<Registro> lista = new ArrayList();
        try {

            this.Conectar();

            stmt = this.con.createStatement();
            //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
            String queryString = "select (max(ID_TRANSAC)+1) as ID from [Inteligencias_transac].[dbo].[RRHH_Transac]";

            // System.out.println(queryString);
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {
                if (rs.getObject(1) != null) {
                    idTransact = Integer.parseInt(rs.getObject(1).toString());
                } else {
                    return 1;
                }

            }

            System.out.println("idTransact" + idTransact);

        } catch (SQLException e) {

        } finally {
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

    public List<Transaccion> getTransacciones(int empresa) {

        List<Transaccion> lista = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {

            this.Conectar();

            stmt = this.con.createStatement();
            //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
            String queryString = "SELECT [ID_TRANSAC]\n"
                    + "      ,[FECHA_TRANSAC]\n"
                    + "      ,[FECHA_DATOS]\n"
                    + "      ,[EMP_CODI]\n"
                    + "      ,[NOMBRE_ARCHIVO]\n"
                    + "      ,[RUTA_ARCHIVO]\n"
                    + "      ,[PROCESO]\n"
                    + "      ,[USER_ID]\n"
                    + "  FROM [Inteligencias_transac].[dbo].[RRHH_Transac] where EMP_CODI=" + empresa +"and [PROCESO]='Reliquidaciones'  order by [FECHA_TRANSAC] desc";

            // System.out.println(queryString);
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {

                int idTransact = Integer.parseInt(rs.getObject(1).toString());

                //  DateFormat df = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
                // Calendar cal = Calendar.getInstance(); 
                // java.sql.Timestamp parsedDate = new java.sql.Timestamp(cal.getTimeInMillis());  
//            try {
//               parsedDate = (Timestamp) df.parse(rs.getObject(2).toString());
//            } catch (ParseException ex) {
//                Logger.getLogger(GetData.class.getName()).log(Level.SEVERE, null, ex);
//            }
                java.sql.Timestamp parsedDate = java.sql.Timestamp.valueOf(rs.getObject(2).toString());
                String fechaDatos = rs.getObject(3).toString();
                String nombreArch = rs.getObject(5).toString();
                String rutaArch = rs.getObject(6).toString();
                String proceso = rs.getObject(7).toString();
                Transaccion transac = new Transaccion(idTransact, parsedDate, fechaDatos, empresa, nombreArch, rutaArch, proceso);
                lista.add(transac);

            }

            //    System.out.println("idTransact"+idTransact);
        } catch (SQLException e) {

        } finally {
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

    public List<Registro> getDiffLiquido(int idTransac) {

        System.out.println("obtener transaccion" + idTransac);

        List<Registro> lista = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {

            this.Conectar();

            stmt = this.con.createStatement();
            //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
            String queryString = "SELECT  [ID_TRANSAC]\n"
                    + "      ,[PROCESO]\n"
                    + "      ,[FECHA_DATOS]\n"
                    + "      ,trans.[FICHA]\n"
                    + "      ,trans.[VARIABLE_CODI]\n"
                    + "      ,trans.[VARIABLE_MONTO] as LIQU_ANTES_REL\n"
                    + "      ,est.[VARIABLE_MONTO]  as LIQU_DESPUES_REL\n"
                    + "      ,trans.[EMP_CODI]\n"
                    + "      ,convert(int,est.VARIABLE_MONTO)-convert(float,trans.VARIABLE_MONTO) as DIFERENCIA\n"
                    + "  FROM [Inteligencias_transac].[dbo].[RRHH_Archivos_Rem] as trans --where id_transac=2 and variable_codi='H303' \n"
                    + "  \n"
                    + "  inner join inteligencias.dbo.RRHH_ESTRUCTURA_SUELDO as est on trans.ficha collate SQL_Latin1_General_CP1_CI_AI=est.ficha and trans.emp_codi=est.emp_codi \n"
                    + "  and est.fecha=right(fecha_datos,4)+left(fecha_datos,2)+'01'  and trans.variable_codi collate SQL_Latin1_General_CP1_CI_AI=est.variable_codi\n"
                    + "  \n"
                    + "  \n"
                    + "  where trans.[VARIABLE_CODI]='H303'  and trans.ID_TRANSAC=" + idTransac + "";

            // System.out.println(queryString);
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {

                String fechaDatos = rs.getObject(3).toString();
                String ficha = rs.getObject(4).toString();
                String varCodi = rs.getObject(5).toString();
                String valorAnterior = rs.getObject(6).toString();
                String valorActual = rs.getObject(7).toString();
                int empresa = Integer.parseInt(rs.getObject(8).toString());
                String valorDiferencia = rs.getObject(9).toString();

                Registro reg = new Registro(fechaDatos, empresa, varCodi, valorActual, ficha);
                reg.setValorAnterior(valorAnterior);
                reg.setValorDiferencia(valorDiferencia);
                lista.add(reg);

            }

            //    System.out.println("idTransact"+idTransact);
        } catch (SQLException e) {

        } finally {
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

    public boolean existsVariable(int empresa, String variable) {

        String empSoftland = "";
        switch (empresa) {
            case 0:
                empSoftland = "GUARD";
                break;
            case 1:
                empSoftland = "TECNOLOGIASSA";
                break;
            case 2:
                empSoftland = "OUTSOURCINGSA";
                break;
            case 3:
                empSoftland = "ODINLTDA";
                break;

        }

        boolean exists = false;

        Statement stmt = null;
        ResultSet rs = null;

        try {

            this.Conectar();

            stmt = this.con.createStatement();
            //      rs = stmt.executeQuery("SELECT idTest FROM relato WHERE test_idTest ='"+rutExaminado+"' ORDER BY idTest ASC");
            // rs = stmt.executeQuery("SELECT idRelato FROM relato WHERE test_idTest =511");
            String queryString = "SELECT codVariable\n"
                    + "  FROM " + empSoftland + ".[softland].[sw_variable]  where codVariable='" + variable + "'";

            // System.out.println(queryString);
            rs = stmt.executeQuery(queryString);

            while (rs.next()) {

                return true;

            }

            //    System.out.println("idTransact"+idTransact);
        } catch (SQLException e) {

        } finally {
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

        return exists;
    }

}
