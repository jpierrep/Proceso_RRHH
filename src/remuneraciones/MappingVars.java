/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remuneraciones;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * This program demonstrates how to use JPanel in Swing.
 *
 * @author www.codejava.net
 */
public class MappingVars extends JFrame {

    String[] cabeceraArchivo;
    int cantidadColumnas;
    JLabel labelUsername = new JLabel("Enter username: ");
    JLabel labelPassword = new JLabel("Enter password: ");
    JTextField textUsername = new JTextField(20);
    JPasswordField fieldPassword = new JPasswordField(20);
    JButton button1 = new JButton("Mapear Variables");
    JLabel[] jlabels;
    JTextField[] jtext;

    public MappingVars(String[] cabeceraArchivo) {
        super("JPanel Demo Program");

        this.cabeceraArchivo = cabeceraArchivo;
        this.cantidadColumnas = cabeceraArchivo.length;
        jlabels = new JLabel[cantidadColumnas];
        jtext = new JTextField[cantidadColumnas];
        // create a new panel with GridBagLayout manager
        JPanel newPanel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(4, 4, 4, 4);

        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        /*       newPanel.add(labelUsername, constraints);
 
        constraints.gridx = 1;
        newPanel.add(textUsername, constraints);
         
        constraints.gridx = 0;
        constraints.gridy = 1;     
        newPanel.add(labelPassword, constraints);
        
         constraints.gridx = 1;
        newPanel.add(fieldPassword, constraints);
         */

        for (int i = 0; i < cantidadColumnas; i++) {
            jlabels[i] = new JLabel((i + 1) + ". " + cabeceraArchivo[i]);
            jtext[i] = new JTextField(5);

            constraints.gridx = 0;
            ++constraints.gridy;

            newPanel.add(jlabels[i], constraints);
            ++constraints.gridx;

            newPanel.add(jtext[i], constraints);

        }

        constraints.gridy++;

        constraints.gridx = 0;

        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newPanel.add(button1, constraints);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }

            private void jButton1ActionPerformed(ActionEvent evt) {

                for (int i = 0; i < 7; i++) {
                    System.out.println(jtext[i].getText());

                }

            }
        });

        // set border for the panel
        newPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Login Panel"));

        // add the panel to this frame
        add(newPanel);

        pack();
        setLocationRelativeTo(null);

    }

    public String[] getTextFieldValue() {
        String[] textFields = new String[cantidadColumnas];

        for (int i = 0; i < cantidadColumnas; i++) {
            textFields[i] = jtext[i].getText().trim();
            //   System.out.println("get"+jtext[i].getText());
        }

        return textFields;

    }

    public String getTextFieldValueString() {

        String[] textFieldValues = getTextFieldValue();
        List<String> textvar = new ArrayList();
        for (String value : textFieldValues) {
            if (!value.equals("")) {
                textvar.add(value);
            }
        }

        return "'" + String.join("','", textvar) + "'";

    }
    
    
    
  

    public static void main(String[] args) {
//        // set look and feel to the system look and feel
//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//         
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new MappingVars().setVisible(true);
//            }
//        });
    }
}
