package fraud;

import Blockchain.ChainConsensus;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.converters.CSVLoader;

/**
 * Method responsible for registering the users in the database.
 * <br><br>
 * Is a JDialog that you can register a person and register data like: name,
 * surname, phone, post, and information about social network.
 */
public class UserPrediction extends JFrame {

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
    public UserPrediction() {

        initComponents();
        setIcon();
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel9 = new keeptoo.KGradientPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        txt_billing_amount = new javax.swing.JTextField();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        txt_claim_amount = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        disease = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        saveButton = new keeptoo.KButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel9.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkFillBackground(false);
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(170, 170, 170));
        jLabel3.setText("Billing Amount");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel4.setForeground(new java.awt.Color(170, 170, 170));
        jLabel4.setText("Claim Amount");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        kGradientPanel1.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel1.setkFillBackground(false);
        kGradientPanel1.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_billing_amount.setBorder(null);
        txt_billing_amount.setOpaque(false);
        kGradientPanel1.add(txt_billing_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 330, 30));

        jPanel3.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 350, 30));

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setkEndColor(new java.awt.Color(57, 114, 227));
        kGradientPanel2.setkFillBackground(false);
        kGradientPanel2.setkStartColor(new java.awt.Color(122, 227, 192));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_claim_amount.setBorder(null);
        txt_claim_amount.setOpaque(false);
        kGradientPanel2.add(txt_claim_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 330, 30));

        jPanel3.add(kGradientPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(200, 204, 208));
        jLabel13.setText("Fill Information");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        disease.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arthritis", "Cancer", "Diabetes", "Heart", "Parkinson" }));
        disease.setBorder(null);
        jPanel3.add(disease, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 180, -1));

        jLabel9.setForeground(new java.awt.Color(170, 170, 170));
        jLabel9.setText("Disease");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        kGradientPanel9.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 480, 260));

        saveButton.setText("Mediclaim");
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
        kGradientPanel9.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 370, 30));
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(90, 68, 193));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setBackground(new java.awt.Color(90, 68, 193));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Prediction");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

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
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 30, 40));

        kGradientPanel9.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 470, 40));

        getContentPane().add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 480));

        setSize(new java.awt.Dimension(500, 482));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (txt_billing_amount.getText().equals("") || txt_billing_amount.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Enter billing amount");
        } else if (txt_claim_amount.getText().equals("") || txt_claim_amount.getText().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Enter claim amount");
        } else {
            predictclaim();
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
            java.util.logging.Logger.getLogger(UserPrediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPrediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPrediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPrediction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JComboBox<String> disease;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel9;
    private keeptoo.KButton saveButton;
    private javax.swing.JTextField txt_billing_amount;
    private javax.swing.JTextField txt_claim_amount;
    // End of variables declaration//GEN-END:variables

    /**
     * This method reads the users registered in the database and adds the value
     * of +1, if there is no registration, that is, if there are 0 records, the
     * id will be 1.
     */
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
    public void predictclaim() {
        //predict the mediclaim and insert into blockchain   
        try {
            String s1 = txt_billing_amount.getText().trim();
            String s2 = txt_claim_amount.getText().trim();

            if (s1.equals("") || s2.equals("")) {
                JOptionPane.showMessageDialog(this, "Enter all details");
            } else {
                int bill = 0;
                int cl = 0;

                int gen = 1;
                if (Details.gender.equalsIgnoreCase("female")) {
                    gen = 2;
                }
                String dis = disease.getSelectedItem().toString();
                // int dindex=jComboBox2.getSelectedIndex()+1;
                try {

                    bill = Integer.parseInt(s1);
                    cl = Integer.parseInt(s2);

                    CSVLoader csv = new CSVLoader();
                    csv.setSource(new File(Details.inPath));

                    Instances data = csv.getDataSet();

                    // from here new code added
                    if (true) {
                        data.setClassIndex(data.numAttributes() - 1);

                        Instances trainingData = new Instances(data, 0, 100);
                        Instances testingData = new Instances(data, 65, 3);
                        Evaluation evaluation = new Evaluation(trainingData);
                        SMO smo = new SMO();
                        smo.buildClassifier(data);
                        evaluation.evaluateModel(smo, testingData);
                        System.out.println(evaluation.toSummaryString());

                        Instance instance = new SparseInstance(4);
                        instance.setValue(data.attribute("age"), Details.age);
                        instance.setValue(data.attribute("sex"), gen);
                        instance.setValue(data.attribute("bill"), bill);
                        instance.setValue(data.attribute("claim"), cl);
                        instance.setValue(data.attribute("disease"), dis);
                        instance.setDataset(data);
                        System.out.println("The instance: " + instance);
                        System.out.println(smo.classifyInstance(instance));
                        int r1 = (int) smo.classifyInstance(instance);

                        String cs[] = smo.classAttributeNames();
                        String ms = cs[r1];
                        
                        int status=1;
                        if(!ms.equalsIgnoreCase("legitimate"))
                        {
                            status=0;
                        }
                        ControlPerson cod = new ControlPerson();
                        cod.insertTrans(Details.user_id, s1, s2, dis, status);
                        JOptionPane.showMessageDialog(this, "Detected As " + ms);
                        String finaldata = Details.user_id + "#" + Details.username + "#" + txt_billing_amount.getText() + "#" + txt_claim_amount.getText() + "#" + disease.getSelectedItem() + "#" + ms;
                        System.out.println(finaldata);
                        ChainConsensus.ProofOfWork(finaldata);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Enter Valid Info");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
 private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/icone.png")));
    }

}
