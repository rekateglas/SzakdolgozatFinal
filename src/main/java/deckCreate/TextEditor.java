/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckCreate;

import game.GameAlgorithms;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * <p>
 * TextEditor class.</p>
 *
 * @author rekat
 * @version $Id: $Id
 */
public class TextEditor extends javax.swing.JFrame {

    private static int comboChecker(int size) {
        int index = 0;
        switch (size) {
            case 11:
                index = 0;
                break;
            case 12:
                index = 1;
                break;
            case 13:
                index = 2;
                break;
            case 15:
                index = 3;
                break;
            case 18:
                index = 4;
                break;
            case 20:
                index = 5;
                break;
            case 22:
                index = 6;
                break;
            case 24:
                index = 7;
                break;
            case 26:
                index = 8;
                break;
        }
        return index;
    }

    private static int comboCheckerString(String type) {
        int index = 0;
        switch (type) {

            case "Arial":
                index = 0;
                break;
            case "Comic Sans MS":
                index = 1;
                break;
            case "Forte":
                index = 2;
                break;
            case "Lucida Console":
                index = 3;
                break;
            case "Script MT Bold":
                index = 4;
                break;
            case "Times New Roman":
                index = 5;
                break;
        }
        return index;
    }

    DBM dbm = new DBM();
    ArrayList a = new ArrayList();
    int qFSize;
    String qFType;
    int rFSize;
    String rFType;

