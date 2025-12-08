import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GlownyView view = new GlownyView();
                UzytkownikModel model = new UzytkownikModel();
                new GlownyController(view, model);

                view.setVisible(true);
            }
        });
    }
}
