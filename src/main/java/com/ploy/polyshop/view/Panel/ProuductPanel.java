package com.ploy.polyshop.view.Panel;

import com.ploy.polyshop.model.Color;
import com.ploy.polyshop.model.Product;
import com.ploy.polyshop.model.ProductStatus;
import com.ploy.polyshop.model.Size;
import com.ploy.polyshop.repository.ColorRepository;
import com.ploy.polyshop.repository.ProductRepository;
import com.ploy.polyshop.repository.ProductStatusRepository;
import com.ploy.polyshop.repository.SizeRepository;
import com.ploy.polyshop.view.HomeFrame;
import com.ploy.polyshop.view.component.EditColorFrame;
import com.ploy.polyshop.view.component.EditProduct;
import com.ploy.polyshop.view.component.EditSizeFrame;
import com.ploy.polyshop.view.component.ListProductPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ProuductPanel extends javax.swing.JPanel {

    HomeFrame father;

    List<Product> listProduct;
    List<Color> listColor;
    List<Size> listSize;
    
    List<ProductStatus> listStatus;
    Timer timer;

    ProductRepository productRepository = new ProductRepository();
    ProductStatusRepository productStatusRepository = new ProductStatusRepository();
    ColorRepository colorRepository = new ColorRepository();
    SizeRepository sizeRepository = new SizeRepository();

    public ProuductPanel(HomeFrame father) {
        initComponents();
        this.father = father;
        init();
    }
    public void fillTableColor(){
        DefaultTableModel model = (DefaultTableModel) tbColor.getModel();
        model.setRowCount(0);
        listColor.forEach(c ->{
            model.addRow( new Object[]{
                c.getColorName(),
                c.getDescription(),
                c.isIsActive()? "Hoạt đông" : "Ngừng hoạt động"
            });
        });
    }
    public  void setListColor(List<Color> listColor){
        this.listColor = listColor;
    }
    
     public void fillTableSize(){
        DefaultTableModel model = (DefaultTableModel) tbSize.getModel();
        model.setRowCount(0);
        listSize.forEach(c ->{
            model.addRow( new Object[]{
                c.getSizeName(),
                c.getDescription(),
                c.isIsActive()? "Hoạt động" : "Ngừng hoạt động"
            });
        });
    }
    public  void setListSize(List<Size> listColor){
        this.listSize = listColor;
    }

   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        tabPanel = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        tabThuocTinh = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbSize = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        tfTimKiemSize = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbColor = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        tfTimKiemMau = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jButton3.setText("Trang chủ");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tabPanel.setBackground(new java.awt.Color(255, 255, 255));
        tabPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanelMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tabThuocTinh.setBackground(new java.awt.Color(255, 255, 255));
        tabThuocTinh.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabThuocTinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabThuocTinhMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbSize.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbSize.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên size", "Mô tả", "Trạng thái"
            }
        ));
        tbSize.setRowHeight(40);
        tbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSizeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbSize);

        jLabel1.setText("Tìm kiếm");

        tfTimKiemSize.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemSizeKeyReleased(evt);
            }
        });

        jButton2.setText("Tạo  mới");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1063, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTimKiemSize, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfTimKiemSize, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        tabThuocTinh.addTab("Size", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tabThuocTinh.addTab("Chất liệu", jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbColor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbColor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên màu", "Mô tả", "Trạng thái"
            }
        ));
        tbColor.setRowHeight(40);
        tbColor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbColorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbColor);

        jButton1.setText("Tạo mới");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        tfTimKiemMau.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemMauKeyReleased(evt);
            }
        });

        jLabel3.setText("Tìm kiếm:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(tfTimKiemMau, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 556, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(tfTimKiemMau, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabThuocTinh.addTab("Màu", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabThuocTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabPanel.addTab("Thuộc tính", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1211, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabThuocTinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabThuocTinhMouseClicked
       int selectIndex = tabThuocTinh.getSelectedIndex();
       if(selectIndex == 2){
           listColor = colorRepository.selectAll();
           fillTableColor();
       }
       if(selectIndex == 0){
           listSize = sizeRepository.selectAll();
           fillTableSize();
       }
    }//GEN-LAST:event_tabThuocTinhMouseClicked

    private void tbColorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbColorMouseClicked
        int row = tbColor.getSelectedRow();
        if(row >=0 && evt.getClickCount() ==2 ){
            new EditColorFrame(this, listColor.get(row)).setVisible(true);
        }
    }//GEN-LAST:event_tbColorMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        new EditColorFrame(this).setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void tbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSizeMouseClicked
        int row = tbSize.getSelectedRow();
        if(row >=0 && evt.getClickCount() ==2 ){
            new EditSizeFrame(this, listSize.get(row)).setVisible(true);
        }
    }//GEN-LAST:event_tbSizeMouseClicked

    private void tabPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanelMouseClicked
        int index = tabPanel.getSelectedIndex();
        if(index == 1){
            listSize = sizeRepository.selectAll();
            tabThuocTinh.setSelectedIndex(0);
            fillTableSize();
        }
        if(index == 0){
            tabPanel.remove(0);
            tabPanel.insertTab("Sản Phẩm", null, new ListProductPanel(tabPanel), null, 0);
            tabPanel.setSelectedIndex(0);
        }
    }//GEN-LAST:event_tabPanelMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new EditSizeFrame(this).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tfTimKiemSizeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemSizeKeyReleased
       String key  = tfTimKiemSize.getText();
       if(key.trim().isBlank()){
           listSize = sizeRepository.selectAll();
       }else{
           listSize = sizeRepository.findByName(key);
       }
       fillTableSize();
    }//GEN-LAST:event_tfTimKiemSizeKeyReleased

    private void tfTimKiemMauKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemMauKeyReleased
        String key  = tfTimKiemMau.getText();
        if(key.trim().isBlank()){
            listColor = colorRepository.selectAll();
        }else{
            listColor = colorRepository.findByName(key);
        }
        fillTableColor();
    }//GEN-LAST:event_tfTimKiemMauKeyReleased

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        father.setContentPane(new HomePanel(father));
        father.revalidate();
        father.repaint();
    }//GEN-LAST:event_jButton3MouseClicked
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTabbedPane tabThuocTinh;
    private javax.swing.JTable tbColor;
    private javax.swing.JTable tbSize;
    private javax.swing.JTextField tfTimKiemMau;
    private javax.swing.JTextField tfTimKiemSize;
    // End of variables declaration//GEN-END:variables

    private void init() {
        tabPanel.add(new ListProductPanel(tabPanel),0);
        tabPanel.setTitleAt(0,"Sản phẩm");
        tabPanel.setSelectedIndex(0);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 1; i < tbColor.getColumnCount(); i++) {
            tbColor.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tbColor.setDefaultEditor(Object.class, null);
       
        for (int i = 1; i < tbSize.getColumnCount(); i++) {
            tbSize.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        tbSize.setDefaultEditor(Object.class, null);
        
    }
}
