package class_management;

import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kylef
 */
public class Main extends javax.swing.JFrame {
    boolean accept = false;
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        Login.setAlwaysOnTop(true);
        Login.setVisible(true);
        Edit.setAlwaysOnTop(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        boxRemPass = new javax.swing.JCheckBox();
        bttLogin = new javax.swing.JButton();
        sucCess = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        passWord = new javax.swing.JPasswordField();
        Edit = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        idEdit = new javax.swing.JTextField();
        nameEdit = new javax.swing.JTextField();
        addressEdit = new javax.swing.JTextField();
        emailEdit = new javax.swing.JTextField();
        phoneEdit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblLVL = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        bttCollect = new javax.swing.JButton();
        bttAttendance = new javax.swing.JButton();
        bttSubject = new javax.swing.JButton();
        bttStudentInfo = new javax.swing.JButton();
        bttFalculty = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        fileLogin = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        editmenuFaculty = new javax.swing.JMenuItem();
        editmenuStudent = new javax.swing.JMenuItem();
        fileExit = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        Login.setMinimumSize(new java.awt.Dimension(400, 300));
        Login.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                LoginWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("LOGIN");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        boxRemPass.setText("Remember Login");

        bttLogin.setText("Login");
        bttLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login.getContentPane());
        Login.getContentPane().setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(bttLogin))
                    .addGroup(LoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(LoginLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(boxRemPass)
                            .addGroup(LoginLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(175, Short.MAX_VALUE))
            .addComponent(sucCess, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(passWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(boxRemPass)
                .addGap(18, 18, 18)
                .addComponent(bttLogin)
                .addGap(18, 18, 18)
                .addComponent(sucCess, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        Edit.setMinimumSize(new java.awt.Dimension(400, 300));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Add/Delete/Edit Students/Faculty");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("ID:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Email:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Phone:");

        emailEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailEditActionPerformed(evt);
            }
        });

        jButton1.setText("Add/Edit");

        jButton2.setText("Cancel");

        javax.swing.GroupLayout EditLayout = new javax.swing.GroupLayout(Edit.getContentPane());
        Edit.getContentPane().setLayout(EditLayout);
        EditLayout.setHorizontalGroup(
            EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditLayout.createSequentialGroup()
                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditLayout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel4))
                    .addGroup(EditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(EditLayout.createSequentialGroup()
                                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(idEdit)
                                    .addComponent(nameEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)))
                            .addGroup(EditLayout.createSequentialGroup()
                                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditLayout.createSequentialGroup()
                                        .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(EditLayout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(25, 25, 25)))
                                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(addressEdit)
                                        .addComponent(emailEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(EditLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        EditLayout.setVerticalGroup(
            EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(EditLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(EditLayout.createSequentialGroup()
                        .addComponent(idEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(emailEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addressEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(phoneEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(0, 253, Short.MAX_VALUE))
        );

        lblLVL.setText("jLabel10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        bttCollect.setBackground(bttAttendance.getBackground());
        bttCollect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Business-Collect-icon.png"))); // NOI18N
        bttCollect.setToolTipText("Collect Attendance");
        bttCollect.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bttCollectFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bttCollectFocusLost(evt);
            }
        });
        bttCollect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttCollectMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttCollectMouseEntered(evt);
            }
        });
        bttCollect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttCollectActionPerformed(evt);
            }
        });

        bttAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Actions-view-pim-tasks-icon.png"))); // NOI18N
        bttAttendance.setToolTipText("Attendance Records");
        bttAttendance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttAttendanceMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttAttendanceMouseEntered(evt);
            }
        });
        bttAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttAttendanceActionPerformed(evt);
            }
        });

        bttSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Mimetypes-gnome-mime-application-rhythmbox-playlist-icon.png"))); // NOI18N
        bttSubject.setToolTipText("Subject");
        bttSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttSubjectMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttSubjectMouseEntered(evt);
            }
        });
        bttSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSubjectActionPerformed(evt);
            }
        });

        bttStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Teacher-icon.png"))); // NOI18N
        bttStudentInfo.setToolTipText("Student Info");
        bttStudentInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttStudentInfoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttStudentInfoMouseEntered(evt);
            }
        });
        bttStudentInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttStudentInfoActionPerformed(evt);
            }
        });

        bttFalculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Teachers-icon.png"))); // NOI18N
        bttFalculty.setToolTipText("Falculty");
        bttFalculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bttFalcultyMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bttFalcultyMouseEntered(evt);
            }
        });
        bttFalculty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttFalcultyActionPerformed(evt);
            }
        });

        lblName.setText("Please LogIn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bttSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bttStudentInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttCollect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttFalculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblName))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bttAttendance, bttCollect, bttFalculty, bttStudentInfo, bttSubject});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttCollect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttAttendance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttSubject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttStudentInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttFalculty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblName)
                .addGap(21, 21, 21))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        mainPanel.setLayout(new java.awt.BorderLayout());
        jSplitPane1.setRightComponent(mainPanel);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");
        fileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileMenuActionPerformed(evt);
            }
        });

        fileLogin.setMnemonic('o');
        fileLogin.setText("Login");
        fileLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileLoginActionPerformed(evt);
            }
        });
        fileMenu.add(fileLogin);

        menuEdit.setText("Edit");

        editmenuFaculty.setText("Faculty");
        menuEdit.add(editmenuFaculty);

        editmenuStudent.setText("Students");
        menuEdit.add(editmenuStudent);

        fileMenu.add(menuEdit);

        fileExit.setMnemonic('x');
        fileExit.setText("Exit");
        fileExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileExitActionPerformed(evt);
            }
        });
        fileMenu.add(fileExit);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fileExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_fileExitActionPerformed

    private void bttCollectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttCollectActionPerformed
        // TODO add your handling code here:
        JFrame collect = new Collection();
        collect.setAlwaysOnTop(true);
        collect.setVisible(true);

    }//GEN-LAST:event_bttCollectActionPerformed

    private void bttAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttAttendanceActionPerformed
        // TODO add your handling code here:
        JPanel attPanel = new Attendance();
        jSplitPane1.setRightComponent(attPanel);
        attPanel.setVisible(true);
    }//GEN-LAST:event_bttAttendanceActionPerformed

    private void bttSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSubjectActionPerformed
        // TODO add your handling code here:
        JPanel subjectPanel = new Subject();
        jSplitPane1.setRightComponent(subjectPanel);
        subjectPanel.setVisible(true);
    }//GEN-LAST:event_bttSubjectActionPerformed

    private void bttStudentInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttStudentInfoActionPerformed
        // TODO add your handling code here:
        JPanel stuInfoPanel;
        try {
            stuInfoPanel = new StudentInfo();
            jSplitPane1.setRightComponent(stuInfoPanel);
        stuInfoPanel.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bttStudentInfoActionPerformed

    private void bttFalcultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttFalcultyActionPerformed
        // TODO add your handling code here:
        JPanel falcultyPanel = new Faculty();
        jSplitPane1.setRightComponent(falcultyPanel);
        falcultyPanel.setVisible(true);
    }//GEN-LAST:event_bttFalcultyActionPerformed

    private void bttLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttLoginActionPerformed
        // TODO add your handling code here:
        accept = false;
        DBClass db = new DBClass();
        Connection con;
        ResultSet rs;
        String ID = userName.getText();
        
        String pass = Arrays.toString(passWord.getPassword());
        if(ID.equals("Admin")){
            accept = true;
                lblName.setText("Admin");
                lblLVL.setText("Admin");
                Login.dispose();
        }else{
        try {
            con = db.getdbConnection();
            PreparedStatement pre = con.prepareStatement("select * from Faculty where Faculty_ID =" + ID + "");
            rs = pre.executeQuery();
            if(rs.first()){
                System.out.println(rs.getString(8) +"   ::: "+pass);
            if (rs.getString(8).equals(pass)) {
                
                
                accept = true;
                lblName.setText(rs.getString(2));
                lblLVL.setText(rs.getString(7));
                Login.dispose();
            } else {
                sucCess.setText(" password Missmatch");
            }
            }else{
                sucCess.setText(" UserName not Found");
            }
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        }
    }//GEN-LAST:event_bttLoginActionPerformed

    private void fileLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileLoginActionPerformed
        // TODO add your handling code here:
        Login.setVisible(true);
    }//GEN-LAST:event_fileLoginActionPerformed

    private void emailEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailEditActionPerformed

    private void fileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileMenuActionPerformed
        // TODO add your handling code here:
        Edit.setVisible(true);
    }//GEN-LAST:event_fileMenuActionPerformed

    private void LoginWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_LoginWindowClosed
        if(!accept){
            Close();
        }
        
    }//GEN-LAST:event_LoginWindowClosed

    private void bttCollectFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bttCollectFocusGained
        //bttCollect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Business-Collect-iconLarge.png")));// TODO add your handling code here:
    }//GEN-LAST:event_bttCollectFocusGained

    private void bttCollectFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bttCollectFocusLost
        //bttCollect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Business-Collect-icon.png")));
    }//GEN-LAST:event_bttCollectFocusLost

    private void bttCollectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCollectMouseEntered
        bttCollect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Business-Collect-iconLarge.png")));
    }//GEN-LAST:event_bttCollectMouseEntered

    private void bttCollectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttCollectMouseExited
        bttCollect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Business-Collect-icon.png")));
    }//GEN-LAST:event_bttCollectMouseExited

    private void bttAttendanceMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttAttendanceMouseEntered
        bttAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Actions-view-pim-tasks-iconLarge.png"))); // NOI18N
       
    }//GEN-LAST:event_bttAttendanceMouseEntered

    private void bttAttendanceMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttAttendanceMouseExited
        bttAttendance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Actions-view-pim-tasks-icon.png"))); // NOI18N
       
    }//GEN-LAST:event_bttAttendanceMouseExited

    private void bttSubjectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttSubjectMouseEntered
bttSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Mimetypes-gnome-mime-application-rhythmbox-playlist-iconLarge.png"))); // NOI18N        // TODO add your handling code here:
    }//GEN-LAST:event_bttSubjectMouseEntered

    private void bttSubjectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttSubjectMouseExited
       bttSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Mimetypes-gnome-mime-application-rhythmbox-playlist-icon.png"))); // NOI18N
    }//GEN-LAST:event_bttSubjectMouseExited

    private void bttStudentInfoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttStudentInfoMouseExited
        bttStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Teacher-icon.png"))); // TODO add your handling code here:
    }//GEN-LAST:event_bttStudentInfoMouseExited

    private void bttStudentInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttStudentInfoMouseEntered
       bttStudentInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Teacher-iconLarge.png")));         // TODO add your handling code here:
    }//GEN-LAST:event_bttStudentInfoMouseEntered

    private void bttFalcultyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttFalcultyMouseEntered
        bttFalculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Teachers-iconLarge.png"))); // NOI18N
// TODO add your handling code here:
    }//GEN-LAST:event_bttFalcultyMouseEntered

    private void bttFalcultyMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttFalcultyMouseExited
        bttFalculty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/class_management/Teachers-icon.png"))); // NOI18N
// TODO add your handling code here:
    }//GEN-LAST:event_bttFalcultyMouseExited

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }
    void Close(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Edit;
    private javax.swing.JDialog Login;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JTextField addressEdit;
    private javax.swing.JCheckBox boxRemPass;
    private javax.swing.JButton bttAttendance;
    private javax.swing.JButton bttCollect;
    private javax.swing.JButton bttFalculty;
    private javax.swing.JButton bttLogin;
    private javax.swing.JButton bttStudentInfo;
    private javax.swing.JButton bttSubject;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem editmenuFaculty;
    private javax.swing.JMenuItem editmenuStudent;
    private javax.swing.JTextField emailEdit;
    private javax.swing.JMenuItem fileExit;
    private javax.swing.JMenuItem fileLogin;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JTextField idEdit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblLVL;
    private javax.swing.JLabel lblName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JTextField nameEdit;
    private javax.swing.JPasswordField passWord;
    private javax.swing.JTextField phoneEdit;
    private javax.swing.JLabel sucCess;
    private javax.swing.JTextField userName;
    // End of variables declaration//GEN-END:variables

}
