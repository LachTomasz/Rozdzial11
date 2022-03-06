package dataExchange;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z menu, którego akcja Plik/Połącz wyświetla okno dialogowe z polem hasła
 * @author Tomek
 *
 */
public class DataExchangeFrame extends JFrame {

    public static final int TEXT_ROWS = 20;
    public static final int TEXT_COLUMNS = 40;
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {

        //Tworzenie menu Plik
        var mbar = new JMenuBar();
        setJMenuBar(mbar);
        var fileMenu = new JMenu("Plik");
        mbar.add(fileMenu);

        //Tworzenie elementów menu Połącz i Zamknij
        var connectItem = new JMenuItem("Połącz");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        //Opcja Zamknij zamyka program
        var exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();

    }

    /**
     * Akcja Connect wyświetla okno dialogowe z polem hasła
     */
    private class ConnectAction implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            //Jeśli jest to pierwszy raz, tworzy okno dialogowe
            if (dialog == null) dialog = new PasswordChooser();

            //Ustawianie wartości domyślnych
            dialog.setUser(new User("Twoja nazwa", null));

            //Wyświetlanie okna dialogowego
            if(dialog.showDialog(DataExchangeFrame.this, "Połącz")) {
                //Pobieranie danych użytkownika w przypadku zatwierdzenia
                User u = dialog.getUser();
                textArea.append("nazwa użytkownika: " + u.getName() + ", hasło: "
                        + (new String(u.getPassword())) + "\n");
            }
        }
    }
}
