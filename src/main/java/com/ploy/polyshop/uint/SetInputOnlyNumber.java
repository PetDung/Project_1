package com.ploy.polyshop.uint;

import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class SetInputOnlyNumber {

    public static void set(JTextField tf) {
        ((AbstractDocument) tf.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (newText.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Phát ra tiếng "beep" khi có ký tự không hợp lệ
                }
            }
        });
    }

    public static void set(JTextField tf, int start) {
        ((AbstractDocument) tf.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (newText.matches("\\d*")) {
                    int newValue = newText.isEmpty() ? 0 : Integer.parseInt(newText);
                    if (newValue >= start) {
                        super.replace(fb, offset, length, text, attrs);
                    } else {
                        Toolkit.getDefaultToolkit().beep(); // Phát ra tiếng "beep" khi có giá trị không hợp lệ
                    }
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Phát ra tiếng "beep" khi có ký tự không hợp lệ
                }
            }
        });
    }
    public static  void setFormatPrice(JTextField tf){
        ((AbstractDocument) tf.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String newText = fb.getDocument().getText(0, fb.getDocument().getLength()) + text;

                if (newText.matches("\\d*\\.?\\d{0,5}")) {
                    super.replace(fb, offset, length, text, attrs);
                } else {
                    Toolkit.getDefaultToolkit().beep(); // Phát ra tiếng "beep" khi có ký tự không hợp lệ
                }
            }
        });
    }
}
