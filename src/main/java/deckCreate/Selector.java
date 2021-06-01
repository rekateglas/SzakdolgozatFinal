/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckCreate;

import game.GameAlgorithms;
import java.util.ArrayList;

/**
 * <p>
 * Selector class.</p>
 *
 * @author rekat
 * @version $Id: $Id
 */
public class Selector extends javax.swing.JFrame {

    DBM dbm = new DBM();
    ArrayList a = new ArrayList();
    ArrayList b = new ArrayList();

    /**
     * Creates new form Selector
     */
    public Selector() {

        initComponents();
        myInitComponents();
        dbm.DeckLoader(a, textArea);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void myInitComponents() {
        GameAlgorithms GA = new GameAlgorithms();
        username.setText(GA.getPlayername());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        textField_1 = new javax.swing.JTextField();
        textField = new javax.swing.JTextField();
        btnSelectCard = new javax.swing.JButton();
        btnNewButton = new javax.swing.JButton();
        btnNewButton_1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kártyapakli készítő - Selector");

        contentPane.setBackground(new java.awt.Color(238, 254, 254));
        contentPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textArea.setEditable(false);
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        textArea.setRows(5);
        scrollPane.setViewportView(textArea);

        contentPane.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 280, 350));
        contentPane.add(textField_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 185, 150, 35));

        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        contentPane.add(textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 150, 35));

        btnSelectCard.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnSelectCard.setText("Kártya választása");
        btnSelectCard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectCardActionPerformed(evt);
            }
        });
        contentPane.add(btnSelectCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 185, 150, 35));

        btnNewButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnNewButton.setText("Pakli választása");
        btnNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButtonActionPerformed(evt);
            }
        });
        contentPane.add(btnNewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 150, 35));

        btnNewButton_1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 12)); // NOI18N
        btnNewButton_1.setText("Tovább");
        btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_1ActionPerformed(evt);
            }
        });
        contentPane.add(btnNewButton_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 415, 200, 35));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel1.setText("Válassza ki a kívánt kártyapaklit (ID-szerint), majd a kívánt kártyákat (ID-szerint)");
        contentPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 34, 580, 40));

        username.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        username.setForeground(new java.awt.Color(0, 102, 102));
        username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        contentPane.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 290, 20));

        buttonBack.setIcon(new javax.swing.ImageIcon("C:\\TeglasRekaSzakdolgozat\\img\\icons8-back-20.png")); // NOI18N
        buttonBack.setContentAreaFilled(false);
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });
        contentPane.add(buttonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed

    }//GEN-LAST:event_textFieldActionPerformed

    private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButtonActionPerformed
        textArea.selectAll();
        textArea.replaceSelection("");

        dbm.DeckChooser(textField);
        textArea.selectAll();
        textArea.replaceSelection("");
        dbm.CardLoader(b, textArea);

    }//GEN-LAST:event_btnNewButtonActionPerformed

    private void btnSelectCardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectCardActionPerformed

        dbm.CardChooser(textField_1);
        dbm.MS("Kártya kiválasztva!");

    }//GEN-LAST:event_btnSelectCardActionPerformed

    private void btnNewButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButton_1ActionPerformed
        dbm.CopyCard(a);
        dispose();
        setVisible(false);
        TextEditor te = new TextEditor();
        te.setVisible(true);
    }//GEN-LAST:event_btnNewButton_1ActionPerformed

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        dispose();
        setVisible(false);
        FirstPg FP = new FirstPg();
        FP.setVisible(true);
    }//GEN-LAST:event_buttonBackActionPerformed

    /**
     * <p>
     * main.</p>
     *
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
            java.util.logging.Logger.getLogger(Selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Selector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Selector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewButton;
    private javax.swing.JButton btnNewButton_1;
    private javax.swing.JButton btnSelectCard;
    private javax.swing.JButton buttonBack;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField textField;
    private javax.swing.JTextField textField_1;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}