package fraud;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 * Method responsible for registering the users in the database.
 * <br><br>
 * Is a JDialog that you can register a person and register data like: name,
 * surname, phone, post, and information about social network.
 */
public class RegisterUser extends javax.swing.JDialog {

    private java.awt.Frame parent;
    //JavaCV

    int numSamples = 25, sample = 1, idPerson;

    //Connection
    DBConnection conecta = new DBConnection();

    /**
     * @param parent It's the JFrame that's calling it
     * @param modal is a window that blocks access to other windows while it is
     * not clicked.
     */
    public RegisterUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        getIdUser();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel9 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        txt_first_name = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        txt_last_name = new javax.swing.JTextField();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        txt_phone_number = new javax.swing.JFormattedTextField();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        txt_office = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        txt_email = new javax.swing.JTextField();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        txt_dob = new com.toedter.calendar.JDateChooser();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        txt_username = new javax.swing.JTextField();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        txt_password = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        saveButton = new keeptoo.KButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_id_label = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        gender = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel9.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkFillBackground(false);
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(170, 170, 170));
        jLabel2.setText("Address: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jLabel3.setForeground(new java.awt.Color(170, 170, 170));
        jLabel3.setText("First Name");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setForeground(new java.awt.Color(170, 170, 170));
        jLabel4.setText("Last Name");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel5.setForeground(new java.awt.Color(170, 170, 170));
        jLabel5.setText("Phone Number");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_first_name.setBorder(null);
        txt_first_name.setOpaque(false);
        kGradientPanel1.add(txt_first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel3.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 180, 20));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel2.setkFillBackground(false);
        kGradientPanel2.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_last_name.setBorder(null);
        txt_last_name.setOpaque(false);
        kGradientPanel2.add(txt_last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel3.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 180, 20));

        kGradientPanel3.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel3.setkFillBackground(false);
        kGradientPanel3.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_phone_number.setBorder(null);
        try {
            txt_phone_number.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(+91)##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_phone_number.setOpaque(false);
        kGradientPanel3.add(txt_phone_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel3.add(kGradientPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 180, 20));

        kGradientPanel4.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel4.setkFillBackground(false);
        kGradientPanel4.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_office.setBorder(null);
        txt_office.setOpaque(false);
        kGradientPanel4.add(txt_office, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel3.add(kGradientPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 180, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(200, 204, 208));
        jLabel13.setText("Personal Information");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        kGradientPanel9.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 420, 140));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(170, 170, 170));
        jLabel6.setText("Password");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel7.setForeground(new java.awt.Color(170, 170, 170));
        jLabel7.setText("Email");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel8.setForeground(new java.awt.Color(170, 170, 170));
        jLabel8.setText("DoB");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

        kGradientPanel5.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel5.setkFillBackground(false);
        kGradientPanel5.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_email.setBorder(null);
        txt_email.setOpaque(false);
        kGradientPanel5.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel4.add(kGradientPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, 20));

        kGradientPanel6.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel6.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel6.setkFillBackground(false);
        kGradientPanel6.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_dob.setDateFormatString("dd/MM/yyyy");
        txt_dob.setOpaque(false);
        kGradientPanel6.add(txt_dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, -1));

        jPanel4.add(kGradientPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 180, 20));

        kGradientPanel7.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel7.setkFillBackground(false);
        kGradientPanel7.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_username.setBorder(null);
        txt_username.setOpaque(false);
        kGradientPanel7.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel4.add(kGradientPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 180, 20));

        kGradientPanel8.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel8.setkFillBackground(false);
        kGradientPanel8.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_password.setBorder(null);
        txt_password.setOpaque(false);
        kGradientPanel8.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 20));

        jPanel4.add(kGradientPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 180, 20));

        jLabel11.setForeground(new java.awt.Color(170, 170, 170));
        jLabel11.setText("Username");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        kGradientPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 420, 140));

        saveButton.setText("Register");
        saveButton.setkAllowTab(false);
        saveButton.setkEndColor(new java.awt.Color(118, 195, 118));
        saveButton.setkHoverEndColor(new java.awt.Color(22, 92, 22));
        saveButton.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        saveButton.setkHoverStartColor(new java.awt.Color(80, 142, 80));
        saveButton.setkPressedColor(new java.awt.Color(28, 72, 28));
        saveButton.setkStartColor(new java.awt.Color(87, 167, 87));
        saveButton.setOpaque(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        kGradientPanel9.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 370, 30));
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(90, 68, 193));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(90, 68, 193));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("User ID");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        txt_id_label.setBackground(new java.awt.Color(90, 68, 193));
        txt_id_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txt_id_label.setForeground(new java.awt.Color(255, 255, 255));
        txt_id_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_id_label.setText("1");
        jPanel1.add(txt_id_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 40, 40));

        jButton1.setBackground(new java.awt.Color(213, 83, 83));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Filled_Circle_15px_1.png"))); // NOI18N
        jButton1.setToolTipText("Close");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 30, 40));

        kGradientPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 410, 40));

        jLabel9.setForeground(new java.awt.Color(170, 170, 170));
        jLabel9.setText("Gender");
        kGradientPanel9.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gender.setBorder(null);
        kGradientPanel9.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 180, -1));

        getContentPane().add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 460));

        setSize(new java.awt.Dimension(462, 460));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (txt_first_name.getText().equals("") || txt_first_name.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Enter first name");
        } else if (txt_last_name.getText().equals("") || txt_last_name.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Enter Last Name");
        } else if (txt_phone_number.getText().equals("") || txt_phone_number.getText().equals("(+91)")) {
            JOptionPane.showMessageDialog(null, "Enter Mobile number");
        } else if (txt_office.getText().equals("") || txt_office.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Enter Address");
        } else if (txt_email.getText().equals("") || txt_email.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Enter Email");
        } else if (txt_dob.getDateFormatString().equals("")) {
            JOptionPane.showMessageDialog(null, "Select DoB");
        } else if (txt_username.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter username");
        } else if (txt_password.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Enter password");
        } else {
            insertDatabase();
        }

    }//GEN-LAST:event_saveButtonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(() -> {
