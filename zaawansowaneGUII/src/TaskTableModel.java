import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {
    private List<Task> zadania;
    private String[] kolumny = {"Zadanie", "Wykonane?", "Priorytet"};

    public TaskTableModel(List<Task> zadania) {
        this.zadania = zadania;
    }

    @Override
    public int getRowCount() { return zadania.size(); }

    @Override
    public int getColumnCount() { return kolumny.length; }

    @Override
    public String getColumnName(int column) { return kolumny[column]; }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task t = zadania.get(rowIndex);
        switch (columnIndex) {
            case 0: return t.getNazwa();
            case 1: return t.isUkonczone();
            case 2: return t.getPriorytet();
            default: return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Task t = zadania.get(rowIndex);
        if (columnIndex == 1 && aValue instanceof Boolean) {
            t.setUkonczone((Boolean) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    public void addTask(Task t) {
        zadania.add(t);
        fireTableRowsInserted(zadania.size()-1, zadania.size()-1);
    }

    public void removeTask(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < zadania.size()) {
            zadania.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }
}
