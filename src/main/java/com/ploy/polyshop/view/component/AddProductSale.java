package com.ploy.polyshop.view.component;

import com.ploy.polyshop.model.OrderDetail;
import com.ploy.polyshop.model.ProductDetail;
import com.ploy.polyshop.repository.ProductDetailRepository;
import com.ploy.polyshop.view.Panel.SalePanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AddProductSale extends javax.swing.JFrame {

    SalePanel father;
    Timer timer;

    ProductDetailRepository productDetailRepository = new ProductDetailRepository();
    List<ProductDetail> productDetailList;

    public AddProductSale(SalePanel father) {
//        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        // Thiết lập đường viền cho JFrame
        getRootPane().setBorder(border);
        initComponents();
      
        this.father = father;
        intit();
    }

    public AddProductSale() {
        initComponents();
        intit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbThongBao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Màu", "Size", "Số lượng", "Hành động"
            }
        ));
        jTable1.setRowSelectionAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("jButton2");

        jButton3.setText("jButton2");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        lbThongBao.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThongBao))
                .addGap(142, 142, 142)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.rowAtPoint(evt.getPoint());
        int column = jTable1.columnAtPoint(evt.getPoint());
        if (row >= 0 && column == 4) {
            Integer value =Integer.valueOf(jTable1.getValueAt(row, 3).toString()) ;
            ProductDetail productDetail = productDetailList.get(row);
            
            for(int i = 0; i< father.getOrderDetailsList().size(); i++ ){
                OrderDetail orderDetail = father.getOrderDetailsList().get(i);
                ProductDetail oldProductDetail = orderDetail.getProductDetail();
                if(oldProductDetail.getProductDetailsId() == productDetail.getProductDetailsId()){
                    orderDetail.setQuantity(orderDetail.getQuantity() + value);
                    thongBao("Thêm thành công!" + father.getOrderDetailsList().size());

                    return;
                }
            }
            OrderDetail newOrderDetail = new OrderDetail();
            
            newOrderDetail.setQuantity(value);
            newOrderDetail.setProductDetail(productDetail);
            newOrderDetail.setCurrentPrice(productDetail.getPrice());
            newOrderDetail.setDiscount(0.0);
            newOrderDetail.setTotal(productDetail.getPrice() * value);
            newOrderDetail.setTotalCost(productDetail.getPrice() * value);
            
            LocalDate updatedAtLCD = LocalDate.now();
            Date updatedAt = Date.valueOf(updatedAtLCD);
            Date createdAt = updatedAt;
            
            newOrderDetail.setCreatedAt(createdAt);
            newOrderDetail.setUpdatedAt(updatedAt);
            
            father.getOrderDetailsList().add(newOrderDetail);
            
            
            thongBao("Thêm thành công!" + father.getOrderDetailsList().size());
        }
    }//GEN-LAST:event_jTable1MouseClicked

    void intit() {
        jTable1.setRowHeight(40);
        jTable1.setDefaultEditor(Object.class, null);
        // Disable editing for a specific column (e.g., Age column)
        jTable1.getColumnModel().getColumn(2).setCellEditor(null);
        jTable1.getColumnModel().getColumn(3).setCellEditor(new TextFieldEditor());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        productDetailList = productDetailRepository.selectAll();
        loadTable(productDetailList);
    }

    void loadTable(List<ProductDetail> productDetailList) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        productDetailList.forEach(productDetail -> {
            model.addRow(new Object[]{
                productDetail.getProduct().getProductName() + productDetail.getProduct().getMaterial().getMaterialName(),
                productDetail.getColor().getColorName(),
                productDetail.getSize().getSizeName(),
                1,
                "Thêm"
            }); 
        });

    }
    void thongBao(String content){
        
        lbThongBao.setText(content);
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
              lbThongBao.setText("");
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
    

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddProductSale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbThongBao;
    // End of variables declaration//GEN-END:variables
}
