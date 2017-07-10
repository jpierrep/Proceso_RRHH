/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;


import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jpierre
 */
public class Inicio extends javax.swing.JFrame {

    
    DefaultTableModel tableModel;
    String mesForm="01";
    int añoForm=2017;
    String fechaForm="01/2017";
    int empresaForm=0;
    String procesoForm;
     private JTextField filename = new JTextField(), dir = new JTextField();
     Transacciones transacciones=new Transacciones();
     MappingTabla mappingTabla =new MappingTabla();
      String filepath;
    
    

    public Inicio() {
        initComponents();
     
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Reliquidaciones");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setText("Liquidaciones");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Liquidos A Pago");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Año:");

        jLabel2.setText("Mes:");

        jLabel3.setText("Empresa:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Automatización Liquidaciones/Reliquidaciones");

        jLabel5.setText("Seleccione un proceso:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(53, 53, 53)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(53, 53, 53)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(59, 59, 59)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)))
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(67, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
         JFileChooser c = new JFileChooser();
 
      c.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      int rVal = c.showOpenDialog(Inicio.this);
    
      
      if (rVal == JFileChooser.APPROVE_OPTION) {
     filename.setText(c.getSelectedFile().getName());
     

 dir.setText(c.getCurrentDirectory().toString());
         System.out.println(filename.getText());
        System.out.println(dir.getText());// TODO add your handling code here:
         filepath=dir.getText()+"\\"+filename.getText();
          System.out.println(filepath);
        

              this.procesoForm="Reliquidaciones";
              this.setParametrosMappingTabla();
            
            mappingTabla.cargaDatosMappingTabla();
   
             
                 
                 mappingTabla.setVisible(true);
                 
      }
                 
                 
         /*  String[] textFieldValues=panel.getTextFieldValue();
           
           for (String valor:textFieldValues){
               System.out.println(valor);
           } */
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      JFileChooser c = new JFileChooser();
      //disableTextField(c);
      c.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
      int rVal = c.showOpenDialog(Inicio.this);
    
      
      if (rVal == JFileChooser.APPROVE_OPTION) {
     filename.setText(c.getSelectedFile().getName());
     
        // disableTextField(c);

 dir.setText(c.getCurrentDirectory().toString());
         System.out.println(filename.getText());
        System.out.println(dir.getText());// TODO add your handling code here:
        String filepath=dir.getText()+"\\"+filename.getText();
          System.out.println(filepath);
      
           
                 this.procesoForm="Liquidaciones";
                 this.setParametrosMappingTabla();
                 mappingTabla.cargaDatosMappingTabla();
                 mappingTabla.setVisible(true);
      }
     
          

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        transacciones.llenarTabla();
        transacciones.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

 
    public void setParametrosMappingTabla(){
          
          mappingTabla.añoForm=this.añoForm;
          mappingTabla.fechaForm=this.fechaForm;
          mappingTabla.empresaForm=this.empresaForm;
          mappingTabla.mesForm=this.mesForm;
          mappingTabla.procesoForm=this.procesoForm;
          mappingTabla.filepath=this.filepath;
    
}
    
    public void postInit()
 {
    

 
  jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              
			   jComboBox1ActionPerformed(evt);
			  
            }

         private void jComboBox1ActionPerformed(ActionEvent evt) {
    //Año

           añoForm=Integer.parseInt(jComboBox1.getSelectedItem().toString());
           fechaForm= mesForm +"/"+Integer.toString(añoForm);
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
           fechaForm=  mesForm +"/"+Integer.toString(añoForm);
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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }
    
    
    

    
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
