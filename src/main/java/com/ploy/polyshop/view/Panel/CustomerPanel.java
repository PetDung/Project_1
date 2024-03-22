package com.ploy.polyshop.view.Panel;

import com.ploy.polyshop.repository.CustomerRepository;
import com.ploy.polyshop.uint.EnumStateLoad;
import com.ploy.polyshop.view.HomeFrame;
import com.ploy.polyshop.view.component.TableCustomerPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTabbedPane;
import javax.swing.Timer;

public class CustomerPanel extends javax.swing.JPanel {

    CustomerRepository customerRepository = new CustomerRepository();
    Timer timer;
    HomeFrame father;

    public CustomerPanel(HomeFrame father ) {
        initComponents();
        this.father = father;
        intit();
    }

    void intit() {
        TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ALL, this);
        tabPanelCustomer.setComponentAt(0, newPanel);
        this.setBackground(Color.WHITE);
    }

    void search() {
        CustomerPanel this_ = this;
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = tfTimKiem.getText().trim();
                System.out.println(key);
                if (key.isBlank()) {
                    TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ALL, this_);
                    tabPanelCustomer.setComponentAt(0, newPanel);
                    return;
                }
                TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.SEARCH, this_, key);
                tabPanelCustomer.setComponentAt(0, newPanel);
                tabPanelCustomer.setSelectedIndex(0);

            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanelCustomer = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tfTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        tabPanelCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanelCustomerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        tabPanelCustomer.addTab("Tất cả ", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        tabPanelCustomer.addTab("Không hoạt động", jPanel3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        tabPanelCustomer.addTab("Đang hoạt động", jPanel2);

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));

        tfTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfTimKiem.setToolTipText("Tìm kiếm theo tên và số điện thoại\n");
        tfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButton1.setText("Trang chủ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPanelCustomer)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabPanelCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanelCustomerMouseClicked
        int selectedIndex = tabPanelCustomer.getSelectedIndex();

        if (selectedIndex == 0) {
            TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ALL, this);
            tabPanelCustomer.setComponentAt(selectedIndex, newPanel);
        } else if (selectedIndex == 2) {
            TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ACTIVE, this);
            tabPanelCustomer.setComponentAt(selectedIndex, newPanel);
        } else if (selectedIndex == 1) {
            TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.NOT_ACTIVE, this);
            tabPanelCustomer.setComponentAt(selectedIndex, newPanel);
        }
    }//GEN-LAST:event_tabPanelCustomerMouseClicked

    private void tfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyReleased
        search();
    }//GEN-LAST:event_tfTimKiemKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        father.setContentPane(new HomePanel(father));
        father.revalidate();
        father.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane tabPanelCustomer;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
