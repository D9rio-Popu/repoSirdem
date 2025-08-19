/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
/**
 *
 * @author alumno
 */
public class TextPrompt extends JLabel implements FocusListener, DocumentListener {
    private JTextComponent component;
    private Document document;

    public TextPrompt(String text, JTextComponent component) {
        this.component = component;
        this.document = component.getDocument();

        setText(text);
        setFont(component.getFont());
        setForeground(Color.GRAY);
        setHorizontalAlignment(SwingConstants.LEADING);

        component.addFocusListener(this);
        document.addDocumentListener(this);

        component.setLayout(new BorderLayout());
        component.add(this);
        checkForPrompt();
    }

    private void checkForPrompt() {
        setVisible(component.getText().length() == 0 && !component.hasFocus());
    }

    @Override
    public void focusGained(FocusEvent e) {
        checkForPrompt();
    }

    @Override
    public void focusLost(FocusEvent e) {
        checkForPrompt();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        checkForPrompt();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        checkForPrompt();
    }
}
