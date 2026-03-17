package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public static final String FORM = "FORM";
    public static final String PREVIEW = "PREVIEW";

    public MainFrame() {
        setTitle("profil uzytkownika");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        FormPanel formPanel = new FormPanel(this);
        PreviewPanel previewPanel = new PreviewPanel(this);

        mainPanel.add(formPanel, FORM);
        mainPanel.add(previewPanel, PREVIEW);

        add(mainPanel);
        setVisible(true);
    }

    public void showCard(String name) {
        cardLayout.show(mainPanel, name);
    }
}