/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableModel;


/**``
 *
 * @author rumia
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBook
     */
    
    String studentName,course,branch;
    int studentId;
    DefaultTableModel Model;
  
    public ManageStudents() {
        initComponents();
         setStudentDetailsToTable();
       
    }

    
    public void setStudentDetailsToTable(){
        
        try {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("select * from student_details");
        
          
          while(rs.next()){
               String studentId = rs.getString("student_id");
               String studentName = rs.getString("name");
               String course = rs.getString("course");
               String branch = rs.getString("branch");
               
               Object[] obj = {studentId,studentName,course,branch};
               
              DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
               model.addRow(obj);
               
          }
        } catch (Exception e) {
            e.printStackTrace();
        }   
}
    
    
    public boolean addStudent(){
        boolean isAdded = false;
      studentId   = Integer.parseInt(txt_studentId.getText());
      studentName = txt_studentName.getText();
      course = combo_CourseName.getSelectedItem().toString();
      branch = combo_branch.getSelectedItem().toString();
      
        try {
            Connection con = DBConnection.getConnection();
            String sql = "Insert into student_details values (?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,studentId);
            pst.setString(2,studentName);
            pst.setString(3,course);
            pst.setString(4,branch );
            
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                isAdded = true;  
            }else{
                isAdded = false;
            }
         
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        return isAdded;
   
    }
    
    public boolean updateStudent(){
        boolean isUpdated = false;
      studentId   = Integer.parseInt(txt_studentId.getText());
      studentName = txt_studentName.getText();
      course = combo_CourseName.getSelectedItem().toString();
      branch = combo_branch.getSelectedItem().toString();
      
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set name = ?,course = ?,branch = ? where student_id = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            
            pst.setString(1,studentName);
            pst.setString(2,course);      
            pst.setString(3,branch);
            pst.setInt(4,studentId);
            
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount >0){
                isUpdated = true;  
            }else{
                isUpdated = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       return isUpdated;
    }
    
    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentId= Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con= DBConnection.getConnection();
            String sql= "delete from student_details where student_id = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,studentId);
     
            int rowCount = pst.executeUpdate();
            
            if (rowCount>0){
                isDeleted = true;
            }else{
                isDeleted = false;
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        
        return isDeleted;
    }
    
   
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
        
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
        backpanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ii = new javax.swing.JLabel();
        qi = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        aname = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        ni = new javax.swing.JLabel();
        ai = new javax.swing.JLabel();
        Id1 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        combo_branch = new javax.swing.JComboBox<>();
        combo_CourseName = new javax.swing.JComboBox<>();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        xtra = new javax.swing.JPanel();
        xpanel = new javax.swing.JPanel();
        x = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojerusan.RSTableMetro();
        managepanel = new javax.swing.JPanel();
        managetitle = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backpanel.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backpanelLayout = new javax.swing.GroupLayout(backpanel);
        backpanel.setLayout(backpanelLayout);
        backpanelLayout.setHorizontalGroup(
            backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backpanelLayout.setVerticalGroup(
            backpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backpanelLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(backpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        ii.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        ii.setForeground(new java.awt.Color(255, 255, 255));
        ii.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(ii, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 50, 30));

        qi.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        qi.setForeground(new java.awt.Color(255, 255, 255));
        qi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(qi, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 40, 30));

        name.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("Enter Student Name");
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 190, 30));

        aname.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        aname.setForeground(new java.awt.Color(255, 255, 255));
        aname.setText("Select Course");
        jPanel1.add(aname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 140, 30));

        quantity.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        quantity.setForeground(new java.awt.Color(255, 255, 255));
        quantity.setText("Select Branch");
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, 140, 30));

        ni.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        ni.setForeground(new java.awt.Color(255, 255, 255));
        ni.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(ni, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 60, 30));

        ai.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        ai.setForeground(new java.awt.Color(255, 255, 255));
        ai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(ai, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 50, 30));

        Id1.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        Id1.setForeground(new java.awt.Color(255, 255, 255));
        Id1.setText("Enter Student ID");
        jPanel1.add(Id1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 240, 30));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 370, -1));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name...");
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 370, -1));

        combo_branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "PLAIN", "ELECTRONICS" }));
        combo_branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_branchActionPerformed(evt);
            }
        });
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 600, 370, 40));

        combo_CourseName.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD" }));
        combo_CourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_CourseNameActionPerformed(evt);
            }
        });
        jPanel1.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 370, 40));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 140, 80));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 700, 140, 80));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 700, 140, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        xtra.setBackground(new java.awt.Color(255, 255, 255));
        xtra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        xpanel.setBackground(new java.awt.Color(255, 51, 51));
        xpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xpanelMouseClicked(evt);
            }
        });

        x.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        x.setText("X");

        javax.swing.GroupLayout xpanelLayout = new javax.swing.GroupLayout(xpanel);
        xpanel.setLayout(xpanelLayout);
        xpanelLayout.setHorizontalGroup(
            xpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xpanelLayout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(x, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        xpanelLayout.setVerticalGroup(
            xpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(x)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        xtra.add(xpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 0, 80, 40));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentDetails.setColorFilasForeground2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 255)); // NOI18N
        tbl_studentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tbl_studentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studentDetails.setRowHeight(40);
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_studentDetails);

        xtra.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 440, 820, 310));

        managepanel.setBackground(new java.awt.Color(51, 0, 51));

        managetitle.setBackground(new java.awt.Color(0, 0, 0));
        managetitle.setFont(new java.awt.Font("Verdana", 3, 25)); // NOI18N
        managetitle.setForeground(new java.awt.Color(255, 255, 255));
        managetitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        managetitle.setText("Manage Students");

        javax.swing.GroupLayout managepanelLayout = new javax.swing.GroupLayout(managepanel);
        managepanel.setLayout(managepanelLayout);
        managepanelLayout.setHorizontalGroup(
            managepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, managepanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(managetitle)
                .addGap(25, 25, 25))
        );
        managepanelLayout.setVerticalGroup(
            managepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(managepanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(managetitle, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        xtra.add(managepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 400, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/manage_student_background.jpg"))); // NOI18N
        xtra.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 830));

        getContentPane().add(xtra, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1140, 830));

        setBounds(0, 0, 1740, 838);
    }// </editor-fold>//GEN-END:initComponents

    private void b_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_updateActionPerformed

    private void b_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_deleteActionPerformed

    private void b_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_addActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
     HomePage home= new HomePage();
     home.setVisible(true);
     dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void xpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xpanelMouseClicked
        System.exit(0);
    }//GEN-LAST:event_xpanelMouseClicked

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void combo_branchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_branchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_branchActionPerformed

    private void combo_CourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_CourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_CourseNameActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(addStudent() ==true){
            JOptionPane.showMessageDialog(this,"Student Added");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this,"Student Addition Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(updateStudent() == true){
            JOptionPane.showMessageDialog(this,"Student updated");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this,"Student Updation Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed

        if(deleteStudent() ==true){
            JOptionPane.showMessageDialog(this,"Student deleted");
            clearTable();
            setStudentDetailsToTable();
        }else{
            JOptionPane.showMessageDialog(this,"Student delete Failed");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo,0).toString());
        txt_studentName.setText(model.getValueAt(rowNo,1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Id1;
    private javax.swing.JLabel ai;
    private javax.swing.JLabel aname;
    private javax.swing.JPanel backpanel;
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JLabel ii;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel managepanel;
    private javax.swing.JLabel managetitle;
    private javax.swing.JLabel name;
    private javax.swing.JLabel ni;
    private javax.swing.JLabel qi;
    private javax.swing.JLabel quantity;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    private javax.swing.JLabel x;
    private javax.swing.JPanel xpanel;
    private javax.swing.JPanel xtra;
    // End of variables declaration//GEN-END:variables
}
