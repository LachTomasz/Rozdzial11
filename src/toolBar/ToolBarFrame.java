/**
 *
 */
package toolBar;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z paskiem narzędzi oraz menu do zmieniania kolorów
 * @author Tomek
 *
 */
public class ToolBarFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel panel;

    public ToolBarFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Panel do zmieniania kolorów
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);

        //Akcje
        Action blueAction = new ColorAction("Niebieski", new ImageIcon("blue-ball.gif"), Color.BLUE);
        Action yellowAction = new ColorAction("Żółty", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action redAction = new ColorAction("Czerwony", new ImageIcon("red-ball.gif"), Color.RED);
        Action exitAction = new AbstractAction("Zamknij", new ImageIcon("exit.gif")) {

            public void actionPerformed(ActionEvent event) {

                System.exit(0);
            }
        };
        exitAction.putValue(Action.SHORT_DESCRIPTION, "Zamknij");

        //Dodanie elementów do paska narzędzi
        JToolBar bar = new JToolBar();
        bar.add(blueAction);
        bar.add(yellowAction);
        bar.add(redAction);
        bar.addSeparator();
        bar.add(exitAction);
        bar.setToolTipText("Pasek Narzędzi");
        add(bar, BorderLayout.NORTH);

        //Dodanie elementów do menu
        JMenu menu = new JMenu("Kolor");
        menu.add(yellowAction);
        menu.add(blueAction);
        menu.add(redAction);
        menu.addSeparator();
        menu.add(exitAction);
        menu.setToolTipText("Menu główne");

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);
        setJMenuBar(menuBar);

    }

    /**
     *Akcja koloru ustawia tło ramki na określony kolor
     */
    class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color c) {

            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, name + "background");
            putValue("Color", c);
        }

        public void actionPerformed(ActionEvent event) {

            Color c = (Color) getValue("Color");
            panel.setBackground(c);
        }
    }
}


