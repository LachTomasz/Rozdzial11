/**
 *
 */
package text;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Ramka z przykładowymi komponentami tekstowymi.
 * @author Tomek
 *
 */

public class TextComponentFrame extends JFrame {

    public static final int TEXTAREA_ROWS = 8;
    public static final int TEXTAREA_COLUMNS = 20;

    public TextComponentFrame() {
        var textField = new JTextField();
        var passwordField = new JPasswordField();

        var northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("Nazwa użytkownika: ", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Hasło:", SwingConstants.RIGHT));
        northPanel.add(passwordField);

        add(northPanel, BorderLayout.NORTH);

        var textArea = new JTextArea(TEXTAREA_ROWS, TEXTAREA_COLUMNS);
        textArea.setLineWrap(true);//Włączono zawijanie wierszy
        var scrollPane = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        //Dodanie przycisku wstawiająceg tekst do obszaru tekstowego

        var southPanel = new JPanel();

        var insertButton = new JButton("Wstaw");
        southPanel.add(insertButton);
        insertButton.addActionListener(event ->
                textArea.append("Nazwa użytkownika: "
                        + textField.getText()
                        + "\n"
                        + "Hasło: "
                        + new String(passwordField.getPassword())
                        + "\n"));

        add(southPanel, BorderLayout.SOUTH);
        pack();
    }
}
