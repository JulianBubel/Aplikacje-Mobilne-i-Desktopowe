package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShoppingListApp extends JFrame {
    private JPanel mainPanel;
    private JTextField itemInput;
    private JButton addButton;
    private JList<String> itemsList;
    private JButton deleteButton;
    private JLabel counterLabel;

    private DefaultListModel<String> listModel;

    public ShoppingListApp() {
        listModel = new DefaultListModel<>();
        itemsList.setModel(listModel);

        updateCounter();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = itemInput.getText().trim();
                if (!text.isEmpty()) {
                    listModel.addElement(text);
                    itemInput.setText("");
                    updateCounter();
                } else {

                    JOptionPane.showMessageDialog(ShoppingListApp.this, "Musisz wpisać nazwe!!!");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedItem();
            }
        });

        itemsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    removeSelectedItem();
                }
            }
        });

        this.setContentPane(mainPanel);
        this.setTitle("To-Do-List");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void removeSelectedItem() {
        int selectedIndex = itemsList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
            updateCounter();
        } else {
            JOptionPane.showMessageDialog(this, "Wybierz zadanie do usunięcia!");
        }
    }

    private void updateCounter() {
        counterLabel.setText("  Zadań: " + listModel.getSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShoppingListApp());
    }
}