package dialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Przykładowe modalne okno dialogowe wyświetlające komunikat
 * i oczekujące na kliknięcie przycisku OK
 * @author Tomek
 *
 */
public class AboutDialog extends JDialog {

    public AboutDialog(JFrame owner) {

        super(owner, "Test okna O programie", true);

        //Dodanie etykiety HTML
        add(
                new JLabel("<html><h1><i>Core Java</i></h1><hr> By Cay Horstmann</html>"),
                BorderLayout.CENTER);

        //Przycisk OK zamyka okno
        var ok = new JButton("OK");
        ok.addActionListener(event -> setVisible(false));

        //Dodanie przycisku OK przy krawędzi południowej
        var panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);

        pack();
    }

}