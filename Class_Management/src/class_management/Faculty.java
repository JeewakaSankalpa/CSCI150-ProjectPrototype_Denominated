/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_management;

import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Kylef
 */
public class Faculty extends javax.swing.JPanel {

    int idx = 0;
    Vector<Vector<String>> data;
    Vector<String> header;
    Vector<String> passcollection;

    /**
     * Creates new form Falculty
     */
    public Faculty() {

        initComponents();
        System.out.println("Test");
        passcollection=new Vector<String>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFname = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        addPanel = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        doneButton = new javax.swing.JButton();
        addFNText = new javax.swing.JTextField();
        addLNText = new javax.swing.JTextField();
        addIDText = new javax.swing.JTextField();
        addAddressText = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        cmbAcessLvl = new javax.swing.JComboBox<>();
        txtPass1 = new javax.swing.JPasswordField();
        txtPass2 = new javax.swing.JPasswordField();
        txtMI = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        facultyTable = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();

        jLabel1.setText("Falculty ID");

        jLabel2.setText("Name");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnEdit.setText("Add");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        addPanel.setVisible(false);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        addFNText.setText("First Name");
        addFNText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addFNTextFocusGained(evt);
            }
        });
        addFNText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFNTextActionPerformed(evt);
            }
        });

        addLNText.setText("Last Name");
        addLNText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addLNTextFocusGained(evt);
            }
        });
        addLNText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLNTextActionPerformed(evt);
            }
        });

        addIDText.setText("ID #");
        addIDText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addIDTextFocusGained(evt);
            }
        });
        addIDText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIDTextActionPerformed(evt);
            }
        });

        addAddressText.setText("Address");
        addAddressText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addAddressTextFocusGained(evt);
            }
        });
        addAddressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAddressTextActionPerformed(evt);
            }
        });

        txtMobile.setText("Tele#");
        txtMobile.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMobileFocusGained(evt);
            }
        });
        txtMobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMobileActionPerformed(evt);
            }
        });

        cmbAcessLvl.setEditable(true);
        cmbAcessLvl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dean", "Lecturer", "Assistant", "Admin" }));

        txtPass1.setText("jPasswordField1");
        txtPass1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPass1FocusGained(evt);
            }
        });
        txtPass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass1ActionPerformed(evt);
            }
        });

        txtPass2.setText("jPasswordField2");
        txtPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPass2ActionPerformed(evt);
            }
        });

        txtMI.setText("Middle Initial");
        txtMI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMIFocusGained(evt);
            }
        });
        txtMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addPanelLayout.createSequentialGroup()
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(saveButton)
                                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(deleteButton)
                                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(addPanelLayout.createSequentialGroup()
                                .addComponent(addFNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(addLNText, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(doneButton)))
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(addIDText, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbAcessLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addFNText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addLNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addIDText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbAcessLvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(doneButton)
                            .addComponent(deleteButton)
                            .addComponent(saveButton)))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(addAddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61))
        );

        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(facultyTable);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFID, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear))
                    .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnSearch)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
         DefaultTableModel tm = (DefaultTableModel) facultyTable.getModel();
          Object[] data = new Object[]{addIDText.getText(), addFNText.getText(),addLNText.getText(),txtMI.getText(),
                        addAddressText.getText(),txtMobile.getText(),cmbAcessLvl.getSelectedItem().toString()};
