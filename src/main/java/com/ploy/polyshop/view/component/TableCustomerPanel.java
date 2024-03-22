package com.ploy.polyshop.view.component;

import com.ploy.polyshop.model.Customer;
import com.ploy.polyshop.repository.CustomerRepository;
import com.ploy.polyshop.uint.EnumStateLoad;
import static com.ploy.polyshop.uint.EnumStateLoad.ACTIVE;
import static com.ploy.polyshop.uint.EnumStateLoad.ALL;
import com.ploy.polyshop.view.Panel.CustomerPanel;
import java.awt.Color;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TableCustomerPanel extends javax.swing.JPanel {
    
    List<Customer> list;
    CustomerPanel fatherFrame;
    CustomerRepository customerRepository = new CustomerRepository();
    EnumStateLoad state;
    String inputSearch;
    
    public TableCustomerPanel( EnumStateLoad state, CustomerPanel customerFrame ) {
        initComponents();
        this.fatherFrame = customerFrame;
        this.state = state;
        this.setBackground(Color.WHITE);
        jTable1.setRowHeight(40);
        loadTable();
    }
    
    public TableCustomerPanel( EnumStateLoad state, CustomerPanel customerFrame, String inputSearch ) {
        initComponents();
        this.fatherFrame = customerFrame;
        this.state = state;
        this.inputSearch = inputSearch;
        this.setBackground(Color.WHITE);
        jTable1.setRowHeight(40);
        loadTable();
    }
    
    void loadTable (){
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        typeLoad(state);
        list.forEach( customer -> {
            model.addRow(customer.getData());
        });
    }
    void typeLoad(EnumStateLoad state) {
        switch (state) {
            case ALL:
                list = customerRepository.selectAll();
                break;
            case SEARCH:
                list = customerRepository.search(inputSearch);
                break;
            case ACTIVE:{
                list = customerRepository.selectByIsActive(true);
                break;
            }
            case NOT_ACTIVE:{
                list = customerRepository.selectByIsActive(false);
                break;
            }
            default:
                throw new AssertionError();
        }
    }
    public JTable getTabel(){
        return jTable1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên Khách Hàng", "Địa Chỉ", "Điểm", "Số Điện Thoại", "Trạng Thái", "Ngày Tạo", "Ngày Cập Nhật"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(175, 227, 181));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Tạo Mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       int index = jTable1.getSelectedRow();
        System.out.println(index);
       if(index >=0 && evt.getClickCount() ==2) {
           Customer customer = list.get(index);
           new InfoCustomerFrame(customer, this).setVisible(true);
       }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         new InfoCustomerFrame(this).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
