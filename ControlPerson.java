package fraud;

import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

public class ControlPerson {

    DBConnection db = new DBConnection();

    public void insert(ModelPerson mod) {
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));

        try {
            db.connect();
            PreparedStatement pst = db.conn.prepareStatement("INSERT INTO person (user_id,first_name,last_name,username,password,email,mobile,address,dob,gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setInt(1, mod.getId());
            pst.setString(2, mod.getFirst_name());
            pst.setString(3, mod.getLast_name());
            pst.setString(4, mod.getUsername());
            pst.setString(5, mod.getPassword());
            pst.setString(6, mod.getEmail());
            pst.setString(7, mod.getMobile());
            pst.setString(8, mod.getAddress());
            pst.setString(9, mod.getDob());
            pst.setString(10, mod.getGender());
            pst.executeUpdate();
            System.out.println("Data Added: " + mod.getFirst_name());
            db.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void insertTrans(String id, String bill_amount, String claim, String disease, int status) {

        try {
            db.connect();
            PreparedStatement pst = db.conn.prepareStatement("INSERT INTO tbl_transactions (user_id,bill_amount,claim_amount,disease_name,transaction_status) VALUES (?, ?, ?, ?, ?)");
            pst.setString(1, id);
            pst.setString(2, bill_amount);
            pst.setString(3, claim);
            pst.setString(4, disease);
            pst.setInt(5, status);
            pst.executeUpdate();
            db.disconnect();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void update(ModelPerson mod, int id) {
        db.connect();
        try {
            PreparedStatement pst = db.conn.prepareStatement("UPDATE person SET first_name= ?, last_name= ?,dob= ?, mobile= ?, address= ?, email= ?, gender= ?, password=? WHERE id=?");
            pst.setString(1, mod.getFirst_name());
            pst.setString(2, mod.getLast_name());
            pst.setString(3, mod.getDob());
            pst.setString(4, mod.getMobile());
            pst.setString(5, mod.getAddress());
            pst.setString(6, mod.getEmail());
            pst.setString(7, mod.getGender());
            pst.setString(8, mod.getPassword());
            pst.setInt(9, id);
            pst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados\n ERRO: " + ex);
        }
        db.disconnect();
    }

    public void updateFingerData(byte[] fingerData, int id) {
        db.connect();
        try {
            PreparedStatement pst = db.conn.prepareStatement("UPDATE person SET finger_data= ? WHERE id=?");
            pst.setBytes(1, fingerData);
            pst.setInt(2, id);
            pst.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        db.disconnect();
    }

    public void delete(int id) {
        db.connect();
        try {
            PreparedStatement pst = db.conn.prepareStatement("DELETE FROM person WHERE id= '" + id + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in Deletion!");
        } finally {
            db.disconnect();
        }
    }

    public void deleteBeneficiary(String added_by, String added_to) {
        db.connect();
        try {
            PreparedStatement pst = db.conn.prepareStatement("DELETE FROM tbl_beneficiary WHERE added_by= '" + added_by + "' AND added_to='" + added_to + "'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record Deleted!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error in Deletion!");
        } finally {
            db.disconnect();
        }
    }

    public void prepareTable(String SQL, JTable tabela) {
        String id = null;
        db.connect();
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{ "ID", "Name", "Phone", "Address", "Email", "DoB", "Gender"};
        db.executeSQL(SQL);
        try {
            db.rs.first();
            do {
                dados.add(new Object[]{
                    db.rs.getString("user_id"),
                    db.rs.getString("first_name") + " " + db.rs.getString("last_name"),
                    db.rs.getString("mobile"),
                    db.rs.getString("address"),
                    db.rs.getString("email"),
                    db.rs.getString("dob"),
                    db.rs.getString("gender")
                });
            } while (db.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Lista de Cadastro Vazia!");
        } finally {
            db.disconnect();
        }

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tabela.setModel((TableModel) modelo);
//        tabela.getColumnModel().getColumn(0).setCellRenderer(new ControlPerson.ImageRenderer());
//        tabela.getColumnModel().getColumn(1).setMaxWidth(0);
//        tabela.getColumnModel().getColumn(1).setMinWidth(0);
//        tabela.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
//        tabela.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void prepareTransactionTable(String SQL, JTable tabela) {
        String id = null;

        db.connect();
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"ID", "Name", "Bill Amount", "Claim Amount", "Disease", "Date", "Status"};
        db.executeSQL(SQL);
        try {
            db.rs.first();
            do {
                String status="Legitimate";
                 if (db.rs.getString("transaction_status").equals("0"))
                 {
                     status="Fradulent";
                 }
                 
                dados.add(new Object[]{
                    db.rs.getString("trans_id"),
                    db.rs.getString("first_name") + " " + db.rs.getString("last_name"),
                    db.rs.getString("bill_amount"),
                    db.rs.getString("claim_amount"),
                    db.rs.getString("disease_name"),
                    db.rs.getString("transaction_date"),
                    status
                   
                });
            } while (db.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane, "Lista de Cadastro Vazia!");
        } finally {
            db.disconnect();
        }

        ModeloTabela modelo = new ModeloTabela(dados, Colunas);
        tabela.setModel((TableModel) modelo);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

  
    class ImageRenderer implements TableCellRenderer {

        public JLabel lbl = new JLabel();

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            try {
                Object text = table.getValueAt(row, 1);
                File image = new File("D:\\photos\\person." + text + ".1.jpg");
                String path = image.getAbsolutePath();
                ImageIcon i = new ImageIcon(new ImageIcon(String.valueOf(path)).getImage().getScaledInstance(lbl.getWidth() + 50, lbl.getHeight() + 50, Image.SCALE_SMOOTH));
                lbl.setIcon(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return lbl;
        }
    }

    public void editor(ModelPerson mod, int id) {
        db.connect();
        try {
            PreparedStatement pst = db.conn.prepareStatement("UPDATE apto SET apto= ? WHERE id=? ");
            pst.setString(1, mod.getFirst_name());
            pst.setInt(2, id);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated Successfully..");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error!");
        } finally {
            db.disconnect();
        }
    }

    public ResultSet getResult(String sql) {
        db.connect();
        db.executeSQL(sql);
        return db.rs;
    }

}
