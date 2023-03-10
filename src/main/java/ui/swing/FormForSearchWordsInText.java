package ui.swing;

import logic.SystemImpl;
import logic.iface.I_ColorFindWords;
import logic.iface.I_System;
import logic.speech.TextToSpeech;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class FormForSearchWordsInText extends JDialog implements I_ColorFindWords {
    private JTextField textFieldSearcher;
    private JTextArea textArea;
    private JPanel searcherPanel;
    private JButton searchButton;
    private JTextField textFieldCounterAllWords;
    private JLabel label_back;
    private JComboBox comboBoxVoice;
    private JButton buttonStartSpeech;
    private String saveOriginalText;

    public FormForSearchWordsInText() {
        setContentPane(searcherPanel);
        setMinimumSize(new Dimension(1280, 400));
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
        buttonStartSpeech.addActionListener(e -> {
            convertTextToSpeech(Objects.requireNonNull(comboBoxVoice.getSelectedItem()).toString(), textArea.getSelectedText());
        });
        setVisible(true);
    }

    private void convertTextToSpeech(String selectedItem, String selectedText) {
        if (selectedItem!=null || !selectedText.isEmpty()) {
            TextToSpeech.textToSpeech(selectedItem, selectedText);
        } else
            JOptionPane.showMessageDialog(this, "You not selected text please, select part or all text in the app.", "Warning!", JOptionPane.WARNING_MESSAGE);

    }

    private void saveOriginalText(String saveOriginalText) {
        this.saveOriginalText = saveOriginalText;
    }

    private void readYourText() {
        if (!textFieldSearcher.getText().isEmpty() && !textArea.getText().isEmpty()) {
            saveOriginalText(textArea.getText());
            textArea.setText(saveOriginalText);
            getCountWordsIntoText();
            searchYourWordInText();
        } else
            JOptionPane.showMessageDialog(this, "You not enter text or word if you want to search!\nPlease enter missing values... ", "Warning!", JOptionPane.WARNING_MESSAGE);
    }

    private void searchYourWordInText() {
        I_System i_system = new SystemImpl();
        JTextArea oldText = new JTextArea(textArea.getText());
        TreeMap<BigDecimal, BigDecimal> hashMap = i_system.getIndexStartEndWordsIntoText(oldText.getText(), textFieldSearcher.getText());
        getTextWithFoundWords(hashMap);
    }

    private void getCountWordsIntoText() {
        I_System i_system = new SystemImpl();
        textFieldCounterAllWords.setText(String.valueOf(i_system.countWordsIntoText(i_system.convertTextIntoArrayString(textArea.getText()))));
    }

    @Override
    public void getTextWithFoundWords(TreeMap<BigDecimal, BigDecimal> convertIndexingIntoTextLand) {
        Highlighter.HighlightPainter cyanPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
        for (Map.Entry<BigDecimal, BigDecimal> item : convertIndexingIntoTextLand.entrySet()) {
            try {
                textArea.getHighlighter().addHighlight(item.getKey().intValue(), item.getValue().intValue() + 1, cyanPainter);
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
    }
}
