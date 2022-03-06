/**
 *
 */
package menu;

import java.awt.event.*;
import javax.swing.*;

/**
 * Ramka z paskiem menu
 * @author Tomek
 *
 */
public class MenuFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem readOnlyItem;
    private JPopupMenu popup;

    /**
     * Przykładowa akcja, która drukuje nazwę akcji do wyjścia System.out
     */
    class TestAction extends AbstractAction{

        public TestAction(String name) {
            super(name);
        }

        public void actionPerformed(ActionEvent event) {
            System.out.println("Wybrano " + getValue(Action.NAME));
        }
    }

    public MenuFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        var fileMenu = new JMenu("Plik");
        fileMenu.add(new TestAction("Nowy"));
        fileMenu.setMnemonic('P');

        //Akceleratory

        var openItem = fileMenu.add(new TestAction("Otwórz"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));

        fileMenu.addSeparator();

        saveAction = new TestAction("Zapisz");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAsAction = new TestAction("Zapisz jako");
        fileMenu.add(saveAsAction);

        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Zakończ") {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        //Menu "Opcje" z polem wyboru i przełącznikami

        readOnlyItem = new JCheckBoxMenuItem("Tylko do odczytu");
        readOnlyItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                boolean saveOk = !readOnlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);
            }
        });

        var group = new ButtonGroup();

        var insertItem = new JRadioButtonMenuItem("Wstawianie");
        insertItem.setSelected(true);

        var overTypeItem = new JRadioButtonMenuItem("Nadpisywanie");

        group.add(insertItem);
        group.add(overTypeItem);

        //Ikony

        var cutAction = new TestAction("Wytnij");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));

        var copyAction = new TestAction("Kopiuj");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));

        var pasteAction = new TestAction("Wklej");
        pasteAction.putValue(Action.SMALL_ICON,  new ImageIcon("paste.gif"));

        var editMenu = new JMenu("Edycja");
        editMenu.setMnemonic('E');
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        //Zagnieżdżone menu

        var optionMenu = new JMenu("Opcje");

        optionMenu.add(readOnlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overTypeItem);

        editMenu.addSeparator();
        editMenu.add(optionMenu);

        //Mnemoniki

        var helpMenu = new JMenu("Pomoc");
        helpMenu.setMnemonic('c');

        var indexItem = new JMenuItem("Indeks");
        indexItem.setMnemonic('I');
        helpMenu.add(indexItem);

        //Mnemoniki można także dodać do akcji
        var aboutAction = new TestAction("O programie");
        aboutAction.putValue(Action.MNEMONIC_KEY, (int) 'O');
        helpMenu.add(aboutAction);

        //Dodanie wszystkich menu najwyższego rzędu do paska menu

        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        //Menu kontekstowe

        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        var panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);


    }
}
