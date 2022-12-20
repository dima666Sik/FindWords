package ui.swing;

import logic.SystemImpl;
import logic.iface.I_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.TreeMap;

public class FormForSearchWordsInText extends JDialog {
    private JTextField textFieldSearcher;
    private JTextArea textArea;
    private JPanel searcherPanel;
    private JButton searchButton;
    private JTextField textFieldCounterAllWords;
    private JLabel label_back;

    public FormForSearchWordsInText() {
        setContentPane(searcherPanel);
        setMinimumSize(new Dimension(1000, 400));
        setUndecorated(true);
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        label_back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                new Menu();
            }
        });

        searchButton.addActionListener(e -> {
            readYourText();
        });
        setVisible(true);
    }

    private void readYourText() {
        if (!textFieldSearcher.getText().isEmpty() && !textArea.getText().isEmpty()) {
            getCountWordsIntoText();
            searchYourWordInText();
        } else
            JOptionPane.showMessageDialog(this, "You not enter text or word if you want to search!\nPlease enter missing values... ", "Warning!", JOptionPane.WARNING_MESSAGE);
    }

    private void searchYourWordInText() {
        I_System i_system = new SystemImpl();
        String oldText = textArea.getText();
        TreeMap<BigDecimal, BigDecimal> hashMap = i_system.getIndexStartEndWordsIntoText(oldText, textFieldSearcher.getText());
        clearText();
        textArea.setText(i_system.getTextWithFoundWords(oldText, hashMap));
    }

    private void getCountWordsIntoText() {
        I_System i_system = new SystemImpl();
        textFieldCounterAllWords.setText(String.valueOf(i_system.countWordsIntoText(i_system.convertTextIntoArrayString(textArea.getText()))));
    }

    private void clearText() {
        textArea.setText("");
    }
}
