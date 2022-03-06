package circleLayout;

import javax.swing.*;

/**
 * Ramka zawierająca przyciski ułożone na obwodzie okręgu
 * @author Tomek
 *
 */
public class circleLayoutFrame extends JFrame {

    public circleLayoutFrame() {

        setLayout (new CircleLayout());
        add(new JButton("Żółty"));
        add(new JButton("Niebieski"));
        add(new JButton("Czerwony"));
        add(new JButton("Zielony"));
        add(new JButton("Pomarańczowy"));
        add(new JButton("Fuksja"));
        add(new JButton("Błękit"));
        pack();
    }
}
