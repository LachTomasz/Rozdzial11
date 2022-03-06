package dialog;

import java.awt.*;
import javax.swing.*;

/**
 * @author Tomek
 *
 */
public class DialogTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new DialogFrame();
            frame.setTitle("DialogTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
