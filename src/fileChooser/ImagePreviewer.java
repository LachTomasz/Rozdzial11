/**
 *
 */
package fileChooser;

import java.awt.*;
import java.io.*;

import javax.swing.*;

/**
 * Akcesorium wyświetlające podgląd obrazów
 * @author Tomek
 *
 */
public class ImagePreviewer extends JLabel {

    /**
     * Tworzy obiekt ImagePreviewer
     * @param chooser okno wyboru plików, którego własnosć zmienia się,
     * powoduje zmianę obrazu w tym podglądzie
     */
    public ImagePreviewer(JFileChooser chooser) {

        setPreferredSize(new Dimension(100,100));
        setBorder(BorderFactory.createEmptyBorder());

        chooser.addPropertyChangeListener(event -> {
            if(event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
                //Użytkownik wybrał inny plik
                File f = (File) event.getNewValue();
                if(f == null) {
                    setIcon(null);
                    return;
                }

                //Wczytywanie obrazu jako ikony
                ImageIcon icon = new ImageIcon(f.getPath());

                //Skalowanie obrazu, jeśli jest zbyt duży na ikonę
                if(icon.getIconWidth() > getWidth()) {
                    icon = new ImageIcon(icon.getImage().getScaledInstance(
                            getWidth(), -1, Image.SCALE_DEFAULT));
                }

                setIcon(icon);
            }
        });
    }
}
