import javax.swing.*;
import javax.swing.SwingWorker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NaprawionaApp {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Naprawiona Aplikacja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 180);
        frame.setLayout(null);

        JButton startButton = new JButton("Start");
        JLabel statusLabel = new JLabel("Status:  ");

        startButton.setBounds(100, 50, 100, 30);
        statusLabel.setBounds(100, 100, 200, 30);

        frame.add(startButton);
        frame.add(statusLabel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MySwingWorker(statusLabel).execute();
            }
        });

        frame.setVisible(true);
    }
}

class MySwingWorker extends SwingWorker<Void, String> {
    private JLabel statusLabel;

    public MySwingWorker(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    @Override
    protected Void doInBackground() throws Exception {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000); // 1 sekunda
            publish("Pracuję... " + (i + 1) + "s");
        }
        return null;
    }

    @Override
    protected void process(java.util.List<String> chunks) {
        for (String status : chunks) {
            statusLabel.setText(status);
        }
    }

    @Override
    protected void done() {
        statusLabel.setText("Zakończono pomyślnie!");
    }
}
