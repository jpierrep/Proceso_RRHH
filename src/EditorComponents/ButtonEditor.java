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
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
import remuneraciones.FileMannager;
import remuneraciones.MappingTabla;
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
   private JTextField filename = new JTextField(), dir = new JTextField();
   private static ButtonEditor instance = null;


          
 
  
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
    button.setText( "Mostrar" );
    isPushed = true;
    //System.out.println("hola");
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
       String[] titulos={"IdTransac","Fecha","Ficha","Variable","Valor Anterior","Valor Nuevo","Diferencia"}; 
            String[] datos= new String[7]; 
        DefaultTableModel tableModel= new DefaultTableModel(null, titulos); 
        NumberFormat nf = NumberFormat.getInstance();
        for (Registro reg: listRegDiff){
            datos[0]=label;
            datos[1]=reg.getFecha();
            datos[2]=reg.getFicha();
            
            datos[3]=reg.getVariable();
            datos[4]= nf.format(Float.parseFloat(reg.getValorAnterior()));
            datos[5]=  nf.format(Float.parseFloat(reg.getValor()));
            datos[6]= nf.format(Float.parseFloat(reg.getValorDiferencia()));
          //  System.out.println("datos"+datos[0]);
            
           tableModel.addRow(datos);
        }
            tabla.setModel(tableModel);
      
      
      
//      tabla.setModel(new javax.swing.table.DefaultTableModel(
//            new Object [][] {
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null},
//                {null, null, null, null}
//            },
//            new String [] {
//                "Title 1", "Title 2", "Title 3", "Title 4"
//            }
//        ));
     




    
    JPanel btnPnl= new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel topBtnPnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
     JButton btn= new JButton("Genera Archivo");
     JTextField txtF=new JTextField(" ",5);
     
     
     btn.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
     
       
            JFileChooser c = new JFileChooser();
      //disableTextField(c);
      c.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      int rVal = c.showOpenDialog(null);
      
       if (rVal == JFileChooser.APPROVE_OPTION) {
    
      filename.setText(c.getSelectedFile().getName());
     
        // disableTextField(c);

 dir.setText(c.getCurrentDirectory().toString());
         System.out.println(filename.getText());
        System.out.println(dir.getText());// TODO add your handling code here:
        String filepath=dir.getText()+"\\"+filename.getText();
          
               try {
            transactionMannager.exportarRegistrosEnVariable( listRegDiff,filepath,"Diff-Liquidos-TR"+label+"",txtF.getText().trim());
             JOptionPane.showMessageDialog(null,"Archivo generado correctamente.","Exito",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al generar archivo.\n "+ ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ButtonEditor.class.getName()).log(Level.SEVERE, null, ex);
              JOptionPane.showMessageDialog(null, "Error al generar archivo.\n "+ ex.toString());
        }
       }
          
      }
    });
     
      btnPnl.add(new JLabel("Variable Diferencia Montos: "));
     btnPnl.add(txtF);
     topBtnPnl.add(btn);
     btnPnl.add(topBtnPnl, BorderLayout.NORTH);
    
     
     
      JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    frame.add(new JScrollPane(tabla),BorderLayout.CENTER);
    frame.add(btnPnl,BorderLayout.SOUTH);
    
   // frame.add(btnAddFlight);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    //  panel.add(frame);
     // panel.add(btnAddFlight);
     // panel.setVisible(true);
       

       
       
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

  public static ButtonEditor getInstance() {
if(instance == null) {
instance = new ButtonEditor(new JCheckBox());
}
return instance;

  }
}



