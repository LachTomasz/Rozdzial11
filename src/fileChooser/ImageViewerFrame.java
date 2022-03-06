/**
 *
 */
package fileChooser;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * Ramka z menu zawierającym opcję Otwórz i obszarem do
 * prezentacji otwartych obrazów
 * @author Tomek
 *
 */
public class ImageViewerFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 400;
    private JLabel label;
    private JFileChooser chooser;

    public ImageViewerFrame() {

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //Pasek menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("Plik");
        menuBar.add(menu);

        JMenuItem openItem = new JMenuItem("Otwórz");
        menu.add(openItem);
        openItem.addActionListener(event -> {
            chooser.setCurrentDirectory(new File ("."));

            //Okno wyboru plików
            int result = chooser.showOpenDialog(ImageViewerFrame.this);

            //Jeśli plik obrazu zostanie zaakceptowany, ustaw go jako ikonę etykiety
            if (result == JFileChooser.APPROVE_OPTION) {
                String name = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(name));
                pack();
            }
        });

        JMenuItem exitItem = new JMenuItem("Zamknij");
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));

        //etykieta do wyświetlania obrazów
        label = new JLabel();
        add(label);

        //Utworzenie akcesorium wyboru plików
        chooser = new JFileChooser();

        //Akceptuje wszystkie pliki obrazów z rozszerzeniem *.jpg, *.jpeg, *.gif
        FileFilter filter = new FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "gif");
        chooser.setFileFilter(filter);
        chooser.setAccessory(new ImagePreviewer(chooser));
        chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
    }
}
