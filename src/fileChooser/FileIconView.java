/**
 *
 */
package fileChooser;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

/**
 * Widok plików wyświetlający ikonę obok wszystkich plików zaakceptowanych przez filtr.
 * @author Tomek
 *
 */
public class FileIconView extends FileView {

    private FileFilter filter;
    private Icon icon;

    /**
     * Tworzy obiekt FileIcovView
     * @param filter filtr plików - wszystkie pliki zaakceptowane przez ten filtr będą miały ikonę
     * @param icon ikona wyświetlana obok wszystkich zaakceptowanych plików
     */
    public FileIconView(FileFilter filter, Icon icon) {
        this.filter = filter;
        this.icon = icon;
    }

    public Icon getIcon(File file) {
        if(!file.isDirectory() && filter.accept(file)) return icon;
        else return null;
    }
}
