/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jpierre
 */
public class MappingTabla extends javax.swing.JFrame {

    
    DefaultTableModel tableModel;
    FileMannager fileMannager=new FileMannager();
    String[] cabeceraArchivo;
    MappingVars mappingVars;
    String mesForm;
    int añoForm;
    String fechaForm;
    int empresaForm;
    
    
    /**
     * Creates new form MappingTabla
     */
    public MappingTabla() {
        initComponents();
        llenarTabla();
        postInit();
        
         jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo", "Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"  }));
       
         java.util.Date utilDate = new java.util.Date();
 //DateFormat df = new SimpleDateFormat("dd-MM-YYYY");
 DateFormat df = new SimpleDateFormat("YYYY-mm-dd");
 String fecha=df.format(utilDate);
 int año=Integer.parseInt(fecha.substring(0,4));
         jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ""+año,""+(año-1),""+(año-2)  }));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GuardService Seguridad S.A.","GS Tecnologías S.A.","GS Outsourcing S.A.","Inversiones Odin Ltda."  }));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 303));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Mapea Variables");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(674, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
                  mappingVars.setVisible(true);
         /*  String[] textFieldValues=panel.getTextFieldValue();
           
           for (String valor:textFieldValues){
               System.out.println(valor);
           } */
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
 
    
    
    public void postInit()
 {
     mappingVars=new MappingVars(cabeceraArchivo);
  mappingVars.button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mappingVarsButton(evt);
            }
        });
  
  
 
  jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
			   jComboBox1ActionPerformed(evt);
			  
            }

         private void jComboBox1ActionPerformed(ActionEvent evt) {
    //Año

           añoForm=Integer.parseInt(jComboBox1.getSelectedItem().toString());
           fechaForm= Integer.toString(añoForm)+"/"+mesForm;
           System.out.println("año"+ añoForm);
         }
        });
        
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

			   jComboBox2ActionPerformed(evt);
		   
					   
            }

         private void jComboBox2ActionPerformed(ActionEvent evt) {
 // Mes
             int mes=jComboBox2.getSelectedIndex()+1; //comienza de 0 aumentamos 1 para que se adapte al real
           mesForm= mes>=10 ? Integer.toString(mes) : "0"+Integer.toString(mes)   ;  
           fechaForm= Integer.toString(añoForm)+"/"+mesForm;
             System.out.println("mes"+ mesForm);


         }
        });
        
        	jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
             
				jComboBox3ActionPerformed(evt);
				
            }

         private void jComboBox3ActionPerformed(ActionEvent evt) {
       //Empresa
             empresaForm=jComboBox3.getSelectedIndex(); //empresa coincide con el nombre
 System.out.println("empresa"+ empresaForm);
         }
        });
 
 
 }
    
    
      private void mappingVarsButton(java.awt.event.ActionEvent evt) {                                         
       
      String[] texto= mappingVars.getTextFieldValue();
      
      for (int i = 0; i < 7; i++) {
          System.out.println("casa"+texto[i]);
      }
        
    }    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MappingTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MappingTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MappingTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MappingTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MappingTabla().setVisible(true);
            }
        });
    }
    
    public void llenarTabla (){
    
      cabeceraArchivo=fileMannager.getFirstLine();
   
    /*  
        for (int i = 0; i < cabeceraArchivo.length; i++) {
            cabeceraArchivo[i]="<html>"+cabeceraArchivo[i]+"<br>date";
        }
      */
      
     String[] lineas=fileMannager.getLineas();
     
         
      String[] datos= new String[cabeceraArchivo.length]; 
      
      tableModel= new DefaultTableModel(null, cabeceraArchivo); 
        for (int i = 1; i <7; i++) { //i=1 porque el primero es header // 7 primeras lineas
         datos=lineas[i].split(";");
           tableModel.addRow(datos);  
        }
          jTable1.setModel(tableModel);
  
          
          
    
}
    
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
