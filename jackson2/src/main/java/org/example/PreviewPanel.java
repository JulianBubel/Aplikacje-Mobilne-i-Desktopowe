package org.example;

import javax.swing.*;
import java.awt.*;

public class PreviewPanel extends JPanel {
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel emailLabel;

    public PreviewPanel(MainFrame frame) {
        setLayout(new GridLayout(4, 1));

        firstNameLabel = new JLabel();
        lastNameLabel = new JLabel();
        emailLabel = new JLabel();

        add(firstNameLabel);
        add(lastNameLabel);
        add(emailLabel);

        JButton backButton = new JButton("wróć do edycji");
        add(backButton);

        backButton.addActionListener(e -> frame.showCard(MainFrame.FORM));
    }

    @Override
    public void addNotify() {
        super.addNotify();
        loadData();
    }

    private void loadData() {
        UserProfile profile = StorageManager.load();
        if (profile != null) {
            firstNameLabel.setText("imie: " + profile.getFirstName());
            lastNameLabel.setText("nazwisko: " + profile.getLastName());
            emailLabel.setText("email: " + profile.getEmail());
        }
    }
}