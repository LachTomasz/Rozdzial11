/**
 *
 */
package slider;

import java.awt.*;
import javax.swing.*;
/**
 * @author Tomek
 *
 */
public class SliderTest {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            JFrame frame = new SliderFrame();
            frame.setTitle("SliderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

}
