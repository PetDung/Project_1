package com.ploy.polyshop.view.component;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.ploy.polyshop.model.Color;
import com.ploy.polyshop.model.ProductDetail;
import com.ploy.polyshop.model.ProductStatus;
import com.ploy.polyshop.model.Size;
import com.ploy.polyshop.repository.ColorRepository;
import com.ploy.polyshop.repository.ProductDetailRepository;
import com.ploy.polyshop.repository.ProductStatusRepository;
import com.ploy.polyshop.repository.SizeRepository;
import com.ploy.polyshop.uint.ImageFromSystem;
import com.ploy.polyshop.uint.SetInputOnlyNumber;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EditProductDetailsFrame extends javax.swing.JFrame {

    ProductDetail productDetail;
    List<Color> listColor;
    List<Size> listSize;
    List<ProductStatus> listStatus;
    EditProduct father;

    byte[] fileData;
    String name;
    Timer timer;

    ColorRepository colorRepository = new ColorRepository();
    SizeRepository sizeRepository = new SizeRepository();
    ProductStatusRepository productStatusRepository = new ProductStatusRepository();
    ProductDetailRepository productDetailRepository = new ProductDetailRepository();

    public EditProductDetailsFrame(ProductDetail productDetail, EditProduct father) {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        pack();
        this.productDetail = productDetail;
        System.out.println(father.getProduct().getProductId());
        this.father = father;
        init();
    }

    public EditProductDetailsFrame(EditProduct father) {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        pack();
        this.productDetail = new ProductDetail();
        this.father = father;
        productDetail.setProduct(father.getProduct());
        init();
    }

    void init() {
        lbThongBao.setText("");
        listColor = colorRepository.selectAll();
        listSize = sizeRepository.selectAll();
        listStatus = productStatusRepository.selectAll();
        SetInputOnlyNumber.set(tfSoLuong);
        SetInputOnlyNumber.setFormatPrice(tfGia);
        fillThuocTinh();
        fillTf();

    }

    void fillTf() {
        LocalDate intiDate = LocalDate.now();
        lbNgayTao.setText(intiDate.toString());
        lbNgayCapNhat.setText(intiDate.toString());

        if (productDetail.getProductDetailsId() != null) {
            tfSoLuong.setText(productDetail.getQuantity().toString());
            tfGia.setText(productDetail.getPrice().toString());
            lbNgayTao.setText(productDetail.getCreatedAt().toString());
            lbNgayCapNhat.setText(productDetail.getUpdatedAt().toString());
        }
        ImageIcon image;
        try {
            image = setWidthImage(225,
                    new ImageFromSystem().getImage(productDetail.getImageUrl()));
        } catch (Exception e) {
            image = setWidthImage(225,
                    new ImageFromSystem().getImage("/images/defaul.jpg"));
        }
        lbImage.setIcon(setWidthImage(200, image));

    }

    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }

    private ImageIcon setWidthImage(int w, ImageIcon image) {
        int originalWidth = image.getIconWidth();
        int originalHeight = image.getIconHeight();
        int width = w;
        double ratio = (double) width / originalWidth;
        int height = (int) (originalHeight * ratio);
        if (height > width) {
            height = width;
        }
        Image scaled = scaleImage(image.getImage(), width, height);
        return new ImageIcon(scaled);
    }

    void fillThuocTinh() {

        Color oldColor = productDetail.getColor() == null ? listColor.get(0) : productDetail.getColor();
        cbbMau.removeAllItems();
        listColor.forEach(c -> {
            cbbMau.addItem(c.getColorName());
            if (c.getColorId() == oldColor.getColorId()) {
                cbbMau.setSelectedIndex(c.getColorId() - 1);
            }
        });
        productDetail.setColor(oldColor);

        ProductStatus oldStatus = productDetail.getStatus() == null ? listStatus.get(0) : productDetail.getStatus();
        cbbStatus.removeAllItems();;
        listStatus.forEach(s -> {
            cbbStatus.addItem(s.getStatusName());
            if (s.getStatusId() == oldStatus.getStatusId()) {
                cbbStatus.setSelectedIndex(s.getStatusId() - 1);
            }
        });
        productDetail.setStatus(oldStatus);

        Size oldSize = productDetail.getSize() == null ? listSize.get(0) : productDetail.getSize();
        cbbSize.removeAllItems();
        listSize.forEach(size -> {
            cbbSize.addItem(size.getSizeName());
            if (size.getSizeId() == oldSize.getSizeId()) {
                cbbSize.setSelectedIndex(size.getSizeId() - 1);
            }
        });
        productDetail.setSize(oldSize);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbbMau = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        cbbStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfGia = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        lbNgayCapNhat = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        lbThongBao = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        jLabel3.setText("Giá: ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        cbbMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMau.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMauItemStateChanged(evt);
            }
        });
        cbbMau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbMauActionPerformed(evt);
            }
        });

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSizeItemStateChanged(evt);
            }
        });

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbStatusItemStateChanged(evt);
            }
        });

        jLabel4.setText("Màu");

        jLabel5.setText("Size");

        jLabel6.setText("Trạng thái");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        tfGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfGiaKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Thông tin chi tiết");

        jLabel7.setText("Ngày tạo:");

        lbNgayTao.setText("0-0-0");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        lbNgayCapNhat.setText("0-0-0");

        jLabel9.setText("Ngày cập nhật: ");

        jLabel2.setText("Số lượng: ");

        tfSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSoLuongKeyReleased(evt);
            }
        });

        lbThongBao.setForeground(new java.awt.Color(255, 51, 51));
        lbThongBao.setText("jLabel12");

        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Lưu");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                .addComponent(lbThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(44, 44, 44)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(lbNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                                .addComponent(lbNgayCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 95, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(635, 641, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbThongBao))
                .addContainerGap(378, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(lbNgayTao))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(lbNgayCapNhat)))
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbbMauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbMauActionPerformed

    }//GEN-LAST:event_cbbMauActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        father.fillTable();
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tfSoLuongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSoLuongKeyReleased
        String text = tfSoLuong.getText().trim().equals("") ? "0" : tfSoLuong.getText();
        int sl = Integer.parseInt(text);
        productDetail.setQuantity(sl);
    }//GEN-LAST:event_tfSoLuongKeyReleased

    private void tfGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfGiaKeyReleased
        String text = tfGia.getText().trim().equals("") ? "0.0" : tfGia.getText();
        Double sl = Double.parseDouble(text);
        productDetail.setPrice(sl);
        System.out.println(sl);
    }//GEN-LAST:event_tfGiaKeyReleased

    private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
        if (evt.getClickCount() == 2) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            // Tạo bộ lọc cho tệp chỉ cho phép các tệp ảnh
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png");
            fileChooser.setFileFilter(filter);
            // Hiển thị hộp thoại chọn file
            int returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // Lấy file đã chọn
                File selectedFile = fileChooser.getSelectedFile();

                if (selectedFile == null) {
                    return;
                }
                lbImage.setIcon(setWidthImage(225, new ImageIcon(selectedFile.getPath())));

                fileData = new byte[(int) selectedFile.length()];
                try {
                    FileInputStream fileInputStream = new FileInputStream(selectedFile);
                    fileInputStream.read(fileData);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

                name = selectedFile.getName();

                productDetail.setImageUrl("/images/" + selectedFile.getName());
            } else {
                System.out.println("No image file selected.");
            }
        }
    }//GEN-LAST:event_lbImageMouseClicked

    private void cbbMauItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMauItemStateChanged
        int index = cbbMau.getSelectedIndex();
        if (index >= 0) {
            productDetail.setColor(listColor.get(index));
        }
    }//GEN-LAST:event_cbbMauItemStateChanged

    private void cbbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSizeItemStateChanged
        int index = cbbSize.getSelectedIndex();
        if (index >= 0) {
            productDetail.setSize(listSize.get(index));
        }
    }//GEN-LAST:event_cbbSizeItemStateChanged

    private void cbbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbStatusItemStateChanged
        int index = cbbStatus.getSelectedIndex();
        if (index >= 0)
            productDetail.setStatus(listStatus.get(index));
    }//GEN-LAST:event_cbbStatusItemStateChanged

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        LocalDate updatedAtLCD = LocalDate.now();
        Date updatedAt = Date.valueOf(updatedAtLCD);
        Date createdAt = updatedAt;
        productDetail.setUpdatedAt(updatedAt);

        if (productDetail.getProductDetailsId() == null) {
            try {
                productDetail.setCreatedAt(createdAt);
                productDetailRepository.insert(productDetail);
                JOptionPane.showMessageDialog(this, "Tạo mới thành công!");
                this.father.fillTable();
            } catch (Exception e) {
                e.printStackTrace();
                thongBao("Sản phẩm chi tiết đã tồn tại!");
                return;
            }
            try {
                if (fileData != null) {
                    new ImageFromSystem().saveFile("/images/", name, fileData);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            return;
        }
        try {
            System.out.println("cập nhật");
            System.out.println(productDetail.getProduct().getProductId());
            productDetailRepository.update(productDetail);
        } catch (Exception e) {
            e.printStackTrace();
            thongBao("Sản phẩm chi tiết đã tồn tại!");
            return;
        }
        try {
            if (fileData != null) {
                new ImageFromSystem().saveFile("/images/", name, fileData);
            }
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            this.father.fillTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton2MouseClicked

    void thongBao(String content) {

        lbThongBao.setText(content);
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
        timer = new Timer(2000, new ActionListener() {
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
                new EditProductDetailsFrame(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbMau;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbNgayCapNhat;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JTextField tfGia;
    private javax.swing.JTextField tfSoLuong;
    // End of variables declaration//GEN-END:variables
}
