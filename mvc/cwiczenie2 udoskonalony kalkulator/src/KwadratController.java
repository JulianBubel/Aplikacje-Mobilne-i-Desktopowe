import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KwadratController {
    private KwadratModel model;
    private KwadratView view;

    public KwadratController(KwadratModel model, KwadratView view) {
        this.model = model;
        this.view = view;

        this.view.addObliczListener(new ObliczListener());
    }

    class ObliczListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            int liczba = view.getLiczba();

            if (liczba == 0) {
                JOptionPane.showMessageDialog(view, "wprowadź liczbę która jest większa niż 0", "Błąd", JOptionPane.ERROR_MESSAGE);
            } else {
                int wynik = model.obliczKwadrat(liczba);
                view.setWynik(wynik);
            }
        }
    }
}
