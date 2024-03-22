package com.ploy.polyshop.view.component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        ImageIcon image = (ImageIcon) value;
        int originalHeight = image.getIconWidth();

        int originalWidth = image.getIconWidth();

        int height = table.getRowHeight(row);

        double ratio = (double) height / originalHeight;
        int width = (int) (originalWidth * ratio);

        Image scaled = scaleImage(image.getImage(), width, height);
        
        JLabel label = new JLabel(new ImageIcon(scaled));
        label.setHorizontalAlignment(JLabel.CENTER);

        return label;
    }

    private Image scaleImage(Image image, int w, int h) {
        Image scaled = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled;
    }
}
