package org.example;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SystemRaportowania extends JFrame {

    private JTable table;

    public SystemRaportowania() {
        setTitle("System Raportowania");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nazwa Produktu");
        model.addColumn("Ilość");
        model.addColumn("Cena");

        model.addRow(new Object[]{1, "Buty", 10, 500});
        model.addRow(new Object[]{2, "Koszulki", 15, 80});
        model.addRow(new Object[]{3, "Spodnie", 8, 150});
        model.addRow(new Object[]{4, "Bluzy", 12, 120});

        table = new JTable(model);

        JButton button = new JButton("Generuj Raport PDF");
        button.addActionListener(e -> exportToPDF());

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }

    public void exportToPDF() {
        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(this);

        if (state == JFileChooser.APPROVE_OPTION) {

            Document document = new Document();

            try {
                PdfWriter.getInstance(document,
                        new FileOutputStream(chooser.getSelectedFile() + ".pdf"));

                document.open();

                Font font = new Font(12);

                String date = new SimpleDateFormat("dd.MM.yyyy HH:mm")
                        .format(new Date());

                Paragraph header = new Paragraph(
                        "Raport magazynowy\nData wygenerowania: " + date,
                        font);

                header.setAlignment(Element.ALIGN_CENTER);
                header.setSpacingAfter(20);
                document.add(header);

                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                pdfTable.setWidthPercentage(100);

                for (int i = 0; i < table.getColumnCount(); i++) {
                    PdfPCell cell = new PdfPCell(
                            new Phrase(table.getColumnName(i), font));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }

                for (int row = 0; row < table.getRowCount(); row++) {
                    for (int col = 0; col < table.getColumnCount(); col++) {
                        PdfPCell cell = new PdfPCell(
                                new Phrase(
                                        table.getValueAt(row, col).toString(),
                                        font));
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        pdfTable.addCell(cell);
                    }
                }

                document.add(pdfTable);

                JOptionPane.showMessageDialog(this,
                        "Raport wygenerowany poprawnie!");

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                document.close();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Dostępne style LookAndFeel:");
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            System.out.println("Nazwa: " + laf.getName() + " | Klasa: " + laf.getClassName());
        }

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        SwingUtilities.invokeLater(() ->
                new SystemRaportowania().setVisible(true));
    }
}