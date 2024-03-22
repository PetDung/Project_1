package com.ploy.polyshop.view.component;

import com.ploy.polyshop.model.Color;
import com.ploy.polyshop.model.Material;
import com.ploy.polyshop.model.Product;
import com.ploy.polyshop.model.ProductDetail;
import com.ploy.polyshop.model.ProductStatus;
import com.ploy.polyshop.model.Size;
import com.ploy.polyshop.repository.ColorRepository;
import com.ploy.polyshop.repository.MaterialRepository;
import com.ploy.polyshop.repository.ProductDetailRepository;
import com.ploy.polyshop.repository.ProductRepository;
import com.ploy.polyshop.repository.ProductStatusRepository;
import com.ploy.polyshop.repository.SizeRepository;
import com.ploy.polyshop.uint.ImageFromSystem;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class EditProduct extends javax.swing.JPanel {

    Product product;
    JTabbedPane tabPanel;
    byte[] fileData;
    Timer timer;
    String name;

    List<ProductStatus> listStatus;
    List<Material> listMaterial;
    List<ProductDetail> listProductDetail;
    List<Color> listColor;
    List<Size> listSize;

    ProductRepository productRepository = new ProductRepository();
    ProductStatusRepository productStatusRepository = new ProductStatusRepository();
    MaterialRepository materialRepository = new MaterialRepository();
    ProductDetailRepository productDetailRepository = new ProductDetailRepository();
    ColorRepository colorRepository = new ColorRepository();
    SizeRepository sizeRepository = new SizeRepository();

    public EditProduct(Product p, JTabbedPane father) {
        initComponents();
        this.product = p;
        this.tabPanel = father;
        init();
    }

    public EditProduct(JTabbedPane father) {
        initComponents();
        this.tabPanel = father;
        this.product = new Product();
        init();
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

    void init() {

        listColor = colorRepository.selectAll();
        listSize = sizeRepository.selectAll();
        lbThongBao.setText("");
        table.getColumnModel().getColumn(0).setCellRenderer(new ImageTableCellRenderer());
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 1; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        table.setDefaultEditor(Object.class, null);
        fillTable();
        fill();
        fillThuocTinh();
    }

    void fill() {
        ImageIcon image;
        try {
            image = setWidthImage(225,
                    new ImageFromSystem().getImage(product.getImageUrl()));
        } catch (Exception e) {
            image = setWidthImage(225,
                    new ImageFromSystem().getImage("/images/defaul.jpg"));
        }
        LocalDate dateInit = LocalDate.now();

        lbNgayTao.setText(dateInit.toString());
        lbCapNhat.setText(dateInit.toString());
        
        if (product.getProductId() != null) {
            lbImage.setIcon(setWidthImage(200, image));
            tfTen.setText(product.getProductName());
            tfMoTa.setText(product.getDescription());
            lbNgayTao.setText(product.getCreatedAt().toString());
            lbCapNhat.setText(product.getUpdatedAt().toString());
        }

        listStatus = productStatusRepository.selectAll();
        cbbStatus.removeAllItems();
        int count = 0;
        ProductStatus statusOld = product.getStatus() == null? listStatus.get(0) : product.getStatus();
        for (ProductStatus status : listStatus) {
            cbbStatus.addItem(status.getStatusName());
            if (status.getStatusId() == statusOld.getStatusId()) {
                cbbStatus.setSelectedIndex(count);
            }
            count++;
        }
        product.setStatus(statusOld);

        listMaterial = materialRepository.selectAll();
        cbbMaterial.removeAllItems();
        count = 0;
        Material materialOld = product.getMaterial() == null? listMaterial.get(0) : product.getMaterial();
        for (Material material : listMaterial) {
            cbbMaterial.addItem(material.getMaterialName());
            if (material.getMaterialId() == materialOld.getMaterialId()) {
                cbbMaterial.setSelectedIndex(count);
            }
            count++;
        }
        product.setMaterial(materialOld);
    }

    void fillTable() {
        if(product.getProductId() == null) return;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        System.out.println("product_id: " + product.getProductId());
        listProductDetail = productDetailRepository.selectByProduct(product.getProductId());
        listProductDetail.forEach(pd -> {
            System.out.println("productId: " + pd.getProduct().getProductId());
            ImageIcon image;
            try {
                image = setWidthImage(225,
                        new ImageFromSystem().getImage(pd.getImageUrl()));
            } catch (Exception e) {
                image = setWidthImage(225,
                        new ImageFromSystem().getImage("/images/defaul.jpg"));
            }
            model.addRow(new Object[]{
                image,
                pd.getSize().getSizeName(),
                pd.getColor().getColorName(),
                pd.getPrice(),
                pd.getQuantity(),
                pd.getStatus().getStatusName()
            });

        });
    }
    
    

    void fillThuocTinh() {
        cbbColor.removeAllItems();
        cbbSize.removeAllItems();
        listColor.forEach(c -> {
            cbbColor.addItem(c.getColorName());
        });
        listSize.forEach(s -> {
            cbbSize.addItem(s.getSizeName());
        });
    }

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

    void sortList(String size, String color) {
        listProductDetail.sort((pd1, pd2) -> {
            boolean isP1MatchSizeAndColor = pd1.getSize().getSizeName().equals(size) && pd1.getColor().getColorName().equals(color);
            boolean isP2MatchSizeAndColor = pd2.getSize().getSizeName().equals(size) && pd2.getColor().getColorName().equals(color);
            boolean isP1MatchSizeOrColor = pd1.getSize().getSizeName().equals(size) || pd1.getColor().getColorName().equals(color);
            boolean isP2MatchSizeOrColor = pd2.getSize().getSizeName().equals(size) || pd2.getColor().getColorName().equals(color);

            // Đưa các sản phẩm khớp cả size và color lên đầu
            if (isP1MatchSizeAndColor && !isP2MatchSizeAndColor) {
                return -1; // Đưa pd1 lên trước pd2
            } else if (!isP1MatchSizeAndColor && isP2MatchSizeAndColor) {
                return 1; // Đưa pd2 lên trước pd1
            } else if (isP1MatchSizeAndColor && isP2MatchSizeAndColor) {
                return 0; // Giữ nguyên thứ tự
            } // Đưa các sản phẩm khớp một trong size hoặc color lên đầu
            else if ((isP1MatchSizeOrColor && !isP2MatchSizeOrColor) && !(isP1MatchSizeAndColor || isP2MatchSizeAndColor)) {
                return -1; // Đưa pd1 lên trước pd2
            } else if (!(isP1MatchSizeAndColor || isP1MatchSizeOrColor) && (isP2MatchSizeOrColor && !isP1MatchSizeOrColor)) {
                return 1; // Đưa pd2 lên trước pd1
            } else {
                return 0; // Giữ nguyên thứ tự
            }
        });
    }
    
    Product getProduct (){ return this.product ;};

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        tfTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfMoTa = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        cbbMaterial = new javax.swing.JComboBox<>();
        cbbStatus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbNgayTao = new javax.swing.JLabel();
        lbCapNhat = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        lbThongBao = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbbColor = new javax.swing.JComboBox<>();
        cbbSize = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdoTypeOne = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Tên sản phẩm");

        tfTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfTenKeyReleased(evt);
            }
        });

        jLabel3.setText("Mô tả");

        tfMoTa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMoTaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tfMoTa);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbMaterial.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbMaterialItemStateChanged(evt);
            }
        });

        cbbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbStatusItemStateChanged(evt);
            }
        });

        jLabel4.setText("Chất liệu");

        jLabel5.setText("Trạng thái ");

        jLabel6.setText("Ngày tạo");

        jLabel7.setText("Ngày cập nhật");

        lbNgayTao.setText("0-0-0");

        lbCapNhat.setText("0-0-0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbbMaterial, 0, 153, Short.MAX_VALUE)
                        .addComponent(cbbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(8, 8, 8)
                .addComponent(cbbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbNgayTao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbCapNhat))
                .addGap(20, 20, 20))
        );

        jButton1.setText("Trở về");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Lưu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thêm sản phẩm chi tiết");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ảnh", "Size", "Màu", "Giá", "Số lượng", "Trạng thái"
            }
        ));
        table.setRowHeight(60);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Danh sách sản phẩm chi tiết");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbImage, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbImage, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbThongBao.setForeground(new java.awt.Color(255, 51, 0));
        lbThongBao.setText("jLabel1");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cbbColor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbColor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbColorItemStateChanged(evt);
            }
        });

        cbbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSizeItemStateChanged(evt);
            }
        });

        jLabel1.setText("Size");

        jLabel8.setText("Color");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Lọc");

        rdoTypeOne.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdoTypeOne);
        rdoTypeOne.setSelected(true);
        rdoTypeOne.setText("Một");

        jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Nhiều");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbSize, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel8))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdoTypeOne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jRadioButton2)
                        .addGap(16, 16, 16))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoTypeOne)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbbColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTen)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbThongBao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 841, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbThongBao))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfTen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int currentIndex = tabPanel.getSelectedIndex();
        tabPanel.remove(currentIndex);
        tabPanel.insertTab("Sản Phẩm", null, new ListProductPanel(tabPanel), null, currentIndex);
        tabPanel.setSelectedIndex(currentIndex);
    }//GEN-LAST:event_jButton1ActionPerformed

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

                product.setImageUrl("/images/" + selectedFile.getName());
            } else {
                System.out.println("No image file selected.");
            }
        }
    }//GEN-LAST:event_lbImageMouseClicked

    private void tfTenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTenKeyReleased
        String text = tfTen.getText();
        product.setProductName(text.trim());
    }//GEN-LAST:event_tfTenKeyReleased

    private void tfMoTaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMoTaKeyReleased
        String text = tfTen.getText();
        product.setDescription(text.trim());
    }//GEN-LAST:event_tfMoTaKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (
            product.getProductName() == null || product.getDescription() == null
            || product.getProductName().isBlank() || product.getDescription().isBlank()) {
            thongBao("Vui lòng nhập đủ thông tin!");
            return;
        }
        LocalDate updatedAtLCD = LocalDate.now();
        Date updatedAt = Date.valueOf(updatedAtLCD);
        Date createdAt = updatedAt;
        product.setUpdatedAt(updatedAt);

        if (product.getProductId() == null) {
            product.setCreatedAt(createdAt);
            try {
                if (fileData != null) {
                    new ImageFromSystem().saveFile("/images/", name, fileData);
                }
                productRepository.insert(product);
                product = productRepository.selectNewProductId();
                System.out.println(product.getProductId());
                JOptionPane.showMessageDialog(this, "Tạo mới thành công!");
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Tên sản phẩm đã tồn tại!");
            }
            return;
        }
        try {
            if (fileData != null) {
                new ImageFromSystem().saveFile("/images/", name, fileData);
            }
            productRepository.update(product);
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm đã tồn tại!");
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbbMaterialItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbMaterialItemStateChanged
        int index = cbbMaterial.getSelectedIndex();
        if (index < 0) {
            return;
        }
        product.setMaterial(listMaterial.get(index));
    }//GEN-LAST:event_cbbMaterialItemStateChanged

    private void cbbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbStatusItemStateChanged
        int index = cbbStatus.getSelectedIndex();
        if (index < 0) {
            return;
        }
        product.setStatus(listStatus.get(index));
    }//GEN-LAST:event_cbbStatusItemStateChanged

    private void cbbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSizeItemStateChanged
        if (listProductDetail == null) {
            return;
        }

        int indexColor = cbbColor.getSelectedIndex();
        int indexSize = cbbSize.getSelectedIndex();
        if (indexColor >= 0 && indexSize >= 0) {
            String size = listSize.get(indexSize).getSizeName();
            String color = listColor.get(indexColor).getColorName();
            boolean isType = rdoTypeOne.isSelected();
            if (!isType) {
                sortList(size, color);
            } else {
                listProductDetail = listProductDetail.stream()
                        .sorted(Comparator.comparing(pd -> pd.getSize().getSizeName().equals(size) ? 0 : 1))
                        .collect(Collectors.toList());
            }
            fillTable();
        }
    }//GEN-LAST:event_cbbSizeItemStateChanged

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void cbbColorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbColorItemStateChanged
        if (listProductDetail == null) {
            return;
        }
        int indexColor = cbbColor.getSelectedIndex();
        int indexSize = cbbSize.getSelectedIndex();
        if (indexColor >= 0 && indexSize >= 0) {
            String size = listSize.get(indexSize).getSizeName();
            String color = listColor.get(indexColor).getColorName();
            boolean isType = rdoTypeOne.isSelected();
            if (!isType) {
                sortList(size, color);
            } else {
                listProductDetail = listProductDetail.stream()
                        .sorted(Comparator.comparing(pd -> pd.getColor().getColorName().equals(color) ? 0 : 1))
                        .collect(Collectors.toList());
            }
            fillTable();
        }
    }//GEN-LAST:event_cbbColorItemStateChanged

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (evt.getClickCount() == 2) {
            int row = table.getSelectedRow();
            if (row >= 0) {
                System.out.println("Trang cha "  + listProductDetail.get(row).getProduct().getProductId());
                new EditProductDetailsFrame( listProductDetail.get(row), this)
                        .setVisible(true);
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        if(product.getProductId() == null){
            JOptionPane.showMessageDialog(this,"Bạn cần tạo sản phẩm trước");
            return;
        }
        new EditProductDetailsFrame(this).setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbColor;
    private javax.swing.JComboBox<String> cbbMaterial;
    private javax.swing.JComboBox<String> cbbSize;
    private javax.swing.JComboBox<String> cbbStatus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCapNhat;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbNgayTao;
    private javax.swing.JLabel lbThongBao;
    private javax.swing.JRadioButton rdoTypeOne;
    private javax.swing.JTable table;
    private javax.swing.JTextPane tfMoTa;
    private javax.swing.JTextField tfTen;
    // End of variables declaration//GEN-END:variables
}
