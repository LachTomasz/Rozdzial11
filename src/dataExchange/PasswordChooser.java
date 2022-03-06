package dataExchange;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 * Elementy służące do podawania hasła, które widać w oknie dialogowym
 * @author Tomek
 *
 */
public class PasswordChooser extends JPanel {

    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;
    public PasswordChooser() {

        setLayout(new BorderLayout());

        //Utwożenie panelu z polami nazwy użytkownika i hasła
        var panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));
        panel.add(new JLabel("Nazwa użytkownika:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Hasło:"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        //Utwożenie przycisków OK i Anuluj, które zamykają okno dialogowe
        okButton = new JButton("OK");
        okButton.addActionListener(event -> {
            ok = true;
            dialog.setVisible(false);
        });

        var cancelButton = new JButton("Anuluj");
        cancelButton.addActionListener(event -> dialog.setVisible(false));

        //Dodawanie przycisków w pobliżu południowej krawędzi
        var buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Ustawia wartości domyślne okna dialogoweg
     * @param u domyślne informacje użytkownika
     */
    public void setUser(User u) {

        username.setText(u.getName());
    }

    /**
     * Pobiera dane podane w oknie dialogowym
     * @return a obiekt typu User, którego stan reprezentuje dane wprowadzone
     * w oknie dialogowym
     */
    public User getUser() {

        return new User(username.getText(), password.getPassword());
    }

    /**
     * Wyświetla panel z elementami przyjmującymi dane od użytkownika w oknie dialogowym
     * @param parent komponent w ramce nadrzędnej lub wartość null
     * @param title tytuł okna dialogowego
     */
    public boolean showDialog(Component parent, String title) {

        ok = false;

        //Lokalizacja ramki nadrzędnej
        Frame owner = null;
        if(parent instanceof Frame)
            owner = (Frame) parent;
        else
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);

        //Jeśli jest to pierwszy raz lub zmienił się użytkownik,
        //utworzenie nowego okna dialogowego
        if(dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }

        //Ustawienie tytułu i wyświetlenie okna dialogowego
        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}