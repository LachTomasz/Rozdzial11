package circleLayout;

import java.awt.*;
import javax.swing.*;
/**
 * @author Tomek
 *
 */
public class CircleLayoutTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame frame = new circleLayoutFrame();
            frame.setTitle("CircleLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}