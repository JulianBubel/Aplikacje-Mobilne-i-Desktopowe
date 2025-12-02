import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ZadanieController {
    private ZadanieModel model;
    private ZadanieView view;
    private List<Zadanie> aktualnaLista;

    public ZadanieController(ZadanieModel model, ZadanieView view) {
        this.model = model;
        this.view = view;

        this.view.addDodajListener(new DodajListener());
        this.view.addUsunListener(new UsunListener());

        updateView();
    }

    private void updateView() {
        aktualnaLista = model.pobierzWszystkieZadania();
        view.updateList(aktualnaLista);
    }

    class DodajListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String tresc = view.getZadanieText();
            if (!tresc.isEmpty()) {
                model.dodajZadanie(tresc);
                updateView();
            }
        }
    }

    class UsunListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = view.getSelectedTaskIndex();
            if (index != -1) {
                int id = aktualnaLista.get(index).getId();
                model.usunZadanie(id);
                updateView();
            }
        }
    }
}
