/**
 *
 */
package slider;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * Ramka zawierająca kilka suwaków oraz pole tekstowe pokazujące wartości za ich pomocą
 * @author Tomek
 *
 */
public class SliderFrame extends JFrame {

    private JPanel sliderPanel;
    private JTextField textField;
    private ChangeListener listener;

    public SliderFrame() {

        sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridBagLayout());

        //Wspólny nasłuchiwacz wszystkich suwaków
        listener = event -> {
            //Aktualizacja pola tekstowego w odpowiedzi na zmianę wartości suwaka
            JSlider source = (JSlider) event.getSource();
            textField.setText("" + source.getValue());
        };

        //Zwykły suwak
        var slider = new JSlider();
        addSlider(slider, "Zwykły");

        //Suwak z podziałką
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Podziałka");


        //Suwak z dosuwaniem gałki do najbliższej kreski
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Dosuwany");

        //Suwak bez prowadnicy
        slider = new JSlider(0, 100, 0);//wartość min, max, oraz wartość inicjująca(położenie suwaka)
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTrack(false);
        addSlider(slider, "Bez prowadnicy");

        //Suwak o odwróconym działaniu
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setInverted(true);
        addSlider(slider, "Odwrócony");

        //Suwak z etykietami liczbowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        addSlider(slider, "Etykiety");

        //Suwak z etykietami literowymi
        slider = new JSlider();
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);

        var labelTable = new Hashtable<Integer, Component>();
        labelTable.put(0,  new JLabel("A"));
        labelTable.put(20,  new JLabel("B"));
        labelTable.put(40,  new JLabel("C"));
        labelTable.put(60,  new JLabel("D"));
        labelTable.put(80,  new JLabel("E"));
        labelTable.put(100,  new JLabel("F"));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Niestandardowe etykiety");

        //Suwak z etykietami ikonowymi
        slider = new JSlider();
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(20);

        labelTable = new Hashtable<Integer, Component>();

        //Dodawanie różnych kart
        labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
        labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
        labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
        labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
        labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
        labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));

        slider.setLabelTable(labelTable);
        addSlider(slider, "Ikony");

        //Dodawanie pola tekstowego, które wyświetla wartość ustawioną na suwaku
        textField = new JTextField();
        add(sliderPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.SOUTH);
        pack();


    }

    /**
     * Dodaje suwak do panelu suwaków i dowiązuje nasłuchiwacz.
     * @param slider suwak
     * @param description opis suwaka
     */
    public void addSlider(JSlider slider, String description) {

        slider.addChangeListener(listener);
        var panel = new JPanel();
        panel.add(slider);
        panel.add(new JLabel(description));
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        var gbc = new GridBagConstraints();

        gbc.gridy = sliderPanel.getComponentCount();
        gbc.anchor = GridBagConstraints.WEST;
        sliderPanel.add(panel, gbc);

    }

}
