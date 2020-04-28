/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asian_paints;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lavanjan
 */
public class sales_cashier extends javax.swing.JFrame {

    /**
     * Creates new form sales_cashier
     */
    public sales_cashier() {
        initComponents();
        Show_details_sales();
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
    
    
    public ArrayList<sales> getsaleslist()
    {
        ArrayList<sales> saleslist = new ArrayList<sales>();
        Connection connection = getConnection();
        String query = "SELECT * FROM `sales_record`";
        Statement st;
        ResultSet rs;
        
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            sales salestable;
            
            while(rs.next())
            {
                salestable = new sales(rs.getInt("cusid"),rs.getInt("sales_id"),rs.getInt("proid"),rs.getString("modelname"),rs.getString("color"),rs.getInt("price"),rs.getInt("quantity"));
                saleslist.add(salestable);
            }
        } catch (Exception e) {
        }
        return saleslist;
    }
    
 // DISPLAY TABLE
    
     public void Show_details_sales()
    {
     ArrayList<sales> list = getsaleslist();
     DefaultTableModel model = (DefaultTableModel)jTable_display_sales.getModel();
     Object[] row = new Object[9];
     for(int i = 0; i<list.size();i++)
     {
         row[0] = list.get(i).getsalesID();
         row[1] = list.get(i).getcusID();
         row[2] = list.get(i).getproID();
         row[3] = list.get(i).getmodelname();
         row[4] = list.get(i).getcolor();
         row[5] = list.get(i).getPrice();
         row[6] = list.get(i).getQty();
         
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
                 DefaultTableModel model = (DefaultTableModel)jTable_display_sales.getModel();
                 model.setRowCount(0);
                 Show_details_sales();
                 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_display_sales = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField_salesid_sales = new javax.swing.JTextField();
        jTextField_cusid_sales = new javax.swing.JTextField();
        jTextField_pname_sales = new javax.swing.JTextField();
        jTextField_color_sales = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField_qty_sales = new javax.swing.JTextField();
        jTextField_proid_sales = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

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

        jTable_display_sales.setBackground(new java.awt.Color(0, 102, 102));
        jTable_display_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTable_display_sales.setForeground(new java.awt.Color(0, 0, 0));
        jTable_display_sales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SalesID", "CustomerID", "ProductID", "ProductName", "Color", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_display_sales.setGridColor(new java.awt.Color(51, 51, 255));
        jTable_display_sales.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable_display_sales.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable_display_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_display_salesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_display_sales);

        jLabel1.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SalesID:");

        jLabel2.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CusID:");

        jLabel3.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText(" Product Name:");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asian_paints/Image/Black.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Color:");

        jLabel7.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Quantity:");

        jLabel11.setFont(new java.awt.Font("Nueva Std", 1, 40)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(" Sales Details Table");
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

        jTextField_salesid_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_salesid_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_salesid_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_salesid_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_salesid_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_salesid_salesActionPerformed(evt);
            }
        });

        jTextField_cusid_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_cusid_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_cusid_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_cusid_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextField_pname_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_pname_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_pname_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_pname_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_pname_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_pname_salesActionPerformed(evt);
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

        jLabel8.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Price:");

        jTextField_qty_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_qty_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_qty_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_qty_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField_qty_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_qty_salesActionPerformed(evt);
            }
        });
        jTextField_qty_sales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_qty_salesKeyTyped(evt);
            }
        });

        jTextField_proid_sales.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_proid_sales.setFont(new java.awt.Font("Nueva Std", 1, 14)); // NOI18N
        jTextField_proid_sales.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_proid_sales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Nueva Std", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ProID:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_color_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_price_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_qty_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_cusid_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_proid_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_pname_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_salesid_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_salesid_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_cusid_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_proid_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_pname_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_color_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_price_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_qty_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jTable_display_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_display_salesMouseClicked
        // TODO add your handling code here:

        int i = jTable_display_sales.getSelectedRow();
        TableModel model = jTable_display_sales.getModel();
        jTextField_salesid_sales.setText(model.getValueAt(i,0).toString());
        jTextField_cusid_sales.setText(model.getValueAt(i,1).toString());
        jTextField_proid_sales.setText(model.getValueAt(i,2).toString());
        jTextField_pname_sales.setText(model.getValueAt(i,3).toString());
        jTextField_color_sales.setText(model.getValueAt(i,4).toString());
        jTextField_price_sales.setText(model.getValueAt(i,5).toString());
        jTextField_qty_sales.setText(model.getValueAt(i,6).toString());

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
    }//GEN-LAST:event_jTable_display_salesMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // BACK TO MANAGER PAGE
        Cashier cashier = new Cashier();
        cashier.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_salesid_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_salesid_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_salesid_salesActionPerformed

    private void jTextField_pname_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_pname_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_pname_salesActionPerformed

    private void jTextField_color_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_color_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_color_salesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here

        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField_qty_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_qty_salesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_qty_salesActionPerformed

    private void jTextField_qty_salesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_qty_salesKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_qty_salesKeyTyped

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
            java.util.logging.Logger.getLogger(sales_cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales_cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales_cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales_cashier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales_cashier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_display_sales;
    private javax.swing.JTextField jTextField_color_sales;
    private javax.swing.JTextField jTextField_cusid_sales;
    private javax.swing.JTextField jTextField_pname_sales;
    private javax.swing.JTextField jTextField_price_sales;
    private javax.swing.JTextField jTextField_proid_sales;
    private javax.swing.JTextField jTextField_qty_sales;
    public static javax.swing.JTextField jTextField_salesid_sales;
    // End of variables declaration//GEN-END:variables
}