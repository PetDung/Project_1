package com.ploy.polyshop.view.component;

import com.ploy.polyshop.model.Customer;
import com.ploy.polyshop.repository.CustomerRepository;
import com.ploy.polyshop.uint.SetInputOnlyNumber;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class InfoCustomerFrame extends javax.swing.JFrame {

    Customer customer;
    TableCustomerPanel father;
    CustomerRepository customerRepository = new CustomerRepository();
    
    public InfoCustomerFrame(Customer customer, TableCustomerPanel father ) {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        // Thiết lập đường viền cho JFrame
        getRootPane().setBorder(border);
        initComponents();
        SetInputOnlyNumber.set(tfSDT);
        SetInputOnlyNumber.set(tfDiem);
        this.customer = customer;
        this.father = father;
        this.father.fatherFrame.setEnabled(false);
        fillForm();
    }

    public InfoCustomerFrame(TableCustomerPanel father) {
        
        setUndecorated(true);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        getRootPane().setBorder(border);
        initComponents();
        this.father = father;
        SetInputOnlyNumber.set(tfSDT);
        SetInputOnlyNumber.set(tfDiem);
        LocalDate updatedAtLCD = LocalDate.now();
        this.father.fatherFrame.setEnabled(false);
        lbNgayCapNhat.setText(updatedAtLCD.toString());
        lbNgayTao.setText(updatedAtLCD.toString());
    }

    public InfoCustomerFrame() {
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfDiaChi = new javax.swing.JTextField();
        tfTen = new javax.swing.JTextField();
        tfDiem = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
        lbNgayCapNhat = new javax.swing.JLabel();
        rdoKhoa = new javax.swing.JRadioButton();
        rdoHD = new javax.swing.JRadioButton();
        btnSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông Tin Khách Hàng");

        tfDiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDiemFocusLost(evt);
            }
        });

        tfSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSDTFocusLost(evt);
            }
        });
        tfSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfSDTKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSDTKeyReleased(evt);
            }
        });

        jLabel2.setText("Ngày tạo:");

        jLabel3.setText("Ngày chỉnh sử gần nhất:");

        lbNgayTao.setText("0-0-0000");

        lbNgayCapNhat.setText("0-0-0000");

        buttonGroup1.add(rdoKhoa);
        rdoKhoa.setText("Khóa");

        buttonGroup1.add(rdoHD);
        rdoHD.setSelected(true);
        rdoHD.setText("Hoạt động");

        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Tên Khách Hàng");

        jLabel7.setText("Số Điện Thoại");

        jLabel8.setText("Địa Chỉ");

        jLabel9.setText("Điểm");

        btnBack.setText("Trờ về");
        btnBack.setBorder(new javax.swing.border.MatteBorder(null));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbNgayCapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(212, 212, 212))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoHD)
                                .addGap(47, 47, 47)
                                .addComponent(rdoKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(64, 64, 64))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDiem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(lbNgayTao)
                    .addComponent(lbNgayCapNhat))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoHD)
                    .addComponent(rdoKhoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    void fillForm(){
        tfTen.setText(customer.getCustomerName());
        tfDiaChi.setText(customer.getAddress());
        tfSDT.setText(customer.getPhoneNumber());
        tfDiem.setText(customer.getPoint()+"");
        lbNgayTao.setText(customer.getCreatedAt().toString());
        lbNgayCapNhat.setText(customer.getUpdatedAt().toString());
        rdoHD.setSelected(true);
        if(!customer.isActive()) rdoKhoa.setSelected(true);
   }
   
   Customer getForm(){
       
       String customerName = tfTen.getText();
       String diaChi = tfDiaChi.getText();
       String phoneNumber = tfSDT.getText();
       String pointString = tfDiem.getText();
       String mess = "";
       if(customerName.isBlank() || diaChi.isBlank() || pointString.isBlank() || phoneNumber.isBlank()) {
           mess += "- Điền đủ thông tin!";
           JOptionPane.showMessageDialog(this, mess);
           return null;
       }
       
       if(!checkNumberPhone(phoneNumber)) {
           mess+= "- Điền đúng định dạng số điện thoại!";
           JOptionPane.showMessageDialog(this, mess);
           return null;
       }
       if(!checkPoint(pointString)){
          mess+= "- Điểm phải là số dương!"; 
          JOptionPane.showMessageDialog(this, mess);
          return null;
       }
       Integer point = Integer.parseInt(pointString);
       
       Boolean isActive = rdoHD.isSelected() ? true : false;
       
       LocalDate updatedAtLCD = LocalDate.now();
       Date updatedAt = Date.valueOf(updatedAtLCD);
       Date createdAt = updatedAt;
               
       if( customer != null ){
            Integer id = customer.getCustomerId();
            return new Customer(id, customerName, diaChi, point, phoneNumber, isActive, updatedAt);
       }
       return new Customer(customerName, diaChi, point, phoneNumber, isActive, updatedAt, createdAt);
       
   }
    
    
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        Customer customer = getForm();
        if(customer != null){
            try {
                customerRepository.update(customer);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
                return;
            }
            if(customer.getCustomerId() == null ){
                try {
                    customerRepository.insert(customer);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Lưu thành công!");
            father.loadTable();
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        father.fatherFrame.setEnabled(true);
        setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfSDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSDTKeyPressed

    }//GEN-LAST:event_tfSDTKeyPressed

    private void tfSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSDTFocusLost
       
    }//GEN-LAST:event_tfSDTFocusLost

    private void tfDiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDiemFocusLost
        String point = tfDiem.getText();
        Border redBorder = BorderFactory.createLineBorder(Color.RED);
        if(!checkPoint(point)) tfDiem.setBorder(redBorder);
        else{
            tfDiem.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        }        
                
    }//GEN-LAST:event_tfDiemFocusLost

    private void tfSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSDTKeyReleased
        String phoneNumber = tfSDT.getText();
        Border redBorder = BorderFactory.createLineBorder(Color.RED);
        
        if(!checkNumberPhone(phoneNumber)){
            tfSDT.setBorder(redBorder);
        }else{
            tfSDT.setBorder(UIManager.getLookAndFeel().getDefaults().getBorder("TextField.border"));
        }
    }//GEN-LAST:event_tfSDTKeyReleased
    
    Boolean checkNumberPhone(String phoneNumber){
        String regex = "^(\\+?84|0)\\d{9,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return  matcher.matches();
    }
    
    Boolean checkPoint(String point){
        try {
            Integer.parseInt(point);
            if(Integer.parseInt(point) < 0 ){
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InfoCustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbNgayCapNhat;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JRadioButton rdoHD;
    private javax.swing.JRadioButton rdoKhoa;
    private javax.swing.JTextField tfDiaChi;
    private javax.swing.JTextField tfDiem;
    private javax.swing.JTextField tfSDT;
    private javax.swing.JTextField tfTen;
    // End of variables declaration//GEN-END:variables
}
