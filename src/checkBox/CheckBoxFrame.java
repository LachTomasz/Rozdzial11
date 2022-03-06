package checkBox;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z przykładową etykietą i polami wyboru
 * reprezentującymi różne atrybuty czcionki.
 * @author Tomek
 *
 */
public class CheckBoxFrame extends JFrame {

    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;
//	private static final int DEFAULT_WIDTH = 520;
//	private static final int DEFAULT_HEIGHT = 200;

    public CheckBoxFrame() {
        //dodanie przykładowej etykiety
//		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT); //zamiast tego lepiej użyć pack() na końcu
        label = new JLabel("Koń i żółw grali w kości z piękną ćmą u żródła.");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        //nasłuchiwacz ustawiający atrybuty czcionki
        //etykiety zgodnie z ustawieniami pól wyboru

        ActionListener listener = event -> {
            int mode = 0;
            if(bold.isSelected()) mode += Font.BOLD;
            if(italic.isSelected()) mode += Font.ITALIC;
            label.setFont(new Font("Serif", mode, FONTSIZE));
        };

        //dodanie pol wyboru

        var buttonPanel = new JPanel();

        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        //bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        //italic.setSelected(true);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}