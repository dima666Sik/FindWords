package ui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JDialog{
    private JButton buttonFindWordsInSwing;
    private JButton buttonFindWordsInBrowser;
    private JPanel menuPanel;
    private JLabel exitFromApp;

    public Menu() {
        setContentPane(menuPanel);
        setMinimumSize(new Dimension(540, 200));
        setUndecorated(true);
        setModal(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        buttonFindWordsInSwing.addActionListener(e -> {
            findWordsInTextWithTheHelp();
        });

        buttonFindWordsInBrowser.addActionListener(e -> {

        });

        exitFromApp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
            }
        });
        setVisible(true);
    }

    private void findWordsInTextWithTheHelp() {
        dispose();
        new FormForSearchWordsInText();
    }
}
