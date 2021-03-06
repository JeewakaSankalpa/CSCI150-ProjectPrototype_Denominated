/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class_management;

import com.google.gson.Gson;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author jeewaka
 */
public class Collection extends javax.swing.JFrame implements MqttCallback {

    static MqttClient client;
    String ip, ctopic;
    Vector<String> attendaceRecords = new Vector<String>();
    Connection con;
    Vector<String> SIDs;
    String ClassID;

    /**
     * Creates new form Collection
     */
    public Collection() {
        initComponents();
        DBClass db = new DBClass();
        db.getClass();
        try {
            con = db.getdbConnection();

        } catch (Exception ex) {
            Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtCID = new javax.swing.JTextField();
        bttSearch = new javax.swing.JButton();
        bttEnd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        bttStart = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtFlagged = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        lblSecCode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel1formComponentAdded(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Attendence"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Class");

        bttSearch.setText("Search");

        bttEnd.setText("End");
        bttEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttEndActionPerformed(evt);
            }
        });

        jLabel2.setText("Code:");

        bttStart.setText("Start");
        bttStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttStartActionPerformed(evt);
            }
        });

        txtFlagged.setColumns(20);
        txtFlagged.setRows(5);
        jScrollPane2.setViewportView(txtFlagged);

        jLabel3.setText("Security Code Errors");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCID, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSecCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttEnd)
                .addGap(171, 171, 171))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bttSearch)
                        .addComponent(bttStart)
                        .addComponent(bttEnd))
                    .addComponent(lblSecCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttEndActionPerformed
        bttStart.setEnabled(true);
        int rows = jTable1.getRowCount();
        try {
            DBClass db = new DBClass();
            Connection conn = db.getdbConnection();
            conn.setAutoCommit(false);
            String queryco = "INSERT INTO `ClassManager`.`Attendance` (`Date`, `Class_Classs_ID`, `Attendance`, `Student_Student_ID`) VALUES (?, ?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(queryco);
            Date date1 = new Date();
            java.sql.Date dNow = (java.sql.Date) new java.sql.Date(date1.getTime());
            String classID = txtCID.getText();

            for (int row = 0; row < rows; row++) {

                String SID = (String) jTable1.getValueAt(row, 0);

                boolean Att = (boolean) jTable1.getValueAt(row, 1);

                pst.setDate(1, dNow);
                pst.setString(2, txtCID.getText());
                pst.setBoolean(3, Att);
                pst.setString(4, SID);

                pst.execute();
                conn.commit();
            }

            for (int i = 0; i < SIDs.size(); i++) {
                if (!attendaceRecords.contains(SIDs.elementAt(i))) {
                    pst.setDate(1, dNow);
                    pst.setString(2, txtCID.getText());
                    pst.setBoolean(3, false);
                    pst.setString(4, SIDs.elementAt(i));

                    pst.execute();
                    conn.commit();
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, null, ex);
        }
this.dispose();
    }//GEN-LAST:event_bttEndActionPerformed

    private void bttStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttStartActionPerformed

        if (txtCID.getText().trim().length() == 6) {
            bttStart.setEnabled(false);
            ClassID = txtCID.getText();
            lblSecCode.setText("ABC3D");
            try {

                try {
                    ip = JOptionPane.showInputDialog(this, "Enter the IP adreess");

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                client = new MqttClient("tcp://" + ip, UUID.randomUUID().toString());// Change the IP Address
                                try {
                                    client.connect();
                                } catch (MqttException ex) {
                                    Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                client.setCallback(Collection.this);
                                if (client.isConnected()) {
                                    JOptionPane.showMessageDialog(Collection.this, "Connected to Server ", "Connection Successful!!!", JOptionPane.INFORMATION_MESSAGE);
                                    attendaceRecords = new Vector();
                                } else {
                                    JOptionPane.showMessageDialog(Collection.this, "Failed to Connect to Server ", "Connection Failed!!!", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } catch (MqttException ex) {
                                Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }).run();

                    // subscriber program subscribes to the same topic to which all android devices are publishing
                    client.subscribe("HOME/"+txtCID.getText());

                    Thread.sleep(100);

                } catch (MqttException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                SIDs = new Vector<String>();
                DBClass db = new DBClass();
                Connection cn = db.getdbConnection();
                PreparedStatement pre = cn.prepareStatement("select 'Student_Student_ID' from Shedule where Class_Classs_ID = " + ClassID + " ORDER BY Student_Student_ID");

                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    SIDs.add(rs.getString(1));
                }
            } catch (Exception ex) {
                Logger.getLogger(Collection.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(this, "Class ID does not MAtch!", "ID Mismatch", HEIGHT);
        }
    }//GEN-LAST:event_bttStartActionPerformed

    private void jPanel1formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel1formComponentAdded

    }//GEN-LAST:event_jPanel1formComponentAdded

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
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Collection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Collection().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttEnd;
    private javax.swing.JButton bttSearch;
    private javax.swing.JButton bttStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblSecCode;
    private javax.swing.JTextField txtCID;
    private javax.swing.JTextArea txtFlagged;
    // End of variables declaration//GEN-END:variables

    @Override
    public void connectionLost(Throwable thrwbl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void messageArrived(String string, MqttMessage mm) throws Exception {
        Message msg = new Gson().fromJson(new String(mm.getPayload()), Message.class);
        //System.out.println(msg.getClassID());
        //  attendaceRecords.add(msg.getMessage())
        updateTable(msg.getStudentID(), msg.getDeviceID(),msg.getSecurityCode());
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken imdt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void updateTable(String StudentID, String DeviceID,String SecurityCode) {
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        if (!attendaceRecords.contains(StudentID)) {
            if(SecurityCode.equals(lblSecCode.getText())){
                attendaceRecords.add(StudentID);
            Object[] data = new Object[]{StudentID, true};
            tm.addRow(data);
            jTable1.setModel(tm);
            jTable1.setVisible(true);
            }else{
                txtFlagged.setText(txtFlagged.getText()+StudentID+"\n");
            }
            
        }

        //String[] rowdata = {msg.getMessage(),msg.getMessage(),"",""};
    }
}
