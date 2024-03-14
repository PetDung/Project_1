/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ploy.polyshop.view.component;

import com.ploy.polyshop.uint.SetInputOnlyNumber;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TextFieldEditor  extends DefaultCellEditor  {
    private JTextField textField;

    public TextFieldEditor() {
        super(new JTextField());
        textField = (JTextField) getComponent();
        textField.setBorder(new LineBorder(Color.BLACK));
        SetInputOnlyNumber.set(textField,1);
    }

    @Override
    public Object getCellEditorValue() {
        return textField.getText();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        textField.setText((value != null) ? value.toString() : "");
        return textField;
    }
}
