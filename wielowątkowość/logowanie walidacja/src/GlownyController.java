import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GlownyController {
    private GlownyView view;
    private UzytkownikModel model;

    public GlownyController(GlownyView view, UzytkownikModel model) {
        this.view = view;
        this.model = model;

        view.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getLoginButton().setEnabled(false);
                view.getStatusLabel().setText("Trwa weryfikacja danych...");

                new SwingWorker<Boolean, Void>() {
                    @Override
                    protected Boolean doInBackground() throws Exception {
                        String user = view.getUserField().getText();
                        String pass = new String(view.getPassField().getPassword());
                        return model.walidujLogowanie(user, pass);
                    }

                    @Override
                    protected void done() {
                        try {
                            boolean isLoggedIn = get();
                            view.getLoginButton().setEnabled(true);

                            if (isLoggedIn) {
                                view.getStatusLabel().setText("Logowanie pomyślne!");
                            } else {
                                view.getStatusLabel().setText("Błędny login lub hasło!");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }.execute();
            }
        });
    }
}
