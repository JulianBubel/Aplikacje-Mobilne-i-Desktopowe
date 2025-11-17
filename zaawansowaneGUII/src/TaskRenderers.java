import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class TaskRenderers {

    public static TableCellRenderer getStatusRenderer() {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {

                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                checkBox.setHorizontalAlignment(JLabel.CENTER);
                if (isSelected) checkBox.setBackground(table.getSelectionBackground());
                else checkBox.setBackground(Color.WHITE);
                return checkBox;
            }
        };
    }

    public static TableCellRenderer getPriorityRenderer() {
        return new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                String priorytet = (String) value;

                switch (priorytet) {
                    case "Wysoki": label.setBackground(Color.PINK); break;
                    case "Średni": label.setBackground(Color.YELLOW); break;
                    default: label.setBackground(Color.WHITE); break;
                }

                label.setOpaque(true);
                return label;
            }
        };
    }
}
