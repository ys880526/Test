/* 
 * Copyright (C) 2015 Open Source Parking Inc.(www.osparking.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.osparking.vehicle.driver;

import com.osparking.vehicle.VehiclesForm;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.sql.Connection;
import static com.osparking.global.names.DB_Access.readSettings;
import com.osparking.global.Globals;
import static com.osparking.global.Globals.OSPiconList;
import static com.osparking.global.Globals.SetAColumnWidth;
import static com.osparking.global.Globals.checkOptions;
import static com.osparking.global.Globals.font_Size;
import static com.osparking.global.Globals.font_Style;
import static com.osparking.global.Globals.font_Type;
import static com.osparking.global.Globals.initializeLoggers;
import static com.osparking.global.Globals.logParkingException;
import static com.osparking.global.names.JDBCMySQL.getConnection;

/**
 *
 * @author Open Source Parking Inc.
 */
public class DriverSelection extends javax.swing.JFrame {
    final static int NAME = 1;
    final static int CELL = 2;
    final static int PHONE = 3;
    final static int SEQ_NO = 4;
    
    VehiclesForm vehicleForm = null;
    int seqNo = 0;
    /**
     * Creates new form DriverSelection
     */
    public DriverSelection(VehiclesForm vehicleForm, int seqNo) {
        this.vehicleForm = vehicleForm;
        if (vehicleForm != null)
            vehicleForm.setEnabled(false);
        this.seqNo = seqNo;
        initComponents();
        setIconImages(OSPiconList);
        
        adjustSkinnyTable();
        loadSkinnyDriverTable(seqNo);
        attachEnterHandler(searchName);
        attachEnterHandler(searchCell);      
        searchName.requestFocus();
        searchName.selectAll();
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wholePanel = new javax.swing.JPanel();
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel2 = new javax.swing.JPanel();
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(100, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        closeFormButton = new javax.swing.JButton();
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler23 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel3 = new javax.swing.JPanel();
        filler11 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler9 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        clearButton = new javax.swing.JButton();
        filler22 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        searchButton = new javax.swing.JButton();
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel1 = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jLabel3 = new javax.swing.JLabel();
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(10, 32767));
        searchName = new javax.swing.JTextField();
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(5, 0), new java.awt.Dimension(10, 32767));
        searchCell = new javax.swing.JTextField();
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jPanel4 = new javax.swing.JPanel();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        skinnyDriverTable = new javax.swing.JTable();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        jPanel5 = new javax.swing.JPanel();
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        manageDriversButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        fixDriverButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 0), new java.awt.Dimension(10, 32767));
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find Driver");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        wholePanel.setLayout(new javax.swing.BoxLayout(wholePanel, javax.swing.BoxLayout.PAGE_AXIS));
        wholePanel.add(filler19);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));
        jPanel2.add(filler14);

        jLabel1.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Find Driver");
        jLabel1.setMaximumSize(new java.awt.Dimension(120, 28));
        jLabel1.setMinimumSize(new java.awt.Dimension(120, 28));
        jLabel1.setPreferredSize(new java.awt.Dimension(120, 28));
        jPanel2.add(jLabel1);
        jPanel2.add(filler16);

        closeFormButton.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        closeFormButton.setMnemonic('c');
        closeFormButton.setText("Close");
        closeFormButton.setToolTipText("");
        closeFormButton.setMaximumSize(new java.awt.Dimension(90, 40));
        closeFormButton.setMinimumSize(new java.awt.Dimension(90, 40));
        closeFormButton.setPreferredSize(new java.awt.Dimension(90, 40));
        closeFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeFormButtonActionPerformed(evt);
            }
        });
        closeFormButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                closeFormButtonKeyReleased(evt);
            }
        });
        jPanel2.add(closeFormButton);
        jPanel2.add(filler12);

        wholePanel.add(jPanel2);
        wholePanel.add(filler23);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));
        jPanel3.add(filler11);
        jPanel3.add(filler9);

        clearButton.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        clearButton.setMnemonic('l');
        clearButton.setText("Clear");
        clearButton.setToolTipText("");
        clearButton.setMaximumSize(new java.awt.Dimension(90, 40));
        clearButton.setMinimumSize(new java.awt.Dimension(90, 40));
        clearButton.setPreferredSize(new java.awt.Dimension(90, 40));
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jPanel3.add(clearButton);
        jPanel3.add(filler22);

        searchButton.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        searchButton.setMnemonic('s');
        searchButton.setText("Search");
        searchButton.setMaximumSize(new java.awt.Dimension(90, 40));
        searchButton.setMinimumSize(new java.awt.Dimension(90, 40));
        searchButton.setPreferredSize(new java.awt.Dimension(90, 40));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        searchButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchButtonKeyReleased(evt);
            }
        });
        jPanel3.add(searchButton);
        jPanel3.add(filler10);

        wholePanel.add(jPanel3);
        wholePanel.add(filler20);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(filler5);

        jLabel3.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Key :");
        jLabel3.setMaximumSize(new java.awt.Dimension(30, 28));
        jLabel3.setPreferredSize(new java.awt.Dimension(57, 28));
        jPanel1.add(jLabel3);
        jPanel1.add(filler6);

        searchName.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        searchName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchName.setText("(Owner Name)");
        searchName.setToolTipText("Search Name");
        searchName.setMinimumSize(new java.awt.Dimension(6, 28));
        searchName.setPreferredSize(new java.awt.Dimension(82, 28));
        searchName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchNameFocusLost(evt);
            }
        });
        searchName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchNameMousePressed(evt);
            }
        });
        jPanel1.add(searchName);
        jPanel1.add(filler7);

        searchCell.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        searchCell.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        searchCell.setText("(Cell Phone)");
        searchCell.setToolTipText("Search CellPhone");
        searchCell.setMinimumSize(new java.awt.Dimension(6, 28));
        searchCell.setPreferredSize(new java.awt.Dimension(110, 28));
        searchCell.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchCellFocusLost(evt);
            }
        });
        searchCell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchCellMousePressed(evt);
            }
        });
        jPanel1.add(searchCell);
        jPanel1.add(filler8);

        wholePanel.add(jPanel1);

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(filler4);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 93));

        skinnyDriverTable.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        skinnyDriverTable.getTableHeader().setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        skinnyDriverTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order", "Owner Name", "Cell Phone", "Phone No.", "SEQ_NO"
            })
            {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            }
        );
        skinnyDriverTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                skinnyDriverTableMouseClicked(evt);
            }
        });
        skinnyDriverTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                skinnyDriverTableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(skinnyDriverTable);

        jPanel4.add(jScrollPane1);
        jPanel4.add(filler3);

        wholePanel.add(jPanel4);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));
        jPanel5.add(filler21);

        manageDriversButton.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        manageDriversButton.setMnemonic('m');
        manageDriversButton.setText("Manage");
        manageDriversButton.setToolTipText("");
        manageDriversButton.setMaximumSize(new java.awt.Dimension(90, 40));
        manageDriversButton.setMinimumSize(new java.awt.Dimension(90, 40));
        manageDriversButton.setPreferredSize(new java.awt.Dimension(90, 40));
        manageDriversButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDriversButtonActionPerformed(evt);
            }
        });
        manageDriversButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                manageDriversButtonKeyReleased(evt);
            }
        });
        jPanel5.add(manageDriversButton);
        jPanel5.add(filler1);

        fixDriverButton.setFont(new java.awt.Font(font_Type, font_Style, font_Size));
        fixDriverButton.setMnemonic('t');
        fixDriverButton.setText("Select");
        fixDriverButton.setToolTipText("");
        fixDriverButton.setMaximumSize(new java.awt.Dimension(90, 40));
        fixDriverButton.setMinimumSize(new java.awt.Dimension(90, 40));
        fixDriverButton.setPreferredSize(new java.awt.Dimension(90, 40));
        fixDriverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fixDriverButtonActionPerformed(evt);
            }
        });
        fixDriverButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fixDriverButtonKeyReleased(evt);
            }
        });
        jPanel5.add(fixDriverButton);
        jPanel5.add(filler2);

        wholePanel.add(jPanel5);
        wholePanel.add(filler15);

        getContentPane().add(wholePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        loadSkinnyDriverTable(seqNo);
    }//GEN-LAST:event_searchButtonActionPerformed

    private void skinnyDriverTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_skinnyDriverTableMouseClicked
        if (evt.getClickCount() == 2) {
            // change parent form and close this form itself
            assignDriverToVehicle();
        }
    }//GEN-LAST:event_skinnyDriverTableMouseClicked

    private void skinnyDriverTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_skinnyDriverTableKeyTyped
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            assignDriverToVehicle();
        }
    }//GEN-LAST:event_skinnyDriverTableKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (vehicleForm != null){
            vehicleForm.setEnabled(true);
            vehicleForm.requestFocus();
        }
    }//GEN-LAST:event_formWindowClosing

    private void manageDriversButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDriversButtonActionPerformed
        ManageDrivers driverManageForm = new ManageDrivers(this);
        driverManageForm.setVisible(true);
    }//GEN-LAST:event_manageDriversButtonActionPerformed

    private void closeFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeFormButtonActionPerformed
        if (vehicleForm != null){
            vehicleForm.setEnabled(true);
            vehicleForm.requestFocus();
        }
        dispose();
    }//GEN-LAST:event_closeFormButtonActionPerformed

    private void fixDriverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fixDriverButtonActionPerformed
        assignDriverToVehicle();
    }//GEN-LAST:event_fixDriverButtonActionPerformed

    private void manageDriversButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_manageDriversButtonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            ManageDrivers driverManageForm = new ManageDrivers(this);
            driverManageForm.setVisible(true);
        }
    }//GEN-LAST:event_manageDriversButtonKeyReleased

    private void searchButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchButtonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            loadSkinnyDriverTable(seqNo);        
        }
    }//GEN-LAST:event_searchButtonKeyReleased

    private void closeFormButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_closeFormButtonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            if (vehicleForm != null){
                vehicleForm.setEnabled(true);
                vehicleForm.requestFocus();
            }
            dispose();            
        }
    }//GEN-LAST:event_closeFormButtonKeyReleased

    private void fixDriverButtonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fixDriverButtonKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            assignDriverToVehicle();
        }        
    }//GEN-LAST:event_fixDriverButtonKeyReleased

    private void searchNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchNameFocusLost
        if(searchName.getText().trim().equals(""))
            searchName.setText("(Owner Name)");
    }//GEN-LAST:event_searchNameFocusLost

    private void searchCellFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchCellFocusLost
        if(searchCell.getText().trim().equals(""))
            searchCell.setText("(Cell Phone)");
    }//GEN-LAST:event_searchCellFocusLost

    private void searchNameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchNameMousePressed
        searchName.selectAll();
    }//GEN-LAST:event_searchNameMousePressed

    private void searchCellMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchCellMousePressed
        searchCell.selectAll();
    }//GEN-LAST:event_searchCellMousePressed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        searchName.setText("(Owner Name)");
        searchCell.setText("(Cell Phone)");
        skinnyDriverTable.requestFocus();
    }//GEN-LAST:event_clearButtonActionPerformed

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
            java.util.logging.Logger.getLogger(DriverSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DriverSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DriverSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DriverSelection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        initializeLoggers();
        checkOptions(args);
        readSettings();        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DriverSelection(null, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton clearButton;
    public javax.swing.JButton closeFormButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler11;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler22;
    private javax.swing.Box.Filler filler23;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.Box.Filler filler9;
    public javax.swing.JButton fixDriverButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manageDriversButton;
    public javax.swing.JButton searchButton;
    private javax.swing.JTextField searchCell;
    private javax.swing.JTextField searchName;
    private javax.swing.JTable skinnyDriverTable;
    private javax.swing.JPanel wholePanel;
    // End of variables declaration//GEN-END:variables

    public void loadSkinnyDriverTable(int seqNo) {
        
        Connection conn = null;
        Statement selectStmt = null;
        ResultSet rs = null;
        DefaultTableModel model = null;
        
        String excepMsg = "(While loading vehicle driver list)";
        int highlightRow = -1;
        int currentRow = 0;   
            
        try {
            // <editor-fold defaultstate="collapsed" desc="-- load car driver list">                          
            conn = getConnection();
            selectStmt = conn.createStatement();
            
            StringBuilder sb = new StringBuilder(); 
            sb.append("SELECT @recNo := @recNo + 1 recNo, A.* ");
            sb.append("From (select name, CELLPHONE, Phone, SEQ_NO ");
            sb.append("  from cardriver order by NAME, CELLPHONE) A, ");
            sb.append("  (SELECT @recNo := 0) tmp ");
            String condition = formSearchCondition();
            sb.append(condition);
        
            rs = selectStmt.executeQuery(sb.toString());
            
            model = (DefaultTableModel) skinnyDriverTable.getModel();  
            model.setRowCount(0);
            while (rs.next()) {               
                //<editor-fold defaultstate="collapsed" desc="-- construct a skinny driver info'"> 
                model.addRow(new Object[] {
                     rs.getInt("recNo"),   rs.getString("name"), rs.getString("CELLPHONE"),
                     rs.getString("PHONE"), rs.getInt("SEQ_NO")
                });
                // non-zero seqNo means highlight the driver with the sequence number
                if (seqNo != 0 && seqNo == (Integer)rs.getInt("SEQ_NO")) {
                    highlightRow = currentRow;
                }
                currentRow++;
                //</editor-fold>
            }
            //</editor-fold>
        } catch (SQLException ex) {
            logParkingException(Level.SEVERE, ex, excepMsg);
        } finally {
            Globals.closeDBstuff(conn, selectStmt, rs, excepMsg);
        }
        if (highlightRow != -1 && model.getRowCount() > 0) {
            skinnyDriverTable.setRowSelectionInterval(highlightRow, highlightRow);
            skinnyDriverTable.requestFocus();
        }
    }

    private void adjustSkinnyTable() {
        // Hide drivers table sequence number which is used by only inside the code
        TableColumnModel skinnyModel = skinnyDriverTable.getColumnModel();
        
        // <editor-fold defaultstate="collapsed" desc="-- Adjust Column Width ">                    
        SetAColumnWidth(skinnyModel.getColumn(0), 60, 60, 60); // 0: row number
        SetAColumnWidth(skinnyModel.getColumn(NAME), 120, 120, 120); // 1: driver name
        SetAColumnWidth(skinnyModel.getColumn(CELL), 150, 150, 150); // 2: cell phone
        //</editor-fold>        
        // <editor-fold defaultstate="collapsed" desc="-- Hide Some Columns">                         
        skinnyModel.removeColumn(skinnyModel.getColumn(SEQ_NO));
        skinnyModel.removeColumn(skinnyModel.getColumn(PHONE));
        //</editor-fold>        
        skinnyDriverTable.setSelectionMode(
                ListSelectionModel.SINGLE_INTERVAL_SELECTION);  
        
        // <editor-fold defaultstate="collapsed" desc="-- Adjust Column Width ">        
        Action handleEnter = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                assignDriverToVehicle();
            }
        };
        JComponent compo = (JComponent) skinnyDriverTable;
        compo.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "handleEnter");
        compo.getActionMap().put("handleEnter", handleEnter);        
        //</editor-fold>                
    }

    private void attachEnterHandler(JComponent compo) {
        Action handleEnter = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                loadSkinnyDriverTable(seqNo);
            }
        };
        compo.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "handleEnter");
        compo.getActionMap().put("handleEnter", handleEnter);
    }    
    
    private String formSearchCondition() {
        StringBuffer cond = new StringBuffer();
        if(!searchName.getText().trim().equals("(Owner Name)"))
            attachCondition(cond, "name", searchName.getText().trim());
        if(!searchCell.getText().trim().equals("(Cell Phone)"))
            attachCondition(cond, "cellphone", searchCell.getText().trim());
        
        return cond.length() > 0 ? "Where " + cond.toString() : "";
    }
    
    private void attachCondition(StringBuffer cond, String column, String content) {
        if (content.length() > 0) {
            if (cond.length() > 0)
                cond.append(" and ");
            cond.append(column + " like '%" + content + "%' ");
        }            
    }      

    private void assignDriverToVehicle() {
        setVisible(false);
        dispose();    
        
        if (vehicleForm != null) {
            int row = skinnyDriverTable.getSelectedRow();
            String cell = (String) skinnyDriverTable.getModel().getValueAt(row, CELL);
            String phone = (String) skinnyDriverTable.getModel().getValueAt(row, PHONE);
            int seqNo = (Integer) skinnyDriverTable.getModel().getValueAt(row, SEQ_NO);
            String name = (String)skinnyDriverTable.getModel().getValueAt(row, NAME);
            vehicleForm.setDriverInfo(name, cell, phone, seqNo);
            vehicleForm.setEnabled(true);
            vehicleForm.requestFocus();
        }
    }
}