//            RegisterFace dialog = new RegisterFace(new javax.swing.JFrame(), true);
//            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//            dialog.setVisible(true);
//        });
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(() -> {
//            RegisterFace dialog = new RegisterFace(new javax.swing.JFrame(), true);
//            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                @Override
//                public void windowClosing(java.awt.event.WindowEvent e) {
//                    System.exit(0);
//                }
//            });
//            dialog.setVisible(true);
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> gender;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    private keeptoo.KButton saveButton;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_first_name;
    private javax.swing.JLabel txt_id_label;
    private javax.swing.JTextField txt_last_name;
    private javax.swing.JTextField txt_office;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JFormattedTextField txt_phone_number;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    /**
     * This method reads the users registered in the database and adds the value
     * of +1, if there is no registration, that is, if there are 0 records, the
     * id will be 1.
     */
    private int getIdUser() {
        int id = 0;
        conecta.connect();
        conecta.executeSQL("SELECT * FROM person ORDER BY user_id DESC LIMIT 1");
        try {
            if (conecta.rs.next()) {
                txt_id_label.setText(String.valueOf(conecta.rs.getInt("user_id")));
                id = Integer.parseInt(txt_id_label.getText());

            }
            id++;
            txt_id_label.setText(String.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * This class is responsible for: displaying the image in JLabel, Detect
     * Face, and Save Images.
     * <br><br>
     * To understand more about the parameters used in the class, download
     * JavaDOC from JavaCV.
     */
    /**
     * This method inserts the information into the database.
     */
    public void insertDatabase() {
        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date newDate =txt_dob.getDate();
        ControlPerson cod = new ControlPerson();
        ModelPerson mod = new ModelPerson();
        mod.setId(Integer.parseInt(txt_id_label.getText()));
        mod.setFirst_name(txt_first_name.getText());
        mod.setLast_name(txt_last_name.getText());
        mod.setDob(dateFormat.format(newDate));
        mod.setAddress(txt_office.getText());
        mod.setEmail(txt_email.getText());
        mod.setUsername(txt_username.getText());
        mod.setPassword(txt_password.getText());
        mod.setMobile(txt_phone_number.getText());
        mod.setGender(gender.getSelectedItem().toString());
        cod.insert(mod);
        JOptionPane.showMessageDialog(null, "Registration success");
        dispose();
    }

}