//            facultyTable.setValueAt(, idx, 1);
//            facultyTable.setValueAt(, idx, 2);
//            facultyTable.setValueAt(, idx, 0);
//            facultyTable.setValueAt(, idx, 3);
//            facultyTable.setValueAt(, idx, 4);
//            facultyTable.setValueAt(, idx, 5);
//            //facultyTable.setValueAt(txtMI.getText(), idx, 6);
//            facultyTable.setValueAt(, idx, 6);
    tm.addRow(data);
    facultyTable.setModel(tm);
        facultyTable.setVisible(true);
        //System.err.println(txtPass1.getPassword().toString());
            passcollection.addElement(Arrays.toString(txtPass1.getPassword()));
            
        
        
        addFNText.setText("First Name");

        addLNText.setText("Last Name");

        addIDText.setText("ID #");

        addAddressText.setText("Address#");
        txtMobile.setText("Mobile#");

        txtMI.setText("Middle Initial");
        txtMobile.setText("Mobile#");
        txtPass1.setText("Password");
        txtPass2.setText("Password");
    }//GEN-LAST:event_saveButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        addFNText.setText("First Name");

        addLNText.setText("Last Name");

        addIDText.setText("ID #");

        addAddressText.setText("Address#");
        txtMobile.setText("Mobile#");

        txtMI.setText("Middle Initial");
        txtMobile.setText("Mobile#");
        txtPass1.setText("Password");
        txtPass2.setText("Password");
        DefaultTableModel model = (DefaultTableModel) facultyTable.getModel();
        int numRows = facultyTable.getSelectedRows().length;
        for (int i = 0; i < numRows; i++) {
            model.removeRow(facultyTable.getSelectedRow());
            --idx;
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        addPanel.setVisible(false);
        DBClass db = new DBClass();
        PreparedStatement pst;
        Connection conn;
        try {

            int rows = facultyTable.getRowCount();
            // Class.forName("com.mysql.jdbc.Driver").newInstance();
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ClassManager?zeroDateTimeBehavior=convertToNull");
            
            conn = db.getdbConnection();
            conn.setAutoCommit(false);
            String queryco = "INSERT INTO `Faculty` (`Faculty_ID`, `Faculty_First_Name`, `Faculty_Last_Name`, `Faculty_Middle_Initial`, `Faculty_Address_1`,  `Faculty_Mobile_No`, `AcessLevel`, `Password`) values (?,?,?,?,?,?,?,?)";
            pst = conn.prepareStatement(queryco);
            // INSERT INTO `ClassManager`.`Faculty` () VALUES (NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
            for (int row = 0; row < rows; row++) {

                String cofname = (String) facultyTable.getValueAt(row, 1);
                String colname = (String) facultyTable.getValueAt(row, 2);
                String coMI = (String) facultyTable.getValueAt(row, 3);
                String coID = (String) facultyTable.getValueAt(row, 0);
                String coAddress = (String) facultyTable.getValueAt(row, 4);
                String coMobileNo = (String) facultyTable.getValueAt(row, 5);
                String coAccesLevel = (String) facultyTable.getValueAt(row, 6);
                System.out.println("Done");
                String coPass = (String) passcollection.elementAt(row);
                System.out.println("Done1");
                pst.setString(2, cofname);
                pst.setString(3, colname);
                pst.setString(4, coMI);
                pst.setString(1, coID);
                pst.setString(5, coAddress);
                pst.setString(6, coMobileNo);
                pst.setString(7, coAccesLevel);
                pst.setString(8, coPass);
                
               pst.execute();
               conn.commit();
            }
            
            //conn.commit();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        //generating new a table with new database table
        DBClass dbengine = new DBClass();
        try {
            
            data = dbengine.getFaculty();
        } catch (Exception ex) {
            Logger.getLogger(Faculty.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        header = new Vector<String>();
        header.add("ID"); // ID
        header.add("First Name"); // first name
        header.add("Last Name"); // Last name
        header.add("Middle Initial"); // ID
        header.add("Address"); // Address
        header.add("Mobile Number");
        header.add("Access Level");
        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
                data, header
        ));
        
    }//GEN-LAST:event_doneButtonActionPerformed

    private void addAddressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAddressTextActionPerformed
        addAddressText.setText("");
    }//GEN-LAST:event_addAddressTextActionPerformed

    private void txtMobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMobileActionPerformed
        txtMobile.setText("");        // TODO add your handling code here:
    }//GEN-LAST:event_txtMobileActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    null},
                new String[]{
                    "ID", "First Name", "Last Name", "Middle Name", "Address", "Mobile No", "Access Level",}
        ));
        addPanel.setVisible(true);
        btnSearch.setEnabled(false);
        btnClear.setEnabled(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        facultyTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    null},
                new String[]{
                    "ID", "First Name", "Last Name", "Middle Name", "Address", "Mobile No", "Access Level",}
        )); // TODO add your handling code here:
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(facultyTable.getModel());
        facultyTable.setRowSorter(rowSorter);
        String fname = txtFname.getText();
        String fID = txtFID.getText();
        if (fname.trim().length() == 0 && fID.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else if (fID.trim().length() != 0) {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + fID));
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + fname));
        }// TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMIActionPerformed

    }//GEN-LAST:event_txtMIActionPerformed

    private void addFNTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFNTextActionPerformed

    }//GEN-LAST:event_addFNTextActionPerformed

    private void addLNTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLNTextActionPerformed

    }//GEN-LAST:event_addLNTextActionPerformed

    private void addIDTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIDTextActionPerformed

    }//GEN-LAST:event_addIDTextActionPerformed

    private void txtPass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass1ActionPerformed

    }//GEN-LAST:event_txtPass1ActionPerformed

    private void txtPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPass2ActionPerformed

    }//GEN-LAST:event_txtPass2ActionPerformed

    private void addFNTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addFNTextFocusGained
        addFNText.setText("");
    }//GEN-LAST:event_addFNTextFocusGained

    private void txtMIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMIFocusGained
        txtMI.setText("");
    }//GEN-LAST:event_txtMIFocusGained

    private void addLNTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addLNTextFocusGained
        addLNText.setText("");
    }//GEN-LAST:event_addLNTextFocusGained

    private void addIDTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addIDTextFocusGained
        addIDText.setText("");
    }//GEN-LAST:event_addIDTextFocusGained

    private void addAddressTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addAddressTextFocusGained
        addAddressText.setText("");
    }//GEN-LAST:event_addAddressTextFocusGained

    private void txtMobileFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMobileFocusGained
        txtMobile.setText("");
    }//GEN-LAST:event_txtMobileFocusGained

    private void txtPass1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPass1FocusGained
        txtPass1.setText("");
        txtPass2.setText("");
    }//GEN-LAST:event_txtPass1FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addAddressText;
    private javax.swing.JTextField addFNText;
    private javax.swing.JTextField addIDText;
    private javax.swing.JTextField addLNText;
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> cmbAcessLvl;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JTable facultyTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField txtFID;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtMI;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    // End of variables declaration//GEN-END:variables
}
