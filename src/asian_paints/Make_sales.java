/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asian_paints;

import java.util.Date;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lavanjan
 */
public class Make_sales extends javax.swing.JFrame {

    /**
     * Creates new form Make_sales
     */
    public Make_sales() {
        initComponents();
        Show_details_paint();
        setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
    }
    
    
    
    public Connection getConnection()
    {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/Asian_Paints", "root", "");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    public ArrayList<Paint> getPaintlist()
    {
        ArrayList<Paint> paintlist = new ArrayList<Paint>();
        Connection connection = getConnection();
        String query = "SELECT * FROM `paint_stock`";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Paint ap;
            
            while(rs.next())
            {
                ap = new Paint(rs.getInt("proid"),rs.getString("modelname"),rs.getString("color"),rs.getInt("price"),rs.getInt("qantity"));
                paintlist.add(ap);
            }
        } catch (Exception e) {
        }
        return paintlist;
    }
    
    
    //VIEW PAINT TABLE
    
     public void Show_details_paint()
    {
     ArrayList<Paint> list = getPaintlist();
     DefaultTableModel model = (DefaultTableModel)jTable_display_paint.getModel();
     Object[] row = new Object[9];
     for(int i = 0; i<list.size();i++)
     {
         row[0] = list.get(i).getID();
         row[1] = list.get(i).getmodelname();
         row[2] = list.get(i).getcolor();
         row[3] = list.get(i).getprice();
         row[4] = list.get(i).getqty();
         
         
         model.addRow(row);
         
         
     }
    }
     
     
     
