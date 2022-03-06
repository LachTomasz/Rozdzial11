package comboBox;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Ramka z przykładową etykietą tekstową i listą rozwijalną umożliwiającą
 * wybór kroju czcionki.
 * @author Tomek
 *
 */
public class ComboBoxFrame extends JFrame {

    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame() {

        //Dodawanie tekstu etykiety

        label = new JLabel("Koń i pies grali w kości z piękną ćmą u żrudła.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //Tworzenie listy rozwijalnej i dodawanie nazw czcionek
        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        //Nasłuchiwacz listy rozwijalnej zmienia krój pisma etykiety na czcionkę
        //wybraną przez użytkownika

        faceCombo.addActionListener(event ->
                label.setFont(
                        new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()),
                                Font.PLAIN, DEFAULT_SIZE)));

        //Dodanie listy rozwijalnej do panelu znajdującego się przy południowej krawędzi ramki

        var comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
        pack();
    }

}