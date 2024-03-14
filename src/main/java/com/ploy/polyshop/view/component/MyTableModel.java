package com.ploy.polyshop.view.component;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4) {
            return JButton.class; // Return JButton class for the third column
        }
        return Object.class; // For other columns, return default class
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Disable cell editing
    }

}