     public void excuteSQlQuery(String query, String message)
     {
         Connection con = getConnection();
         Statement st;
         try {
             st = con.createStatement();
             if((st.executeUpdate(query)) == 1)
             {
                 // Refresh Data
                 DefaultTableModel model = (DefaultTableModel)jTable_display_paint.getModel();
                 model.setRowCount(0);
                 Show_details_paint();
                 
                 JOptionPane.showMessageDialog(null, "Data "+message+" Successfully");
             }else{
                 JOptionPane.showMessageDialog(null, "Data Not"+message);
             }
         } catch (Exception ex) {
             ex.printStackTrace();
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
        jTextField_price_sales = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField_cusid_sales = new javax.swing.JTextField();
        jTextField_pro_id_sales = new javax.swing.JTextField();
        jTextField_model_sales = new javax.swing.JTextField();
        jTextField_color_sales = new javax.swing.JTextField();
        jTextField_Qty_sales = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_display_paint = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setPreferredSize(new java.awt.Dimension(1357, 565));

        jTextField_price_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_price_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_price_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_price_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_price_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_price_salesActionPerformed(evt);
            }
        });
        jTextField_price_sales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_price_salesKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cus ID:");

        jLabel2.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ProID:");

        jLabel3.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText(" Model Name:");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asian_paints/Image/Black.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Paint Color:");

        jLabel7.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Unit Price:");

        jLabel11.setFont(new java.awt.Font("Nueva Std", 1, 40)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Make Sales");
        jLabel11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asian_paints/Image/Arrow-Back-icon.png"))); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField_cusid_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_cusid_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_cusid_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_cusid_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_cusid_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_cusid_salesActionPerformed(evt);
            }
        });

        jTextField_pro_id_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_pro_id_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_pro_id_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_pro_id_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_pro_id_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_pro_id_salesActionPerformed(evt);
            }
        });

        jTextField_model_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_model_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_model_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_model_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_model_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_model_salesActionPerformed(evt);
            }
        });

        jTextField_color_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_color_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_color_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_color_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_color_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_color_salesActionPerformed(evt);
            }
        });

        jTextField_Qty_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_Qty_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_Qty_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_Qty_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_Qty_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Qty_salesActionPerformed(evt);
            }
        });
        jTextField_Qty_sales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Qty_salesKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Quantity:");

        jTable_display_paint.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTable_display_paint.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Model Name", "Paint Color", "Unit Price", "Quantity"
            }
        ));
        jTable_display_paint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_display_paintMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_display_paint);

        jButton4.setBackground(new java.awt.Color(0, 102, 102));
        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asian_paints/Image/Actions-button-cancel-icon (1).png"))); // NOI18N
        jButton4.setText("CANCEL");
        jButton4.setAutoscrolls(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Nueva Std", 1, 15)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asian_paints/Image/Package-add-icon (1).png"))); // NOI18N
        jButton5.setText("ADD SALES");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 102, 102));
        jButton3.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asian_paints/Image/Button-Red-Cancel-icon (1).png"))); // NOI18N
        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 78, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_model_sales)
                            .addComponent(jTextField_pro_id_sales)
                            .addComponent(jTextField_cusid_sales)
                            .addComponent(jTextField_color_sales)
                            .addComponent(jTextField_price_sales)
                            .addComponent(jTextField_Qty_sales)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jButton5)))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(460, 460, 460)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jLabel11)
                .addGap(200, 200, 200))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_cusid_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pro_id_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_model_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_color_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_price_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Qty_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(159, 159, 159))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 797, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_price_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_price_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_price_salesActionPerformed

    private void jTextField_price_salesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_price_salesKeyTyped
        // TODO add your handling code here:

        if(!Character.isDigit(evt.getKeyChar())){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField_price_salesKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // BACK TO MANAGER PAGE
        Manage_customer mcus = new Manage_customer();
        mcus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_cusid_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_cusid_salesActionPerformed
        // TODO add your handling code here:
       // jTextField_cusid_sales.setText(Manage_customer.jTextField_cusid_customer.getText());
        jTextField_cusid_sales.setEnabled(false);
        
        
    }//GEN-LAST:event_jTextField_cusid_salesActionPerformed

    private void jTextField_color_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_color_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_color_salesActionPerformed

    private void jTextField_Qty_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Qty_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Qty_salesActionPerformed

    private void jTextField_Qty_salesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Qty_salesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Qty_salesKeyTyped

    private void jTable_display_paintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_display_paintMouseClicked
        // TODO add your handling code here:

        int i = jTable_display_paint.getSelectedRow();
        TableModel model = jTable_display_paint.getModel();
        jTextField_pro_id_sales.setText(model.getValueAt(i,0).toString());
        jTextField_model_sales.setText(model.getValueAt(i,1).toString());
        jTextField_color_sales.setText(model.getValueAt(i,2).toString());
        jTextField_price_sales.setText(model.getValueAt(i,3).toString());
        jTextField_Qty_sales.setText(model.getValueAt(i,4).toString());

        /*  String roll = model.getValueAt(i, 8).toString();
        if(roll.equals("CASHIER"))
        {
            jRadioButton_cash.setSelected(true);
            jRadioButton_Stock.setSelected(false);
        }
        else{
            jRadioButton_Stock.setSelected(true);
            jRadioButton_cash.setSelected(false);
        }*/

        //   jComboBox_gender_staff.getSelectedItem()(model.getValueAt(i,0).toString());
        // jComboBox_roll_staff.setText(model.getValueAt(i,0).toString());
    }//GEN-LAST:event_jTable_display_paintMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        int cancel = JOptionPane.showConfirmDialog(this, "Cancel registration?");
        if (cancel == JOptionPane.YES_OPTION) {
            Manager manager = new Manager();
            manager.setVisible(true);
            this.dispose();
        }
        else if (cancel == JOptionPane.NO_OPTION) {

            JOptionPane.showMessageDialog(null, "Continue process.");
        } else {

        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField_pro_id_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_pro_id_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_pro_id_salesActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String mname,color;
        int proid,qty,price,cusid;
   
        try {
            if(jTextField_pro_id_sales.getText().equals("")||jTextField_model_sales.getText().equals("")||jTextField_color_sales.getText().equals("")||jTextField_price_sales.getText().equals("")||jTextField_Qty_sales.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Select Details");
            }else{
                cusid = Integer.parseInt(jTextField_cusid_sales.getText());
                proid = Integer.parseInt(jTextField_pro_id_sales.getText());
                mname = jTextField_model_sales.getText();
                color = jTextField_color_sales.getText();
                price = Integer.parseInt(jTextField_price_sales.getText());
                qty = Integer.parseInt(jTextField_Qty_sales.getText());
                
                
                String sql = "SELECT * FROM `paint_stock` WHERE `proid` = '"+proid+"' && `qantity` < '"+qty+"'";
                PreparedStatement pst;
                ResultSet rs;
                Connection con = getConnection();
                con = DriverManager.getConnection("jdbc:mysql://localhost/Asian_Paints", "root", "");
                
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                if(rs.next()){
                
                    
                    JOptionPane.showMessageDialog(null, "Insufficent Stock ! Please check your stock");
            }else
                {
                    sql = "SELECT * FROM `sales_record` WHERE `cusid` = '"+cusid+"' && `proid` = '"+proid+"' ";
                    
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    
                    sql = "UPDATE `sales_record` SET `quantity`= `quantity`+ "+qty+" WHERE `cusid` = '"+cusid+"' && `proid` = '"+proid+"'";
                    pst = con.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Additional Data Updated");
                
                sql = "UPDATE `paint_stock` SET `qantity`= `qantity` - '"+qty+"' WHERE `proid` = '"+proid+"'";
                 pst = con.prepareStatement(sql);
                 pst.executeUpdate();
               // JOptionPane.showMessageDialog(null, "Stock Devrease");
               
                }else{
                    sql = "INSERT INTO `sales_record` (`cusid`, `proid`, `modelname`, `color`, `price`, `quantity`) VALUES ('"+cusid+"','"+proid+"','"+mname+"','"+color+"','"+price+"','"+qty+"')";
                    pst = con.prepareStatement(sql);
                 pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "ThankYou !");
                
                sql = "UPDATE `paint_stock` SET `qantity`= `qantity` - '"+qty+"' WHERE `proid` = '"+proid+"'";
                 pst = con.prepareStatement(sql);
                pst.executeUpdate();
               // JOptionPane.showMessageDialog(null, "Stock Devrease");
                
                }
                
                }
                
            }
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField_model_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_model_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_model_salesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Make_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Make_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Make_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Make_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Make_sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_display_paint;
    private javax.swing.JTextField jTextField_Qty_sales;
    private javax.swing.JTextField jTextField_color_sales;
    public static javax.swing.JTextField jTextField_cusid_sales;
    private javax.swing.JTextField jTextField_model_sales;
    private javax.swing.JTextField jTextField_price_sales;
    private javax.swing.JTextField jTextField_pro_id_sales;
    // End of variables declaration//GEN-END:variables
}
