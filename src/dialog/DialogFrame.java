/**
 *
 */
package dialog;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Ramka z menu, którego akcja Plik/O programie wyświetla okno dialogowe
 * @author Tomek
 *
 */
public class DialogFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private AboutDialog dialog;

    public DialogFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Tworzenie menu Plik
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        var fileMenu = new JMenu("Plik");
        menuBar.add(fileMenu);

        //Tworzenie elementów o programie i Zamknij

        //element O programie wyświetla okno dialogowe O programie
        var aboutItem = new JMenuItem("O programie");
        aboutItem.addActionListener(event -> {
            if(dialog == null) //pierwszy raz
                dialog = new AboutDialog(DialogFrame.this);
            dialog.setVisible(true); //wyskakujące okno dialogowe
        });

        fileMenu.add(aboutItem);

        //Element Zamknij powoduje zamknięcie programu
        var exitItem = new JMenuItem("Zamknij");
        exitItem.addActionListener(event -> System.exit(0));
        fileMenu.add(exitItem);
    }

}