package org.example;

import javax.swing.*;
import java.awt.*;

public class FormPanel extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;

    public FormPanel(MainFrame frame) {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Imię:"));
        firstNameField = new JTextField();
        add(firstNameField);

        add(new JLabel("Nazwisko:"));
        lastNameField = new JTextField();
        add(lastNameField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        JButton saveButton = new JButton("Zapisz i Dalej");
        add(saveButton);

        saveButton.addActionListener(e -> {
            UserProfile profile = new UserProfile(
                    firstNameField.getText(),
                    lastNameField.getText(),
                    emailField.getText()
            );

            StorageManager.save(profile);
            frame.showCard(MainFrame.PREVIEW);
        });
    }
}