    /**
     * Creates new form TextEditor
     */
    public TextEditor() {

        initComponents();
        myInitComponents();

        if (dbm.isBtn1() == true) {
            dbm.CopyCard(a);

            int i = 1;
            textField.setText(String.valueOf(a.get(i)));
            i++;

            textField_2.setText(String.valueOf(a.get(i)));

            i++;
            textField_1.setText(String.valueOf(a.get(i)));
            i++;
            textField_3.setText(String.valueOf(a.get(i)));
            i++;
            textField_5.setText(String.valueOf(a.get(i)));
            i++;
            textField_6.setText(String.valueOf(a.get(i)));
            i++;
            textField_7.setText(String.valueOf(a.get(i)));
            i++;
            qFSize = Integer.parseInt(String.valueOf(a.get(i)));
            System.out.println(a.get(i));
            i++;
            qFType = String.valueOf(a.get(i));
            i++;
            rFSize = Integer.parseInt(String.valueOf(a.get(i)));
            System.out.println(a.get(i));
            i++;
            rFType = String.valueOf(a.get(i));
        }
        if (dbm.isBtn2() == true) {
            dbm.CopyCard(a);
            int i = 1;
            textField.setText(String.valueOf(a.get(i)));
            i++;
            textField_2.setText(String.valueOf(a.get(i)));

            i++;
            textField_1.setText(String.valueOf(a.get(i)));
            i++;
            textField_3.setText(String.valueOf(a.get(i)));
            i++;
            textField_5.setText(String.valueOf(a.get(i)));
            i++;
            textField_6.setText(String.valueOf(a.get(i)));
            i++;
            textField_7.setText(String.valueOf(a.get(i)));
            i++;
            qFSize = Integer.parseInt(String.valueOf(a.get(i)));
            System.out.println(a.get(i));
            i++;
            qFType = String.valueOf(a.get(i));
            i++;
            rFSize = Integer.parseInt(String.valueOf(a.get(i)));
            System.out.println(a.get(i));
            i++;
            rFType = String.valueOf(a.get(i));
        }
        if (dbm.isBtn3() == true) {

            dbm.CopyCard(a);
            int i = 1;
            textField.setText(String.valueOf(a.get(i)));
            i++;

            textField_2.setText(String.valueOf(a.get(i)));

            i++;
            textField_1.setText(String.valueOf(a.get(i)));
            i++;
            textField_3.setText(String.valueOf(a.get(i)));
            i++;
            textField_5.setText(String.valueOf(a.get(i)));
            i++;
            textField_6.setText(String.valueOf(a.get(i)));
            i++;
            textField_7.setText(String.valueOf(a.get(i)));
            i++;
            qFSize = Integer.parseInt(String.valueOf(a.get(i)));
            System.out.println(a.get(i));
            i++;
            qFType = String.valueOf(a.get(i));
            i++;
            rFSize = Integer.parseInt(String.valueOf(a.get(i)));
            System.out.println(a.get(i));
            i++;
            rFType = String.valueOf(a.get(i));

            String math = textField_2.getText();

            textField.setFont(new Font(qFType, Font.PLAIN, qFSize));

            TeXFormula fomule = new TeXFormula(math);

            TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, qFSize);
            BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);

            ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);
            flabel.setIcon(ti);
            panel.revalidate();
            panel.repaint();

            String math2 = textField_3.getText();
            textField_1.setFont(new Font(rFType, Font.PLAIN, rFSize));
            TeXFormula fomule1 = new TeXFormula(math2);

            TeXIcon tit = fomule1.createTeXIcon(TeXConstants.STYLE_DISPLAY, rFSize);
            BufferedImage bg = new BufferedImage(tit.getIconWidth(), tit.getIconHeight(),
                    BufferedImage.TYPE_4BYTE_ABGR);

            tit.paintIcon(new JLabel(), bg.getGraphics(), 0, 0);
            flabel_1.setIcon(tit);
            panel_1.revalidate();
            panel_1.repaint();
        }
        // left
        if (!textField_2.getText().equals("")) {
            System.out.println(qFSize + "   " + rFSize);
            comboBox.setSelectedIndex(comboCheckerString(qFType));
            comboBox_1.setSelectedIndex(comboChecker(qFSize));
            String math = textField_2.getText();
            textField.setFont(new Font(qFType, Font.PLAIN, qFSize));
            TeXFormula fomule = new TeXFormula(math);

            TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, qFSize);
            BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);

            ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);

            flabel.setIcon(ti);
            panel.revalidate();
            panel.repaint();
        } else if (!textField_6.getText().equals("")) {
            textField_6.setText("");
        }
        if (textField_2.getText().equals("")) {
            String path = textField_6.getText();
            ImageIcon ti = new ImageIcon(path);

            flabel.setIcon(ti);
            panel.revalidate();
            panel.repaint();
        }
        // right
        if (!textField_3.getText().equals("")) {
            System.out.println(qFSize + "   " + rFSize);
            comboBox_2.setSelectedIndex(comboCheckerString(rFType));
            comboBox_1_1.setSelectedIndex(comboChecker(rFSize));
            String math = textField_3.getText();
            textField_1.setFont(new Font(rFType, Font.PLAIN, rFSize));
            TeXFormula fomule = new TeXFormula(math);

            TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, rFSize);
            BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(), BufferedImage.TYPE_4BYTE_ABGR);

            ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);

            flabel_1.setIcon(ti);
            panel_1.revalidate();
            panel_1.repaint();
        } else if (!textField_7.getText().equals("")) {
            textField_7.setText("");
        }
        if (textField_3.getText().equals("")) {
            String path = textField_7.getText();
            ImageIcon ti = new ImageIcon(path);

            flabel_1.setIcon(ti);
            panel_1.revalidate();
            panel_1.repaint();
        }
    }

    public void myInitComponents() {
        GameAlgorithms GA = new GameAlgorithms();
        username.setText(GA.getPlayername());
        String bgcolour = dbm.getColour();

        panel.setBackground(Color.decode(bgcolour));
        panel.revalidate();
        panel.repaint();
        panel_1.setBackground(Color.decode(bgcolour));
        panel_1.revalidate();
        panel_1.repaint();

        btnNewButton.setVisible(dbm.isBtn4());
        btnPrint.setVisible(dbm.isBtn3());
        btnNewButton_2.setVisible(dbm.isBtn1());
        btnNewButton_2_1.setVisible(dbm.isBtn2());
        if (dbm.isBtn1() == true || dbm.isBtn2() == true || dbm.isBtn3() == true) {
            buttonBack.setVisible(false);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contentPane = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        flabel = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        panel_1 = new javax.swing.JPanel();
        flabel_1 = new javax.swing.JLabel();
        textField_1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblNewLabel_3 = new javax.swing.JLabel();
        textField_4 = new javax.swing.JTextField();
        btnNewButton_1_2 = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();
        comboBox_1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        textField_2 = new javax.swing.JTextField();
        btnNewButton_1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textField_3 = new javax.swing.JTextField();
        btnNewButton_1_1 = new javax.swing.JButton();
        comboBox_2 = new javax.swing.JComboBox<>();
        comboBox_1_1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        textField_7 = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textField_6 = new javax.swing.JTextField();
        lblNewLabel_3_1 = new javax.swing.JLabel();
        textField_5 = new javax.swing.JTextField();
        btnNewButton_1_2_1 = new javax.swing.JButton();
        btnNewButton = new javax.swing.JButton();
        btnNewButton_2_1 = new javax.swing.JButton();
        btnNewButton_2 = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        buttonBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kártyapakli készítő");

        contentPane.setBackground(new java.awt.Color(238, 254, 254));
        contentPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        contentPane.setMinimumSize(new java.awt.Dimension(1170, 630));
        contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        flabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(flabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 250, 120));

        textField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        panel.add(textField, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 248, 170));

        contentPane.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 270, 400));

        panel_1.setBackground(new java.awt.Color(255, 255, 255));
        panel_1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panel_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        flabel_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel_1.add(flabel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, 120));

        textField_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textField_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_1ActionPerformed(evt);
            }
        });
        panel_1.add(textField_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 248, 170));

        contentPane.add(panel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 270, 400));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Megoldás kártya");
        contentPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 40, 270, 30));

        lblNewLabel_3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lblNewLabel_3.setText("Pakli ID:");
        contentPane.add(lblNewLabel_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 60, 40));

        textField_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField_4ActionPerformed(evt);
            }
        });
        contentPane.add(textField_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 170, 40));

        btnNewButton_1_2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        btnNewButton_1_2.setText("Mutat");
        btnNewButton_1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewButton_1_2ActionPerformed(evt);
            }
        });
        contentPane.add(btnNewButton_1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 80, 30));

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arial", "Comic Sans MS", "Forte", "Lucida Console", "Script MT Bold", "Times New Roman" }));
        comboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        comboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxItemStateChanged(evt);
            }
        });
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });
        contentPane.add(comboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 120, -1));

        comboBox_1.setMaximumRowCount(10);
        comboBox_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12", "13", "15", "18", "20", "22", "24", "26" }));
        comboBox_1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBox_1ItemStateChanged(evt);
            }
        });
        comboBox_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBox_1ActionPerformed(evt);
            }
        });
        contentPane.add(comboBox_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 120, -1));

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setText("Matematikai kifejezés:");
        contentPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 160, 20));

        textField_2.setText("\\");
            textField_2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    textField_2ActionPerformed(evt);
                }
            });
            contentPane.add(textField_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 170, 30));

            btnNewButton_1.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
            btnNewButton_1.setText("Mutat");
            btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnNewButton_1ActionPerformed(evt);
                }
            });
            contentPane.add(btnNewButton_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 80, 30));

            jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
            jLabel6.setText("Matematikai kifejezés:");
            contentPane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 160, 20));

            textField_3.setText("\\");
                textField_3.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        textField_3ActionPerformed(evt);
                    }
                });
                contentPane.add(textField_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 110, 170, 30));

                btnNewButton_1_1.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
                btnNewButton_1_1.setText("Mutat");
                btnNewButton_1_1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnNewButton_1_1ActionPerformed(evt);
                    }
                });
                contentPane.add(btnNewButton_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 110, 80, 30));

                comboBox_2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arial", "Comic Sans MS", "Forte", "Lucida Console", "Script MT Bold", "Times New Roman" }));
                comboBox_2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
                comboBox_2.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        comboBox_2ItemStateChanged(evt);
                    }
                });
                comboBox_2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        comboBox_2ActionPerformed(evt);
                    }
                });
                contentPane.add(comboBox_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 180, 120, -1));

                comboBox_1_1.setMaximumRowCount(10);
                comboBox_1_1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "11", "12", "13", "15", "18", "20", "22", "24", "26" }));
                comboBox_1_1.addItemListener(new java.awt.event.ItemListener() {
                    public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        comboBox_1_1ItemStateChanged(evt);
                    }
                });
                contentPane.add(comboBox_1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 220, 120, -1));

                jLabel7.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
                jLabel7.setText("Ábra URL-je:");
                contentPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 330, 160, 20));

                textField_7.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        textField_7ActionPerformed(evt);
                    }
                });
                contentPane.add(textField_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 360, 170, 30));

                btnPrint.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
                btnPrint.setText("Nyomtatás");
                btnPrint.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnPrintActionPerformed(evt);
                    }
                });
                contentPane.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 540, 130, 40));

                jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
                jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel8.setText("Kérdés kártya");
                contentPane.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 270, 30));

                jLabel9.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
                jLabel9.setText("Ábra URL-je:");
                contentPane.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 160, 20));

                textField_6.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        textField_6ActionPerformed(evt);
                    }
                });
                contentPane.add(textField_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 170, 30));

                lblNewLabel_3_1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
                lblNewLabel_3_1.setText("Kártya név:");
                contentPane.add(lblNewLabel_3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 540, 80, 40));

                textField_5.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        textField_5ActionPerformed(evt);
                    }
                });
                contentPane.add(textField_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, 170, 40));

                btnNewButton_1_2_1.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
                btnNewButton_1_2_1.setText("Mutat");
                btnNewButton_1_2_1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnNewButton_1_2_1ActionPerformed(evt);
                    }
                });
                contentPane.add(btnNewButton_1_2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 360, 80, 30));

                btnNewButton.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
                btnNewButton.setText("Mentés");
                btnNewButton.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnNewButtonActionPerformed(evt);
                    }
                });
                contentPane.add(btnNewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 540, 130, 40));

                btnNewButton_2_1.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
                btnNewButton_2_1.setText("Szerkesztés");
                btnNewButton_2_1.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnNewButton_2_1ActionPerformed(evt);
                    }
                });
                contentPane.add(btnNewButton_2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 540, 130, 40));

                btnNewButton_2.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
                btnNewButton_2.setText("Másolás");
                btnNewButton_2.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnNewButton_2ActionPerformed(evt);
                    }
                });
                contentPane.add(btnNewButton_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 130, 40));

                username.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 18)); // NOI18N
                username.setForeground(new java.awt.Color(0, 63, 117));
                username.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                contentPane.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 350, 20));

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
                    .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1380, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPane, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                );

                pack();
            }// </editor-fold>//GEN-END:initComponents

    private void textField_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_1ActionPerformed

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldActionPerformed

    private void textField_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_4ActionPerformed

    private void btnNewButton_1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButton_1_2ActionPerformed
        String path = textField_6.getText();
        ImageIcon ti = new ImageIcon(path);

        flabel.setIcon(ti);
        panel.revalidate();
        panel.repaint();

    }//GEN-LAST:event_btnNewButton_1_2ActionPerformed

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed

    private void textField_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_2ActionPerformed

    private void btnNewButton_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButton_1ActionPerformed

        String math = textField_2.getText();

        TeXFormula fomule = new TeXFormula(math);

        TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, dbm.getFsize());
        BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(),
                BufferedImage.TYPE_4BYTE_ABGR);

        ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);

        flabel.setIcon(ti);
        panel.revalidate();
        panel.repaint();

    }//GEN-LAST:event_btnNewButton_1ActionPerformed

    private void textField_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_3ActionPerformed

    private void btnNewButton_1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButton_1_1ActionPerformed
        String math = textField_3.getText();

        TeXFormula fomule = new TeXFormula(math);

        TeXIcon ti = fomule.createTeXIcon(TeXConstants.STYLE_DISPLAY, dbm.getFsize1());
        BufferedImage b = new BufferedImage(ti.getIconWidth(), ti.getIconHeight(),
                BufferedImage.TYPE_4BYTE_ABGR);

        ti.paintIcon(new JLabel(), b.getGraphics(), 0, 0);

        flabel_1.setIcon(ti);
        panel_1.revalidate();
        panel_1.repaint();
    }//GEN-LAST:event_btnNewButton_1_1ActionPerformed

    private void comboBox_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_2ActionPerformed

    private void textField_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_7ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {

            dbm.PrintDeck(a, panel, panel_1, textField, textField_2, textField_1, textField_3, textField_5,
                    textField_6, textField_7, flabel, flabel_1, panel, panel_1);

        } catch (Throwable e1) {
            e1.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void textField_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_6ActionPerformed

    private void textField_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField_5ActionPerformed

    private void btnNewButton_1_2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButton_1_2_1ActionPerformed
        String path = textField_7.getText();
        ImageIcon ti = new ImageIcon(path);

        flabel_1.setIcon(ti);
        panel_1.revalidate();
        panel_1.repaint();

    }//GEN-LAST:event_btnNewButton_1_2_1ActionPerformed

    private void btnNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButtonActionPerformed
        if (textField.getText().isEmpty() && textField_1.getText().isEmpty()) {
            dbm.MS("A szövegdoboz üres. Írj be valamit!");
        } else {

            int did = Integer.parseInt(textField_4.getText());

            dbm.Insert(did, textField, textField_2, textField_1, textField_3, textField_5, textField_6,
                    textField_7);

        }
    }//GEN-LAST:event_btnNewButtonActionPerformed

    private void btnNewButton_2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButton_2_1ActionPerformed
        if (dbm.Update(textField, textField_2, textField_1, textField_3, textField_5, textField_6, textField_7) == true) {
            dispose();
            setVisible(false);
            Selector se = new Selector();
            se.setVisible(true);
        }
    }//GEN-LAST:event_btnNewButton_2_1ActionPerformed

    private void btnNewButton_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewButton_2ActionPerformed
        if (textField.getText().isEmpty() && textField_1.getText().isEmpty()) {
            dbm.MS("A szövegdoboz üres. Írj be valamit!");
        } else {

            int did = Integer.parseInt(textField_4.getText());

            dbm.Insert(did, textField, textField_2, textField_1, textField_3, textField_5, textField_6,
                    textField_7);
            dispose();
            setVisible(false);
            Selector se = new Selector();
            se.setVisible(true);

        }

    }//GEN-LAST:event_btnNewButton_2ActionPerformed

    private void comboBox_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBox_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBox_1ActionPerformed

    private void comboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            dbm.setFtype(String.valueOf(comboBox.getSelectedItem().toString()));
            String fontka = dbm.getFtype();
            textField.setFont(new Font(fontka, Font.PLAIN, 11));

            panel.revalidate();
            panel.repaint();
        }
    }//GEN-LAST:event_comboBoxItemStateChanged

    private void comboBox_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            dbm.setFsize(Integer.valueOf(comboBox_1.getSelectedItem().toString()));
            String fontka = dbm.getFtype();
            int sizeka = dbm.getFsize();
            textField.setFont(new Font(fontka, Font.PLAIN, sizeka));
            flabel.revalidate();
            flabel.repaint();
            panel.revalidate();
            panel.repaint();
        }
    }//GEN-LAST:event_comboBox_1ItemStateChanged

    private void comboBox_2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_2ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

            dbm.setFtype1(String.valueOf(comboBox_2.getSelectedItem().toString()));
            String fontka2 = dbm.getFtype1();
            textField_1.setFont(new Font(fontka2, Font.PLAIN, 11));

            panel_1.revalidate();
            panel_1.repaint();
        }
    }//GEN-LAST:event_comboBox_2ItemStateChanged

    private void comboBox_1_1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBox_1_1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            dbm.setFsize1(Integer.valueOf(comboBox_1_1.getSelectedItem().toString()));
            String fontka2 = dbm.getFtype1();
            int sizeka2 = dbm.getFsize1();
            textField_1.setFont(new Font(fontka2, Font.PLAIN, sizeka2));
            flabel_1.revalidate();
            flabel_1.repaint();
            panel_1.revalidate();
            panel_1.repaint();
        }
    }//GEN-LAST:event_comboBox_1_1ItemStateChanged

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        dispose();
        DeckCreate dc = new DeckCreate();
        dc.setVisible(true);
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
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewButton;
    private javax.swing.JButton btnNewButton_1;
    private javax.swing.JButton btnNewButton_1_1;
    private javax.swing.JButton btnNewButton_1_2;
    private javax.swing.JButton btnNewButton_1_2_1;
    private javax.swing.JButton btnNewButton_2;
    private javax.swing.JButton btnNewButton_2_1;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton buttonBack;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JComboBox<String> comboBox_1;
    private javax.swing.JComboBox<String> comboBox_1_1;
    private javax.swing.JComboBox<String> comboBox_2;
    private javax.swing.JPanel contentPane;
    private javax.swing.JLabel flabel;
    private javax.swing.JLabel flabel_1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblNewLabel_3;
    private javax.swing.JLabel lblNewLabel_3_1;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panel_1;
    private javax.swing.JTextField textField;
    private javax.swing.JTextField textField_1;
    private javax.swing.JTextField textField_2;
    private javax.swing.JTextField textField_3;
    private javax.swing.JTextField textField_4;
    private javax.swing.JTextField textField_5;
    private javax.swing.JTextField textField_6;
    private javax.swing.JTextField textField_7;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables
}
