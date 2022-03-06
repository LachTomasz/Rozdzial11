/**
 *
 */
package radioButton;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Ramka z przykładową etykietą tekstową i przełącznikami służącymi do
 * wyboru rozmiaru czcionki
 * @author Tomek
 *
 */
public class RadioButtonFrame extends JFrame {

    private JPanel buttonPanel;
    private ButtonGroup group;
    private JLabel label;
    private static final int DEFAULT_SIZE = 36;
    private static final int DEFAULT_WIDTH = 720;
    private static final int DEFAULT_HEIGHT = 200;

    public RadioButtonFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //Dodanie przykładowej etykiety tekstowej
        label = new JLabel("Koń i żółw grali w kości z piękną ćmą u żródła.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        //Dodanie przełączników
        buttonPanel = new JPanel();
        group = new ButtonGroup();

        addRadioButton("Mała", 8);
        addRadioButton("Średnia", 12);
        addRadioButton("Duża", 18);
        addRadioButton("Bardzo duża", 36);

        //Obramowanie przycisków zmiany czcionki
        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Tytuł");
        buttonPanel.setBorder(titled);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Tworzy przełącznik ustawiający rozmiar czcionki przykładowego tekstu.
     * @param name łańcuch identyfikujący przełącznik
     * @param size rozmiar czcionki ustawiany przez ten przełącznik
     */

    public void addRadioButton(String name, final int size) {
        boolean selected = size ==DEFAULT_SIZE;
        var button = new JRadioButton(name, selected);
        group.add(button);
        buttonPanel.add(button);

        //Ten nasluchiwacz ustawia rozmiar czcionki etykiety

        ActionListener listener = event -> label.setFont(new Font("Serif", Font.PLAIN, size));
        button.addActionListener(listener);

    }

}
