/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import EditorComponents.ButtonRenderer;
import EditorComponents.ButtonEditor;
import Model.Transaccion;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jpierre
 */
public class Transacciones extends javax.swing.JFrame {

    /**
     * Creates new form Transacciones
     */
    TransactionMannager transactionMannager=new TransactionMannager();
    
    
    public Transacciones() {
     
  //       super( "JButtonTable Example" );
    initComponents();
    
    llenarTabla();
//    DefaultTableModel dm = new DefaultTableModel();
//    dm.setDataVector(new Object[][]{{"button 1","foo"},
//                                    {"button 2","bar"}},
//                     new Object[]{"Button","String"});
//                      
//    jTable1.setModel(dm);
//    jTable1.getColumn("Button").setCellRenderer(new ButtonRenderer());
//    jTable1.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));

       
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
        jLabel1 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Listado de Transacciones Anteriores");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
            .addGroup(layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transacciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables


     public void llenarTabla(){
    

           String[] titulos={"Nº Transacción","Fecha Datos","Nombre Archivo","Fecha Trans","Proceso","Accion"}; 
           String[] datos= new String[6]; 
       DefaultTableModel tableModel = new DefaultTableModel(null, titulos); 
         List<Transaccion> listTrans=transactionMannager.getTransacciones(0);
        int i=1;
        for (Transaccion trans: listTrans){
            datos[0]=Integer.toString(trans.getIdTransac());
            datos[1]=trans.getFechaDatos();
            datos[2]=trans.getNombreArchivo();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
          String fechatrans  = dateFormat.format(trans.getFechaTransac());
            
            datos[3]= fechatrans;
            datos[4]= trans.getProceso();
            //datos[5]="boton"+i;
            datos[5]=Integer.toString(trans.getIdTransac());
          //  System.out.println("datos"+datos[0]);
            
          tableModel.addRow(datos);
           
            i++;
            
        }
         
            jTable1.setModel(tableModel);
             jTable1.getColumn("Accion").setCellRenderer(new ButtonRenderer());
             jTable1.getColumn("Accion").setCellEditor(new ButtonEditor(new JCheckBox()));
        
     }
    
    
    
    
}
