package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingListApp extends JFrame {
    private JPanel mainPanel;
    private JTextField itemInput;
    private JButton addButton;
    private JList<String> itemsList;
    private JButton deleteButton;

    private DefaultListModel<String> listModel;

    public ShoppingListApp() {
        listModel = new DefaultListModel<>();
        itemsList.setModel(listModel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = itemInput.getText().trim();
                if (!text.isEmpty()) {
                    listModel.addElement(text);
                    itemInput.setText("");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = itemsList.getSelectedIndex();
                if (selectedIndex != -1) {
                    listModel.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(null, "Nie Wybrano elementu");
                }
            }
        });

        this.setContentPane(mainPanel);
        this.setTitle("To-Do-List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ShoppingListApp();
    }
}