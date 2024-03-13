package com.ploy.polyshop.view;

import com.ploy.polyshop.view.component.TableCustomerPanel;
import com.ploy.polyshop.repository.CustomerRepository;
import com.ploy.polyshop.uint.EnumStateLoad;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CustomerFrame extends javax.swing.JFrame {

    CustomerRepository customerRepository = new CustomerRepository();
    Timer timer ;
    
    

    public CustomerFrame() {
        initComponents();
        intit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfTimKiem = new javax.swing.JTextField();
        tabPanelCustomer = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tfTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTimKiemActionPerformed(evt);
            }
        });
        tfTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfTimKiemKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTimKiemKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTimKiemKeyTyped(evt);
            }
        });

        tabPanelCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanelCustomerMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        tabPanelCustomer.addTab("Tất cả", jPanel1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        tabPanelCustomer.addTab("Đã Khóa", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1003, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
        );

        tabPanelCustomer.addTab("Hoạt Động", jPanel4);

        jLabel1.setText("Tìm kiếm theo tên hoặc số điện thọai");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 1003, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabPanelCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyPressed

    }//GEN-LAST:event_tfTimKiemKeyPressed

    private void tfTimKiemKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyTyped

    }//GEN-LAST:event_tfTimKiemKeyTyped

    private void tfTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTimKiemKeyReleased
        search();
    }//GEN-LAST:event_tfTimKiemKeyReleased

    private void tabPanelCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanelCustomerMouseClicked
//        int selectedIndex = tabPanelCustomer.getSelectedIndex();
//
//        if (selectedIndex == 0) {
//            TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ALL, this);
//            tabPanelCustomer.setComponentAt(selectedIndex, newPanel);
//        }
//        else if (selectedIndex == 2) {
//            TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ACTIVE, this);
//            tabPanelCustomer.setComponentAt(selectedIndex, newPanel);
//        }
//        else if (selectedIndex == 1) {
//            TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.NOT_ACTIVE, this);
//            tabPanelCustomer.setComponentAt(selectedIndex, newPanel);
//        }
    }//GEN-LAST:event_tabPanelCustomerMouseClicked

    private void tfTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTimKiemActionPerformed

    void intit() {
//        TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ALL, this);
//        tabPanelCustomer.setComponentAt(0, newPanel);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerFrame().setVisible(true);
            }
        });
    }
    void search(){
//        CustomerFrame this_ = this;
//        if (timer != null && timer.isRunning()) {
//            timer.stop();
//        }
//        timer = new Timer(300, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String key = tfTimKiem.getText().trim();
//                System.out.println(key);
//                if (key.isBlank()) {
//                    TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.ALL, this_);
//                    tabPanelCustomer.setComponentAt(0, newPanel);
//                    return;
//                }
//                TableCustomerPanel newPanel = new TableCustomerPanel(EnumStateLoad.SEARCH, this_, key);
//                tabPanelCustomer.setComponentAt(0, newPanel);
//                tabPanelCustomer.setSelectedIndex(0);
//                
//            }
//        });
//        timer.setRepeats(false);
//        timer.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane tabPanelCustomer;
    private javax.swing.JTextField tfTimKiem;
    // End of variables declaration//GEN-END:variables
}
