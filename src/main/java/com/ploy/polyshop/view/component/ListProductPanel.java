package com.ploy.polyshop.view.component;

import com.ploy.polyshop.model.Product;
import com.ploy.polyshop.model.ProductStatus;
import com.ploy.polyshop.repository.ProductRepository;
import com.ploy.polyshop.repository.ProductStatusRepository;
import com.ploy.polyshop.uint.ImageFromSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ListProductPanel extends javax.swing.JPanel {

    JTabbedPane tabPanel;

    List<Product> listProduct;
    List<ProductStatus> listStatus;
    Timer timer;

    ProductRepository productRepository = new ProductRepository();
    ProductStatusRepository productStatusRepository = new ProductStatusRepository();

    public ListProductPanel(JTabbedPane tabPanel) {
        initComponents();
        this.tabPanel = tabPanel;
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabone = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tfTimKiem = new javax.swing.JTextField();
        cbbStatus = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tabone.setBackground(new java.awt.Color(255, 255, 255));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Ảnh", "Sản Phẩm", "Chất liệu", "Trạng thái"
            }
        ));
        jTable2.setRowHeight(60);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable2);

        tfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemKeyReleased(evt);
            }
        });

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbStatusItemStateChanged(evt);
            }
        });
        cbbStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbStatusMouseClicked(evt);
            }
        });
        cbbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbStatusActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 0));
        jButton1.setText("Thêm sản phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm kiếm ");

        javax.swing.GroupLayout taboneLayout = new javax.swing.GroupLayout(tabone);
        tabone.setLayout(taboneLayout);
        taboneLayout.setHorizontalGroup(
            taboneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taboneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(taboneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(taboneLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(taboneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(14, 14, 14))))
        );
        taboneLayout.setVerticalGroup(
            taboneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taboneLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(taboneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(taboneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addComponent(cbbStatus)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1192, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(tabone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int index = jTable2.getSelectedRow();
        if (index >= 0 && evt.getClickCount() == 2) {
            int currentIndex = tabPanel.getSelectedIndex();
            tabPanel.remove(currentIndex);
            tabPanel.insertTab(
                    "Sản Phẩm",
                    null,
                    new EditProduct(listProduct.get(index), tabPanel),
                    null,
                    currentIndex);
            tabPanel.setSelectedIndex(currentIndex);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void tfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyReleased
        find();
    }//GEN-LAST:event_tfTimKiemKeyReleased

    private void cbbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbStatusActionPerformed

    }//GEN-LAST:event_cbbStatusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int currentIndex = tabPanel.getSelectedIndex();
            tabPanel.remove(currentIndex);
            tabPanel.insertTab(
                    "Sản Phẩm",
                    null,
                    new EditProduct(tabPanel),
                    null,
                    currentIndex);
            tabPanel.setSelectedIndex(currentIndex);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbbStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbStatusMouseClicked

    }//GEN-LAST:event_cbbStatusMouseClicked

    private void cbbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbStatusItemStateChanged
        int index = cbbStatus.getSelectedIndex();
        if (index == 0) {
            listProduct = productRepository.selectAll();
            loadTable();
        } else if (index > 0) {
            listProduct = productRepository.selectByStatus(index);
            loadTable();
        }
    }//GEN-LAST:event_cbbStatusItemStateChanged

    void loadTable() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        System.out.println("Load");
        listProduct.forEach(p -> {
            ImageIcon image;
            try {
                image = new ImageFromSystem().getImage(p.getImageUrl());
            } catch (Exception e) {
                image = new ImageFromSystem().getImage("/images/defaul.jpg");
            }            
            model.addRow(
                    new Object[]{
                        image,
                        p.getProductName(),
                        p.getMaterial().getMaterialName(),
                        p.getStatus().getStatusName()
                    }
            );
        });

    }

    void init() {
        listProduct = productRepository.selectAll();
        listStatus = productStatusRepository.selectAll();
        cbbStatus.removeAllItems();
        cbbStatus.addItem("Tất cả");
        cbbStatus.setSelectedIndex(0);
        for (ProductStatus status : listStatus) {
            cbbStatus.addItem(status.getStatusName());
        }
        jTable2.getColumnModel().getColumn(0).setCellRenderer(new ImageTableCellRenderer());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 1; i < jTable2.getColumnCount(); i++) {
            jTable2.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        jTable2.setDefaultEditor(Object.class, null);
        loadTable();
    }

    void find() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = tfTimKiem.getText().trim();
                if (key.isBlank()) {
                    listProduct = productRepository.selectAll();
                    loadTable();
                } else {
                    listProduct = productRepository.findByName(key);
                    loadTable();
                }
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel tabone;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
