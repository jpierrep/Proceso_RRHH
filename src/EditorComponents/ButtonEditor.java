/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EditorComponents;

/**
 *
 * @author jpierre
 */
import Model.Registro;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import remuneraciones.FileMannager;
import remuneraciones.TransactionMannager;
  
/**
 * @version 1.0 11/09/98
 */
public class ButtonEditor extends DefaultCellEditor {
  protected JButton button;
  private String   label;
  private boolean   isPushed;
  private int transaction;
  private  TransactionMannager transactionMannager=new TransactionMannager();

          
 
  
  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    
   
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }
  
  public Component getTableCellEditorComponent(JTable table, Object value,
                   boolean isSelected, int row, int column) {
    if (isSelected) {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } else{
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    label = (value ==null) ? "" : value.toString();
    button.setText( "Archivo" );
    isPushed = true;
    return button;
  }
  
  public Object getCellEditorValue() {
    if (isPushed)  {
      //
      //
     // JOptionPane.showMessageDialog(button ,label + ": Ouch!");
     //  System.out.println(label + ": Ouch!");
       
       List<Registro> listRegDiff=transactionMannager.getLiquidoTransacciones(Integer.parseInt(label));
       
       JTable tabla= new JTable();
       
      //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      tabla.setSize(500,500);
       tabla.setModel(new javax.swing.table.DefaultTableModel(
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
     

    JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    frame.add(new JScrollPane(tabla));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
      
       
        try {
            transactionMannager.exportarRegistros(listRegDiff,"C:\\Users\\jpierre\\Desktop","transacciones");
        } catch (IOException ex) {
            Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       
    }
    isPushed = false;
    return new String( label ) ;
  }
    
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }
  
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}